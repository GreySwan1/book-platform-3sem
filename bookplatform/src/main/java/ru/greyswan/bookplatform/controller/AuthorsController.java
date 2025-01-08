package ru.greyswan.bookplatform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.greyswan.bookplatform.service.AuthorsService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthorsController {

    private final AuthorsService authorsService;

    @GetMapping("/api/v1/authors")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    public ResponseEntity<?> getAuthors() {
        try {
            return ResponseEntity.ok(authorsService.getAllAuthors());
        } catch (Exception e) {
            log.error("Ошибка: ", e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/api/v1/authors/{id}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    public ResponseEntity<?> getAuthorById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(authorsService.getAuthorById(id));
        } catch (Exception e) {
            log.error("Ошибка: ", e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
