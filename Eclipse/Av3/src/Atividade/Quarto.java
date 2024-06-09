package Atividade;


import DAO.*;

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

        DAO dao = new DAO();
        return new Quarto(codigo, dao.consultar(categoriaPegar), status);
  
    }
    
    public String getFilePath() {
        return FILE_PATH;
    }
	
	
}
