package Atividade;

import java.util.NoSuchElementException;

public class Funcionario extends Pessoa {

	private String setor;

	private static final String FILE_PATH = "Funcionarios.txt";

	public Funcionario(String cpf, String nome, String email, String setor) {
		super(cpf, nome, email);
		this.setor = setor;
	}

	public Funcionario() {
		super();
		this.setor = "";
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	@Override
	public String toString() {
		return cpf + "," + nome + "," + email + "," + setor;
	}

	public static Funcionario fromString(String linha) {
		try {
			String[] partes = linha.split(",");
			String cpf = partes[0];
			String nome = partes[1];
			String email = partes[2];
			String setor = partes[3];

			return new Funcionario(cpf, nome, email, setor);

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
