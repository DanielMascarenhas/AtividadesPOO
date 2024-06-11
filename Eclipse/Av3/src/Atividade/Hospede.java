package Atividade;

import java.util.NoSuchElementException;

public class Hospede extends Pessoa {

	private String enderecoCompleto;

	private static final String FILE_PATH = "Hospedes.txt";

	public Hospede(String cpf, String nome, String email, String enderecoCompleto) {
		super(cpf, nome, email);
		this.enderecoCompleto = enderecoCompleto;
	}

	public Hospede() {
		super();
		this.enderecoCompleto = "";
	}

	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}

	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}

	@Override
	public String toString() {
		return cpf + "," + nome + "," + email + "," + enderecoCompleto;
	}

	public static Hospede fromString(String linha) {
		try {
			String[] partes = linha.split(",");
			String cpf = partes[0];
			String nome = partes[1];
			String email = partes[2];
			String enderecoCompleto = partes[3];

			return new Hospede(cpf, nome, email, enderecoCompleto);

		} catch (NumberFormatException e) {
			System.err.println("Erro: as informações fornecidas não são válidas.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Erro: valores não suficientes para a entidade.");
		} catch (NoSuchElementException e) {
			System.err.println("Erro: valores errados a entidade.");
		}
		return null;
	}

	public String getFilePath() {
		return FILE_PATH;
	}

}
