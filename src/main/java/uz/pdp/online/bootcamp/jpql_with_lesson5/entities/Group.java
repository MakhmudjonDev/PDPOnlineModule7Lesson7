package uz.pdp.online.bootcamp.jpql_with_lesson5.entities;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "group_jakarta")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String name;
    private LocalDateTime createdAt;
    private int studentCount;
    @Column(name = "createdby")
    private Integer createdBy;


}
