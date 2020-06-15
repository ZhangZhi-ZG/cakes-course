package course.spring.demo7.dao.impl;

import course.spring.demo7.dao.PingDao;
import org.springframework.stereotype.Repository;

@Repository
public class PingDaoImpl implements PingDao {

    @Override
    public void addPing(String msg) {
        System.out.println("PingDaoImpl.addPing: " + msg);
    }
}
