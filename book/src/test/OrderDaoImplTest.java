package test;

import bean.Order;
import dao.daoImpl.OrderDaoImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-26 16:43
 */
public class OrderDaoImplTest {
    private OrderDaoImpl orderDao = new OrderDaoImpl();
    @Test
    public void getOrders() {
        List<Order> orders = orderDao.getOrders(1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void getAllOrders() {
        List<Order> allOrders = orderDao.getAllOrders();
        for (Order allOrder : allOrders) {
            System.out.println(allOrder);
        }
    }

    @Test
    public void changeStatus() {
        int i = orderDao.changeStatus(1, "16118320339521");
        System.out.println(i);
    }
}