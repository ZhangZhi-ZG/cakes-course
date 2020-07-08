package course.patterns.chain.case2;

import course.patterns.enums.FileType;
import course.patterns.bean.MyFile;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public class RmvbParserHandler extends AbstractHandler<MyFile> {

    @Override
    protected boolean preHandle(MyFile myFile) {
        return myFile.getFileType() == FileType.RMVB;
    }

    @Override
    protected void onHandle(MyFile myFile) {
        System.out.println("RmvbParserHandler.onHandle myFile=" + myFile);
    }
}
