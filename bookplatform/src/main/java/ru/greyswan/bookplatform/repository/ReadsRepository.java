package ru.greyswan.bookplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.greyswan.bookplatform.entity.ReadEntity;
import ru.greyswan.bookplatform.entity.UserEntity;

import java.util.List;

@Repository
public interface ReadsRepository extends JpaRepository<ReadEntity, Long> {

    List<ReadEntity> findReadEntitiesByUser(UserEntity user);

}
