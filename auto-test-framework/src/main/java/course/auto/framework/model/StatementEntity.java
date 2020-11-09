package course.auto.framework.model;

public class StatementEntity {
    private String fieldName;
    private Object fieldValue;
    private StatementOperator operator;

    public StatementEntity(String fieldName, Object fieldValue, StatementOperator operator) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.operator = operator;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }

    public StatementOperator getOperator() {
        return operator;
    }

    public void setOperator(StatementOperator operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "StatementEntity{" +
                "fieldName='" + fieldName + '\'' +
                ", fieldValue='" + fieldValue + '\'' +
                ", operator=" + operator +
                '}';
    }
}
