package Homework.Module11;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainTester {
    public static void main(String[] args) throws IOException {
        FileHW file=new FileHW();
        Map<String,String> map=new HashMap<>();
        map.put("kartopla","main");
        //map.put("main","kartopla");
        /*System.out.println(file.replacer(map));
        System.out.println(file.fileContentReplacer(map));*/
        file.fileContentMerger(map);
        System.out.println(file.checkWord("main"));
    }
}
