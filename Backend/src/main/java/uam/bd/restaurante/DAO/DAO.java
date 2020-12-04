package uam.bd.restaurante.DAO;

import java.awt.List;
import java.util.Optional;

public interface DAO<T> {
	 // void update(T t, String[] params);

    List getAll() throws Exception;

    T getBy(int id) throws Exception;

    boolean save(T t) throws Exception;

    boolean update(T t) throws Exception;

    boolean delete(T t) throws Exception;
}
