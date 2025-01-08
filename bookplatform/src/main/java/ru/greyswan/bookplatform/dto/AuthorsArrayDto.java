package ru.greyswan.bookplatform.dto;

import lombok.Data;

import java.util.List;

@Data
public class AuthorsArrayDto {

    private List<AuthorDto> authors;

}
