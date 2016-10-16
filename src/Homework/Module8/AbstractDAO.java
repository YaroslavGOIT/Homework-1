package Homework.Module8;

import java.util.List;

public interface AbstractDAO<T> {
    public T save(T obj);
    public void delete(T obj);
    public void deleteAll(List<T> obj);
    public void saveAll(List<T> obj);
    public List<T> getList();
    void deleteById(long id);
    T get(long id);
}
