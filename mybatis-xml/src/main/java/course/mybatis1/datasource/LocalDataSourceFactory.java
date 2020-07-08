package course.mybatis1.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class LocalDataSourceFactory implements DataSourceFactory {

    private Properties props;

    @Override
    public void setProperties(Properties props) {
        this.props = props;
    }

    /**
     * 参数详细配置参考如下链接
     *
     * @return
     * @link https://github.com/alibaba/druid/wiki/DruidDataSource%E9%85%8D%E7%BD%AE
     */
    @Override
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        // 最基本的配置
        dataSource.setUrl(this.props.getProperty("url"));
        dataSource.setDriverClassName(this.props.getProperty("driver"));
        dataSource.setUsername(this.props.getProperty("username"));
        dataSource.setPassword(this.props.getProperty("password"));

        // 数据源参数调优
        dataSource.setMaxActive(Integer.parseInt(this.props.getProperty("maxActive")));
        dataSource.setMaxWait(60000);

        return dataSource;
    }
}
