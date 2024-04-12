package teste;

public class Liquidificador {
	private String marca;
	private String cor;
	private int velocidade;
	private boolean tampado;

	public Liquidificador () {
		this.marca = "";
		this.cor = "";
		this.velocidade = 3;
		this.tampado = true;
	}
	
	public Liquidificador (String marca, String cor, int velocidade, boolean tampado) {
		this.marca = marca;
		this.cor = cor;
		this.velocidade = velocidade;
		this.tampado = tampado;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca (String marca ) {
		this.marca = marca;
	}
	public String getCor() {
		return cor; 
	}
	public void setCor (String cor ) {
		this.cor = cor;
	}
	public int getVelocidade () {
		return velocidade;
	}
	
	public void setVelocidade (int velocidade ) {
		this.velocidade = velocidade;
	}
	public boolean getTampado () {
		return tampado;
	}
	public void setTampado (boolean tampado) {
		this.tampado = tampado;
	}
	
	public void tampar() {
		tampado = true;
	}
	public void destampar () {
		tampado = false;
	}
	public void liquificar () {
		if(tampado){
			System.out.println("ligar");
		} else {
			System.out.println("tampar liquidificador");
		}
	
	}
	public void status () {
		System.out.println("marca: "+ marca);
		System.out.println("cor:"+ cor);
		System.out.println("velocidade:"+ velocidade);
		System.out.println("tampado:"+ tampado);
		}

}
