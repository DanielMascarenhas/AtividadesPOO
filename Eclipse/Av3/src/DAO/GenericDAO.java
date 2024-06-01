package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import Atividade.*;

public class GenericDAO<T> implements DAO<T>{
	
	public boolean cadastrar(T objeto) throws NoSuchFieldException, IllegalAccessException {
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter(getFilePath(objeto),true))) {
	            writer.write(objeto.toString());
	            writer.newLine();
	            System.out.println("Informação cadastrada com sucesso!");
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	        return true;
	}
	
	
	public boolean editar(T objeto) {
		return false;
	}
	
	public T consultar(T objeto) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        ArrayList<T> itens = new ArrayList<>();

        String filePath = getFilePath(objeto);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linha;
            Method fromStringMethod = type.getMethod("fromString", String.class);
            while ((linha = reader.readLine()) != null) {
                @SuppressWarnings("unchecked")
                T itemProcurar = (T) fromStringMethod.invoke(type.getDeclaredConstructor().newInstance(), linha);
                itens.add(itemProcurar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Method getCodigoMethod = type.getMethod("getCodigo");
            for (T itemProcurar : itens) {
                Object codigo1 = getCodigoMethod.invoke(objeto);
                Object codigo2 = getCodigoMethod.invoke(itemProcurar);
                if (codigo1.equals(codigo2)) {
                    return itemProcurar;
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
	
	public ArrayList<T> listar(T objeto) throws NoSuchMethodException, InvocationTargetException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        ArrayList<T> ts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath(objeto)))) {
            String linha;
            Method fromStringMethod = objeto.getClass().getMethod("fromString", String.class);
            while ((linha = reader.readLine()) != null) {
                // Create a new instance of T
                T newInstance = (T) objeto.getClass().getDeclaredConstructor().newInstance();
                // Invoke fromString on the new instance
                T objetos = (T) fromStringMethod.invoke(newInstance, linha);
                ts.add(objetos);
            }
        } catch (IOException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return ts;
    }
	
	
	 private String getFilePath(T objeto) throws NoSuchFieldException, IllegalAccessException {
	        Field field = objeto.getClass().getDeclaredField("FILE_PATH");
	        field.setAccessible(true);
	        return (String) field.get(objeto);
	    }
	 
	 
	 
	 
	 
	 
	 
}
