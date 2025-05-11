package ru.mironov.subscriptionapp.service;

import ru.mironov.subscriptionapp.controller.payload.NewSubscriptionPayload;

public interface UserSubscriptionService {

    void addSubscription(Integer userId, NewSubscriptionPayload subscriptionPayload);

    void updateSubscription(Integer userId, Integer subscriptionId, NewSubscriptionPayload subscriptionPayload);

    void deleteSubscription(Integer userId, Integer subscriptionId);
}
