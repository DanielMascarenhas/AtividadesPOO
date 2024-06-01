package Main;

import java.lang.reflect.InvocationTargetException;

import Atividade.*;
import DAO.*;

public class Main {

	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
		Item item = new Item(12, "TUA MÃE", 12.50);
		//item.cadastrar(item);
		
		Categoria categoria = new Categoria(12, "TUA MÃE23", 12.50);
		//categoria.cadastrar(categoria);


		
		
		CategoriaItem cat = new CategoriaItem(item, categoria, 50);
		
		//cat.cadastrar(cat);
		
		GenericDAO genericDAO = new GenericDAO();
		
		//genericDAO.cadastrar(cat);
		//genericDAO.cadastrar(item);
		genericDAO.consultar(categoria);
		
	}

}
