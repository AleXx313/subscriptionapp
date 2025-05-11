package ru.mironov.subscriptionapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mironov.subscriptionapp.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
