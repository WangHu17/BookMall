package service;

import bean.Cart;
import bean.Order;
import bean.OrderItem;
import bean.User;

import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-21 17:59
 */
public interface OrderService {
    public String createOrder(Cart cart, Integer userId, String userName);

    public List<Order> getOrders(Integer userId);

    public List<Order> getAllOrders();

    public List<OrderItem> getOrderItems(String orderId);

    public String getOrderItemImg(Integer bookId);

    public String getOrderItemAuthor(Integer bookId);

    public int changeStatus(Integer status, String orderId);
}
