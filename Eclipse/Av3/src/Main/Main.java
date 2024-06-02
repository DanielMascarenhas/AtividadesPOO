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
		
		//Funcionario funcionario = new Funcionario("sdgfart", "wetagerg", "gergag", "tgerger", "fgertgae");
		//funcionario.cadastrar(funcionario);

		Hospede hospede = new Hospede("adsf", "fsa", "afs", "ada", "dsaaa");
		hospede.cadastrar(hospede);
		Hospede hospede2 = new Hospede("adsf", "", "", "", "");
		System.out.println(hospede.consultar(hospede2));
		

		
	}

}
