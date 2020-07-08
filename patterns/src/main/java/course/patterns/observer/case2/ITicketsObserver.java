package course.patterns.observer.case2;

import course.patterns.bean.Tickets;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public interface ITicketsObserver {

    void receive(Tickets tickets);
}
