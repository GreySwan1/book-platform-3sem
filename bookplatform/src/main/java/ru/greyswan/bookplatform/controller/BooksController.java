package ru.greyswan.bookplatform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.greyswan.bookplatform.service.BooksService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BooksController {

    private final BooksService booksService;

    @GetMapping("/api/v1/books")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    public ResponseEntity<?> getBooks() {
        try {
            return ResponseEntity.ok(booksService.getAllBooks());
        } catch (Exception e) {
            log.error("Ошибка: ", e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/api/v1/books/{id}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    public ResponseEntity<?> getBookById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(booksService.getBookById(id));
        } catch (Exception e) {
            log.error("Ошибка: ", e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
