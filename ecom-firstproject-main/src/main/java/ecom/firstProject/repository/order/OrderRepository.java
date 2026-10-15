package ecom.firstProject.repository.order;

import ecom.firstProject.model.order.Order;
import java.util.List;

public interface OrderRepository {
    Order getOrderById(Integer id);
    List<Order> getAllOrders();
    List<Integer> getAllIdsByFullName(String fullName);
    void createOrder(Order order);
    void updateOrder(Order order);
    void deleteOrderById(Integer id);
}
