package zzhg.boot.Service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzhg.boot.Service.IOrderSerivce;
import zzhg.boot.dao.IOrderDao;

/**
 * @author zzhg
 * @date 2020-06-24
 */
@Service
public class IOrderServiceImpl implements IOrderSerivce {

    private static final Logger LOGGER =  LoggerFactory.getLogger(IOrderServiceImpl.class);

    @Autowired
    private IOrderDao iOrderDao;
    @Override
    public Boolean createOrder(String orderId) {

        LOGGER.info("order service prepare create order for {}",orderId);
        Integer effectRows = iOrderDao.insertOrder(orderId);
        return effectRows > 0;
    }
}
