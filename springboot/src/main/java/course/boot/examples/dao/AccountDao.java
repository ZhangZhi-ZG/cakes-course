package course.boot.examples.dao;

import course.boot.examples.bean.TbAccount;

import java.util.List;

/**
 * author: xiha
 * crate time: 2020/6/21
 */
public interface AccountDao {

    TbAccount selectByAccountId(String accountId);

    List<TbAccount> selectAll();

    Integer insertAccount(TbAccount account);
}
