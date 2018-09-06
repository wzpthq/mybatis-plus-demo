package wzp.study.mybatis.mvc.services.impl;

import wzp.study.mybatis.domain.model.Address;
import wzp.study.mybatis.mvc.daos.AddressDao;
import wzp.study.mybatis.mvc.services.AddressService;
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
public class AddressServiceImpl extends ServiceImpl<AddressDao, Address> implements AddressService {

}
