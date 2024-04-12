package teste;

import java.util.List;
import java.util.ArrayList;

public class Loja{
	public String nomeLoja;
	public int anoFundacao;
	public List<Liquidificador> listaLiquidificadores= new ArrayList<>();

	public Loja(String nomeLoja, int anoFundacao, Liquidificador Liquidificador) {
		this.nomeLoja=nomeLoja;
		this.anoFundacao=anoFundacao;
		this.listaLiquidificadores.add(Liquidificador);
		
	}
	
	public void status () {
		System.out.println("Nome Loja: "+ nomeLoja);
		System.out.println("Ano Fundacao:"+ anoFundacao);
		System.out.println("Liquidificador: ");
		
		for (Liquidificador L:this.listaLiquidificadores) {
			L.status();
			System.out.println("");
		}
	}
	
	public void adicionarLiquidificador (Liquidificador L) {
		this.listaLiquidificadores.add(L);
	}
	
	public void removerLiquidificador (int id) {
		this.listaLiquidificadores.remove(id);
	}
	
	public void listarLiquidificadores () {
		for (Liquidificador L:this.listaLiquidificadores) {
			L.status();
			System.out.println("");
		}
	}
	
	public int tamanhoLiquidificadores () {
		return this.listaLiquidificadores.size();
	}
	
	
}
