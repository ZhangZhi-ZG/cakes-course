package course.patterns.strategy;

import course.patterns.bean.MyFile;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class RmvbParserStrategy implements IStrategy<MyFile> {

    @Override
    public void update(MyFile file) {
        System.out.println("RmvbParserStrategy.parse file=" + file);
    }
}
