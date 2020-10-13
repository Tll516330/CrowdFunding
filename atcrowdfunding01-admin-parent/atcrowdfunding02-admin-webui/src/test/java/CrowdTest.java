import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author tll
 * @create 2020/10/13 15:06
 * 在类上标记必要的注解，Spring整合Junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml"})
public class CrowdTest {

    /**
     * 数据源
     */
    @Autowired
    private DataSource dataSource;

    /**
     * 自动注入Mapper
     */
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 测试类
     */
    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    /**
     * 测试mapper
     */
    @Test
    public void testMapper(){
//        int insert = adminMapper.insert(new Admin(null,"ha","123","ha","22@qq.com",null));
//        System.out.println("影响行数"+insert);
        int i = adminMapper.deleteByPrimaryKey(1);
        System.out.println("影响行数"+i);
    }


}
