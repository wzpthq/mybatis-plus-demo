package wzp.study.mybatis;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import javax.sql.DataSource;
import java.util.*;

/**
 * 代码生成器, 快速生成：
 * Entity、Mapper、Mapper Xml、Service、Controller
 * 1，dataSource 数据源配置，通过该配置，指定需要生成代码的具体数据库 DataSourceConfig
 * dbType、schemaName、typeConvert、url：链接、driverName：驱动名、username：用户名、password：密码
 *
 * 2，strategy 数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表 StrategyConfig
 * dbColumnUnderline、isCapitalMode、skipView、naming、columnNaming
 # tablePrefix、fieldPrefix、superEntityClass、superEntityColumns
 # superMapperClass、superServiceClass、superServiceImplClass
 # superControllerClass、include、exclude、entityColumnConstant
 # entityBuilderModel、entityLombokModel、entityBooleanColumnRemoveIsPrefix
 # restControllerStyle、controllerMappingHyphenStyle、entityTableFieldAnnotationEnable
 # versionFieldName、logicDeleteFieldName、tableFillList
 *
 * 3，packageInfo 包名配置，通过该配置，指定生成代码的包路径 PackageConfig
 * parent、moduleName、entity、service、serviceImpl、mapper、xml、controller、pathInfo
 *
 * 4，template 模板配置，可自定义代码生成的模板，实现个性化操作 TemplateConfig
 * entity、entityKt、service、serviceImpl、mapper、xml、controller
 *
 * 5，globalConfig 全局策略配置 GlobalConfig
 * outputDir、fileOverride、open、enableCache、author、kotlin、swagger2
 # activeRecord、baseResultMap、dateType、baseColumnList、entityName、mapperName
 # xmlName、serviceName、serviceImplName、controllerName、idType

 * 6，injectionConfig 注入配置，通过该配置，可注入自定义参数等操作以实现个性化操作 InjectionConfig
 * map、fileOutConfigList、fileCreate、initMap
 * Created by wangzhiping on 2018/9/6.
 */
public class CodeGenerator {

    public final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
    public final static String URL = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true";
    public final static String USERNAME = "root";
    public final static String PASSWORD = "root";

    public final static String SUPPER_MAPPER_CLASS = "com.baomidou.mybatisplus.core.mapper.BaseMapper";

    // Package Config
    public final static String BASE_PACKAGE = "wzp.study.mybatis";
    public final static String ENTITY_PACKAGE = "domain.model";
    public final static String MAPPER_PACKAGE = "mvc.daos";
    public final static String SERVICE_PACKAGE = "mvc.services";
    public final static String SERVICE_IMPL_PACKAGE = "mvc.services.impl";
    public final static String CONTROLLER_PACKAGE = "mvc.controllers";
    public final static String MAPPER_XML_PACKAGE = "mapper";

    public final static String MAPPER_OUT_PATH = "/Users/wangzhiping/workspace/mybatis-plus-demo/src/main/resources/mapper";
    public final static String PROJECT_PATH = "/Users/wangzhiping/workspace/mybatis-plus-demo/src/main/java";

    public final static String AUTHOR = "o2lx";

    // 包含的表集合
    static String[] includeTables;
    // 排除的表集合
    static String[] excludeTables;

    static {
        includeTables = new String[]{
                "user", "address"
        };

        excludeTables = new String[]{};
    }


    /**
     * 获取数据库配置
     * @return
     */
    public static DataSourceConfig dataSourceConfig() {
        return new DataSourceConfig()
                .setDbType(DbType.MYSQL)
                .setDriverName(DRIVER_NAME)
                .setUrl(URL)
                .setUsername(USERNAME)
                .setPassword(PASSWORD);
    }

    /**
     * 获取策略配置，哪些表需要生成，哪些不需要生成
     * @return
     */
    public static StrategyConfig strategyConfig() {
        return new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel) // 下划线转成驼峰命名
                .setInclude(includeTables)
                .setExclude(excludeTables)
                .setSuperMapperClass(SUPPER_MAPPER_CLASS) // 继承的Mapper父类
                .setEntityBuilderModel(true) // 是否设置未Builder类
                .setEntityLombokModel(true)  // 是否Lombok类
                .setRestControllerStyle(true) // Controller 为 RestController 模式
                ;
    }

    /**
     * 包配置(生成的Entity、Xml、Mapper、Controller、Service存放的问题)
     * @return
     */
    public static PackageConfig packageConfig() {
        return new PackageConfig()
                .setParent(BASE_PACKAGE)
                .setEntity(ENTITY_PACKAGE)
                .setController(CONTROLLER_PACKAGE)
                .setMapper(MAPPER_PACKAGE)
                .setService(SERVICE_PACKAGE)
                .setServiceImpl(SERVICE_IMPL_PACKAGE)
                .setXml(MAPPER_XML_PACKAGE)
                ;
    }

    /**
     * 自动注入配置
     * @return
     */
    public static InjectionConfig injectionConfig() {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/mapper.xml.vm") {
                    // 自定义输出文件目录
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return MAPPER_OUT_PATH + "/" + tableInfo.getEntityName() + "Mapper.xml";
                    }
                })
        );
    }

    /**
     * 模板配置
     * 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
     * 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
     * @return
     */
    public static TemplateConfig templateConfig() {
        return new TemplateConfig()
                .setXml(null);
    }

    /**
     * 全局配置
     * @return
     */
    public static GlobalConfig globalConfig() {
        return new GlobalConfig()
                .setOutputDir(PROJECT_PATH)// 输出目录
                .setFileOverride(true)  // 是否覆盖文件
                .setActiveRecord(true)  // 开启 activeRecord 模式
                .setEnableCache(false)  // XML 二级缓存
                .setBaseResultMap(false)// XML ResultMap
                .setBaseColumnList(true)// XML columList
                .setAuthor(AUTHOR)
                .setXmlName("%sMapper")
                .setMapperName("%sDao")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController");
    }

    /**
     * 生成代码
     */
    public static void generate() {
        AutoGenerator autoGenerator = new AutoGenerator()
                .setGlobalConfig(globalConfig())
                .setDataSource(dataSourceConfig())
                .setStrategy(strategyConfig())
                .setPackageInfo(packageConfig())
                .setCfg(injectionConfig())
                .setTemplate(templateConfig())
                ;

        autoGenerator.execute();
    }

    public static void main(String[] args) {
        generate();
    }

}
