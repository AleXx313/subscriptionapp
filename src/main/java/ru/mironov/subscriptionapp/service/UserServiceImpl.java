package ru.mironov.subscriptionapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mironov.subscriptionapp.controller.payload.NewUserPayload;
import ru.mironov.subscriptionapp.controller.payload.UpdateUserPayload;
import ru.mironov.subscriptionapp.exception.NotFoundException;
import ru.mironov.subscriptionapp.entity.User;
import ru.mironov.subscriptionapp.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(NewUserPayload payload) {
        User user = User.builder()
                .username(payload.getUsername())
                .email(payload.getEmail())
                .birthdate(payload.getBirthdate())
                .build();
        return userRepository.save(user);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public User update(Integer id, UpdateUserPayload payload) {
        User user = userRepository.findById(id).orElseThrow(NotFoundException::new);
        user.setUsername(payload.getUsername());
        user.setEmail(payload.getEmail());
        user.setBirthdate(payload.getBirthdate());
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.findById(id).ifPresentOrElse(
                userRepository::delete,
                NotFoundException::new);
    }
}
