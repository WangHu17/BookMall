package dao;

import bean.Book;

import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-13 14:03
 */
public interface BookDao {

    public int addBook(Book book);

    public int changeBook(Book book);

    public int deleteBookById(Integer id);

    public Book queryById(Integer id);

    public List<Book> queryBooks();

    public Integer getCount();

    public int getCountByPrice(int min, int max);

    public List<Book> queryBooks(int begin, int num);

    public List<Book> queryBooksByPrice(int min, int max, int begin, int pageSize);
}
