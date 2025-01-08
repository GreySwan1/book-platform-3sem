package ru.greyswan.bookplatform.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String login;

    private String picture;

    private String registrationDate;

    private Integer booksRead;

    private String nowReading;

    private List<ReviewDto> reviews;

}
