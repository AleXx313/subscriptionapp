package ru.mironov.subscriptionapp.service;

import ru.mironov.subscriptionapp.controller.payload.NewUserPayload;
import ru.mironov.subscriptionapp.controller.payload.UpdateUserPayload;
import ru.mironov.subscriptionapp.entity.User;

public interface UserService {

    User save(NewUserPayload payload);

    User findById(Integer id);

    User update(Integer id, UpdateUserPayload payload);

    void deleteById(Integer id);
}
