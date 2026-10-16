package ecom.firstProject.repository.order;

import ecom.firstProject.mapper.order.OrderMapper;
import ecom.firstProject.model.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private static final String ORDER_TABLE_NAME = "customer_order";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Order getOrderById(Integer id) {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE id=?";
        try{
            return jdbcTemplate.queryForObject(
                    sql,
                    new OrderMapper(),
                    id
            );
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Not found");
            return null;
        }
    }

    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME;
        try{
            return jdbcTemplate.query(
                    sql,
                    new OrderMapper()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Order> getAllOrdersByCustomerId(Integer customerId) throws Exception {
        String sql = "SELECT * FROM " + ORDER_TABLE_NAME + " WHERE customer_id=?";
        try {
            return jdbcTemplate.query(
                    sql,
                    new OrderMapper(),
                    customerId
            );
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Integer> getAllIdsByFullName(String fullName) {
       String sql = "SELECT id FROM " + ORDER_TABLE_NAME +
               " WHERE full_name=?";
        try {
            return jdbcTemplate.queryForList(
                sql,
                Integer.class,
                fullName
            );
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void createOrder(Order order) throws Exception{
        String sql = "INSERT INTO " + ORDER_TABLE_NAME + " " +
                "(customer_id, item_name, price) VALUES (?,?,?)";
        try {
            jdbcTemplate.update(
                    sql,
                    order.getCustomerId(),
                    order.getItemName(),
                    order.getPrice()
            );
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void updateOrder(Order order) throws Exception{
        String sql = "UPDATE " + ORDER_TABLE_NAME + " " +
                "SET customer_id=?, item_name=?, price=?" +
                " WHERE id=?";
        try {
            jdbcTemplate.update(
                    sql,
                    order.getCustomerId(),
                    order.getItemName(),
                    order.getPrice(),
                    order.getOrderId()
            );
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void deleteOrderById(Integer id) throws Exception{
        String sql = "DELETE FROM " + ORDER_TABLE_NAME + " WHERE id=?";
        try {
            jdbcTemplate.update(sql, id);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
