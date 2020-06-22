package course.boot.examples.test;

import course.boot.examples.bean.TbAccount;
import course.boot.examples.dao.AccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * author: xiha
 * crate time: 2020/6/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJdbc {

    @Autowired
    private AccountDao accountDao;

    @Test
    public void testSelectAll() {
        List<TbAccount> accounts = accountDao.selectAll();
        accounts.forEach(account -> {
            System.out.println("accountaccountaccountaccountaccountaccountaccountaccount = " + account);
        });
    }

    @Test
    public void testSelectByAccountId() {
        TbAccount account = accountDao.selectByAccountId("2222");
        System.out.println("accountaccountaccountaccount = " + account);
    }
}
