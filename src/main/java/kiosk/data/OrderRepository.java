package kiosk.data;

import kiosk.Order;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends CrudRepository<Order, Long> {
    
    @Query("from Order o where o.city= :city")
    List<Order> readSomething(@Param("city") String city);
}
