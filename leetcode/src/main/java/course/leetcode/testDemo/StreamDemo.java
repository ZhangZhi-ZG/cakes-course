package course.leetcode.testDemo;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {

        List<String> strs = Arrays.asList("fly","foo","flower","flight","bitch","flight");

//        strs.forEach(System.out::println);
        Map<String, Integer> map = StreamTest1(strs);
        map.forEach((k,v)->System.out.println("key:" + k  + " value:" + v + "\n"));
    }

    private static Map<String,Integer> StreamTest1(List<String> list) {
        Map<String, Integer> map = list.stream()
                .filter(str -> str.startsWith("fl"))
                .map(String::toUpperCase)
                .distinct()
                .collect(Collectors.toMap(str -> str, String::length));
//        System.out.println("map = " + map);
        return map;
    }

}
