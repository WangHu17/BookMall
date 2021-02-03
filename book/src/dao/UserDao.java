package dao;

import bean.User;

/**
 * @author wanghu
 * @discrption：
 * @create 2020-12-25 22:35
 */
public interface UserDao {
    /**
     * 通过用户名查询数据库是否有该用户
     * @param username
     * @return
     */
    public User queryByUsername(String username);

    /**
     * 通过用户名和密码查询数据库是否有该用户
     * @param username
     * @param password
     * @return
     */
    public User queryByUsernameAndPassword(String username, String password);

    /**
     * 将用户信息存到数据库
     * @param user
     * @return
     */
    public int saveUser(User user);

}
