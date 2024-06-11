package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import Atividade.Funcionario;

public class FuncionarioDAO implements DAOInterface<Funcionario>{

	public boolean cadastrar(Funcionario funcionario) {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(funcionario.getFilePath(), true))) {
            writer.write(funcionario.toString());
            writer.newLine();
            System.out.println("Funcionario cadastrado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }catch (NumberFormatException e) {
		    System.err.println("Erro: as informações fornecidas não são válidas.");
		    return false;
		} catch (ArrayIndexOutOfBoundsException e) {
		    System.err.println("Erro: valores não suficientes para a entidade.");
		    return false;
		} catch (NoSuchElementException e) {
		    System.err.println("Erro: valores errados a entidade.");
		    return false;
		} 
        return true;
	}
	
	public boolean editar(Funcionario funcionario) {
		DAO dao = new DAO();
		ArrayList<Funcionario> funcionarios = dao.listar(funcionario);
    	
    	for(var i = 0; i < funcionarios.size(); i++) {
    		Funcionario funcionarioProcurar = funcionarios.get(i);
        	if(funcionario.getCpf() == funcionarioProcurar.getCpf()) {
        		funcionarios.remove(i);
        		funcionarios.set(i, funcionario); 
            }
        }
    	
    	File arquivo = new File(funcionario.getFilePath());
    	
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
    		 dao.cadastrar(funcionarioCadastrar);
         }
		
		return true;
	}
	public Funcionario consultar(Funcionario funcionario) {
		ArrayList<Funcionario> funcionarios = new ArrayList<>();

	    try (BufferedReader reader = new BufferedReader(new FileReader(funcionario.getFilePath()))) {
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
	
	public ArrayList<Funcionario> listar(Funcionario funcionario2){

		
		ArrayList<Funcionario> funcionarios = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(funcionario2.getFilePath()))) {
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
	
}
