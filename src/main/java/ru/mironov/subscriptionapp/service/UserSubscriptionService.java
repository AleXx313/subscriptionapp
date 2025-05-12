package ru.mironov.subscriptionapp.service;

import ru.mironov.subscriptionapp.controller.payload.NewSubscriptionPayload;
import ru.mironov.subscriptionapp.entity.Subscription;

import java.util.Set;

public interface UserSubscriptionService {

    void addSubscription(Integer userId, NewSubscriptionPayload subscriptionPayload);

    Set<Subscription> getUserSubscriptions(Integer userId);

    void deleteSubscription(Integer userId, Integer subscriptionId);
}
