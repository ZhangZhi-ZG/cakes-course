package course.patterns.observer.case2;

import course.patterns.bean.Tickets;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class AirLineComp2 {

    public void send(Tickets tickets) {
        TicketsObserverManager.of().doReceive(tickets);
    }
}
