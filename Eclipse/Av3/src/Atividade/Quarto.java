package Atividade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
	
	public Quarto() {
		this.codigo = 0;
		this.categoria = new Categoria();
		this.status = "";

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
		
		ArrayList<Quarto> quartos = quarto.listar();
    	
	    	for(var i = 0; i < quartos.size(); i++) {
	    		Quarto quartoProcurar = quartos.get(i);
	        	if(quarto.getCodigo() == quartoProcurar.getCodigo()){
	        		quartos.remove(i);
	        		quartos.set(i, quarto); 
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
	    	 
	    	 
	    	 for(Quarto quartoCadastrar : quartos) {
	    		 quarto.cadastrar(quartoCadastrar);
	         }
			
		return true;
	}
	public Quarto consultar(Quarto quarto) {
		ArrayList<Quarto> quartos = quarto.listar();
		
	    for(Quarto quartoProcurar : quartos) {
	    	if(quarto.getCodigo() == quartoProcurar.getCodigo() ) {
	    		return quartoProcurar;
	            }
	        }
	        return null;
	}
	
	public ArrayList<Quarto> listar(){
		ArrayList<Quarto> quartos = new ArrayList<>();
		
	    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
	        String linha;
	        while ((linha = reader.readLine()) != null) {
	        	Quarto quarto = Quarto.fromString(linha);
	        	quartos.add(quarto);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	    return quartos;
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
