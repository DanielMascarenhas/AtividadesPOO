package Atividade;

import java.util.ArrayList;
import java.util.List;

public class Frigobar {
	
	List<Iten> itens = new ArrayList<>();
	double registroConsumo;
	int quantidade;
	
	public Frigobar(double registroConsumo, int quantidade) {
		this.registroConsumo = registroConsumo;
		this.quantidade = quantidade;
	}
	
	public void listarItens() {
		for (Iten iten : itens){
			iten.Mostrar();
		}
			
	}
	

	public void consumirIten(String nomeIten) {
		
		for (Iten iten : itens){
			if(iten.nome == nomeIten) {
				registroConsumo += iten.preço;
				itens.remove(iten);
				System.out.println("Iten consumido!");
				return;
			}
		}
		
	}
	
	public void adicionrIten(Iten iten) {
		itens.add(iten);
	}
	
}
