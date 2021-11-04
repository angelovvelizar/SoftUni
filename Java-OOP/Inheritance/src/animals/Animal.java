package animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender){
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setGender(String gender) {
        if(gender.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }

        this.gender = gender;
    }

    private void setAge(int age) {
        if(age == ' ' || age < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private void setName(String name) {
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }

        this.name = name;
    }

    public String produceSound(){
        return "";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        sb.append(this.getName()).append(" ").append(this.age).append(" ").append(this.gender).append(System.lineSeparator());
        sb.append(produceSound());

        return sb.toString();
    }
}
