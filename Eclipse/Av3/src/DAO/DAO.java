package DAO;

import java.util.ArrayList;

public interface DAO<T> {
    boolean cadastrar(T objeto);
    boolean editar(T objeto);
    T consultar(T objeto);
    ArrayList<T> listar();
}

