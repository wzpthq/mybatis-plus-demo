package wzp.study.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangzhiping on 2018/9/6.
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 默认不配置分页插件的，会使用人RowBound进行分页，实际上是逻辑分页，物理上不会分页，也就是查询出来
     * 缓存中再分页；这样对于数据量比较多的情况，不合适，因此需要配置这个分页拦截器来实现物理的分页；
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
