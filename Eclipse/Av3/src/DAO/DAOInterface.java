package DAO;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

public interface DAOInterface<T>{
	
	boolean cadastrar(T obj);
	boolean editar(T obj) throws ParseException, FileNotFoundException;
	T consultar(T obj) throws ParseException, FileNotFoundException;
	ArrayList<T> listar(T obj) throws ParseException, FileNotFoundException;
	

}
