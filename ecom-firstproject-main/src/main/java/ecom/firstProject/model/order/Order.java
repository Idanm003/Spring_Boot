package ecom.firstProject.model.order;

import ecom.firstProject.model.customer.Customer;
import ecom.firstProject.responses.OrderResponse;

import java.util.List;

public class Order {
    private Integer orderId;
    private Integer customerId;
    private String itemName;
    private Double price;

    public Order(Integer orderId, Integer customerId, String itemName, Double price) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.itemName = itemName;
        this.price = price;
    }

    public Order() {}

    public Integer getOrderId() {
        return orderId;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public String getItemName() {
        return itemName;
    }
    public Double getPrice() {
        return price;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public OrderResponse toOrderResponse(
            Customer customer,
            List<Order> customerOrderList ) {
        return new OrderResponse(
                customer,
                customerOrderList
        );
    }
}
