package ru.lastuhinaa.RepairService.Service;

import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import ru.lastuhinaa.RepairService.Model.AllWorks;
import ru.lastuhinaa.RepairService.Repository.AllWorkRepo;

import java.util.List;

@Service
public class AllWorkService implements CrudListener<AllWorks> {
    private final AllWorkRepo allWorkRepo;

    public AllWorkService(AllWorkRepo allWorkRepo) {
        this.allWorkRepo = allWorkRepo;
    }

    @Override
    public List<AllWorks> findAll() {
        return allWorkRepo.findAll();
    }

    @Override
    public AllWorks add(AllWorks allWorks) {
        return allWorkRepo.save(allWorks);
    }

    @Override

    public AllWorks update(AllWorks allWorks) {
        return allWorkRepo.save(allWorks);
    }

    @Override
    public void delete(AllWorks allWorks) {
        allWorkRepo.delete(allWorks);
    }
}
