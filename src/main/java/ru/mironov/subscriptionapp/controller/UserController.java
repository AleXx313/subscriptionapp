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
import org.springframework.web.util.UriComponentsBuilder;
import ru.mironov.subscriptionapp.controller.payload.NewUserPayload;
import ru.mironov.subscriptionapp.controller.payload.UpdateUserPayload;
import ru.mironov.subscriptionapp.entity.User;
import ru.mironov.subscriptionapp.service.UserService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "User Controller", description = "Управление пользователями")
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    @Operation(
            summary = "Создать пользователя",
            description = "Возвращает созданного пользователя"
    )
    @ApiResponse(responseCode = "201", description = "Пользователь создан")
    @ApiResponse(responseCode = "400", description = "Ошибка валидации")
    public ResponseEntity<User> createUser(@RequestBody @Valid NewUserPayload payload,
                                           BindingResult bindingResult,
                                           UriComponentsBuilder uriComponentsBuilder) throws BindException {
        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
                throw exception;
            } else {
                throw new BindException(bindingResult);
            }
        } else {
            User user = userService.save(payload);
            log.debug("Created new user: {}", user);
            return ResponseEntity.created(
                            uriComponentsBuilder
                                    .replacePath("/users/{id}")
                                    .build(Map.of("id", user.getId())))
                    .body(user);
        }
    }

    @Operation(
            summary = "Получить пользователя по id",
            description = "Возвращает пользователя с указанным идентификатором"
    )
    @ApiResponse(responseCode = "200", description = "Пользователь найден")
    @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    @GetMapping("{id}")
    public ResponseEntity<User> findUser(@PathVariable("id") Integer id) {
        User user = userService.findById(id);
        log.debug("User found: {}", user);
        return ResponseEntity.ok(user);
    }

    @Operation(
            summary = "Обновить пользователя по id",
            description = "Возвращает обновленного пользователя"
    )
    @ApiResponse(responseCode = "200", description = "Пользователь обновлен")
    @ApiResponse(responseCode = "400", description = "Ошибка валидации")
    @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    @PatchMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id,
                                           @RequestBody @Valid UpdateUserPayload payload,
                                           BindingResult bindingResult) throws BindException {
        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
                throw exception;
            } else {
                throw new BindException(bindingResult);
            }
        } else {
            User user = userService.update(id, payload);
            log.debug("User updated: {}", user);
            return ResponseEntity.ok(user);
        }
    }

    @Operation(
            summary = "Удалить пользователя по id",
            description = "Тело ответа отсутствует"
    )
    @ApiResponse(responseCode = "204", description = "Пользователь удален")
    @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        log.debug("User with id - {} deleted", id);
        return ResponseEntity.noContent().build();
    }
}
