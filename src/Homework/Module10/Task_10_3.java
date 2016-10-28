package Homework.Module10;

import Homework.Module3.Task_4.User;

public class Task_10_3 {
    public static void main(String[] args) {
        User user=null;
        try{
            user.getCurrency();
        } catch (Throwable e){
            System.err.println("Your user isn't found");
        } finally {
            user=new User("Vasa",1243,5,"Super Vasa Company",52,"EUR");
            System.out.println(user);
        }
    }
}
