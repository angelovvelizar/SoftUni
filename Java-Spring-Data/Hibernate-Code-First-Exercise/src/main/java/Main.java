import entity.universityEntities.Course;
import entity.universityEntities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo");
        EntityManager em = entityManagerFactory.createEntityManager();

        em.close();


    }
}
