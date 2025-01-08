package ru.greyswan.bookplatform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.greyswan.bookplatform.service.UsersService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/api/v1/users")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    public ResponseEntity<?> getUsers() {
        try {
            return ResponseEntity.ok(usersService.getUsers());
        } catch (Exception e) {
            log.error("Ошибка: ", e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/api/v1/users/{id}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.OPTIONS})
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(usersService.getUserById(id));
        } catch (Exception e) {
            log.error("Ошибка: ", e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
