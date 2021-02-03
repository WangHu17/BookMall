package bean;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wanghu
 * @discrption：购物车的JavaBean
 * @create 2021-01-20 16:30
 */
public class Cart {
    //    private Integer totalCount;
    //    private BigDecimal totalPrice;
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    /**
     * 加入购物车
     *
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        Integer id = cartItem.getId();
        CartItem item = items.get(id);
        if (item == null) {
            //购物车没有则直接加入
            items.put(id, cartItem);
        } else {
            //改数量
            item.setCount(item.getCount() + 1);
            //改总价(小数)
            item.setTotalPrice(item.getSinglePrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    /**
     * 删除购物车中的物品
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }

    /**
     * 更改图书数量
     */
    public void updateCount(Integer id, Integer count) {
        CartItem item = items.get(id);
        if (item != null) {
            item.setCount(count);
            item.setTotalPrice(item.getSinglePrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    //获取总数量
    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    //获取总价
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
