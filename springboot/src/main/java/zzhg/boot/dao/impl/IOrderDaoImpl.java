package zzhg.boot.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import zzhg.boot.dao.IOrderDao;

/**
 * @author zzhg
 * @date 2020-06-24
 */
@Repository
public class IOrderDaoImpl implements IOrderDao {
    private static final Logger LOGGER =  LoggerFactory.getLogger(IOrderDaoImpl.class);


    @Override
    public Integer insertOrder(String orderId) {
        LOGGER.info("insert into order sql start... for {}",orderId);

        return 1;
    }
}
