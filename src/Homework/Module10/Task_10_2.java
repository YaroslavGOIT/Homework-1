package Homework.Module10;

public class Task_10_2 {
    public static void main(String[] args) throws MyExceptions{
        try{
            throw new MyExceptions("This is my error");
        }catch (MyExceptions e){
            System.err.println(e.getMessage());
        }finally {
            System.out.println("In finally block");
        }
    }
}
