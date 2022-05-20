package ru.lastuhinaa.RepairService.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import ru.lastuhinaa.RepairService.Repository.OrdersRepository;

@PageTitle("home")
public class HomeView extends VerticalLayout {
    public HomeView(OrdersRepository ordersRepository) {
        TextField username = new TextField("Введите ваш номер заказа");
        Button button = new Button("Поиск");

        add(username,button);

        button.addClickListener(buttonClickEvent -> {
            if(ordersRepository.getById(Long.valueOf(username.getValue())) !=  null){
                //Вывести информацию
            }
        });
    }


}
