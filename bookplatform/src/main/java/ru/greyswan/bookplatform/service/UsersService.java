package ru.greyswan.bookplatform.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.greyswan.bookplatform.dto.ReviewDto;
import ru.greyswan.bookplatform.dto.UserDto;
import ru.greyswan.bookplatform.dto.UsersArrayDto;
import ru.greyswan.bookplatform.entity.ReadEntity;
import ru.greyswan.bookplatform.entity.UserEntity;
import ru.greyswan.bookplatform.repository.ReadsRepository;
import ru.greyswan.bookplatform.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final ReadsRepository readsRepository;

    public UsersArrayDto getUsers() {
        List<UserEntity> userEntities = usersRepository.findAll();

        List<UserDto> userDtos = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            UserDto userDto = new UserDto();
            userDto.setLogin(userEntity.getLogin());
            userDto.setPicture(userEntity.getPicture());

            List<ReadEntity> reads = readsRepository.findReadEntitiesByUser(userEntity);
            userDto.setBooksRead(reads.size());
            userDto.setReviews(reads.stream().map(this::getReviewDto).toList());

            userDtos.add(userDto);
        }

        UsersArrayDto usersArrayDto = new UsersArrayDto();
        usersArrayDto.setUsers(userDtos);
        return usersArrayDto;
    }

    public UserDto getUserById(Long id) {
        UserEntity userEntity = usersRepository.findById(id).orElseThrow();

        UserDto userDto = new UserDto();
        userDto.setLogin(userEntity.getLogin());
        userDto.setPicture(userEntity.getPicture());

        List<ReadEntity> reads = readsRepository.findReadEntitiesByUser(userEntity);
        userDto.setBooksRead(reads.size());
        userDto.setReviews(reads.stream().map(this::getReviewDto).toList());

        return userDto;
    }

    private ReviewDto getReviewDto(ReadEntity readEntity) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(readEntity.getId());
        reviewDto.setRate(readEntity.getRate());
        reviewDto.setText(readEntity.getReview());
        return reviewDto;
    }

}
