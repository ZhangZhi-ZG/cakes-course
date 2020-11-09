package course.auto.framework.model;

public class FieldEntity {
    private String filedName;
    private Object fieldValue;

    public FieldEntity(String filedName, Object fieldValue) {
        this.filedName = filedName;
        this.fieldValue = fieldValue;
    }

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public String toString() {
        return "FieldEntity{" +
                "filedName='" + filedName + '\'' +
                ", fieldValue=" + fieldValue +
                '}';
    }
}
