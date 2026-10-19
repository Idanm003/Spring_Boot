package ecom.firstProject.controller.order;

import ecom.firstProject.service.order.OrderService;
import ecom.firstProject.model.order.Order;
import ecom.firstProject.requests.order.OrderRequest;
import ecom.firstProject.responses.order.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/{id}")
    public Order getOrderById(@PathVariable(value = "id") Integer id) {
        return orderService.getOrderById(id);
    }

    @GetMapping(value = "/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping(value = "/ids")
    public List<Integer> getAllIdsByFullName(@RequestParam String fullName) {
        return orderService.getAllIdsByFullName(fullName);
    }

    @PostMapping(value = "/create")
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) throws Exception {
        return orderService.createOrder(orderRequest);
    }

    @PutMapping(value = "/update")
    public OrderResponse updateOrder(@RequestBody Order order) throws Exception {
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable(value = "id") Integer id) throws Exception {
        orderService.deleteOrderById(id);
    }

}
