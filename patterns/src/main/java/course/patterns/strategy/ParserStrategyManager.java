package course.patterns.strategy;

import com.google.common.collect.Maps;
import course.patterns.bean.MyFile;
import course.patterns.enums.FileType;

import java.util.Map;

/**
 * author: xiha
 * crate time: 2020/6/25
 */
public final class ParserStrategyManager {

    private final Map<FileType, IStrategy<MyFile>> strategyMap;

    private ParserStrategyManager() {
        this.strategyMap = Maps.newConcurrentMap();
        this.strategyMap.put(FileType.MP4, new Mp4ParserStrategy());
        this.strategyMap.put(FileType.AVI, new AviParserStrategy());
        this.strategyMap.put(FileType.RMVB, new RmvbParserStrategy());
    }

    private static final class ClassHolder {
        private static final ParserStrategyManager INSTANCE = new ParserStrategyManager();
    }

    public static ParserStrategyManager of() {
        return ClassHolder.INSTANCE;
    }

    public void doParse(MyFile file) {
        if (this.strategyMap.containsKey(file.getFileType())) {
            this.strategyMap.get(file.getFileType()).update(file);
        }
    }
}
