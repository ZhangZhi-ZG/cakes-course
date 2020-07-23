package course.patterns.chain.case3;

/**
 * @author zzhg
 * @create time 2020-07-22 16:24
 */
public class MyVedio {

    private String vedioName;
    private String vedioType;
    private String vedioPath;

    private MyVedio() {
    }

    private MyVedio(Builder builder) {
        this.vedioName = builder.vedioName;
        this.vedioType = builder.vedioType;
        this.vedioPath = builder.vedioPath;
    }


    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private String vedioName;
        private String vedioType;
        private String vedioPath;

        public Builder vedioName(String vedioName) {
            this.vedioName = vedioName;
            return this;
        }

        public Builder vedioType(String vedioType) {
            this.vedioType = vedioType;
            return this;
        }

        public Builder vedioPath(String vedioPath) {
            this.vedioPath = vedioPath;
            return this;
        }

        public MyVedio build() {
            return new MyVedio(this);
        }
    }

    public String getVedioName() {
        return vedioName;
    }

    public String getVedioType() {
        return vedioType;
    }

    public String getVedioPath() {
        return vedioPath;
    }
}
