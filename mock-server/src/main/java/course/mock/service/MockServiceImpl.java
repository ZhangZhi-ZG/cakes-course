package course.mock.service;

import course.mock.chain.ChainManager;
import course.mock.model.MockContext;
import org.springframework.stereotype.Service;

@Service
public class MockServiceImpl implements MockService {

    @Override
    public String doMock(MockContext context) {
        return ChainManager.newInstance.doMapping(context);
    }
}
