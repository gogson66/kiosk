package kiosk.data;

import kiosk.Order;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    
    //Order save(Order order);

    List<Order> findByCity(String city);
}
