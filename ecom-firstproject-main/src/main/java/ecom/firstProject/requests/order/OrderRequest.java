package ecom.firstProject.requests.order;

import ecom.firstProject.model.customer.Customer;
import ecom.firstProject.model.order.Order;

public class OrderRequest {
    private Customer customer;
    private Order order;

    public OrderRequest(Customer customer, Order order) {
        this.customer = customer;
        this.order = order;
    }

    public OrderRequest() {}

    public Customer getCustomer() {
        return this.customer;
    }
    public Order getOrder() {
        return this.order;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public Order toOrder() {
        return new Order(
                this.order.getOrderId(),
                this.customer.getCustomerId(),
                this.order.getItemName(),
                this.order.getPrice()
        );
    }
}
