package ru.mironov.subscriptionapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mironov.subscriptionapp.entity.Subscription;

import java.util.Optional;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {

    Optional<Subscription> findByTitle(String title);
}
