package ru.lastuhinaa.RepairService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lastuhinaa.RepairService.Model.AllWorks;

@Repository
public interface AllWorkRepo extends JpaRepository<AllWorks,Long> {
}
