package course.basic.exception;

public class Demo4 {
    public static void main(String[] args) {

    }

    public static void foo1() {
        // send http request

        try {
            // timeout 异常  1
            // String response = HttpClient.doPost(url,params);
            // response handle
            // response.data.bizCode = 余额不足 异常  2
            // response.data.bizCode = 支付系统故障   3
            // } catch (TimeoutEx e) {
            //     // retry
            // } catch (BalanceEx e) {
            //     // ignore
            // } catch (SysEx e) {
            //     // send alarm
            //     throw e;
            // } }
        } catch (Exception e) {
            // log.error("failed. push data. 余额不足") // 三类异常

            StackTraceElement[] stackTraceArr = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTraceArr) {
                stackTraceElement.getMethodName();
                stackTraceElement.getClassName();
                stackTraceElement.getLineNumber();
            }

            handleException(e);
        }
    }

    static void handleException(Exception e) {
        if (e instanceof TimeoutEx) {
            // retry
        }

        if (e instanceof BalanceEx) {
            // ignore
        }

        if (e instanceof SysEx) {
            // log.error()
        }
    }

    /**
     * 自定义异常
     */
    static class TimeoutEx extends RuntimeException {
        public TimeoutEx() {
        }

        public TimeoutEx(String message) {
            super(message);
        }

        public TimeoutEx(String message, Throwable cause) {
            super(message, cause);
        }

        public TimeoutEx(Throwable cause) {
            super(cause);
        }

        public TimeoutEx(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

    static class BalanceEx extends RuntimeException {

    }

    static class SysEx extends RuntimeException {

    }
}
