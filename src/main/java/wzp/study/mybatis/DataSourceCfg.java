package wzp.study.mybatis;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


/**
 * Created by wangzhiping on 2018/9/6.
 */
@Configuration
public class DataSourceCfg {

    @Bean(name="dataSource")
    @Qualifier(value="dataSource")
    @Primary
    @ConfigurationProperties(prefix="c3p0")
    public DataSource dataSource(){
        return DataSourceBuilder.create().type(ComboPooledDataSource.class).build();//创建数据源
    }

}
