package test;

import bean.Book;
import org.junit.Test;
import service.serviceImpl.BookServiceImpl;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-16 18:22
 */
public class BookServiceImplTest {
    private BookServiceImpl bookServiceImpl = new BookServiceImpl();

    @Test
    public void addBook() {
        bookServiceImpl.addBook(new Book(null,"斗罗大陆",new BigDecimal(55),"唐家三少",220000,120000,"imgs/default.jpg"));
    }

    @Test
    public void changeBook() {
        bookServiceImpl.changeBook(new Book(44,"斗罗大陆",new BigDecimal(55),"唐家三少",220000,120000,"imgs/default.jpg"));
    }

    @Test
    public void deleteBookById() {
        bookServiceImpl.deleteBookById(43);
    }

    @Test
    public void queryById() {
        System.out.println(bookServiceImpl.queryById(44));;
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookServiceImpl.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        System.out.println(bookServiceImpl.page(1,4,"null"));;
    }

    @Test
    public void pageByPrice() {
        System.out.println(bookServiceImpl.pageByPrice(10,50,1,4,"null"));
    }
}
