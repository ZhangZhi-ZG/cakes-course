package course.java8.stream;

import com.google.common.base.Strings;

import java.util.Optional;

public class Demo5 {
    public static void main(String[] args) {
        Optional<String> op1 = testOp("");
        // 比较挫
        // if (op1.isPresent()) {
        //     String val = op1.get();
        //     System.out.println("val = " + val);
        // }

        // String val = op1.orElse("default");
        // System.out.println("val = " + val);

        // String val = op1.orElseGet(Demo5::getStringData);
        // System.out.println("val = " + val);

        // String val = op1.orElseThrow(() -> new IllegalStateException("none data."));
        // System.out.println("val = " + val);
    }

    private static String getStringData() {
        return "1234566";
    }

    private static Optional<String> testOp(String data) {
        if (Strings.isNullOrEmpty(data)) {
            return Optional.empty();
        }
        return Optional.of(data.toUpperCase());
    }
}
