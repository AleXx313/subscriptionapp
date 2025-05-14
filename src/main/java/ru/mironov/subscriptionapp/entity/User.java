package ru.mironov.subscriptionapp.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Schema(description = "Сущность пользователя")
@Table(schema = "app_subscription", name = "users")
public class User {

    @Id
    @Schema(description = "Уникальный идентификатор подписки", example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Schema(description = "Имя пользователя", example = "Иван Иванов")
    @Column(name = "username")
    private String username;

    @Schema(description = "Email пользователя", example = "ivan@ivanov.ru")
    @Column(name = "email")
    private String email;

    @Schema(description = "Дата рождения пользователя", example = "2025-05-14")
    @Column(name = "birthdate")
    private LocalDate birthdate;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            schema = "app_subscription",
            name = "user_subscription",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "subscription_id")
    )
    private Set<Subscription> subscriptions;

    public void addSubscription(Subscription subscription) {
        this.subscriptions.add(subscription);
        subscription.getUsers().add(this);
    }

    public void removeSubscription(Subscription subscription) {
        this.subscriptions.remove(subscription);
        subscription.getUsers().remove(this);
    }
}
