package bean;

import java.math.BigDecimal;

/**
 * @author wanghu
 * @discrption：购物车中每一项的JavaBean
 * @create 2021-01-20 16:24
 */
public class CartItem {
    private Integer id;
    private String name;
    private Integer count;
    private BigDecimal singlePrice;
    private BigDecimal totalPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public CartItem(Integer id, String name, Integer count, BigDecimal singlePrice, BigDecimal totalPrice) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.singlePrice = singlePrice;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", singlePrice=" + singlePrice +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
