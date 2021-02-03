package dao.daoImpl;

import bean.Order;
import dao.BaseDao;
import dao.OrderDao;

import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-21 17:45
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    /**
     * 保存订单
     * @param order
     * @return
     */
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into orders(orderId,orderDate,itemsCount,totalPrice,orderStatus,userId,userName)values(?,?,?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getOrderDate(),order.getItemsCount(),order.getTotalPrice(),order.getOrderStatus(),order.getUserId(),order.getUserName());
    }

    /**
     * 获取指定用户的所有订单
     * @param userId
     * @return
     */
    @Override
    public List<Order> getOrders(int userId) {
        String sql = "select * from orders where userId = ? order by orderDate desc";
        return querys(Order.class,sql,userId);
    }

    /**
     * 获取所有用户的所有订单
     * @return
     */
    @Override
    public List<Order> getAllOrders() {
        String sql = "select * from orders order by orderDate desc";
        return querys(Order.class,sql);
    }

    /**
     * 更新订单状态
     * @param orderId
     * @return
     */
    @Override
    public int changeStatus(int status, String orderId) {
        String sql = "update orders set orderStatus = ? where orderId = ?";
        return update(sql,status,orderId);
    }
}
