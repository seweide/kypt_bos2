package net.liangyihui.manager.kypt.bos;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {

    private static String author = "liangyihui";

    public static void main(String[] args) {

        generate("modules", "kypt_attainment",
                "kypt_cg_member",
                "kypt_config",
                "kypt_consult",
                "kypt_cooperate_group",
                "kypt_dynamic",
                "kypt_follow",
                "kypt_indication",
                "kypt_indication_relation",
                "kypt_information",
                "kypt_label",
                "kypt_label_relation",
                "kypt_lecturer",
                "kypt_major",
                "kypt_project",
                "kypt_project_center",
                "kypt_project_ethics",
                "kypt_project_group",
                "kypt_project_researcher",
                "kypt_project_sponsor",
                "kypt_rc_ec_meeting",
                "kypt_rc_file",
                "kypt_rc_major",
                "kypt_rc_or_ec_member",
                "kypt_read_center",
                "kypt_read_project",
                "kypt_research_center",
                "kypt_research_team",
                "kypt_researcher",
                "kypt_sponsor",
                "kypt_untoward_reaction"
        );
       // generate("modules","bos_notice");
    }


    private static void generate(String moduleName, String... tableNamesInclude) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/kypt-bos-base/src/main/java");
        gc.setAuthor(author);//作者名称
        gc.setOpen(false);
//         gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setFileOverride(false);   // 是否覆盖已有文件
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
//        gc.setEntityName("%sDO");

        gc.setDateType(DateType.ONLY_DATE); // 设置日期类型为Date
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://demodb.liangyihui.net:3306/lyhdbone?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("393ZiccUiUi");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("net.liangyihui.manager.kypt.bos");
        pc.setModuleName(moduleName); //自定义模块名
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("net.liangyihui.dtbos.common.vo.BaseId");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
//        strategy.setSuperControllerClass("com.mage.common.vo.BaseController");
        strategy.setInclude(tableNamesInclude);
//        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

//        configCustomizedCodeTemplate(mpg);
//        configInjection(mpg);

        mpg.execute();
    }

    /**
     * 自定义模板
     * @param mpg
     */
//    private static void configCustomizedCodeTemplate(AutoGenerator mpg){
//        //配置 自定义模板
//        TemplateConfig templateConfig = new TemplateConfig()
//                .setEntity("templates/MyEntityTemplate.java")//指定Entity生成使用自定义模板
//                .setXml(null);//不生成xml
//        mpg.setTemplate(templateConfig);
//    }

    /**
     * 配置自定义参数/属性
     *
     * @param mpg
     */
//    private static void configInjection(AutoGenerator mpg){
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                Map<String, Object> map = new HashMap<>();
//                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
//                this.setMap(map);
//                /*
//                自定义属性注入: 模板配置：abc=${cfg.abc}
//                 */
//            }
//        };
//        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//    }

}
