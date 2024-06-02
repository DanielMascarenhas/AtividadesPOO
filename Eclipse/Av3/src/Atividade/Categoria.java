package Atividade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



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
	
	public boolean cadastrar(Categoria categoria) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(categoria.toString());
            writer.newLine();
            System.out.println("Categoria cadastrada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
	
	public boolean editar(Categoria C) {
		
		return true;
	}

public Categoria consultar(Categoria categoria) {
		
		ArrayList<Categoria> categorias = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
            	Categoria categoriaProcurar = Categoria.fromString(linha);
                categorias.add(categoriaProcurar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for(Categoria categoriaProcurar : categorias) {
        	if(categoria.getCodigo() == categoriaProcurar.getCodigo()) {
        		return categoriaProcurar;
            }
        }
        return null;
    }
	
	public ArrayList<Categoria> listar(){
		ArrayList<Categoria> categorias = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
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
	
	
	@Override
    public String toString() {
        return codigo + "," + descricao + "," + valor;
    }

    public static Categoria fromString(String linha) {
        String[] partes = linha.split(",");
        int codigo = Integer.parseInt(partes[0]);
        String descricao = partes[1];
        double valor = Double.parseDouble(partes[2]);
        return new Categoria(codigo, descricao, valor);
    }
	
    public String getFilePath() {
        return FILE_PATH;
    }
	
}
