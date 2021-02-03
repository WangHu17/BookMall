package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author wanghu
 * @discrption：对数据库的CRUD操作的基本DAO
 * @create 2020-12-25 20:10
 */
public abstract class BaseDao {

    private QueryRunner runner = new QueryRunner();

    /**
     * 实现对数据库的insert/update/delete操作
     *
     * @param sql
     * @param args
     */
    public int update(String sql, Object... args) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            return runner.update(conn, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询一条记录
     *
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return 对象
     */
    public <T> T query(Class<T> type, String sql, Object... args) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            return runner.query(conn, sql, new BeanHandler<>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询多条记录
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return 对象组成的集合
     */
    public <T> List<T> querys(Class<T> type, String sql, Object... args) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            return runner.query(conn,sql,new BeanListHandler<>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取某个表中特殊的一个值
     * @param sql
     * @param args
     * @return
     */
    public Object getValue(String sql,Object...args){
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            return runner.query(conn,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
