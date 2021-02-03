package servlet;

import bean.Cart;
import bean.Order;
import bean.OrderItem;
import bean.User;
import com.google.gson.Gson;
import service.serviceImpl.OrderServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-21 20:13
 */
public class OrderServlet extends BaseServlet {
    private OrderServiceImpl orderService = new OrderServiceImpl();

    /**
     * 生成订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");
        int userId = user.getId();
        String userName = user.getUsername();
        String orderId = orderService.createOrder(cart, userId, userName);
        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

    /**
     * 获取指定用户的所有订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void listOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Order> orders = orderService.getOrders(user.getId());
        req.getSession().setAttribute("orders", orders);
        resp.sendRedirect(req.getContextPath() + "/pages/order/clientOrders.jsp");
    }

    /**
     * 获取所有用户的所有订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void listAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> allOrders = orderService.getAllOrders();
        req.getSession().setAttribute("allOrders", allOrders);
        resp.sendRedirect(req.getContextPath() + "/pages/manager/order_manager.jsp");
    }

    /**
     * 获取指定订单的items
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void listItems(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String orderId = req.getParameter("orderId");
        List<OrderItem> orderItems = orderService.getOrderItems(orderId);
        List<Map<String, Object>> list = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            Map<String, Object> map = new HashMap<>();
            String imgPath = orderService.getOrderItemImg(orderItem.getBookId());
            String author = orderService.getOrderItemAuthor(orderItem.getBookId());
            map.put("imgPath", imgPath);
            map.put("author", author);
            map.put("Name", orderItem.getName());
            map.put("Count", orderItem.getCount());
            map.put("singlePrice", orderItem.getSinglePrice());
            map.put("totalPrice", orderItem.getTotalPrice());
            list.add(map);
        }
//        System.out.println(list);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        resp.getWriter().write(json);
    }

    /**
     * 发货
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deliver(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        int i = orderService.changeStatus(1, orderId);
        //重新获取订单，否则页面无法更新数据
        List<Order> allOrders = orderService.getAllOrders();
        req.getSession().setAttribute("allOrders", allOrders);
        resp.sendRedirect(req.getContextPath() + "/pages/manager/order_manager.jsp");
    }

    /**
     * 确认收货
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void confirmReceipt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        int i = orderService.changeStatus(2, orderId);
        //重新获取订单，否则页面无法更新数据
        User user = (User) req.getSession().getAttribute("user");
        List<Order> orders = orderService.getOrders(user.getId());
        req.getSession().setAttribute("orders", orders);
        resp.sendRedirect(req.getContextPath() + "/pages/order/clientOrders.jsp");
    }

}
