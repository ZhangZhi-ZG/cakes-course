package course.patterns.bean;

import course.patterns.enums.FileType;

public class App {
    public static void main(String[] args) {
        MyFile myFile = MyFile.builder()
                .fileName("test.mp4")
                .filePath("/root/")
                .fileType(FileType.MP4)
                .build();
        System.out.println("myFile = " + myFile);
    }
}
