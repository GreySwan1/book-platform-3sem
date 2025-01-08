package ru.greyswan.bookplatform.dto;

import lombok.Data;
import ru.greyswan.bookplatform.entity.BookEntity;
import ru.greyswan.bookplatform.entity.UserEntity;

@Data
public class ReviewDto {

    private Long id;

    private BookEntity book;

    private UserEntity user;

    private String rate;

    private String text;

}
