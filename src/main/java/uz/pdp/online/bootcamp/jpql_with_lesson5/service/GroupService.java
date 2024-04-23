package uz.pdp.online.bootcamp.jpql_with_lesson5.service;


import jakarta.persistence.*;
import lombok.Generated;
import uz.pdp.online.bootcamp.jpql_with_lesson5.entities.Group;

import java.sql.*;
import java.time.LocalDateTime;

public class GroupService {
    public boolean save(String name, int studentCount, int creatorID){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Group group = Group.builder()
                .name(name)
                .createdAt(LocalDateTime.now())
                .studentCount(studentCount)
                .createdBy(creatorID)
                .build();

        entityManager.persist(group);

        entityManager.getTransaction().commit();

        return true;
    }

    public boolean update(int id, String name, int studentCount){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        Group group1 = entityManager.find(Group.class, id);
        group1.setName(name);
        group1.setStudentCount(studentCount);

//        Group group = Group.builder()
//                .id(id)
//                .name(name)
//                .studentCount(studentCount)
//                .build();

        entityManager.merge(group1);

        entityManager.getTransaction().commit();

        return true;
    }

    public boolean delete(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Group group = entityManager.find(Group.class, id);
        entityManager.remove(group);
        entityManager.getTransaction().commit();

        return true;
    }

    public Group get(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Group group = entityManager.find(Group.class, id);

        return group;
    }
}
