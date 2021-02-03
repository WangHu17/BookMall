package service;

import bean.Book;
import bean.Page;

import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-13 17:18
 */
public interface BookService {

    public void addBook(Book book);

    public void changeBook(Book book);

    public void deleteBookById(Integer id);

    public Book queryById(Integer id);

    public List<Book> queryBooks();

    public Page<Book> page(int pageNum, int pageSize, String url);

    public Page<Book> pageByPrice(int min, int max, int pageNum, int pageSize, String url);
}
