package ru.lastuhinaa.RepairService.Service;

import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import ru.lastuhinaa.RepairService.Model.Orders;
import ru.lastuhinaa.RepairService.Repository.OrdersRepository;

import java.util.List;

@Service

public class OrdersService implements CrudListener<Orders> {
    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders add(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override

    public Orders update(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public void delete(Orders orders) {
        ordersRepository.delete(orders);
    }

    public Orders getById(Long id) {
        return ordersRepository.getById(id);
    }
}


