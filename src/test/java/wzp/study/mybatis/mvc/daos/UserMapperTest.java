package wzp.study.mybatis.mvc.daos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wzp.study.mybatis.domain.model.User;

import java.util.List;

/**
 * Created by wangzhiping on 2018/9/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelectList() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out :: println);
    }

    @Test
    public void testSelectById() {
        System.out.println(userMapper.selectById(1));
    }

}
