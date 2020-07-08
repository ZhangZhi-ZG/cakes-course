package course.patterns.strategy;

import course.patterns.bean.MyFile;
import course.patterns.enums.FileType;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class App {

    public static void main(String[] args) {
        MyFile myFile = MyFile.builder()
                .fileType(FileType.RMVB)
                .fileName("haha")
                .filePath("hehe")
                .build();

        System.out.println("myFile = " + myFile);
    }
}
