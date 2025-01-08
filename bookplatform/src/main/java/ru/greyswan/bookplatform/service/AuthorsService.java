package ru.greyswan.bookplatform.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.greyswan.bookplatform.dto.AuthorDto;
import ru.greyswan.bookplatform.dto.AuthorsArrayDto;
import ru.greyswan.bookplatform.dto.BookDto;
import ru.greyswan.bookplatform.entity.AuthorEntity;
import ru.greyswan.bookplatform.entity.BookEntity;
import ru.greyswan.bookplatform.repository.AuthorsRepository;
import ru.greyswan.bookplatform.repository.BooksRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorsService {

    private final AuthorsRepository authorsRepository;
    private final BooksRepository booksRepository;

    public AuthorsArrayDto getAllAuthors() {
        List<AuthorEntity> authorEntities = authorsRepository.findAll();

        List<AuthorDto> authorDtos = new ArrayList<>();
        for (AuthorEntity authorEntity : authorEntities) {
            List<BookEntity> bookEntities = booksRepository.findBookEntitiesByAuthor(authorEntity);

            AuthorDto authorDto = new AuthorDto();
            authorDto.setId(authorEntity.getId());
            authorDto.setPicture(authorEntity.getPicture());
            authorDto.setFistName(authorEntity.getFirstName());
            authorDto.setLastName(authorEntity.getLastName());
            authorDto.setPatronymic(authorEntity.getPatronymic());
            authorDto.setDateOfBirth(authorEntity.getDateOfBirth());
            authorDto.setDateOfDeath(authorEntity.getDateOfDeath());
            authorDto.setBiography(authorEntity.getBiography());

            List<BookDto> bookDtos = new ArrayList<>();
            for (BookEntity bookEntity : bookEntities) {
                BookDto bookDto = getBookDto(bookEntity);
                bookDtos.add(bookDto);
            }
            authorDto.setBooks(bookDtos);
            authorDtos.add(authorDto);
        }

        AuthorsArrayDto authorsArrayDto = new AuthorsArrayDto();
        authorsArrayDto.setAuthors(authorDtos);
        return authorsArrayDto;
    }

    public AuthorDto getAuthorById(Long id) {
        AuthorEntity authorEntity = authorsRepository.findById(id).orElseThrow();
        List<BookEntity> bookEntities = booksRepository.findBookEntitiesByAuthor(authorEntity);

        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(authorEntity.getId());
        authorDto.setPicture(authorEntity.getPicture());
        authorDto.setFistName(authorEntity.getFirstName());
        authorDto.setLastName(authorEntity.getLastName());
        authorDto.setPatronymic(authorEntity.getPatronymic());
        authorDto.setDateOfBirth(authorEntity.getDateOfBirth());
        authorDto.setDateOfDeath(authorEntity.getDateOfDeath());
        authorDto.setBiography(authorEntity.getBiography());
        List<BookDto> bookDtos = new ArrayList<>();
        for (BookEntity bookEntity : bookEntities) {
            BookDto bookDto = getBookDto(bookEntity);
            bookDtos.add(bookDto);
        }
        authorDto.setBooks(bookDtos);
        return authorDto;
    }

    private BookDto getBookDto(BookEntity bookEntity) {
        BookDto bookDto = new BookDto();
        bookDto.setId(bookEntity.getId());
        bookDto.setPicture(bookEntity.getPicture());
        bookDto.setTitle(bookEntity.getTitle());
        bookDto.setDescription(bookEntity.getDescription());
        bookDto.setLanguage(bookEntity.getLanguage());
        bookDto.setGenre(bookEntity.getGenre());
        bookDto.setYearOfPublish(bookEntity.getYearOfPublish());
        return bookDto;
    }

}
