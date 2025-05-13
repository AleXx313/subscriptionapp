package ru.mironov.subscriptionapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mironov.subscriptionapp.entity.Subscription;
import ru.mironov.subscriptionapp.service.SubscriptionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Subscription Controller", description = "Управление подписками")
@Slf4j
@RequestMapping("subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Operation(
            summary = "Получить топ 3 подписки по популярности",
            description = "Возвращает список из 3 самых популярных подписок"
    )
    @ApiResponse(responseCode = "200", description = "Список получен")
    @GetMapping("top")
    public ResponseEntity<List<Subscription>> getMostPopularSubscriptions() {
        List<Subscription> topSubscription = subscriptionService.findTopSubscription();
        log.debug("Top subscriptions request complete with result: {}", topSubscription);
        return ResponseEntity.ok(topSubscription);
    }
}
