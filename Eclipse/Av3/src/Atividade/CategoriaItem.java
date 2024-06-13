package Atividade;


import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

import DAO.DAO;


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
	
	
		
	public CategoriaItem() {
		this.item = new Item();
		this.categoria = new Categoria();
		this.quantidade = 0;
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

	
	
	
	@Override
    public String toString() {
        return getItem().getCodigo() + "," + getCategoria().getCodigo() + "," + getQuantidade();
    }

    public static CategoriaItem fromString(String linha) throws FileNotFoundException {
    	
        try {
        	String[] partes = linha.split(",");
        	int item = Integer.parseInt(partes[0]);
        	int categoria = Integer.parseInt(partes[1]);
        	int quantidade = Integer.parseInt(partes[2]);
        	
        	Item itemPegar = new Item(item, "", 0.0);        
        	Categoria categoriaPegar = new Categoria(categoria, "", 0.0);
        	
        	DAO dao = new DAO();
        	
        	return new CategoriaItem(dao.consultar(itemPegar), dao.consultar(categoriaPegar), quantidade);
        	
        	
        } catch (NumberFormatException e) {
		    System.err.println("Erro: as informações fornecidas não são válidas.");
		} catch (ArrayIndexOutOfBoundsException e) {
		    System.err.println("Erro: valores não suficientes para a entidade.");
		} catch (NoSuchElementException e) {
		    System.err.println("Erro: valores errados a entidade.");
		} catch (NullPointerException e) {
 		    System.err.println("Erro: Alguma das informações não estão cadastradas Coretamente.");
 		} 
        return null;
    }
    
    public String getFilePath() {
        return FILE_PATH;
    }
    
}
