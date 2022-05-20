package ru.lastuhinaa.RepairService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lastuhinaa.RepairService.Model.Details;

@Repository
public interface DetailsRepo extends JpaRepository<Details, Long> {
}
