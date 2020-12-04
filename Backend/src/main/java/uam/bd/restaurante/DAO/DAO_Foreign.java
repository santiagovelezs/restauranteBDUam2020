package uam.bd.restaurante.DAO;

import java.util.List;

public interface DAO_Foreign<T> extends DAO<T>
{
	List<T> getAllById(int id) throws Exception;
}
