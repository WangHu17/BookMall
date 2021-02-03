package test;

import org.junit.Test;
import utils.JdbcUtils;

import java.sql.Connection;

/**
 * @author wanghu
 * @discrption：
 * @create 2020-12-25 20:13
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 100; i++){
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
        }
    }

//    @Test
//    public void testJdbcUtils1(){
//        for (int i = 0; i < 100; i++){
//            Connection connection = JdbcUtils.getConnection();
//            System.out.println(connection);
//            JdbcUtils.closeConnection(connection);
//        }
//    }
}
