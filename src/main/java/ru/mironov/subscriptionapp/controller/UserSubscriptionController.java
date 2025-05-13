package ru.mironov.subscriptionapp.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "User_Subscription Controller", description = "Управление пользовательскими подписками")
@RequestMapping("user/{userId:\\d+}/subscription")
public class UserSubscriptionController {

    private final UserSubscriptionService userSubscriptionService;

    @PostMapping
    @Operation(
            summary = "Добавить подписку пользователю"
    )
    @ApiResponse(responseCode = "200", description = "Подписка добавлена")
    @ApiResponse(responseCode = "400", description = "Ошибка валидации")
    @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    public ResponseEntity<Void> addSubscription(@PathVariable("userId") Integer userId,
                                                @Valid NewSubscriptionPayload payload,
                                                BindingResult bindingResult) throws BindException {
        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
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
    @Operation(
            summary = "Добавить подписку пользователю"
    )
    @ApiResponse(responseCode = "204", description = "Подписка удалена")
    @ApiResponse(responseCode = "404", description = "Пользователь или подписка не найдены")
    public ResponseEntity<Void> removeSubscription(@PathVariable("userId") Integer userId,
                                                   @PathVariable("subscriptionId") Integer subscriptionId) {
        userSubscriptionService.deleteSubscription(userId, subscriptionId);
        log.debug("User subscription removed");
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Получить подписки пользователя",
            description = "Возвращает список подписок пользователя"
    )
    @ApiResponse(responseCode = "200", description = "Список получен")
    @ApiResponse(responseCode = "404", description = "Пользователь или подписка не найдены")
    @GetMapping
    public ResponseEntity<Set<Subscription>> getUserSubscriptions(@PathVariable("userId") Integer userId) {
        Set<Subscription> userSubscriptions = userSubscriptionService.getUserSubscriptions(userId);
        log.debug("User {} subscriptions found - {}", userId, userSubscriptions);
        return ResponseEntity.ok(userSubscriptions);
    }
}
