package course.schema.sync.dao;

import com.google.common.base.Predicates;
import course.schema.sync.factory.LocalSqlSessionFactory;
import course.schema.sync.mapper.BaseMapper;
import course.schema.sync.mapper.SchemaMapper;
import course.schema.sync.model.ConnectInfo;
import course.schema.sync.model.SchemaDO;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * author: xiha
 * crate time: 2020/7/5
 */
public final class DaoFacade {

    private DaoFacade() {
        //
    }

    public static <R, M extends BaseMapper> R ofMapper(ConnectInfo connect, Class<M> mapperClazz, Function<M, R> func) {
        try (SqlSession sqlSession = LocalSqlSessionFactory.of().getSqlSession(connect)) {
            M mapper = sqlSession.getMapper(mapperClazz);
            return func.apply(mapper);
        } catch (Exception e) {
            throw new IllegalStateException("exec mapper failed.", e);
        }
    }

    public static void execSql(ConnectInfo connect, String sql) {
        try (SqlSession sqlSession = LocalSqlSessionFactory.of().getSqlSession(connect);
             Connection connection = sqlSession.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        } catch (Exception e) {
            throw new IllegalStateException("exec sql failed.", e);
        }
    }

    public static void execBatchSql(ConnectInfo connect, List<String> sqlList) {
        try (SqlSession sqlSession = LocalSqlSessionFactory.of().getSqlSession(connect);
             Connection connection = sqlSession.getConnection()) {
            for (String sql : sqlList) {
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.execute();
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException("exec sql failed.", e);
        }
    }

    public static void execSql(ConnectInfo connect, String sql, Object... params) {
        try (SqlSession sqlSession = LocalSqlSessionFactory.of().getSqlSession(connect);
             Connection connection = sqlSession.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            statement.execute();
        } catch (Exception e) {
            throw new IllegalStateException("exec sql failed.", e);
        }
    }
}
