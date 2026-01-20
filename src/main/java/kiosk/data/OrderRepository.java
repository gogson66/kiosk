package kiosk.data;

import kiosk.Order;

public interface OrderRepository {
    
    Order save(Order order);
}
