package course.schema.sync.dao;

import course.schema.sync.factory.LocalSqlSessionFactory;
import course.schema.sync.mapper.BaseMapper;
import course.schema.sync.mapper.SchemaMapper;
import course.schema.sync.model.ConnectInfo;
import course.schema.sync.model.SchemaDO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
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

        //  SqlSession sqlSession = LocalSqlSessionFactory.of().getSqlSession(connect);
        //  SchemaMapper mapper = sqlSession.getMapper(SchemaMapper.class);
        //  List<SchemaDO> schemaDOS = mapper.selectAllSchema();

        try (SqlSession sqlSession = LocalSqlSessionFactory.of().getSqlSession(connect)) {
            M mapper = sqlSession.getMapper(mapperClazz);
            return func.apply(mapper);
        } catch (Exception e) {
            throw new IllegalStateException("exec mapper failed.", e);
        }
    }
}
