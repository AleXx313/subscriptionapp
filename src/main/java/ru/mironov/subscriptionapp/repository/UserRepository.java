package ru.mironov.subscriptionapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mironov.subscriptionapp.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
