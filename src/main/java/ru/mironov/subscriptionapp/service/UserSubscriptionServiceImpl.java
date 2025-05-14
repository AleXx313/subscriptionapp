package ru.mironov.subscriptionapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mironov.subscriptionapp.controller.payload.NewSubscriptionPayload;
import ru.mironov.subscriptionapp.entity.Subscription;
import ru.mironov.subscriptionapp.entity.User;
import ru.mironov.subscriptionapp.exception.NotFoundException;
import ru.mironov.subscriptionapp.repository.SubscriptionRepository;
import ru.mironov.subscriptionapp.repository.UserRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserSubscriptionServiceImpl implements UserSubscriptionService {

    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;

    @Override
    public void addSubscription(Integer userId, NewSubscriptionPayload subscriptionPayload) {
        User user = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        Subscription subscription = subscriptionRepository.findByTitle(subscriptionPayload.getTitle())
                .orElseGet(() -> {
                    Subscription newSubscription = new Subscription();
                    newSubscription.setTitle(subscriptionPayload.getTitle());
                    newSubscription.setDetails(subscriptionPayload.getDetails());
                    return subscriptionRepository.save(newSubscription);
                });
        user.addSubscription(subscription);
        userRepository.save(user);
    }

    @Override
    public Set<Subscription> getUserSubscriptions(Integer userId) {
        return userRepository.findById(userId).orElseThrow(NotFoundException::new).getSubscriptions();
    }

    @Override
    public void deleteSubscription(Integer userId, Integer subscriptionId) {
        User user = userRepository.findById(userId).orElseThrow(NotFoundException::new);
        Subscription subscription = subscriptionRepository.findById(subscriptionId).orElseThrow(NotFoundException::new);
        user.removeSubscription(subscription);
        userRepository.save(user);
    }
}
