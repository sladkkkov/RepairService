package ru.lastuhinaa.RepairService.View.Report;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.hibernate.criterion.Order;
import org.vaadin.reports.PrintPreviewReport;
import ru.lastuhinaa.RepairService.Model.Orders;
import ru.lastuhinaa.RepairService.Service.OrdersService;

@Route("report")
public class ReportView extends VerticalLayout {
    public ReportView(OrdersService ordersService) {
        PrintPreviewReport<Orders> report = new PrintPreviewReport<>(Orders.class);
        report.setItems(ordersService.findAll());
        add(report);
    }
}
