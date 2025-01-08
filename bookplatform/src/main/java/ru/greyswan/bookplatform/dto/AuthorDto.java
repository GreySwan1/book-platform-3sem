package ru.greyswan.bookplatform.dto;

import lombok.Data;

import java.util.List;

@Data
public class AuthorDto {

    private Long id;

    private String picture;

    private String fistName;

    private String lastName;

    private String patronymic;

    private String dateOfBirth;

    private String dateOfDeath;

    private String biography;

    private List<BookDto> books;

}
