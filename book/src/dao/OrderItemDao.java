package dao;

import bean.OrderItem;

import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-21 17:42
 */
public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);

    public List<OrderItem> getOrderItems(String orderId);

    public String getOrderItemImg(int bookId);

    public String getOrderItemAuthor(int bookId);
}
