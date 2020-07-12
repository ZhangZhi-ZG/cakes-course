package course.schema.sync.util;

import course.schema.sync.model.ColumnsDO;

import java.util.Formatter;
import java.util.Objects;

/**
 * author: heiha
 */
public final class SqlUtils {

    private SqlUtils() {
        //
    }

    public static String wrapperNullableSet(ColumnsDO column) {
        if ("YES".equals(column.getIsNullable())) {
            return "";
        }

        if ("NO".equals(column.getIsNullable())) {
            return "not null";
        }

        throw new IllegalArgumentException("unknow val set = " + column.getIsNullable());
    }

    public static String wrapperDefaultSet(ColumnsDO columnsDO) {//String columnDefault, String dataType) {
        if (Objects.isNull(columnsDO.getColumnDefault())) {
            return "";
        }

        if ("".equals(columnsDO.getColumnDefault())) {
            return "default ''";
        }

        // TODO ， 有bug,需要去 判断 其他几种字符串如, char. List<String> mysql_string_type_list = [varchar,char]. mysql_string_type_list.contains
        if (columnsDO.getDataType().equals("varchar")) {
            return new Formatter().format("default '%s'", columnsDO.getColumnDefault()).toString();
        }

        return "default " + columnsDO.getColumnDefault();
    }

    public static String wrapperCommentSet(ColumnsDO columnsDO) {
        if (Objects.isNull(columnsDO.getColumnComment())) {
            return "";
        }

        return "comment '" + columnsDO.getColumnComment() + "'";
    }
}