package dao.daoImpl;

import dao.BaseDao;
import dao.BookDao;
import bean.Book;

import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-13 14:44
 */
public class BookDaoImpl extends BaseDao implements BookDao {

    /**
     * 添加图书
     *
     * @param book
     * @return 成功返回1(受影响的行数)，不成功返回-1
     */
    @Override
    public int addBook(Book book) {
        String sql = "insert into books(name,price,author,sales,stock,img_path)values(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImg_path());
    }

    /**
     * 修改图书信息
     *
     * @param book
     * @return 成功返回受影响的行数，不成功返回-1
     */
    @Override
    public int changeBook(Book book) {
        String sql = "update books set name = ?,price = ?, author = ?,sales = ?,stock = ?,img_path = ? where id = ?";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImg_path(), book.getId());
    }

    /**
     * 根据id删除图书
     *
     * @param id
     * @return 成功返回1(受影响的行数)，不成功返回-1
     */
    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from books where id = ?";
        return update(sql, id);
    }

    /**
     * 通过id查询图书
     *
     * @param id
     * @return 查询到的Book对象
     */
    @Override
    public Book queryById(Integer id) {
        String sql = "select id,name,price,author,sales,stock,img_path from books where id = ?";
        return query(Book.class, sql, id);
    }

    /**
     * 查询所有的图书
     *
     * @return 所有图书的Book对象组成的集合
     */
    @Override
    public List<Book> queryBooks() {
        String sql = "select * from books";
        return querys(Book.class, sql);
    }

    /**
     * 获取图书的总数量
     *
     * @return
     */
    @Override
    public Integer getCount() {
        String sql = "select count(*) from books";
        Number count = (Number) getValue(sql);
        return count.intValue();
    }

    /**
     * 获取指定价格区间图书的总数量
     *
     * @param min
     * @param max
     * @return
     */
    @Override
    public int getCountByPrice(int min, int max) {
        String sql = "select count(*) from books where price between ? and ?";
        Number count = (Number) getValue(sql, min, max);
        return count.intValue();
    }

    /**
     * 获取指定页的图书数据
     *
     * @param begin
     * @param num
     * @return
     */
    @Override
    public List<Book> queryBooks(int begin, int num) {
        String sql = "select id,name,price,author,sales,stock,img_path from books limit ?,?";
        return querys(Book.class, sql, begin, num);
    }

    /**
     * 获取指定价格区间的指定页的图书数据
     *
     * @param begin
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    @Override
    public List<Book> queryBooksByPrice(int min, int max, int begin, int pageSize) {
        String sql = "select id,name,price,author,sales,stock,img_path from books where price between ? and ? order by price limit ?,?";
        return querys(Book.class, sql, min, max, begin, pageSize);
    }
}
