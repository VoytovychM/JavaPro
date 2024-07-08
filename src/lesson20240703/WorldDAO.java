package lesson20240703;

import java.util.List;

public interface WorldDAO<T, Id> {

     T getById(Id id);

     List<T> getAll();

     void save(T t);

     void delete(Id id);

     void update(T t);

}