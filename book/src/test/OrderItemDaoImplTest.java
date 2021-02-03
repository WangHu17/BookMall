package test;

import bean.OrderItem;
import dao.daoImpl.OrderItemDaoImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-26 20:08
 */
public class OrderItemDaoImplTest {
    private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
    @Test
    public void getOrderItems() {
        List<OrderItem> orderItems = orderItemDao.getOrderItems("16116535325741");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }
    }
}