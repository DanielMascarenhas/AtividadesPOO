package Atividade;

import java.util.NoSuchElementException;

public class Categoria {
	
	private int codigo;
	private String descricao;
	private double valor;
	
	private static final String FILE_PATH = "Categorias.txt";
	
	public Categoria(int codigo, String descricao, double valor) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
	}
		
	public Categoria() {
		this.codigo = 0;
		this.descricao = "";
		this.valor = 0.0;
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
	
	@Override
    public String toString() {
        return codigo + "," + descricao + "," + valor;
    }

    public static Categoria fromString(String linha) {
    	
        
        try {
        	String[] partes = linha.split(",");
            int codigo = Integer.parseInt(partes[0]);
            String descricao = partes[1];
            double valor = Double.parseDouble(partes[2]);
            return new Categoria(codigo, descricao, valor);
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
