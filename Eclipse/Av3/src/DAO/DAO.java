package DAO;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public interface DAO<T> {
    boolean cadastrar(T objeto) throws NoSuchFieldException, IllegalAccessException;
    boolean editar(T objeto);
    T consultar(T objeto) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException;
    ArrayList<T> listar(T objeto) throws NoSuchMethodException, InvocationTargetException, NoSuchFieldException, IllegalAccessException, InstantiationException;
}

