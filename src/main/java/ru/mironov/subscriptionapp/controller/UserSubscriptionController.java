package ru.mironov.subscriptionapp.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mironov.subscriptionapp.controller.payload.NewSubscriptionPayload;
import ru.mironov.subscriptionapp.entity.Subscription;
import ru.mironov.subscriptionapp.service.UserSubscriptionService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("user/{userId:\\d+}/subscription")
public class UserSubscriptionController {

    private final UserSubscriptionService userSubscriptionService;

    @PostMapping
    public ResponseEntity<Void> addSubscription(@PathVariable("userId") Integer userId,
                                                @Valid NewSubscriptionPayload payload,
                                                BindingResult bindingResult) throws BindException{
        if (bindingResult.hasErrors()){
            if (bindingResult instanceof BindException exception){
                throw exception;
            } else {
                throw new BindException(bindingResult);
            }
        } else {
            userSubscriptionService.addSubscription(userId, payload);
            log.debug("User subscription added");
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("{subscriptionId}")
    public ResponseEntity<Void> removeSubscription(@PathVariable("userId") Integer userId,
                                                   @PathVariable("subscriptionId") Integer subscriptionId){
        userSubscriptionService.deleteSubscription(userId, subscriptionId);
        log.debug("User subscription removed");
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Set<Subscription>> getUserSubscriptions(@PathVariable("userId") Integer userId){
        Set<Subscription> userSubscriptions = userSubscriptionService.getUserSubscriptions(userId);
        log.debug("User {} subscriptions found - {}", userId, userSubscriptions);
        return ResponseEntity.ok(userSubscriptions);
    }

}
