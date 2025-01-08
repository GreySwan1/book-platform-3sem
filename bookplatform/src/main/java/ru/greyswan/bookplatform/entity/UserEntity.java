package ru.greyswan.bookplatform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "picture", length = Integer.MAX_VALUE)
    private String picture;

    @Column(name = "login", length = Integer.MAX_VALUE)
    private String login;

    @Column(name = "password", length = Integer.MAX_VALUE)
    private String password;

}