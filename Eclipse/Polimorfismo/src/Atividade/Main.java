package Atividade;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		List<Animal> animais = new ArrayList<>();
		double media = 0;
		
		Cachorro c1 = new Cachorro("trovao", 5, true);
		Bixo_preguiça b1 = new Bixo_preguiça("preguiço", 8, true);
		
		c1.som();
		b1.som();
		
		animais.add(c1);
		animais.add(b1);
		
		for (Animal animal : animais) {
			media += animal.idade;
		}
		media /= animais.size();
		
		System.out.println(media);
		
		
		
	}

}
