package kiosk.data;

import kiosk.Order;

public interface OrederRepository {
    
    Order save(Order order);
}
