package Main;

import Atividade.*;

public class Main {

	public static void main(String[] args) {
		Item item = new Item(12, "TUA MÃE", 12.50);
		item.cadastrar(item);
		
		Categoria categoria = new Categoria(12, "TUA MÃE2", 12.50);
		categoria.cadastrar(categoria);


		
		
		CategoriaItem cat = new CategoriaItem(item, categoria, 50);
		
		cat.cadastrar(cat);
		
	}

}
