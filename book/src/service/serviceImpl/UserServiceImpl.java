package service.serviceImpl;

import bean.User;
import dao.BaseDao;
import dao.daoImpl.UserDaoImpl;
import service.UserService;

/**
 * @author wanghu
 * @discrption：
 * @create 2020-12-25 22:38
 */
public class UserServiceImpl extends BaseDao implements UserService {

    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public void register(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if(userDao.queryByUsername(username) != null){
            return true;
        }
        return false;
    }
}
