package bean;

import java.util.List;

/**
 * @author wanghu
 * @discrption：分页的JavaBean
 * @create 2021-01-14 16:06
 */
public class Page<T> {
    public static final Integer PAGE_SIZE = 4;
    private Integer pageNum;
    private Integer pageSize = PAGE_SIZE;
    private Integer itemTotal;
    private Integer pageTotal;
    private List<T> items;
    private String url;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(Integer itemTotal) {
        this.itemTotal = itemTotal;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page(Integer pageNum, Integer pageSize, Integer itemTotal, Integer pageTotal, List<T> items, String url) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.itemTotal = itemTotal;
        this.pageTotal = pageTotal;
        this.items = items;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", itemTotal=" + itemTotal +
                ", pageTotal=" + pageTotal +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
