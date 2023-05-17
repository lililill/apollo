package com.ctrip.framework.apollo.common.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class OracleUpperCaseStrategy extends PhysicalNamingStrategyStandardImpl {

    private static final long serialVersionUID = 1383021413247872469L;


    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        // 将表名全部转换成大写,加双引号解决字段或表名是oracle关键字
        String tableName = "\"" + name.getText().toUpperCase() + "\"";
        return name.toIdentifier(tableName);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        // 将字段全部转换成大写,加双引号解决字段或表名是oracle关键字
        String columnName = "\"" + name.getText().toUpperCase() + "\"";
        return name.toIdentifier(columnName);
    }

}