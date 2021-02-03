package bean;

import java.math.BigDecimal;

/**
 * @author wanghu
 * @discrption：订单中每一项的Javabean
 * @create 2021-01-21 17:33
 */
public class OrderItem {
    private Integer id;
    private Integer bookId;
    private String Name;
    private Integer Count;
    private BigDecimal singlePrice;
    private BigDecimal totalPrice;
    private String orderId;

    public OrderItem() {
    }

    public OrderItem(Integer id, Integer bookId, String name, Integer count, BigDecimal singlePrice, BigDecimal totalPrice, String orderId) {
        this.id = id;
        this.bookId = bookId;
        Name = name;
        Count = count;
        this.singlePrice = singlePrice;
        this.totalPrice = totalPrice;
        this.orderId = orderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getCount() {
        return Count;
    }

    public void setCount(Integer count) {
        Count = count;
    }

    public BigDecimal getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(BigDecimal singlePrice) {
        this.singlePrice = singlePrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", Name='" + Name + '\'' +
                ", Count=" + Count +
                ", singlePrice=" + singlePrice +
                ", totalPrice=" + totalPrice +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
