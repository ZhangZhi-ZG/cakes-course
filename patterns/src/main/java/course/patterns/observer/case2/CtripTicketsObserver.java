package course.patterns.observer.case2;

import course.patterns.bean.Tickets;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class CtripTicketsObserver implements ITicketsObserver {

    @Override
    public void receive(Tickets tickets) {
        System.out.println("CtripTicketsObserver.receive tickets=" + tickets);
    }
}
