package course.patterns.chain.case2;

import course.patterns.enums.FileType;
import course.patterns.bean.MyFile;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class App {

    public static void main(String[] args) {
        MyFile myFile = MyFile.builder()
                .fileType(FileType.PNG)
                .fileName("haha")
                .filePath("hehe")
                .build();

        FileParserManager.of().doParse(myFile);
    }
}
