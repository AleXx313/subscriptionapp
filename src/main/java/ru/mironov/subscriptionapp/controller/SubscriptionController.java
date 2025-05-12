package ru.mironov.subscriptionapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mironov.subscriptionapp.service.SubscriptionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;
}
