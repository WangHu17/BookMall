package bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wanghu
 * @discrption：订单的Javabean
 * @create 2021-01-21 16:55
 */
public class Order {
    private String orderId;
    private Date orderDate;
    private Integer itemsCount;
    private BigDecimal totalPrice;
    private Integer orderStatus;
    private Integer userId;
    private String userName;

    public Order() {
    }

    public Order(String orderId, Date orderDate, Integer itemsCount, BigDecimal totalPrice, Integer orderStatus, Integer userId, String userName) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.itemsCount = itemsCount;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.userId = userId;
        this.userName = userName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(Integer itemsCount) {
        this.itemsCount = itemsCount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", itemsCount=" + itemsCount +
                ", totalPrice=" + totalPrice +
                ", orderStatus=" + orderStatus +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
