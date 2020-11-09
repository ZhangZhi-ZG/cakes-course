package course.auto.framework.cases.model;

public class OldOrder {
    private OldUser payer;

    public OldUser getPayer() {
        return payer;
    }

    public void setPayer(OldUser payer) {
        this.payer = payer;
    }

    @Override
    public String toString() {
        return "OldOrder{" +
                "payer=" + payer +
                '}';
    }
}
