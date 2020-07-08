package course.patterns.strategy;

import course.patterns.bean.MyFile;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class Mp4ParserStrategy implements IStrategy<MyFile> {

    @Override
    public void update(MyFile file) {
        System.out.println("Mp4ParserStrategy.parse file=" + file);
    }
}
