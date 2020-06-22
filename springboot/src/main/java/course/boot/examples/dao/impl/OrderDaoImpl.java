package course.boot.examples.dao.impl;

import course.boot.examples.dao.IOrderDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * author: xiha
 * crate time: 2020/6/21
 */
@Repository
public class OrderDaoImpl implements IOrderDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDaoImpl.class);

    @Override
    public Integer insertOrder(String orderId) {
        LOGGER.info("insert into order sql start.... id={}", orderId);
        return 1;
    }
}
