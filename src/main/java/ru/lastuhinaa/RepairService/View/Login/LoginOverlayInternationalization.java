package ru.lastuhinaa.RepairService.View.Login;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import ru.lastuhinaa.RepairService.Model.Role;
import ru.lastuhinaa.RepairService.Repository.UserRepository;
import ru.lastuhinaa.RepairService.Service.AuthService;

@Route("login")
@PageTitle("Войти")
public class LoginOverlayInternationalization extends Div {

    public LoginOverlayInternationalization(AuthService authService, UserRepository userRepository) {
        LoginI18n i18n = LoginI18n.createDefault();

        LoginI18n.Form i18nForm = i18n.getForm();
        i18nForm.setTitle("Мастерская");
        i18nForm.setUsername("Логин");
        i18nForm.setPassword("Пароль");
        i18nForm.setSubmit("Войти");
        i18nForm.setForgotPassword("Зарегистрироваться");
        i18n.setForm(i18nForm);


        LoginI18n.ErrorMessage i18nErrorMessage = i18n.getErrorMessage();
        i18nErrorMessage.setTitle("Ошибка");
        i18nErrorMessage.setMessage("Попробуйте снова");
        i18n.setErrorMessage(i18nErrorMessage);

        LoginOverlay loginOverlay = new LoginOverlay();
        loginOverlay.setI18n(i18n);
        add(loginOverlay);
        loginOverlay.setOpened(true);

        loginOverlay.setTitle("Мастерская");
        loginOverlay.setDescription("Проверить готовность заказа");
        loginOverlay.getElement().setAttribute("no-autofocus", "");


        loginOverlay.addLoginListener(loginEvent -> {
            try {
                authService.authenticate(loginEvent.getUsername(), loginEvent.getPassword());
                if (userRepository.getByUsername(loginEvent.getUsername()).getRole().equals(Role.ADMIN)) {
                    UI.getCurrent().navigate("orders");
                } else {
                    UI.getCurrent().navigate("home");
                }
            } catch (AuthService.AuthException e) {
                Notification.show("Неправильные данные, попробуйте снова");
            }
        });


        loginOverlay.addForgotPasswordListener(forgotPasswordEvent -> {
            UI.getCurrent().navigate("registerЙ");
        });
    }
}
