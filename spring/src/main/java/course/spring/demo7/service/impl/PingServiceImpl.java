package course.spring.demo7.service.impl;

import course.spring.demo7.dao.PingDao;
import course.spring.demo7.service.PingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // ==> Component ==>
/**
 * <bean id="pingServiceImpl" class="course.spring.demo7.service.impl.PingServiceImpl">
 *      <property name="pingDao" ref="pingDaoImpl"/>
 * </bean>
 */
public class PingServiceImpl implements PingService {

    @Autowired
    private PingDao pingDao;

    @Override
    public void ping(String msg) {
        pingDao.addPing(msg);
    }
}
