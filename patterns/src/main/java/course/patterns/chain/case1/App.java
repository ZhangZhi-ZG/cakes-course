package course.patterns.chain.case1;

import course.patterns.enums.FileType;
import course.patterns.bean.MyFile;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class App {

    public static void main(String[] args) {
        parse(MyFile.builder()
                .fileType(FileType.MP4)
                .fileName("haha")
                .filePath("hehe")
                .build());
    }

    /**
     * 问题: 若后续做扩展，新加了文件的解析器，要如何修改这段代码？
     * 是不是 要在当前这个parse方法中 去 添加各种if的判断
     * <p>
     * 代码重复度高， if分支判断多， 没有面向扩展编程
     * <p>
     * 文件解析 目前只支持 MyFile 的处理，若有新的文件该怎么办？
     *
     * @param myFile
     */
    private static void parse(MyFile myFile) {
        if (myFile.getFileType() == FileType.MP4) {
            new Mp4Parser().parse(myFile);
        }

        if (myFile.getFileType() == FileType.PNG) {
            new PngParser().parse(myFile);
        }

        if (myFile.getFileType() == FileType.AVI) {
            // .....
        }

        if (myFile.getFileType() == FileType.RMVB) {
            // .....
        }
    }
}
