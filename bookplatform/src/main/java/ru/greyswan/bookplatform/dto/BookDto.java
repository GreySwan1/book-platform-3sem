package ru.greyswan.bookplatform.dto;

import lombok.Data;

@Data
public class BookDto {

    private Long id;

    private String picture;

    private String title;

    private AuthorDto author;

    private String description;

    private String language;

    private String genre;

    private String yearOfPublish;



}
