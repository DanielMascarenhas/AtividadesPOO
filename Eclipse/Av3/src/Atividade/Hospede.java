package Atividade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Hospede extends Pessoa{
	
	private String enderecoCompleto;
	
	private static final String FILE_PATH = "Hospedes.txt";

	public Hospede(String cpf, String nome, String email, String senha, String enderecoCompleto) {
		super(cpf, nome, email, senha);
		this.enderecoCompleto = enderecoCompleto;
	}
	
	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}

	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}
	
	public boolean cadastrar(Hospede hospede) {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(hospede.toString());
            writer.newLine();
            System.out.println("Hospede cadastrado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
	}
	
	public boolean editar(Hospede H) {
		
		return true;
	}
	
	public Hospede consultar(Hospede hospede) {
	    ArrayList<Hospede> hospedes = new ArrayList<>();

	    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
	        String linha;
	        while ((linha = reader.readLine()) != null) {
	                Hospede hospedeProcurar = Hospede.fromString(linha);
	                hospedes.add(hospedeProcurar);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    for (Hospede hospedeProcurar : hospedes) {
	        if (hospede.getCpf().equals(hospedeProcurar.getCpf()) || hospede.getNome().equals(hospedeProcurar.getNome())) {
	            return hospedeProcurar;
	        }
	    }
	    return null;
	}

	
	
	public ArrayList<Hospede> listar(){
		ArrayList<Hospede> hospedes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
            	Hospede hospede = Hospede.fromString(linha);
            	hospedes.add(hospede);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hospedes;
	}
	
	@Override
    public String toString() {
        return cpf + "," + nome + "," + email + "," + senha + "," + enderecoCompleto;
    }

    public static Hospede fromString(String linha) {
        String[] partes = linha.split(",");
        String cpf = partes[0];
        String nome = partes[1];
        String email = partes[2];
        String senha = partes[3];
        String enderecoCompleto = partes[4];
        
        
        return new Hospede(cpf,nome,email,senha,enderecoCompleto);
    }
    
    public String getFilePath() {
        return FILE_PATH;
    }
	

}
