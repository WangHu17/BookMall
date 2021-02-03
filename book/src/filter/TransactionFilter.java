package filter;

import utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author wanghu
 * @discrption：使用 Filter 过滤器统一给所有的 Service 方法都加上 try-catch。来实现事务管理
 * @create 2021-01-23 19:09
 */
public class TransactionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
