package com.yy.linxiweb.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.nio.file.Paths;
import java.sql.Types;

/**
 * 代码生成器
 */
public class CodeGenerator {

    public static final String THIS_MODULE_NAME = "web-core"; //当前项目名称

    public static final String DB_URL = "jdbc:mysql://139.224.197.83:3306/linxidb";
    public static final String DB_USERNAME = "webuser";
    public static final String DB_PASSWORD = "123456";

    //    public static final String DB_URL = "jdbc:mysql://localhost:3306/wms?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
//    public static final String DB_USERNAME = "root";
//    public static final String DB_PASSWORD = "123456";
    // 多个用表用 ， 拼接
    //public static final String TABLE_NAMES= "t_sys_entitlement,t_sys_role,t_sys_user,t_sys_user_auth";
    public static final String TABLE_NAMES = "music_sheet";

    public static void main(String[] args) {
        FastAutoGenerator.create(DB_URL, DB_USERNAME, DB_PASSWORD)
                .globalConfig(builder -> {
                    builder.author("yueyi")// 设置作者
                            .disableOpenDir() // 不打开输出目录
                            .enableSpringdoc() // 开启springdoc，用于swagger3
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(Paths.get(System.getProperty("user.dir")) + "/src/main/java")
                            .dateType(DateType.ONLY_DATE)
                            .commentDate("yyyy-MM-dd");
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            if (typeCode == Types.DOUBLE) {
                                // 自定义类型转换
                                return DbColumnType.BIG_DECIMAL;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent("com.yy.linxiweb")
                                .entity("po")
                                .mapper("dao")
                                .service("service")
                                .serviceImpl("service.impl")
                                .xml("mapper")
                                .controller("controller")
                )
                .strategyConfig(builder ->
                        builder.addInclude(TABLE_NAMES.split(","))
                                .addTablePrefix("d_", "f_")
                                .entityBuilder()
                                .naming(NamingStrategy.underline_to_camel)
                                .columnNaming(NamingStrategy.underline_to_camel)
                                //.enableFileOverride()
                                .enableLombok()
                                .enableTableFieldAnnotation()
                                .enableChainModel()
                                .entityBuilder()
                                .logicDeleteColumnName("deleted")
                                .versionColumnName("version")
                                .addTableFills(new Column("created", FieldFill.INSERT))
                                .addTableFills(new Column("createdBy", FieldFill.INSERT))
                                .addTableFills(new Column("lastModifiedBy", FieldFill.UPDATE))
                                .addTableFills(new Column("lastModified", FieldFill.UPDATE))
                                .addTableFills(new Column("creatorId", FieldFill.INSERT))
                                .addTableFills(new Column("lastModifierId", FieldFill.UPDATE))
                                .build()
                                .serviceBuilder()
//                                .enableFileOverride()
                                .build()
                                .mapperBuilder()
//                                .enableFileOverride()
                                .build()
                                .controllerBuilder()
//                                .enableFileOverride()
                                .enableRestStyle().build()

                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
