package Homework.Module8;

import java.util.ArrayList;
import java.util.List;

public class AbstractDAOImpl<T> implements AbstractDAO<T>{
    @Override
    public T save(T obj) {
        System.out.println("Saved: "+obj);
        return null;
    }

    @Override
    public void delete(T obj) {
        System.out.println("Deleted: "+obj);
        obj=null;
    }

    @Override
    public void deleteAll(List<T> obj) {
        System.out.println("Deleted all: \n"+obj);
        for(T el:obj){
            el=null;
        }
    }

    @Override
    public void saveAll(List<T> obj) {
        System.out.println("Saved all: \n"+obj);
    }

    @Override
    public List<T> getList() {
        return new ArrayList<T>();
    }

    @Override
    public void deleteById(long id) {
        /*for(T el: ){

        }*/
    }

    @Override
    public T get(long id) {
        return null;
    }
}
