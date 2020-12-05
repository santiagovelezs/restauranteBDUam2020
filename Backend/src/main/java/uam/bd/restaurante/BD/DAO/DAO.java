package uam.bd.restaurante.BD.DAO;

import java.util.List;

public interface DAO<T> 
{	
    List<T> getAll() throws Exception;

    T getBy(String id) throws Exception;

    String save(T t) throws Exception;

    boolean update(T t) throws Exception;

    boolean delete(T t) throws Exception;
}
