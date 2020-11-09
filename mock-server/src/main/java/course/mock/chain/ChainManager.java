package course.mock.chain;

import course.mock.model.MockContext;

public enum ChainManager {
    newInstance;

    private AbstractHandler<MockContext, String> mappingHandler;

    ChainManager() {
        this.mappingHandler = initMappingHandler();
    }

    private AbstractHandler<MockContext, String> initMappingHandler() {
        AbstractHandler<MockContext, String> singletonMatchHandler = new SingletonMappingHandler();
        AbstractHandler<MockContext, String> multipleMatchHandler = new MultipleMappingHandler();

        singletonMatchHandler.setNextHandler(multipleMatchHandler);

        return singletonMatchHandler;
    }

    public String doMapping(MockContext context) {
        return this.mappingHandler.doHandle(context);
    }
}
