package course.patterns.observer.case1;

import course.patterns.bean.Tickets;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class QunarComp {

    public void receive(Tickets tickets) {
        System.out.println("QunarComp.receive tickets=" + tickets);
    }
}
