package dao;

import bean.Order;

import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-21 17:39
 */
public interface OrderDao {
    public int saveOrder(Order order);

    public List<Order> getOrders(int userId);

    public List<Order> getAllOrders();

    public int changeStatus(int status, String orderId);
}
