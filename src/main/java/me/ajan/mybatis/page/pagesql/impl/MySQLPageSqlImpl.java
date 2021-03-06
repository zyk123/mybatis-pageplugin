package me.ajan.mybatis.page.pagesql.impl;

import me.ajan.mybatis.page.DBDialectType;
import me.ajan.mybatis.page.PageInfo;
import me.ajan.mybatis.page.pagesql.AbstractPageSql;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by ajan on 2016/8/1.
 */
public class MySQLPageSqlImpl extends AbstractPageSql {

    public MySQLPageSqlImpl(){
        dbDialectType = DBDialectType.MYSQL.getName();
    }

    @Override
    public String getPageSql(String sql, PageInfo pageInfo) {
        StringBuilder sb = new StringBuilder("");
        if (StringUtils.isNotBlank(sql) && pageInfo != null) {
            if(pageInfo.getPageNo() < 1){
                pageInfo.setPageNo(1);
            }
            if(pageInfo.getPageSize() <= 0){
                pageInfo.setPageSize(10);
            }
            int start = (pageInfo.getPageNo() - 1) * pageInfo.getPageSize();
            int pageSize = pageInfo.getPageSize();
            sb.append(sql).append(" limit ").append(start).append(",").append(pageSize).append(" ");
        }
        return sb.toString();
    }
}
