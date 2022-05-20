package ru.lastuhinaa.RepairService.View.Login.ForgotPassword;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import ru.lastuhinaa.RepairService.Model.Person;
import ru.lastuhinaa.RepairService.Model.Role;
import ru.lastuhinaa.RepairService.Repository.UserRepository;


@Route(value = "forgot")
@PageTitle("Восстановление пароля")
@Component
public class ForgotPasswordView extends VerticalLayout {

    public ForgotPasswordView(UserRepository userRepository, JavaMailSender javaMailSender) {
        EmailField emailField = new EmailField();
        emailField.setLabel("Введите адрес почты");
        emailField.setErrorMessage("Введите корректный адрес почты");
        emailField.setClearButtonVisible(true);
        emailField.setPattern("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
        emailField.setHeightFull();
        Button button = new Button(("Отправить"));
        add(emailField, button);
        button.addClickListener(e -> {
            if (userRepository.getByUsername(emailField.getValue()) != null) {
                String s =  RandomStringUtils.randomAlphabetic(6);
                Person person = userRepository.save(new Person(emailField.getValue(), s, Role.USER, RandomStringUtils.randomAlphanumeric(5)));

                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom("sladkkov@yandex.ru");
                message.setText("Ваш новый пароль для входа на ресурс" + s);
                message.setTo(emailField.getValue());
                javaMailSender.send(message);
                Notification.show("Проверьте почту");
            } else {
                Notification.show("Такого пользователя не найдено");
            }
        });
    }

}