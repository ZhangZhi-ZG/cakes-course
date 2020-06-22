package course.boot.examples.service.impl;

import course.boot.examples.dao.IOrderDao;
import course.boot.examples.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author: xiha
 * crate time: 2020/6/21
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private IOrderDao orderDao;

    // @Autowired
    // private PayService payService;

    // private AdminService adminService;

    // private RealNameService rnService;

    @Override
    public Boolean createOrder(String orderId) {
        LOGGER.info("order service prepare create order for {}", orderId);

        Integer effectRows = orderDao.insertOrder(orderId);

        // payService.pay();

        return effectRows > 0;
    }
}
