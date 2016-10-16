package Homework.Module8;

import java.util.Map;

public class UserDAO<T,K> extends AbstractDAOImpl {
    private T id;
    private K name;
    public void findName(T id, Map<T, K> o){
        System.out.println(o.get(id));
    }

}
