package DAO;
import java.text.ParseException;
import java.util.ArrayList;

public interface DAOInterface<T>{
	
	boolean cadastrar(T obj);
	boolean editar(T obj) throws ParseException;
	T consultar(T obj) throws ParseException;
	ArrayList<T> listar(T obj) throws ParseException;
	

}
