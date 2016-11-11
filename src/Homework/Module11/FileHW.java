package Homework.Module11;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FileHW {
    public String replacer(Map<String, String> map) throws IOException{
        //read File
        String linkTofile="D:/files/file.txt";
        String forResult="";
        String result="";
        BufferedReader br=new BufferedReader(new FileReader(linkTofile));
        String line=br.readLine();
        int countOfLine=0;
        while (line!=null){
            countOfLine++;
        }
        int countOfWrite=0;
        while (countOfLine>countOfWrite&&line!=null){
            forResult=forResult+line;
            forResult=forResult+"\n"+" sedthftsd ";
            line=br.readLine();
            countOfWrite++;
        }
        br.close();

        //Delete word is from map
        String[] deleteWord= forResult.split(" sedthftsd ");
        for(int i=0;i<deleteWord.length;i++){
            String str=deleteWord[i];
            if(map.containsKey(str)){
                deleteWord[i]= map.get(str);
            }
        }

        //Rewrite file
        for(String str:deleteWord){
            result=result+str+" ";
        }
        return result;
    }

    public File fileContentReplacer(Map<String, String> map) throws IOException {
        File file=new File("D:/files/file.txt");
        //read File
        String linkTofile="D:/files/file.txt";
        String forResult="";
        String result="";
        BufferedReader br=new BufferedReader(new FileReader(linkTofile));
        String line=br.readLine();
        int countOfLine=0;
        while (line!=null){
            countOfLine++;
        }
        int countOfWrite=0;
        while (countOfLine>countOfWrite&&line!=null){
            forResult=forResult+line;
            forResult=forResult+" idfshgudftg ";
            line=br.readLine();
        }
        br.close();

        //Delete word is from map
        String[] deleteWord= forResult.split(" ");
        for(int i=0;i<deleteWord.length;i++){
            String str=deleteWord[i];
            if(map.containsKey(str)){
                deleteWord[i]= map.get(str);
            }
        }
        for(String str:deleteWord){
            result=result+str+" ";
        }
        //Rewrite file
        String forFile[]=result.split(" idfshgudftg ");
        BufferedWriter bw=new BufferedWriter(new FileWriter("D:/files/file.txt"));
        for(String str:forFile){
            bw.write(str);
            bw.newLine();
        }
        bw.close();
        return file;
    }
    public File fileContentMerger(Map<String, String> map)throws IOException{
        File file=new File("D:/files/file.txt");
        System.out.println(replacer(map));
        fileContentReplacer(map);
        return file;
    }
    public int checkWord(String word)throws IOException{
        HashMap nothing=new HashMap();
        nothing.put("дЛЯ ТОГО ЧТОБ ТЕКСТ СОХРАНИЛСя","");
        String[] str=replacer(nothing).split(" ");
        int result=0;
        for(String string:str){
            if(Objects.equals(string,word)){
                result++;
            }
        }
        return result;
    }

}
