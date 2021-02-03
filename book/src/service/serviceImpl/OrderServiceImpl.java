package service.serviceImpl;

import bean.*;
import dao.daoImpl.BookDaoImpl;
import dao.daoImpl.OrderDaoImpl;
import dao.daoImpl.OrderItemDaoImpl;
import service.OrderService;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-21 18:00
 */
public class OrderServiceImpl implements OrderService {
    private OrderDaoImpl orderDao = new OrderDaoImpl();
    private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
    private BookDaoImpl bookDao = new BookDaoImpl();

    /**
     * 创建订单
     * @param cart
     * @param userId
     * @return
     */
    @Override
    public String createOrder(Cart cart, Integer userId, String userName) {
        //生成订单编号（唯一）
        String orderId = System.currentTimeMillis() + "" + userId;

        int itemsCount = 0;
        //遍历购物车的物品项
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            //获取订单中的图书总数
            CartItem cartItem = entry.getValue();
            itemsCount += cartItem.getCount();
        }
        //生成订单对象保存到数据库
        Order order = new Order(orderId, new Date(), itemsCount, cart.getTotalPrice(), 0, userId, userName);
        orderDao.saveOrder(order);

        //遍历购物车的物品项
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            //获取购物车中每一项的对象
            CartItem cartItem = entry.getValue();
            //生成订单项保存到数据库
            OrderItem orderItem = new OrderItem(null, cartItem.getId(), cartItem.getName(), cartItem.getCount(), cartItem.getSinglePrice(), cartItem.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);
            //生成订单后更新对应的图书销量和库存
            Integer id = cartItem.getId();
            Book book = bookDao.queryById(id);
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.changeBook(book);
        }
        //生成订单后清空购物车
        cart.clear();

        return orderId;
    }

    /**
     * 获取指定用户的所有订单
     * @param userId
     * @return
     */
    @Override
    public List<Order> getOrders(Integer userId) {
        return orderDao.getOrders(userId);
    }

    /**
     * 获取所有用户的所有订单
     * @return
     */
    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    /**
     * 获取指定订单的items
     * @param orderId
     * @return
     */
    @Override
    public List<OrderItem> getOrderItems(String orderId) {
        return orderItemDao.getOrderItems(orderId);
    }

    /**
     * 获取订单item的图片
     * @param bookId
     * @return
     */
    @Override
    public String getOrderItemImg(Integer bookId) {
        return orderItemDao.getOrderItemImg(bookId);
    }

    /**
     * 获取订单item的作者
     * @param bookId
     * @return
     */
    @Override
    public String getOrderItemAuthor(Integer bookId) {
        return orderItemDao.getOrderItemAuthor(bookId);
    }

    /**
     * 更新订单状态
     * @param status
     * @param orderId
     * @return
     */
    @Override
    public int changeStatus(Integer status, String orderId) {
        return orderDao.changeStatus(status, orderId);
    }
}
