package ru.mironov.subscriptionapp.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Schema(description = "Сущность подписки")
@Table(schema = "app_subscription", name = "subscriptions")
public class Subscription {

    @Id
    @Schema(description = "Уникальный идентификатор подписки", example = "1")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Schema(description = "Наименование подписки", example = "Подписка-1")
    @Column(name = "title")
    private String title;

    @Schema(description = "Описание подписки", example = "Подписка-1 (описание)")
    @Column(name = "details")
    private String details;

    @JsonIgnore
    @ManyToMany(mappedBy = "subscriptions")
    private Set<User> users = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, details);
    }
}
