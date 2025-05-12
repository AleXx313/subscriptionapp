package ru.mironov.subscriptionapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.mironov.subscriptionapp.entity.Subscription;

import java.util.Optional;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {

    Optional<Subscription> findByTitle(String title);

    @Query(value = """
                    select subs.id, subs.title, subs.details, COUNT(us.user_id) as user_count
                    from subscriptions as subs
                    left join user_subscription as us on subs.id = us.subscription_id
                    group by subs.id
                    order by user_count desc
                    limit 3
                    """, nativeQuery = true
    )
    Iterable<Subscription> findMostPopularSubscriptions();
}
