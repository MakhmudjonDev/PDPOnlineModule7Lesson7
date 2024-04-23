package uz.pdp.online.bootcamp.jpql_with_lesson5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(nullable = false)
    private String fullName;
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private int groupID;
    @Column(nullable = false)
    private int age;
    @Column(name = "createdby")
    private Integer createdBy;
}
