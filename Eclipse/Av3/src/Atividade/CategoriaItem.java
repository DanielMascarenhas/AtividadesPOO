package Atividade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CategoriaItem {
	private Item item;
	private Categoria categoria;
	private int quantidade;
	
	private static final String FILE_PATH = "CategoriasItens.txt";
	
	public CategoriaItem(Item item, Categoria categoria, int quantidade) {
		
        this.item = item;
		this.categoria = categoria;
		this.quantidade = quantidade;
	}
		
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public boolean cadastrar(CategoriaItem CategoriasItens) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(CategoriasItens.toString());
            writer.newLine();
            System.out.println("Categoria do Item cadastrada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
	
	public boolean editar(CategoriaItem categoriaItem) {
		
		ArrayList<CategoriaItem> categoriaItens = categoriaItem.listar();
    	
    	for(var i = 0; i < categoriaItens.size(); i++) {
    		CategoriaItem categoriaItemProcurar = categoriaItens.get(i);
        	if(categoriaItem.getItem().getCodigo() == categoriaItemProcurar.getItem().getCodigo() && categoriaItem.getCategoria().getCodigo() == categoriaItemProcurar.getCategoria().getCodigo() ){
        		categoriaItens.remove(i);
        		categoriaItens.set(i, categoriaItem); 
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
    	 
    	 
    	 for(CategoriaItem categoriaItemCadastrar : categoriaItens) {
    		 categoriaItem.cadastrar(categoriaItemCadastrar);
         }
		
		return true;
	}
	
	
	public CategoriaItem consultar(CategoriaItem categoriaItem) {
			
		ArrayList<CategoriaItem> categoriasItens = categoriaItem.listar();
	
	    for(CategoriaItem categoriaItemProcurar : categoriasItens) {
	    	if(categoriaItem.item.getCodigo() == categoriaItemProcurar.item.getCodigo() && categoriaItem.categoria.getCodigo() == categoriaItemProcurar.categoria.getCodigo()) {
	    		return categoriaItemProcurar;
	            }
	        }
	        return null;
	}
	
	
	
	public ArrayList<CategoriaItem> listar() {
		ArrayList<CategoriaItem> categoriasItens = new ArrayList<>();
	
	    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
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
	
	
	@Override
    public String toString() {
        return getItem().getCodigo() + "," + getCategoria().getCodigo() + "," + getQuantidade();
    }

    public static CategoriaItem fromString(String linha) {
    	
        String[] partes = linha.split(",");
        int item = Integer.parseInt(partes[0]);
        int categoria = Integer.parseInt(partes[1]);
        int quantidade = Integer.parseInt(partes[2]);
        
        Item itemPegar = new Item(item, "", 0.0);        
        Categoria categoriaPegar = new Categoria(categoria, "", 0.0);

        return new CategoriaItem(itemPegar.consultar(itemPegar), categoriaPegar.consultar(categoriaPegar), quantidade);
  
    }
    
    public String getFilePath() {
        return FILE_PATH;
    }
    
}
