package course.patterns.chain.case2;

import course.patterns.enums.FileType;
import course.patterns.bean.MyFile;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class Mp4ParserHandler extends AbstractHandler<MyFile> {

    @Override
    protected boolean preHandle(MyFile myFile) {
        return myFile.getFileType() == FileType.MP4;
    }

    @Override
    protected void onHandle(MyFile myFile) {
        System.out.println("Mp4ParserHandler.onHandle myFile=" + myFile);
    }
}
