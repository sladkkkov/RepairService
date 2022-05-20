package ru.lastuhinaa.RepairService.View.OrdersView;


import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.crudui.crud.impl.GridCrud;
import ru.lastuhinaa.RepairService.Model.Orders;
import ru.lastuhinaa.RepairService.Service.OrdersService;
import ru.lastuhinaa.RepairService.View.MainLayout;

@Route(value = "orders", layout = MainLayout.class)
@PageTitle("Administration Panel")

public class OrdersView extends VerticalLayout {
    public OrdersView(OrdersService ordersService) {
        setSpacing(false);


        GridCrud<Orders> ordersGridCrud = new GridCrud<>(Orders.class, ordersService);

       ordersGridCrud.getGrid().setColumnReorderingAllowed(true);

       ordersGridCrud.getGrid().setColumns("orderId", "customerProblem", "realProblem", "status", "dateAcceptance", "dateFinish","cost");
       ordersGridCrud.getGrid().getColumnByKey("orderId").setHeader("Айди");
       ordersGridCrud.getGrid().getColumnByKey("customerProblem").setHeader("Проблема");
       ordersGridCrud.getGrid().getColumnByKey("realProblem").setHeader("Что нужно сделать");
       ordersGridCrud.getGrid().getColumnByKey("status").setHeader("Статус");
       ordersGridCrud.getGrid().getColumnByKey("dateAcceptance").setHeader("Дата поступления");
       ordersGridCrud.getGrid().getColumnByKey("dateFinish").setHeader("Дата готовности");
       ordersGridCrud.getGrid().getColumnByKey("cost").setHeader("Цена");

        add(ordersGridCrud);
        setSizeFull();
    }
}
