package service;

import bean.User;

/**
 * @author wanghu
 * @discrption：
 * @create 2020-12-25 22:38
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void register(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 用户名是否可用
     * @param username
     * @return
     */
    public boolean existUsername(String username);
}
