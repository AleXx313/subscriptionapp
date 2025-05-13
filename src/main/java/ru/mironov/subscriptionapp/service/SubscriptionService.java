package ru.mironov.subscriptionapp.service;

import ru.mironov.subscriptionapp.entity.Subscription;

import java.util.List;

public interface SubscriptionService {

    List<Subscription> findTopSubscription();
}
