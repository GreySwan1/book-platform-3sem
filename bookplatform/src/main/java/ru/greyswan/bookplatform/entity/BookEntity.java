package ru.greyswan.bookplatform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "picture", length = Integer.MAX_VALUE)
    private String picture;

    @Column(name = "title", length = Integer.MAX_VALUE)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "language", length = Integer.MAX_VALUE)
    private String language;

    @Column(name = "genre", length = Integer.MAX_VALUE)
    private String genre;

    @Column(name = "year_of_publish", length = Integer.MAX_VALUE)
    private String yearOfPublish;

}