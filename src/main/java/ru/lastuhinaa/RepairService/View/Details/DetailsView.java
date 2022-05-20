package ru.lastuhinaa.RepairService.View.Details;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.crudui.crud.impl.GridCrud;
import ru.lastuhinaa.RepairService.Model.Details;
import ru.lastuhinaa.RepairService.Service.DetailsService;
import ru.lastuhinaa.RepairService.View.MainLayout;


@PageTitle("Детали")
@Route(value = "details", layout = MainLayout.class)
public class DetailsView extends VerticalLayout {
    public DetailsView(DetailsService detailsService) {
        setSpacing(false);

        setSizeFull();

        GridCrud<Details> crud = new GridCrud<>(Details.class, detailsService);
        crud.getGrid().setColumnReorderingAllowed(true);

        crud.getGrid().setColumns("id", "name", "model", "compatModel", "available", "cost","maker");
        crud.getGrid().getColumnByKey("id").setHeader("Айди");
        crud.getGrid().getColumnByKey("cost").setHeader("Цена");
        crud.getGrid().getColumnByKey("available").setHeader("Количество на складе");
        crud.getGrid().getColumnByKey("name").setHeader("Название");
        crud.getGrid().getColumnByKey("model").setHeader("Модель");
        crud.getGrid().getColumnByKey("maker").setHeader("Производитель");
        crud.getGrid().getColumnByKey("compatModel").setHeader("Совместимые модели");
        add(crud);
    }
}