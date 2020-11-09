package course.mock;

import java.util.HashMap;
import java.util.Map;

public class App {

    private static Map<String, Strategy> mmmm = new HashMap<String, Strategy>() {
        {
            put("1", new One());
            put("2", new Two());
        }
    };

    public static void main(String[] args) {
        testStrategy("2");
    }

    public static void testStrategy(String k) {
        if (mmmm.containsKey(k)) {
            mmmm.get(k).ttt();
        } else {
            throw new IllegalStateException("");
        }
    }

    public interface Strategy {
        void ttt();
    }

    static class One implements Strategy {

        @Override
        public void ttt() {
            System.out.println("One.ttt");
        }
    }

    static class Two implements Strategy {

        @Override
        public void ttt() {
            System.out.println("Two.ttt");
        }
    }
}
