package Main;

import java.lang.reflect.InvocationTargetException;

import Atividade.*;
import DAO.*;

public class Main {

	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

		
		Item item = new Item(1,"asda",1.0);
		Categoria categoria = new Categoria(1,"asda",1.0);
		
		Consumo consumo = new Consumo(item, categoria, 1);


		
		System.out.println(consumo.consultar(consumo));
		

		
	}

}
