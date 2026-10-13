package ecom.firstProject.repository.Order;

import ecom.firstProject.mapper.Order.OrderMapper;
import ecom.firstProject.model.Order.Order;
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
    public void createOrder(Order order) {
        String sql = "INSERT INTO " + ORDER_TABLE_NAME + " " +
                "(customer_id, item_name, price) VALUES (?,?,?)";
        jdbcTemplate.update(
                sql,
                order.getCustomerId(),
                order.getItemName(),
                order.getPrice()
        );
    }

    @Override
    public void updateOrder(Order order) {
        String sql = "UPDATE " + ORDER_TABLE_NAME + " " +
                "SET customer_id=?, item_name=?, price=?" +
                " WHERE id=?";
        jdbcTemplate.update(
                sql,
                order.getCustomerId(),
                order.getItemName(),
                order.getPrice(),
                order.getOrderId()
        );
    }

    @Override
    public void deleteOrderById(Integer id) {
        String sql = "DELETE FROM " + ORDER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
