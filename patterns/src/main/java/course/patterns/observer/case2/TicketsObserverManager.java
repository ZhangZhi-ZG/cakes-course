package course.patterns.observer.case2;

import com.google.common.collect.Lists;
import course.patterns.bean.Tickets;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public final class TicketsObserverManager {
    private final List<ITicketsObserver> observers;

    private TicketsObserverManager() {
        this.observers = Lists.newArrayList();
        this.observers.add(new QunarTicketsObserver());
        this.observers.add(new CtripTicketsObserver());
    }

    private static final class ClassHolder {
        private static final TicketsObserverManager INSTANCE = new TicketsObserverManager();
    }

    public static TicketsObserverManager of() {
        return ClassHolder.INSTANCE;
    }

    public void doReceive(Tickets tickets) {
        for (ITicketsObserver observer : this.observers) {
            observer.receive(tickets);
        }
    }

//    public void doReceive(Tickets tickets) throws InterruptedException {
//        // 先将消息入队，瞬间一万个，这里是不断的往 队列里生产消息
//        ArrayBlockingQueue<Tickets> queue = new ArrayBlockingQueue<Tickets>();
//        queue.add(tickets);
//
//        // 以下是拿到所欲的 消费者，也就是坚挺着， 从队列中拿出消息后， 来逐个的进行消费处理
//        for (ITicketsObserver observer : this.observers) {
//            Tickets t = queue.take();
//            observer.receive(t);
//        }
//    }
}
