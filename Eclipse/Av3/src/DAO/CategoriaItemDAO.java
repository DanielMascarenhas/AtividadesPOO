package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Atividade.CategoriaItem;

public class CategoriaItemDAO implements DAOInterface<CategoriaItem>{

	
	public boolean cadastrar(CategoriaItem categoriasIten) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(categoriasIten.getFilePath() , true))) {
            writer.write(categoriasIten.toString());
            writer.newLine();
            System.out.println("Categoria do Item cadastrada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
	
	public boolean editar(CategoriaItem categoriaItem) {
		DAO dao = new DAO();
		
		ArrayList<CategoriaItem> categoriaItens = dao.listar(categoriaItem);
    	
    	for(var i = 0; i < categoriaItens.size(); i++) {
    		CategoriaItem categoriaItemProcurar = categoriaItens.get(i);
        	if(categoriaItem.getItem().getCodigo() == categoriaItemProcurar.getItem().getCodigo() && categoriaItem.getCategoria().getCodigo() == categoriaItemProcurar.getCategoria().getCodigo() ){
        		categoriaItens.remove(i);
        		categoriaItens.set(i, categoriaItem); 
            }
        }
    	
    	File arquivo = new File(categoriaItem.getFilePath());
    	
    	 if (arquivo.exists()) {
             if (arquivo.delete()) {
                 System.out.println("O arquivo foi excluído com sucesso.");
             } else {
                 System.out.println("Falha ao excluir o arquivo.");
             }
         } else {
             System.out.println("O arquivo não existe.");
         }
    	 
    	 
    	 for(CategoriaItem categoriaItemCadastrar : categoriaItens) {
    		 dao.cadastrar(categoriaItemCadastrar);
         }
		
		return true;
	}
	
	
	public CategoriaItem consultar(CategoriaItem categoriaItem) {
		DAO dao = new DAO();
			
		ArrayList<CategoriaItem> categoriasItens = dao.listar(categoriaItem);
	
	    for(CategoriaItem categoriaItemProcurar : categoriasItens) {
	    	if(categoriaItem.getItem().getCodigo() == categoriaItemProcurar.getItem().getCodigo() && categoriaItem.getCategoria().getCodigo() == categoriaItemProcurar.getCategoria().getCodigo()) {
	    		return categoriaItemProcurar;
	            }
	        }
	        return null;
	}
	
	
	
	public ArrayList<CategoriaItem> listar(CategoriaItem categoriaItem2) {
		ArrayList<CategoriaItem> categoriasItens = new ArrayList<>();
	
	    try (BufferedReader reader = new BufferedReader(new FileReader(categoriaItem2.getFilePath()))) {
	        String linha;
	        while ((linha = reader.readLine()) != null) {
	        	CategoriaItem categoriaItem = CategoriaItem.fromString(linha);
	            categoriasItens.add(categoriaItem);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	    return categoriasItens;
	}
}
