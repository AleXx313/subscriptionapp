package ru.mironov.subscriptionapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(schema = "app_subscription", name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "birthdate")
    private LocalDateTime birthdate;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
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
