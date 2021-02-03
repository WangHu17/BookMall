package service.serviceImpl;

import bean.Book;
import bean.Page;
import dao.daoImpl.BookDaoImpl;
import service.BookService;

import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-13 17:20
 */
public class BookServiceImpl implements BookService {

    private BookDaoImpl bookDao = new BookDaoImpl();

    /**
     * 添加图书
     *
     * @param book
     */
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    /**
     * 修改图书信息
     *
     * @param book
     */
    @Override
    public void changeBook(Book book) {
        bookDao.changeBook(book);
    }

    /**
     * 根据id删除图书
     *
     * @param id
     */
    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    /**
     * 通过id查询图书
     *
     * @param id
     * @return 查询到的Book对象
     */
    @Override
    public Book queryById(Integer id) {
        return bookDao.queryById(id);
    }

    /**
     * 查询所有图书
     *
     * @return 所有图书的Book对象组成的集合
     */
    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    /**
     * 计算得到指定页的Page对象
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page<Book> page(int pageNum, int pageSize, String url) {
        int itemTotal = bookDao.getCount();
        int pageTotal = itemTotal / pageSize;
        if (itemTotal % pageSize > 0) {
            pageTotal += 1;
        }
        if (pageNum < 1) {
            pageNum = 1;
        }
        if (pageNum > pageTotal) {
            pageNum = pageTotal;
        }
        int begin = (pageNum - 1) * pageSize;
        List<Book> items = bookDao.queryBooks(begin, pageSize);
        Page<Book> page = new Page<Book>(pageNum, pageSize, itemTotal, pageTotal, items, url);
        return page;
    }

    /**
     * 计算得到指定价格区间的指定页的Page对象
     * @param pageNum
     * @param pageSize
     * @param min
     * @param max
     * @param url
     * @return
     */
    @Override
    public Page<Book> pageByPrice(int min, int max, int pageNum, int pageSize, String url) {
        int itemTotal = bookDao.getCountByPrice(min, max);
        int pageTotal = itemTotal / pageSize;
        if (itemTotal % pageSize > 0) {
            pageTotal += 1;
        }
        if (pageNum < 1) {
            pageNum = 1;
        }
        if (pageNum > pageTotal) {
            pageNum = pageTotal;
        }
        int begin = (pageNum - 1) * pageSize;
        List<Book> items = bookDao.queryBooksByPrice(min, max, begin, pageSize);
        Page<Book> page = new Page<Book>(pageNum, pageSize, itemTotal, pageTotal, items, url);
        return page;
    }
}
