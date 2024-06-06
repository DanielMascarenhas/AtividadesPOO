package Atividade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
	
	public boolean cadastrar(Servico servico) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(servico.toString());
            writer.newLine();
            System.out.println("Serviço cadastrada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
	}
	
	public boolean editar(Servico S) {
		return true;
	}
	
	public Servico consultar(Servico servico) {
		ArrayList<Servico> servicos = servico.listar();

        
        for(Servico servicoProcurar : servicos) {
        	if(servico.getCodigo() == servicoProcurar.getCodigo()) {
        		return servicoProcurar;
            }
        }
        return null;
	}
	
	public ArrayList<Servico> listar(){
		ArrayList<Servico> servicos = new ArrayList<>();
				
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
            	Servico servico = Servico.fromString(linha);
                servicos.add(servico);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return servicos;
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
	
	
}
