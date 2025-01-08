package ru.greyswan.bookplatform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "picture", length = Integer.MAX_VALUE)
    private String picture;

    @Column(name = "first_name", length = Integer.MAX_VALUE)
    private String firstName;

    @Column(name = "last_name", length = Integer.MAX_VALUE)
    private String lastName;

    @Column(name = "patronymic", length = Integer.MAX_VALUE)
    private String patronymic;

    @Column(name = "date_of_birth", length = Integer.MAX_VALUE)
    private String dateOfBirth;

    @Column(name = "date_of_death", length = Integer.MAX_VALUE)
    private String dateOfDeath;

    @Column(name = "biography", length = Integer.MAX_VALUE)
    private String biography;

}