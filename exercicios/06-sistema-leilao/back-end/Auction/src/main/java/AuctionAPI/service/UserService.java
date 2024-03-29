package AuctionAPI.service;

import AuctionAPI.component.validation.component.EmailNotExists;
import AuctionAPI.component.validation.component.NotEmpty;
import AuctionAPI.component.validation.component.NotNull;
import AuctionAPI.component.validation.rule.Validation;
import AuctionAPI.dto.UserDto;
import AuctionAPI.exception.ExceptionGeneric;
import AuctionAPI.mapper.UserMapper;
import AuctionAPI.model.UserModel;
import AuctionAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService implements Validation<UserDto> {
    private final UserRepository userRepository;
    private final EmailNotExists emailNotExists;

    public UserModel save(UserDto user) {
        validated(user);

        return userRepository.save(UserMapper.toMapper(user));
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    public List<UserModel> listAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean validate(UserDto value) {
        return Stream.of(
                NotNull.isValid(value.getName()),
                NotNull.isValid(value.getEmail()),
                NotEmpty.isValid(value.getName()),
                NotEmpty.isValid(value.getEmail()),
                emailNotExists.isValid(value.getEmail())
        ).allMatch(valor -> valor.equals(true));
    }

    @Override
    public void validated(UserDto value) {
        if(!validate(value))
            throw new ExceptionGeneric("", "", 404);
    }
}
