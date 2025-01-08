package ru.greyswan.bookplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.greyswan.bookplatform.entity.UserEntity;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Long> {
}
