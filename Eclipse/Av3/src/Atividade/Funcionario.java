package Atividade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Funcionario extends Pessoa{
	
	private String setor;
	
	private static final String FILE_PATH = "Funcionarios.txt";

	public Funcionario(String cpf, String nome, String email, String setor) {
		super(cpf, nome, email);
		this.setor = setor;
	}
	
	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public boolean cadastrar(Funcionario funcionario) {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(funcionario.toString());
            writer.newLine();
            System.out.println("Funcionario cadastrado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
	}
	
	public boolean editar(Funcionario funcionario) {
		
		ArrayList<Funcionario> funcionarios = funcionario.listar();
    	
    	for(var i = 0; i < funcionarios.size(); i++) {
    		Funcionario funcionarioProcurar = funcionarios.get(i);
        	if(funcionario.getCpf() == funcionarioProcurar.getCpf()) {
        		funcionarios.set(i, funcionario); 
            }
        }
    	
    	File arquivo = new File(FILE_PATH);
    	
    	 if (arquivo.exists()) {
             if (arquivo.delete()) {
                 System.out.println("O arquivo foi excluído com sucesso.");
             } else {
                 System.out.println("Falha ao excluir o arquivo.");
             }
         } else {
             System.out.println("O arquivo não existe.");
         }
    	 
    	 
    	 for(Funcionario funcionarioCadastrar : funcionarios) {
    		 funcionario.cadastrar(funcionarioCadastrar);
         }
		
		return true;
	}
	public Funcionario consultar(Funcionario funcionario) {
		ArrayList<Funcionario> funcionarios = new ArrayList<>();

	    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
	        String linha;
	        while ((linha = reader.readLine()) != null) {
	        	Funcionario funcionarioProcurar = Funcionario.fromString(linha);
	        	funcionarios.add(funcionarioProcurar);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    for (Funcionario funcionarioProcurar : funcionarios) {
	        if (funcionario.getCpf().equals(funcionarioProcurar.getCpf()) || funcionario.getNome().equals(funcionarioProcurar.getNome())) {
	            return funcionarioProcurar;
	        }
	    }
	    return null;
	}
	
	public ArrayList<Funcionario> listar(){
		ArrayList<Funcionario> funcionarios = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
            	Funcionario funcionario = Funcionario.fromString(linha);
            	funcionarios.add(funcionario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return funcionarios;
	}
	
	
	@Override
    public String toString() {
        return cpf + "," + nome + "," + email + "," + setor;
    }

    public static Funcionario fromString(String linha) {
        String[] partes = linha.split(",");
        String cpf = partes[0];
        String nome = partes[1];
        String email = partes[2];
        String setor = partes[3];
        
        
        return new Funcionario(cpf,nome,email,setor);
    }
	
	public String getFilePath() {
        return FILE_PATH;
    }
	
}
