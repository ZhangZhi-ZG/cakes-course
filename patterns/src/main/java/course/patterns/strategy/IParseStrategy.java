package course.patterns.strategy;

import course.patterns.bean.MyFile;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public interface IParseStrategy {

    void parse(MyFile file);
}
