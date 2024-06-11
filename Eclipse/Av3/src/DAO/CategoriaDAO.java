package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Atividade.Categoria;

public class CategoriaDAO implements DAOInterface<Categoria>{
	
	
	
	public boolean cadastrar(Categoria categoria) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(categoria.getFilePath(), true))) {
            writer.write(categoria.toString());
            writer.newLine();
            System.out.println("Categoria cadastrada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
	
	public boolean editar(Categoria categoria) {
		
		ArrayList<Categoria> categorias = listar(categoria);
    	
    	for(var i = 0; i < categorias.size(); i++) {
    		Categoria categoriaProcurar = categorias.get(i);
        	if(categoria.getCodigo() == categoriaProcurar.getCodigo()) {
        		categorias.remove(i);
        		categorias.set(i, categoria); 
            }
        }
    	
    	File arquivo = new File(categoria.getFilePath());
    	
    	 if (arquivo.exists()) {
             if (arquivo.delete()) {
                 System.out.println("O arquivo foi excluído com sucesso.");
             } else {
                 System.out.println("Falha ao excluir o arquivo.");
             }
         } else {
             System.out.println("O arquivo não existe.");
         }
    	 
    	 
    	 for(Categoria categoriaCadastrar : categorias) {
    		 cadastrar(categoriaCadastrar);
         }
		
		return true;
	}

	public Categoria consultar(Categoria categoria) {
		
		ArrayList<Categoria> categorias = listar(categoria);
		
        for(Categoria categoriaProcurar : categorias) {
        	if(categoria.getCodigo() == categoriaProcurar.getCodigo()) {
        		return categoriaProcurar;
            }
        }
        return null;
    }
	
	public ArrayList<Categoria> listar(Categoria categoria2){
		ArrayList<Categoria> categorias = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(categoria2.getFilePath()))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
            	Categoria categoria = Categoria.fromString(linha);
                categorias.add(categoria);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return categorias;
	}

	
}
