import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private final EntityManager entityManager;
    private BufferedReader bufferedReader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.println("Please enter exercise number or zero to exit: ");
        try {
            int exNumber = Integer.parseInt(bufferedReader.readLine());

            switch (exNumber) {
                case 2:
                    changeCasing();
                    break;
                case 3:
                    containsEmployee();
                    break;
                case 4:
                    employeesWithSalaryOver50k();
                    break;
                case 5:
                    employeesFromDepartment();
                    break;
                case 6:
                    addingAddress();
                    break;
                case 7:
                    addressesWithEmployeeCount();
                    break;
                case 8:
                    getEmployeeWithProject();
                    break;
                case 9:
                    findLatestProjects();
                    break;
                case 10:
                    increaseSalaries();
                    break;
                case 11:
                    findEmployeesByFirstName();
                    break;
                case 12:
                    employeesMaximumSalaries();
                    break;
                case 13:
                    removeTowns();
                    break;
                case 0:
                    System.out.println("You ended the program.");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }


    }

    private void removeTowns() throws IOException {
        System.out.println("Please enter town name: ");
        String townName = bufferedReader.readLine();

        Town town = getTownByName(townName);

        int removedAddresses = removeAddressesByTown(town);

        entityManager.getTransaction().begin();
        entityManager.remove(town);
        entityManager.getTransaction().commit();

        System.out.printf("%d address in %s deleted", removedAddresses, town.getName());


    }

    private int removeAddressesByTown(Town town) {

        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a " +
                        "WHERE a.town.name = :t_name", Address.class)
                .setParameter("t_name", town.getName())
                .getResultList();

        entityManager.getTransaction().begin();
        addresses.forEach(entityManager::remove);
        entityManager.getTransaction().commit();

        return addresses.size();
    }

    private Town getTownByName(String townName) {
        return entityManager.createQuery("SELECT t FROM Town t " +
                        "WHERE t.name = :t_name", Town.class)
                .setParameter("t_name", townName)
                .getSingleResult();
    }

    @SuppressWarnings("unchecked")
    private void employeesMaximumSalaries() {

        List<Object[]> rows = entityManager.createNativeQuery("SELECT d.name, MAX(e.salary) AS max_salary FROM departments d\n" +
                        "join employees e on d.department_id = e.department_id\n" +
                        "GROUP BY d.name\n" +
                        "HAVING max_salary NOT BETWEEN 30000 AND 70000;")
                .getResultList();

        rows.forEach(o -> System.out.printf("%s %.2f%n", o[0], o[1]));


    }

    private void findEmployeesByFirstName() throws IOException {
        System.out.println("Please enter pattern: ");
        String pattern = bufferedReader.readLine();

        entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.firstName LIKE :pattern", Employee.class)
                .setParameter("pattern", pattern + "%")
                .getResultStream()
                .forEach(e -> {
                    System.out.printf("%s %s - %s - ($%.2f)%n",
                            e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary());
                });
    }

    private void increaseSalaries() {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("UPDATE Employee e SET e.salary = e.salary + (e.salary * 0.12) " +
                "WHERE e.department.id IN :ids");

        query.setParameter("ids", Set.of(1, 2, 4, 11));
        query.executeUpdate();

        entityManager.getTransaction().commit();

        entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name IN('Engineering','Tool Design', 'Marketing', 'Information Services')", Employee.class)
                .getResultList()
                .forEach(e -> System.out.printf("%s %s ($%.2f)%n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getSalary()));
    }

    private void findLatestProjects() {
        List<Project> projects = getFirst10Projects();

        projects.forEach(p -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println("Project name: " + p.getName());
            System.out.printf("      Project Description: %s%n" +
                    "      Project Start Date: %s%n" +
                    "      Project End Date: %s%n", p.getDescription(), p.getStartDate().format(formatter), p.getEndDate());
        });
    }

    private List<Project> getFirst10Projects() {
        List<Project> projects = entityManager.createQuery("SELECT p FROM Project p " +
                        "ORDER BY p.startDate DESC", Project.class)
                .getResultList()
                .stream()
                .limit(10).sorted(Comparator.comparing(Project::getName)).collect(Collectors.toList());
        return projects;
    }

    private void getEmployeeWithProject() throws IOException {
        System.out.println("Please enter employee ID: ");

        int id = Integer.parseInt(bufferedReader.readLine());

        Employee employee = entityManager.find(Employee.class, id);
        if (employee == null) {
            throw new IllegalArgumentException("Employee not found");
        }

        System.out.printf("%s %s - %s%n", employee.getFirstName(),
                employee.getLastName(), employee.getJobTitle());

        employee.getProjects()
                .stream().map(Project::getName)
                .sorted()
                .forEach(p -> System.out.println("      " + p));


    }

    private void addressesWithEmployeeCount() {
        List<Address> addresses = entityManager.createQuery("SELECT a FROM  Address a " +
                        "ORDER BY a.employees.size DESC", Address.class)
                .getResultList();

        addresses.stream().limit(10).forEach(a -> System.out.printf("%s, %s - %d employees%n", a.getText(),
                a.getTown().getName(), a.getEmployees().size()));

    }

    private void addingAddress() throws IOException {
        System.out.println("Please enter employee last name: ");
        String lastName = bufferedReader.readLine();

        try {
            Employee employee = getEmployeeByLastName(lastName);


            Address address = createAddress("Vitoshka 15");

            entityManager.getTransaction().begin();
            employee.setAddress(address);
            entityManager.getTransaction().commit();


        } catch (Exception e) {
            System.out.println("No such employee");
        }

    }

    private Employee getEmployeeByLastName(String lastName) {
        Employee employee = entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.lastName = :last_name", Employee.class)
                .setParameter("last_name", lastName).getSingleResult();
        return employee;
    }

    private Address createAddress(String s) {
        Address address = new Address();
        address.setText(s);

        entityManager.getTransaction().begin();

        entityManager.persist(address);

        entityManager.getTransaction().commit();

        return address;

    }

    private void employeesFromDepartment() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.department.name = 'Research and Development' " +
                "ORDER BY e.salary,e.id", Employee.class);

        query.getResultList().forEach(e -> System.out.printf("%s %s from %s - $%.2f%n",
                e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));


    }

    private void employeesWithSalaryOver50k() {
        entityManager.createQuery("SELECT e.firstName FROM Employee e WHERE e.salary > 50000",
                String.class).getResultList().forEach(System.out::println);
    }

    private void containsEmployee() throws IOException {
        System.out.println("Please enter employee name: ");
        String employeeName = bufferedReader.readLine();

        TypedQuery<Employee> query = entityManager.createQuery("SELECT DISTINCT e FROM Employee e " +
                "WHERE concat(e.firstName,' ', e.lastName) = :employeeName", Employee.class);
        query.setParameter("employeeName", employeeName);

        List<Employee> resultList = query.getResultList();
        System.out.println(resultList.isEmpty() ? "No" : "Yes");
    }


    private void changeCasing() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Town t SET t.name = UPPER(t.name) WHERE length(t.name) <= :nameLength");
        query.setParameter("nameLength", 5);

        int affectedEntities = query.executeUpdate();
        entityManager.getTransaction().commit();
        System.out.println(affectedEntities);


    }
}
