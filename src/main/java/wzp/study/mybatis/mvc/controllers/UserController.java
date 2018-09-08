package wzp.study.mybatis.mvc.controllers;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import wzp.study.mybatis.domain.MyPage;
import wzp.study.mybatis.domain.model.User;
import wzp.study.mybatis.mvc.services.UserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author o2lx
 * @since 2018-09-06
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 分页测试
     * @param current
     * @param size
     * @return
     */
    @GetMapping("/users/{current}/{size}")
    public IPage<User> getByPage(@PathVariable int current, @PathVariable int size) {
        return userService.page(new MyPage<User>(current, size), null);
    }

}

