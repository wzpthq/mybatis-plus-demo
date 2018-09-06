package wzp.study.mybatis.mvc.services.impl;

import wzp.study.mybatis.domain.model.User;
import wzp.study.mybatis.mvc.daos.UserDao;
import wzp.study.mybatis.mvc.services.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author o2lx
 * @since 2018-09-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
