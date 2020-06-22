package course.boot.examples.dao.impl;

import course.boot.examples.bean.TbAccount;
import course.boot.examples.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: xiha
 * crate time: 2020/6/21
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public TbAccount selectByAccountId(String accountId) {
        return jdbcTemplate.queryForObject("select * from `tb_account` where `account_id`=?", new String[]{accountId}, TbAccount.class);
    }

    @Override
    public List<TbAccount> selectAll() {
        return jdbcTemplate.query("select * from `tb_account`", new BeanPropertyRowMapper<>(TbAccount.class));
    }

    @Override
    public Integer insertAccount(TbAccount account) {
        return null;
    }
}
