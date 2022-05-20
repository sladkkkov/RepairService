package ru.lastuhinaa.RepairService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lastuhinaa.RepairService.Model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
