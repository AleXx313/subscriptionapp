# Spring SubscriptionApp
## Тестовое задание

### Описание задания
Необходимо создать небольшой REST сервис с пользователями и подписками.

### Описание проекта
Было создано приложение для создания пользователей и добавления им подписок.
<br>
<br>Подробная документация доступна по ссылке: http://localhost:8080/swagger-ui/index.html <br>
OAS доступна по ссылке: http://localhost:8080/v3/api-docs

### Запуск
Приложение запускается в docker контейнерах.
Для работы необходимы docker и docker-compose.
Запуск осуществляется через docker-compose файл.
Для запуска необходимо:
- Скачать проект с GitHub.
- Перейти в корневую папку проекта
- В терминале ввести команду ```docker-compose up```


По умолчанию приложение запустится на порту 8080.
<details>
<summary><strong>📝 TODO List</strong></summary>

### Задачи на будущее:
- [ ] Добавить сообщения для ошибок. Добавить локализацию сообщений.
- [ ] Доработать уникальность имен и email пользователей.
- [ ] Добавить DTO модели для корректных ответов.
- [ ] Разработать сервис для работы с подписками.
- [ ] Доработать логирование.
- [ ] Добавить тесты.
</details>

### Используемые технологии
+ [Java](https://www.java.com/) (17)
+ [Spring Boot](https://spring.io/projects/spring-boot) (3)
+ [Hibernate](https://hibernate.org)
+ [PostgreSQL](https://www.postgresql.org)
+ [Apache Maven](https://maven.apache.org)
+ [Project Lombok](https://projectlombok.org)