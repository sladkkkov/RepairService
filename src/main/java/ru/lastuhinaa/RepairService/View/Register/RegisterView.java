package ru.lastuhinaa.RepairService.View.Register;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.BoxSizing;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import ru.lastuhinaa.RepairService.Service.AuthService;

@Route("register")
@PageTitle("Регистрация")

public class RegisterView extends Composite<VerticalLayout> {

    private final AuthService authService;

    public RegisterView(AuthService authService1) {
        this.authService = authService1;
        TextField firstName = new TextField("Почта");
        TextField lastName = new TextField("Имя");
        TextField username = new TextField("Фамилия");
        PasswordField password = new PasswordField("Пароль");
        PasswordField confirmPassword = new PasswordField("Подтвердите пароль");
        VerticalLayout layout = getContent();
        FormLayout formLayout = new FormLayout();

        formLayout.add(
                firstName, lastName,
                username,
                password, confirmPassword
        );
        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("500px", 2)
        );
        layout.setAlignItems(FlexComponent.Alignment.CENTER);

        layout.add(formLayout, new Button("Отправить", event -> {
            try {
                register(
                        username.getValue(),
                        password.getValue(),
                        confirmPassword.getValue()
                );
            } catch (AuthService.AuthException e) {
                e.printStackTrace();
            }
        }));
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
    }


    private void register(String username, String password1, String password2) throws AuthService.AuthException {
        if (username.trim().isEmpty()) {
            Notification.show("Введите логин");
        } else if (password1.isEmpty()) {
            Notification.show("Введите пароль");
        } else if (!password1.equals(password2)) {
            Notification.show("Пароли не совпадают");
        } else {
            authService.register(username, password1);
            Notification.show("Проверьте почту!");
        }
    }
}