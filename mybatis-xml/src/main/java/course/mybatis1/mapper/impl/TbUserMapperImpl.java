package course.mybatis1.mapper.impl;

import course.mybatis1.bean.TbUser;
import course.mybatis1.mapper.TbUserMapper;

import java.util.List;

/**
 * 这个类啥用没有，就是说明 要想让接口真正工作，必须得有一个 实现类，模拟实现如下:
 * <p>
 * mybatis做的事情，其实就是帮我们完成了 实现方法里的内容而已。
 * <p>
 * 如何完成的，实现过程中有很多变化的东西，比如 SQL，比如返回的数据类型。
 * <p>
 * 那就是我们在TbUserMapper.xml 里去配置的数据
 *
 *
 * abstract 只是为了不让报错，目的是说明 实现类的过程，本类 无运行的实际意义
 * author: xiha
 * crate time: 2020/6/25
 */
public abstract class TbUserMapperImpl implements TbUserMapper {

    @Override
    public List<TbUser> selectByUserId(String userId) {
        // 连接数据库
        // 创建statement
        // 执行SQL  ===> 变化的,不同的操作，不同的SQL
        // 处理结果集 ===> 返回的数据类型不一样
        // 资源关闭
        throw new IllegalStateException("have not support");
    }
}
