package Homework.Module10;

public class ClassWithExceptuion {
    public static void main(String[] args) throws Exception{
        try{
            throw new Exception("Massage with error");
        } catch (Throwable e){
            System.err.println(e.getMessage());
        }
    }
}
