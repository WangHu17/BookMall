package servlet;

import bean.User;
import com.google.gson.Gson;
import service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author wanghu
 * @discrption：
 * @create 2021-01-07 20:43
 */
public class UserServlet extends BaseServlet {

    private UserServiceImpl userService = new UserServiceImpl();

    /**
     * Ajax动态验证用户名是否已存在
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxUsernameExist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean existUsername = userService.existUsername(username);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("existUsername",existUsername);
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);
    }

    /**
     * Ajax注册
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String verificode = req.getParameter("verificode");
        String key = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        Map<String, Object> map = new HashMap<>();
        Gson gson = new Gson();
        if (key != null && key.equalsIgnoreCase(verificode)) {
            if (!userService.existUsername(username)) {
                userService.register(new User(0, username, password, email));
                map.put("response","注册成功");
                System.out.println("注册成功");
            } else {
                map.put("response","用户名已存在");
                System.out.println("用户名已存在");
            }
        } else {
            map.put("response","验证码错误");
            System.out.println("验证码错误");
        }
        String json = gson.toJson(map);
        resp.getWriter().write(json);
    }

    /**
     * Ajax登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User login = userService.login(new User(0, username, password, null));
        Map<String, Object> map = new HashMap<>();
        Gson gson = new Gson();
        if (login != null) {
            map.put("response","登陆成功");
            req.getSession().setAttribute("user", login);
            System.out.println("登陆成功");
        } else {
            map.put("response","用户名或密码错误");
            System.out.println("用户名或密码错误");
        }
        String json = gson.toJson(map);
        resp.getWriter().write(json);
    }
//        /**
//         * 注册
//         * @param req
//         * @param resp
//         * @throws ServletException
//         * @throws IOException
//         */
//    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        String confpass = req.getParameter("confpass");
//        String email = req.getParameter("email");
//        String verificode = req.getParameter("verificode");
//        String key = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
//        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
//
//        if (key != null && key.equalsIgnoreCase(verificode)) {
//            if (!userService.existUsername(username)) {
//                userService.register(new User(0, username, password, email));
//                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
//                System.out.println("注册成功");
//            } else {
//                System.out.println("用户名已存在");
//                req.setAttribute("msg1", "用户名已存在");
//                req.setAttribute("username1", username);
//                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
//            }
//        } else {
//            System.out.println("验证码不正确");
//            req.setAttribute("msg1", "验证码不正确");
//            req.setAttribute("username1", username);
//            req.setAttribute("password1", password);
//            req.setAttribute("confpass1", confpass);
//            req.setAttribute("email1", email);
//            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
//        }
//    }

//    /**
//     * 登录
//     *
//     * @param req
//     * @param resp
//     * @throws ServletException
//     * @throws IOException
//     */
//    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        User login = userService.login(new User(0, username, password, null));
//        if (login != null) {
//            req.getSession().setAttribute("user", login);
//            resp.sendRedirect(req.getContextPath()+"/index.jsp");
//        } else {
//            req.setAttribute("msg", "用户名或密码错误");
//            req.setAttribute("username", username);
//            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
//        }
//    }

    /**
     * 注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void loginOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }
}