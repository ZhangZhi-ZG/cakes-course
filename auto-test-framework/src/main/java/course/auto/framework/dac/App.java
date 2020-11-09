package course.auto.framework.dac;

import com.google.common.collect.Maps;
import course.auto.framework.dac.builder.StatementBuilder;
import course.auto.framework.dac.factory.DataSourceFactory;
import course.auto.framework.dac.fields.AccountFields;
import course.auto.framework.dac.table.AccountTb;
import course.auto.framework.model.RowEntity;
import course.auto.framework.model.StatementOperator;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * mybatis
 */
public class App {

    @Test
    public void testDelete() {
        int effectRows = AccountTb.of().delete(StatementBuilder.builder()
                .addStatement(AccountFields.ID, 1, StatementOperator.MORE_THAN));
        System.out.println("effectRows = " + effectRows);
    }

    @Test
    public void testSelect() {
        List<RowEntity> rows = AccountTb.of().query(StatementBuilder.builder()
                .addStatement("account_id", "1111"));
        System.out.println("rows = " + rows);
    }

    @Test
    public void test1() {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(DataSourceFactory.of().getDataSource());
        Map<String, String> params = Maps.newHashMap();
        params.put("account_id", "1111");
        List<Map<String, Object>> response = jdbcTemplate.queryForList("select * from course.tb_account where account_id=:account_id", params);
        for (Map<String, Object> res : response) {
            System.out.println("res = " + res);
        }
    }
}
