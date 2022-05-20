package ru.lastuhinaa.RepairService.Service;

import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import ru.lastuhinaa.RepairService.Model.Details;
import ru.lastuhinaa.RepairService.Repository.DetailsRepo;

import java.util.Collection;
@Service
public class DetailsService implements CrudListener<Details> {

    private final DetailsRepo detailsRepo;

    public DetailsService(DetailsRepo detailsRepo) {
        this.detailsRepo = detailsRepo;
    }


    @Override
    public Collection<Details> findAll() {
        return detailsRepo.findAll();
    }

    @Override
    public Details add(Details details) {
        return detailsRepo.save(details);
    }

    @Override
    public Details update(Details details) {
        return detailsRepo.save(details);
    }

    @Override
    public void delete(Details details) {
        detailsRepo.delete(details);
    }
}
