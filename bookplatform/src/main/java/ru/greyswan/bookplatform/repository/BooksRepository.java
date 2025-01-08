package ru.greyswan.bookplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.greyswan.bookplatform.entity.AuthorEntity;
import ru.greyswan.bookplatform.entity.BookEntity;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findBookEntitiesByAuthor(AuthorEntity author);

}
