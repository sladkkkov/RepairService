package ru.lastuhinaa.RepairService.Service;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.server.VaadinSession;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import ru.lastuhinaa.RepairService.Model.Person;
import ru.lastuhinaa.RepairService.Model.Role;
import ru.lastuhinaa.RepairService.Repository.UserRepository;
import ru.lastuhinaa.RepairService.View.Logout.LogoutView;
import ru.lastuhinaa.RepairService.View.MainView;
import ru.lastuhinaa.RepairService.View.MasterView;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    public record AuthorizedRoute(String route, String name, Class<? extends Component> view) {

    }

    public class AuthException extends Exception {

    }

    private final UserRepository userRepository;
    public final JavaMailSender emailSender;

    public AuthService(UserRepository userRepository, JavaMailSender emailSender) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    public void authenticate(String username, String password) throws AuthException {
        Person person = userRepository.getByUsername(username);
        if (person != null && person.checkPassword(password) && person.isActive()) {
            VaadinSession.getCurrent().setAttribute(Person.class, person);
            createRoutes(person.getRole());
        } else {
            throw new AuthException();
        }
    }

    private void createRoutes(Role role) {
        getAuthorizedRoutes(role).stream()
                .forEach(route ->
                        RouteConfiguration.forSessionScope().setRoute(
                                route.route, route.view, MainView.class));
    }

    public List<AuthorizedRoute> getAuthorizedRoutes(Role role) {
        var routes = new ArrayList<AuthorizedRoute>();

        if (role.equals(Role.USER)) {
            routes.add(new AuthorizedRoute("logout", "Logout", LogoutView.class));
            routes.add(new AuthorizedRoute("home", "Home", LogoutView.class));

        } else if (role.equals(Role.ADMIN)) {
            routes.add(new AuthorizedRoute("admin", "Admin", MasterView.class));
            routes.add(new AuthorizedRoute("logout", "Logout", LogoutView.class));
        }

        return routes;
    }

    public void register(String email, String password) throws AuthException {
        Person person = userRepository.save(new Person(email, password, Role.ADMIN, RandomStringUtils.randomAlphanumeric(5)));

        String text = "http://localhost:8080/activate?code=" + person.getActivationCode();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sladkkov@yandex.ru");
        message.setText(text);
        message.setTo(email);
        activate(person.getActivationCode());
        emailSender.send(message);
    }

    public void activate(String activationCode) throws AuthException {
        Person person = userRepository.getByActivationCode(activationCode);
        if (person != null) {
            person.setActive(true);
            userRepository.save(person);
        } else {
            throw new AuthException();
        }
    }

}
