package ru.greyswan.bookplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.greyswan.bookplatform.entity.AuthorEntity;

import java.util.Optional;

@Repository
public interface AuthorsRepository extends JpaRepository<AuthorEntity, Long> {

}
