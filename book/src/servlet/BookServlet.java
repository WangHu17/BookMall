package servlet;

import bean.Book;
import bean.Page;
import service.serviceImpl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-13 17:36
 */
public class BookServlet extends BaseServlet {
    private BookServiceImpl bookService = new BookServiceImpl();

    /**
     * 处理分页功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNum = WebUtils.parseInt(req.getParameter("pageNum"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        String url = "manager/bookServlet?action=page";
        Page<Book> page = bookService.page(pageNum, pageSize, url);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    /**
     * 查询全部图书
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    /**
     * 添加图书
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Book book = WebUtils.setParamToBean(new Book(), req.getParameterMap());
        int pageNum = WebUtils.parseInt(req.getParameter("pageNum"),0);
        pageNum+=1;
        String name = new String(req.getParameter("name").getBytes("iso-8859-1"), "utf-8");
        String price = req.getParameter("price");
        String author = new String(req.getParameter("author").getBytes("iso-8859-1"), "utf-8");
        String sales = req.getParameter("sales");
        String stock = req.getParameter("stock");
        Book book = new Book(null, name, new BigDecimal(price), author, Integer.parseInt(sales), Integer.parseInt(stock), null);
        System.out.println(book);
        bookService.addBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNum=" + pageNum);
    }

    /**
     * 删除图书
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        bookService.deleteBookById(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNum="+req.getParameter("pageNum"));
    }

    /**
     * 获取指定图书信息
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Book book = bookService.queryById(Integer.parseInt(id));
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    /**
     * 修改图书信息
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Book book = WebUtils.setParamToBean(new Book(), req.getParameterMap());
        String id = req.getParameter("id");
        String name = new String(req.getParameter("name").getBytes("iso-8859-1"), "utf-8");
        String price = req.getParameter("price");
        String author = new String(req.getParameter("author").getBytes("iso-8859-1"), "utf-8");
        String sales = req.getParameter("sales");
        String stock = req.getParameter("stock");
        Book book = new Book(Integer.parseInt(id), name, new BigDecimal(price), author, Integer.parseInt(sales), Integer.parseInt(stock), null);
        bookService.changeBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNum=" + req.getParameter("pageNum"));
    }
}
