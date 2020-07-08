package course.patterns.observer.case1;

import course.patterns.bean.Tickets;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class AirlLneComp1 {

    public void send(Tickets tickets) {
        // 去哪儿网处理消息
        new QunarComp().receive(tickets);

        // 携程处理消息
        new CtripComp().receive(tickets);

        // .....
    }
}
