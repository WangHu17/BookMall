package dao.daoImpl;

import bean.User;
import dao.BaseDao;
import dao.UserDao;

/**
 * @author wanghu
 * @discrption：
 * @create 2020-12-25 22:37
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryByUsername(String username) {
        String sql = "select id,username,email from users where username = ?";
        return query(User.class,sql,username);
    }

    @Override
    public User queryByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,email from users where username = ? and password = ?";
        return query(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into users(username,password,email)values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
