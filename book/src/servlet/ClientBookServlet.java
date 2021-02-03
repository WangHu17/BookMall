package servlet;

import bean.Book;
import bean.Page;
import service.serviceImpl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-16 14:55
 */
public class ClientBookServlet extends BaseServlet {
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
        String url = "client/bookServlet?action=page";
        Page<Book> page = bookService.page(pageNum, pageSize, url);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    /**
     * 按价格区间处理分页功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        int pageNum = WebUtils.parseInt(req.getParameter("pageNum"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        StringBuilder url = new StringBuilder("client/bookServlet?action=pageByPrice");
        if(req.getParameter("min")!=null){
            url.append("&min="+min);
        }
        if(req.getParameter("max")!=null){
            url.append("&max="+max);
        }
        Page<Book> page = bookService.pageByPrice(min, max, pageNum, pageSize, url.toString());
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
