package Atividade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Item {
    private int codigo;
    private String descricao;
    private double valor;
    

    public static final String FILE_PATH = "Itens.txt";

    public Item(int codigo, String descricao, double valor) {
        this.codigo = codigo;        
        this.descricao = descricao;
        this.valor = valor;
    }
    
	public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean cadastrar(Item item) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(item.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean editar(Item item) {
    	ArrayList<Item> itens = item.listar();
    	
    	for(var i = 0; i < itens.size(); i++) {
    		Item itemProcurar = itens.get(i);
        	if(item.getCodigo() == itemProcurar.getCodigo()) {
        		itens.set(i, item); 
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
    	 
    	 
    	 for(Item itemCadastrar : itens) {
    		 item.cadastrar(itemCadastrar);
         }
    	 

		return true;
	}
    
	public Item consultar(Item item) {
		
		ArrayList<Item> itens = item.listar();

        
        for(Item itemProcurar : itens) {
        	if(item.getCodigo() == itemProcurar.getCodigo()) {
        		return itemProcurar;
            }
        }
        return null;
    }
    
    public ArrayList<Item> listar() {
        ArrayList<Item> itens = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
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
    
    @Override
    public String toString() {
        return codigo + "," + descricao + "," + valor;
    }

    public static Item fromString(String linha) {
        String[] partes = linha.split(",");
        int codigo = Integer.parseInt(partes[0]);
        String descricao = partes[1];
        double valor = Double.parseDouble(partes[2]);
        return new Item(codigo, descricao, valor);
    }
    
    
}
