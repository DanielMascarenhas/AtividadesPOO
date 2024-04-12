package questao2;

public class Funcionario {
	private String nome;
	private String cpf;
	private int idade;
	private double saldo;
	private int tempoServiço;
	private boolean gerente;
	

	
	public Funcionario(String nome, String cpf, int idade, double saldo, boolean gerente) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.saldo = saldo;
		this.tempoServiço = 0;
		this.gerente = gerente;
	}
	
	public Funcionario() {
		this.nome = "";
		this.cpf = "";
		this.idade = 0;
		this.saldo = 0;
		this.tempoServiço = 0;
		this.gerente = false;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public boolean isGerente() {
		return gerente;
	}
	public void setGerente(boolean gerente) {
		this.gerente = gerente;
	}
	public int getTempoServiço() {
		return tempoServiço;
	}
	public void setTempoServiço(int tempoServiço) {
		this.tempoServiço = tempoServiço;
	}
	
	public void aniversario() {
		idade++;
	}
	
	public void aumntarTempoServiço(int tempoServiço) {
		this.tempoServiço += tempoServiço;
	}
	
	public void mostrar() {
		System.out.println("Nome: " + nome);
		System.out.println("CPF: " + cpf);
		System.out.println("Idade: " + idade);
		System.out.println("Saldo: " + saldo);
		System.out.println("Tempo de serviço: " + tempoServiço);
		System.out.println("gerente: " + gerente);
	}
	
	
	
	
}
