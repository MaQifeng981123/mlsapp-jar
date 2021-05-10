package com.rt.generalframework;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成器
 */
@Slf4j
public class CodeGenerator {

    //需要生成的表
    private static final String[] INCLUDE_TABLES = {"dict_users","dict_icd","exams","message"};
    //代码生成根目录
    private static final String CODE_ROOT_PATH = "D:\\云pacs\\\\mlsappJar\\src\\main\\java";
    //模块名称
    private static final String MODULE_NAME = "generalframework";
    //包名
    private static final String PACKAGE_NAME = "com.rt." + MODULE_NAME;
    //代码生成者
    private static final String AUTHOR = "ideaGenerator";
    //数据源
    private static final DbType DB_TYPE = DbType.MYSQL;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.0.242:3306/mslapp?serverTimezone=UTC&useSSL=false";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    /**
     * main方法
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(CODE_ROOT_PATH);
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setFileOverride(true);// 是否覆盖文件
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setXmlName("%sMapper");
        gc.setMapperName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        //不生成controller 生成dto 将controller模板拿来生成dto
        gc.setControllerName("%sDto");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DB_TYPE);
        dsc.setUrl(URL);
        // dsc.setSchemaName("public");
        dsc.setDriverName(DRIVER);
        dsc.setUsername(USER_NAME);
        dsc.setPassword(PASSWORD);
        //blob字段改为byte[]
        dsc.setTypeConvert(new MySqlTypeConvert() {
            public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                if (fieldType.toLowerCase().contains("blob")) {
                    return DbColumnType.BYTE_ARRAY;
                }
                if (fieldType.toLowerCase().contains("clob")) {
                    return DbColumnType.STRING;
                }
                return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
            }
        });
        dsc.setTypeConvert(new OracleTypeConvert(){
            public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                if (fieldType.toLowerCase().contains("blob")) {
                    return DbColumnType.BYTE_ARRAY;
                }
                if (fieldType.toLowerCase().contains("clob")) {
                    return DbColumnType.STRING;
                }
                return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
            }
        });
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(PACKAGE_NAME);
        pc.setEntity("entity");
        //不生成controller 生成dto 将controller模板拿来生成dto
        pc.setController("dto");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 自定义输出配置
        // List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // 自定义配置会被优先输出
        File rootDir = new File(CODE_ROOT_PATH);
        rootDir.mkdirs();
        System.out.println("文件生成根目录为:" + CODE_ROOT_PATH);

        //cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.ftl, 会根据使用的模板引擎自动识别
        templateConfig.setEntity("templates/entity.java");
        templateConfig.setMapper("templates/mapper.java");
        templateConfig.setXml("templates/mapper.xml");
        templateConfig.setService("templates/service.java");
        templateConfig.setServiceImpl("templates/serviceImpl.java");
        //不生成controller 生成dto 将controller模板拿来生成dto
        templateConfig.setController("templates/dto.java");
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityColumnConstant(true);
        //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        /*strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");
        strategy.setSuperServiceClass("com.rt.generalframework.common.base.IBaseService");*/
        //strategy.setRestControllerStyle(true);
        //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        strategy.setInclude(INCLUDE_TABLES);
        //strategy.setExclude(EXCLUDE_TABLES);
        //strategy.setSuperEntityColumns("id");
        // strategy.setControllerMappingHyphenStyle(true);
        // strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setEntitySerialVersionUID(false);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

    }
}

