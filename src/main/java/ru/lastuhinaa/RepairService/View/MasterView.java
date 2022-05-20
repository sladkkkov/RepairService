package ru.lastuhinaa.RepairService.View;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.crudui.crud.impl.GridCrud;
import ru.lastuhinaa.RepairService.Model.AllWorks;
import ru.lastuhinaa.RepairService.Service.AllWorkService;

import javax.annotation.security.RolesAllowed;

@PageTitle("Administration Panel")
@Route(value = "masters", layout = MainLayout.class)

public class MasterView extends VerticalLayout {
    public MasterView(AllWorkService allWorkService) {
        setSpacing(false);


        GridCrud<AllWorks> allWorkGridCrud = new GridCrud<>(AllWorks.class, allWorkService);

        allWorkGridCrud.getGrid().setColumnReorderingAllowed(true);
        allWorkGridCrud.getGrid().setColumns("id", "info", "cost", "garanty");

        allWorkGridCrud.getGrid().getColumnByKey("id").setHeader("Айди");
        allWorkGridCrud.getGrid().getColumnByKey("info").setHeader("О заказе");
        allWorkGridCrud.getGrid().getColumnByKey("cost").setHeader("Цена");
        allWorkGridCrud.getGrid().getColumnByKey("garanty").setHeader("Гарантия");

        add(allWorkGridCrud);
        setSizeFull();
    }
}
