package Atividade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ConsumoServico {
	private Servico servico;
	private Categoria categoria;
	private Reserva reserva;
	private int quantidadeSolicitada;
	private Date dataServico;
	
	private static final String FILE_PATH = "ConsumoServicos.txt";
	
	public ConsumoServico(Servico servico, Categoria categoria, Reserva reserva, int quantidadeSolicitada,
			Date dataServico) {
		super();
		this.servico = servico;
		this.categoria = categoria;
		this.reserva = reserva;
		this.quantidadeSolicitada = quantidadeSolicitada;
		this.dataServico = dataServico;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	public int getQuantidadeSolicitada() {
		return quantidadeSolicitada;
	}
	public void setQuantidadeSolicitada(int quantidadeSolicitada) {
		this.quantidadeSolicitada = quantidadeSolicitada;
	}
	public Date getDataServico() {
		return dataServico;
	}
	public void setDataServico(Date dataServico) {
		this.dataServico = dataServico;
	}
	
	public boolean cadastrar(ConsumoServico consumoServico) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(consumoServico.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
	}
	
	public boolean editar(ConsumoServico consumoServico) throws ParseException {
		ArrayList<ConsumoServico> consumoServicos = consumoServico.listar();
    	
    	for(var i = 0; i < consumoServicos.size(); i++) {
    		ConsumoServico consumoServicoProcurar = consumoServicos.get(i);
    		if(consumoServico.servico.getCodigo() == consumoServicoProcurar.servico.getCodigo() && 
	    			consumoServico.categoria.getCodigo() == consumoServicoProcurar.categoria.getCodigo() && 
	    					consumoServico.reserva.getCodigo() == consumoServicoProcurar.reserva.getCodigo() ){
    			consumoServicos.remove(i);
    			consumoServicos.set(i, consumoServico); 
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
    	 
    	 
    	 for(ConsumoServico consumoServicoCadastrar : consumoServicos) {
    		 consumoServico.cadastrar(consumoServicoCadastrar);
         }
		
		return true;
	}
	
	
	public ConsumoServico consultar(ConsumoServico consumoServico) throws ParseException {
		ArrayList<ConsumoServico> consumoServicos = consumoServico.listar();
		
	    for(ConsumoServico consumoServicoProcurar : consumoServicos) {
	    	if(consumoServico.servico.getCodigo() == consumoServicoProcurar.servico.getCodigo() && 
	    			consumoServico.categoria.getCodigo() == consumoServicoProcurar.categoria.getCodigo() && 
	    					consumoServico.reserva.getCodigo() == consumoServicoProcurar.reserva.getCodigo() )
	    	{
	    		return consumoServicoProcurar;
	            }
	        }
	        return null;
	}
	
	public ArrayList<ConsumoServico> listar() throws ParseException{
		ArrayList<ConsumoServico> consumoServicos = new ArrayList<>();
		
	    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
	        String linha;
	        while ((linha = reader.readLine()) != null) {
	        	ConsumoServico consumoServico = ConsumoServico.fromString(linha);
	        	consumoServicos.add(consumoServico);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	    return consumoServicos;
	}
	

	
	@Override
    public String toString() {
        return getServico().getCodigo() + "," + getCategoria().getCodigo() + "," + getReserva().getCodigo() + "," + getQuantidadeSolicitada() + "," + dataToString(getDataServico());
    }

    public static ConsumoServico fromString(String linha) throws ParseException {
    	
        String[] partes = linha.split(",");
        int servico = Integer.parseInt(partes[0]);
        int categoria = Integer.parseInt(partes[1]);
        int reserva = Integer.parseInt(partes[2]);
        int quantidadeSolicitada = Integer.parseInt(partes[3]);
        String dataServico = partes[4];
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formatter.parse(dataServico);
        
        Servico servicoPegar = new Servico(servico, "", 0.0);        
        Categoria categoriaPegar = new Categoria(categoria, "", 0.0);
        Reserva reservaPegar = new Reserva(reserva, new Hospede(), new Quarto(), new Funcionario(), new Funcionario(), data, data, data, data, 0.0, 0.0 );

        
        
        return new ConsumoServico(servicoPegar, categoriaPegar, reservaPegar,
        		quantidadeSolicitada, data);
  
    }
	
    public String dataToString(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(data);
    }
	
}
