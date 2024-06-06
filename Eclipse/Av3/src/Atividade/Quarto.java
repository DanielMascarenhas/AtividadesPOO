package Atividade;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Quarto {
	
	private int codigo;
	private Categoria categoria;
	private String status;
	
	public static final String FILE_PATH = "Quartos.txt";
	
	public Quarto(int codigo, Categoria categoria, String status) {
		this.codigo = codigo;
		this.categoria = categoria;
		this.status = status;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean cadastrar(Quarto quarto) {
			
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
	        writer.write(quarto.toString());
	        writer.newLine();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	    return true;
    }
	
	public boolean editar(Quarto quarto) {
		
		return true;
	}
	public Quarto consultar(Quarto quarto) {
		return quarto;
	}
	
	public ArrayList<Quarto> listar(){
		List<Quarto> quartos = new ArrayList<>();
		return null;
	}
	
	@Override
    public String toString() {
        return getCodigo() + "," + getCategoria().getCodigo() + "," + getStatus();
    }


    public static Quarto fromString(String linha) {
    	
        String[] partes = linha.split(",");
        int codigo = Integer.parseInt(partes[0]);
        int categoria = Integer.parseInt(partes[1]);
        String status = partes[2];
               
        Categoria categoriaPegar = new Categoria(categoria, "", 0.0);

        return new Quarto(codigo, categoriaPegar.consultar(categoriaPegar), status);
  
    }
	
	
}
