package ru.greyswan.bookplatform.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.greyswan.bookplatform.dto.AuthorDto;
import ru.greyswan.bookplatform.dto.BookDto;
import ru.greyswan.bookplatform.dto.BooksArrayDto;
import ru.greyswan.bookplatform.entity.AuthorEntity;
import ru.greyswan.bookplatform.entity.BookEntity;
import ru.greyswan.bookplatform.repository.BooksRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksArrayDto getAllBooks() {
        List<BookEntity> bookEntities = booksRepository.findAll();

        List<BookDto> bookDtos = new ArrayList<>();
        for (BookEntity bookEntity : bookEntities) {
            BookDto bookDto = new BookDto();
            bookDto.setId(bookEntity.getId());
            bookDto.setTitle(bookEntity.getTitle());
            bookDto.setPicture(bookEntity.getPicture());
            bookDto.setAuthor(getAuthorDto(bookEntity.getAuthor()));
            bookDto.setDescription(bookEntity.getDescription());
            bookDto.setLanguage(bookEntity.getLanguage());
            bookDto.setGenre(bookEntity.getGenre());
            bookDto.setYearOfPublish(bookEntity.getYearOfPublish());
            bookDtos.add(bookDto);
        }

        BooksArrayDto booksArrayDto = new BooksArrayDto();
        booksArrayDto.setBooks(bookDtos);
        return booksArrayDto;
    }

    public BookDto getBookById(Long id) {
        BookEntity bookEntity = booksRepository.findById(id).orElseThrow();

        BookDto bookDto = new BookDto();
        bookDto.setId(bookEntity.getId());
        bookDto.setTitle(bookEntity.getTitle());
        bookDto.setPicture(bookEntity.getPicture());
        bookDto.setAuthor(getAuthorDto(bookEntity.getAuthor()));
        bookDto.setDescription(bookEntity.getDescription());
        bookDto.setLanguage(bookEntity.getLanguage());
        bookDto.setGenre(bookEntity.getGenre());
        bookDto.setYearOfPublish(bookEntity.getYearOfPublish());

        return bookDto;
    }

    private AuthorDto getAuthorDto(AuthorEntity authorEntity) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(authorEntity.getId());
        authorDto.setPicture(authorEntity.getPicture());
        authorDto.setFistName(authorEntity.getFirstName());
        authorDto.setLastName(authorEntity.getLastName());
        authorDto.setPatronymic(authorEntity.getPatronymic());
        authorDto.setDateOfBirth(authorEntity.getDateOfBirth());
        authorDto.setDateOfDeath(authorEntity.getDateOfDeath());
        authorDto.setBiography(authorEntity.getBiography());
        return authorDto;
    }

}
