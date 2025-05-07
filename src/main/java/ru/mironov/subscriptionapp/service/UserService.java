package ru.mironov.subscriptionapp.service;

import ru.mironov.subscriptionapp.dto.UserDto;

public interface UserService {

    UserDto save(UserDto userDto);

    UserDto findById(Integer id);

    UserDto update(UserDto userDto);

    void deleteById(Integer id);
}
