package ru.greyswan.bookplatform.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.greyswan.bookplatform.helper.ResponseHelper;

@RestController
@RequestMapping("/api/v1")
@Profile("MOCK")
public class MockController {

    private final ResponseHelper responseHelper;

    public MockController(ResponseHelper responseHelper) {
        this.responseHelper = responseHelper;
    }

    @GetMapping("/authors")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    public ResponseEntity<String> getAuthors() {
        return responseHelper.response("authors.json");
    }

    @GetMapping("/books")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    public ResponseEntity<String> getBooks() {
        return responseHelper.response("books.json");
    }

    @GetMapping("/users")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    public ResponseEntity<String> getUsers() {
        return responseHelper.response("users.json");
    }

    @GetMapping("/books/{id}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    public ResponseEntity<String> getBookById(@PathVariable String id) {
        return responseHelper.response("book.json");
    }

    @GetMapping("/authors/{id}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    public ResponseEntity<String> getAuthorById(@PathVariable String id) {
        return responseHelper.response("author.json");
    }

    @GetMapping("/users/{id}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    public ResponseEntity<String> getUserById(@PathVariable String id) {
        return responseHelper.response("user.json");
    }

}
