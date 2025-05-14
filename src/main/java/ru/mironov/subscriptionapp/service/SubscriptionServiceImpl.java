package ru.mironov.subscriptionapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mironov.subscriptionapp.entity.Subscription;
import ru.mironov.subscriptionapp.repository.SubscriptionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    @Override
    public List<Subscription> findTopSubscription() {
        return subscriptionRepository.findMostPopularSubscriptions();
    }
}
