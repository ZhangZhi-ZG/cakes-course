package course.mock.observer;

import course.mock.decorator.DecoratorManager;
import course.mock.model.MockContext;

/**
 * ${random:id}
 * ${random:str}
 * ${random:num}
 * ${time}
 */
public class PackResponseObserver implements IObserver<MockContext> {

    @Override
    public void update(MockContext context) {
        String finalResponse = context.getFinalResponse();
        String newResponse = DecoratorManager.newInstance.doPack(finalResponse);
        context.setFinalResponse(newResponse);
    }
}
