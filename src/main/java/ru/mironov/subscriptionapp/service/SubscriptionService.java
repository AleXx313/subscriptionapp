package ru.mironov.subscriptionapp.service;

import ru.mironov.subscriptionapp.entity.Subscription;

public interface SubscriptionService {

    Iterable<Subscription> findTopSubscription();
}
