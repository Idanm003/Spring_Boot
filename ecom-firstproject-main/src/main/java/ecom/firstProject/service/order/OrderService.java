package ecom.firstProject.service.order;

import ecom.firstProject.model.order.Order;
import ecom.firstProject.requests.order.OrderRequest;
import ecom.firstProject.responses.OrderResponse;

import java.util.List;

public interface OrderService {
    Order getOrderById(Integer id);
    List<Order> getAllOrders();
    List<Integer> getAllIdsByFullName(String fullName);
    OrderResponse createOrder(OrderRequest orderRequest) throws Exception;
    OrderResponse updateOrder(Order order)  throws Exception;
    void deleteOrderById(Integer id) throws Exception;
}
