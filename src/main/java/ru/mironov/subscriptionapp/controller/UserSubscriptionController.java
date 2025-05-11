package ru.mironov.subscriptionapp.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mironov.subscriptionapp.service.UserSubscriptionService;

@RestController
@RequiredArgsConstructor
public class UserSubscriptionController {

    private final UserSubscriptionService userSubscriptionService;



}
