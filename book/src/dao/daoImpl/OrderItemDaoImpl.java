package dao.daoImpl;

import bean.OrderItem;
import dao.BaseDao;
import dao.OrderItemDao;

import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-21 17:53
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    /**
     * 将订单中的每一项保存到数据库中
     *
     * @param orderItem
     * @return
     */
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into orders_items(id,bookId,Name,Count,singlePrice,totalPrice,orderId)values(?,?,?,?,?,?,?)";
        return update(sql, orderItem.getId(), orderItem.getBookId(), orderItem.getName(), orderItem.getCount(), orderItem.getSinglePrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    /**
     * 获取指定订单的items
     *
     * @param orderId
     * @return
     */
    @Override
    public List<OrderItem> getOrderItems(String orderId) {
        String sql = "select * from orders_items where orderId = ?";
        return querys(OrderItem.class, sql, orderId);
    }

    /**
     * 获取订单item的图片
     * @param bookId
     * @return
     */
    @Override
    public String getOrderItemImg(int bookId) {
        String sql = "select img_path from books where id = ?";
        return (String) getValue(sql, bookId);
    }

    /**
     * 获取订单item的作者
     * @param bookId
     * @return
     */
    @Override
    public String getOrderItemAuthor(int bookId) {
        String sql = "select author from books where id = ?";
        return (String) getValue(sql,bookId);
    }
}
