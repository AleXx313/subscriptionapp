package ru.mironov.subscriptionapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mironov.subscriptionapp.entity.Subscription;
import ru.mironov.subscriptionapp.service.SubscriptionService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("subscriptions")
@Slf4j
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @GetMapping("top")
    public ResponseEntity<List<Subscription>> getMostPopularSubscriptions(){
        List<Subscription> topSubscription = subscriptionService.findTopSubscription();
        log.debug("Top subscriptions request complete with result: {}", topSubscription);
        return ResponseEntity.ok(topSubscription);
    }
}
