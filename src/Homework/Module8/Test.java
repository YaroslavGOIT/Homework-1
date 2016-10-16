package Homework.Module8;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("Den",2001);
        map.put("Den1",2002);
        map.put("Den2",2003);
        map.put("Den3",2004);
        map.put("Den4",2005);

        Map<String,Integer> map1=new HashMap<>();
        map1.put("Den",2001);
        map1.put("Den01",1999);
        map1.put("Den02",1998);
        map1.put("Den03",1997);
        map1.put("Den04",1996);

        map.putAll(map1);
        System.out.println(map.get("Den"));
        map.remove("Den");
        System.out.println(map.containsKey("Den"));


        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.values());

        Character[] x1=new Character[]{'f','h'};
        Character[] x2=new Character[]{'j','q'};
        List<Character> k=new ArrayList();
        karta(k,x1);
    }
    public static <Corduple> Collection<Corduple> karta(Collection<Corduple> c,Corduple[] v){
        for(Corduple el:v){
            c.add(el);
        }
        return c;
    }
}
