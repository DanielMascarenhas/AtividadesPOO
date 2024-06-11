package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Atividade.Item;

public class ItemDAO implements DAOInterface<Item>{
	
	public boolean cadastrar(Item item) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(item.getFilePath(), true))) {
            writer.write(item.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean editar(Item item) {
    	DAO dao = new DAO();
    	ArrayList<Item> itens = dao.listar(item);
    	
    	for(var i = 0; i < itens.size(); i++) {
    		Item itemProcurar = itens.get(i);
        	if(item.getCodigo() == itemProcurar.getCodigo()) {
        		itens.remove(i);
        		itens.set(i, item); 
            }
        }
    	
    	File arquivo = new File(item.getFilePath());
    	
    	 if (arquivo.exists()) {
             if (arquivo.delete()) {
                 System.out.println("O arquivo foi excluído com sucesso.");
             } else {
                 System.out.println("Falha ao excluir o arquivo.");
             }
         } else {
             System.out.println("O arquivo não existe.");
         }
    	 
    	 
    	 for(Item itemCadastrar : itens) {
    		 dao.cadastrar(itemCadastrar);
         }
    	 

		return true;
	}
    
	public Item consultar(Item item) {
		DAO dao = new DAO();
		ArrayList<Item> itens = dao.listar(item);

        
        for(Item itemProcurar : itens) {
        	if(item.getCodigo() == itemProcurar.getCodigo()) {
        		return itemProcurar;
            }
        }
        return null;
    }
    
    public ArrayList<Item> listar(Item item2) {
        ArrayList<Item> itens = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(item2.getFilePath()))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Item item = Item.fromString(linha);
                itens.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return itens;
    }
    

}
