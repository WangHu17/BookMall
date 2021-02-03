package test;

import bean.Book;
import dao.daoImpl.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-13 15:26
 */
public class BookDaoImplTest {
    private BookDaoImpl bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "极简宇宙史", new BigDecimal(199), "克里斯托弗·加尔法德", 200000, 10000, null));
    }

    @Test
    public void changeBook() {
        bookDao.changeBook(new Book(1, "Java核心技术", new BigDecimal(119), "Cay S. Horstmann,Gary Cornell", 320000, 120000, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(3);
    }

    @Test
    public void queryById() {
        System.out.println(bookDao.queryById(1));
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void getCount() {
        System.out.println(bookDao.getCount());
    }

    @Test
    public void getCountByPrice() {
        System.out.println(bookDao.getCountByPrice(50, 100));
    }

    @Test
    public void queryBooksByPage() {
        List<Book> books = bookDao.queryBooks(2, 4);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryBooksByPrice() {
        List<Book> books = bookDao.queryBooksByPrice(50, 100, 1, 4);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
