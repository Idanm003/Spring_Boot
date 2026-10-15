package ecom.firstProject.controller.order;

import ecom.firstProject.service.order.OrderService;
import ecom.firstProject.model.order.Order;
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
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }

    @PutMapping(value = "/update")
    public void updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable(value = "id") Integer id) {
        orderService.deleteOrderById(id);
    }

}
