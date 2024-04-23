package uz.pdp.online.bootcamp.jpql_with_lesson5.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import uz.pdp.online.bootcamp.jpql_with_lesson5.entities.Group;
import uz.pdp.online.bootcamp.jpql_with_lesson5.entities.Student;

import java.sql.*;
import java.time.LocalDateTime;

public class StudentService {

    public boolean save(String fullName, int groupID, int age, int creatorID){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = Student.builder()
                .fullName(fullName)
                .groupID(groupID)
                .age(age)
                .createdBy(creatorID)
                .createdAt(LocalDateTime.now())
                .build();

        entityManager.persist(student);

        entityManager.getTransaction().commit();

        return true;
    }

    public boolean update(int id, String fullName, int groupID, int age){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student student1 = entityManager.find(Student.class, id);

        student1.setAge(age);
        student1.setFullName(fullName);
        student1.setGroupID(groupID);

/*        Student student = Student.builder()
                .id(id)
                .fullName(fullName)
                .groupID(groupID)
                .build();*/

        entityManager.merge(student1);

        entityManager.getTransaction().commit();

        return true;
    }

    public boolean delete(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
        entityManager.getTransaction().commit();

        return true;
    }

    public Student get(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        return entityManager.find(Student.class, id);
    }
}
