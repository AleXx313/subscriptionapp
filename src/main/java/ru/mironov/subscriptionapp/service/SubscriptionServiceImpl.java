package ru.mironov.subscriptionapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mironov.subscriptionapp.entity.Subscription;
import ru.mironov.subscriptionapp.repository.SubscriptionRepository;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    @Override
    public Iterable<Subscription> findTopSubscription() {
        return subscriptionRepository.findMostPopularSubscriptions();
    }
}
