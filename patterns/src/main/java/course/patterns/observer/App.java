package course.patterns.observer;

import course.patterns.bean.Tickets;
import course.patterns.observer.case2.AirLineComp2;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class App {

    public static void main(String[] args) {
        new AirLineComp2().send(new Tickets(1024,"大连","上海"));
    }
}
