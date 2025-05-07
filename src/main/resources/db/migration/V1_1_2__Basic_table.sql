DROP TABLE IF EXISTS app_subscription.users;
DROP TABLE IF EXISTS app_subscription.subscriptions;

CREATE TABLE app_subscription.users
(
    id        serial primary key,
    username  varchar(50) not null,
    email     varchar(50) not null,
    birthdate date        not null
);

CREATE TABLE app_subscription.subscriptions
(
    id      serial primary key,
    title   varchar(50) not null,
    details text
);

CREATE TABLE app_subscription.user_subscription
(
    user_id         bigint not null,
    subscription_id bigint not null,
    PRIMARY KEY (user_id, subscription_id),
    FOREIGN KEY (user_id) REFERENCES app_subscription.users (id) ON DELETE CASCADE,
    FOREIGN KEY (subscription_id) REFERENCES app_subscription.subscriptions (id) ON DELETE CASCADE
);

CREATE INDEX idx_user_id ON app_subscription.user_subscription (user_id);
CREATE INDEX idx_subscription_id ON app_subscription.user_subscription (subscription_id);