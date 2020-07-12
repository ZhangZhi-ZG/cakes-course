package course.schema.sync.consts;

/**
 * author: heiha
 */
public interface SqlFormatterConst {

    String MODIFY_COLUMN_FORMAT = "alter table `%s`.`%s` modify column `%s` %s %s %s %s;";

    String ADD_COLUMN_FORMAT = "alter table `%s`.`%s` add column `%s` %s %s %s %s;";

    String ADD_INDEX_FORMAT = "alter table `%s`.`%s` add index `%s`(%s);";

    String ADD_UNIQUE_INDEX_FORMAT = "alter table `%s`.`%s` add unique index `%s`(%s);";

    String DROP_INDEX_FORMAT = "alter table `%s`.`%s` drop index `%s`;";

}
