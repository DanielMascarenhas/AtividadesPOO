package Atividade;


public class Servico {
	
	private int codigo;
	private String descricao;
	private double valor;
	
	public static final String FILE_PATH = "Servicos.txt";
	
	public Servico(int codigo, String descricao, double valor) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	
	
	public Servico() {
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

    public static Servico fromString(String linha) {
        String[] partes = linha.split(",");
        int codigo = Integer.parseInt(partes[0]);
        String descricao = partes[1];
        double valor = Double.parseDouble(partes[2]);
        return new Servico(codigo, descricao, valor);
    }
    
    public String getFilePath() {
        return FILE_PATH;
    }
	
	
}
