package course.java8.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zzhg
 * @date 2020-05-24
 */
public class streamDemo {

    /**
     * 示例3: 找出全文的单词，转小写，并排序
     */

    public static void main(String[] args) {
        String file_path = "C:\\Workspace\\cakes-course\\java8\\src\\main\\java\\course\\java8\\Demo3.java";
        testStream(file_path);
    }

    private static void testStream(String file_path) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file_path));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bf.readLine())!=null){
                sb.append(line);
            }
            String[] ss = sb.toString().split("\\.|;| |,|@|\\)|>|<|\\(|\\*|/|}|]|\\[|\\{");
            Map<String, Integer> collect = Arrays.stream(ss)
//                    .peek(System.out::println)
                    .filter(str -> ! str.isEmpty())
                    .filter(str->str.length()>1)
                    .map(String::toUpperCase)
                    .distinct()
                    .collect(Collectors.toMap(str -> str, String::length));
            collect.forEach((k,v)->{
                System.out.println("data map K=="+k);
                System.out.println("         v=="+v);
                System.out.println("\n");
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
