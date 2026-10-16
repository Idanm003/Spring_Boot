package ecom.firstProject.repository.order;

import ecom.firstProject.model.order.Order;
import java.util.List;

public interface OrderRepository {
    Order getOrderById(Integer id);
    List<Order> getAllOrders();
    List<Order> getAllOrdersByCustomerId(Integer customerId) throws Exception;
    List<Integer> getAllIdsByFullName(String fullName);
    void createOrder(Order order) throws Exception;
    void updateOrder(Order order) throws Exception;
    void deleteOrderById(Integer id) throws Exception;
}
