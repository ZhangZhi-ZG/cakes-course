package course.patterns.bean;

import course.patterns.enums.FileType;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class MyFile {
    private FileType fileType;
    private String fileName;
    private String filePath;

    public MyFile(Builder builder) {
        this.fileType = builder.fileType;
        this.fileName = builder.fileName;
        this.filePath = builder.filePath;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private FileType fileType;
        private String fileName;
        private String filePath;

        public Builder fileType(FileType fileType){
            this.fileType = fileType;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder filePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public MyFile build() {
            return new MyFile(this);
        }

    }

    public FileType getFileType() {
        return fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public String toString() {
        return "MyFile{" +
                "fileType=" + fileType +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
