package ru.greyswan.bookplatform.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsersArrayDto {

    private List<UserDto> users;

}
