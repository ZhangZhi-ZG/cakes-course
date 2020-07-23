package course.schema.sync.factory;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Maps;
import com.mysql.cj.jdbc.Driver;
import course.schema.sync.model.ConnectInfo;

import javax.sql.DataSource;
import java.util.Map;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public class LocalDataSourceFactory {

    private final Map<String, DataSource> dataSourceMap;

    private LocalDataSourceFactory() {
        this.dataSourceMap = Maps.newConcurrentMap();
    }

    private static final class ClassHolder {
        private static final LocalDataSourceFactory INSTANCE = new LocalDataSourceFactory();
    }

    public static LocalDataSourceFactory of() {
        return ClassHolder.INSTANCE;
    }

    public DataSource getDataSource(ConnectInfo connectInfo) {
        String key = getDataSourceKey(connectInfo);
        if (this.dataSourceMap.containsKey(key)) {
            return this.dataSourceMap.get(key);
        }

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(connectInfo.getUrl());
        dataSource.setUsername(connectInfo.getUserName());
        dataSource.setPassword(connectInfo.getPassword());
        dataSource.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());

        // TODO 有一大堆的建议配置, @link https://github.com/alibaba/druid/wiki/DruidDataSource%E9%85%8D%E7%BD%AE

        this.dataSourceMap.put(key, dataSource);
        return dataSource;
    }

    private String getDataSourceKey(ConnectInfo connectInfo) {
        return String.format("%s:%s:%s", connectInfo.getUrl(), connectInfo.getUserName(), connectInfo.getPassword());
    }
}
