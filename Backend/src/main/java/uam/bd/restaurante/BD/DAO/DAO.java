package uam.bd.restaurante.BD.DAO;

import java.util.List;

public interface DAO<T> 
{	
    List getAll() throws Exception;

    T getBy(int id) throws Exception;

    boolean save(T t) throws Exception;

    boolean update(T t) throws Exception;

    boolean delete(T t) throws Exception;
}
