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

public class Reserva {

	private int codigo;
	private Hospede hospede;
	private Quarto quarto;
	private Funcionario funcionarioReserva;
	private Funcionario funcionarioFechamento;
	private Date dataEntradaReserva;
	private Date dataSaidaReserva;
	private Date dataCheckin;
	private Date dataCheckout;
	double valorReserva;
	double valorPago;	
	
	private static final String FILE_PATH = "Reservas.txt";
	
	public Reserva(int codigo, Hospede hospede, Quarto quarto, Funcionario funcionarioReserva,
			Funcionario funcionarioFechamento, Date dataEntradaReserva, Date dataSaidaReserva, Date dataCheckin,
			Date dataCheckout, double valorReserva, double valorPago) {
		super();
		this.codigo = codigo;
		this.hospede = hospede;
		this.quarto = quarto;
		this.funcionarioReserva = funcionarioReserva;
		this.funcionarioFechamento = funcionarioFechamento;
		this.dataEntradaReserva = dataEntradaReserva;
		this.dataSaidaReserva = dataSaidaReserva;
		this.dataCheckin = dataCheckin;
		this.dataCheckout = dataCheckout;
		this.valorReserva = valorReserva;
		this.valorPago = valorPago;
	}
	
	
	
	public Reserva() {
		this.codigo = 0;
		this.hospede = new Hospede();
		this.quarto = new Quarto();
		this.funcionarioReserva = new Funcionario();
		this.funcionarioFechamento = new Funcionario();
		this.dataEntradaReserva = new Date();
		this.dataSaidaReserva = new Date();
		this.dataCheckin = new Date();
		this.dataCheckout = new Date();
		this.valorReserva = 0.0;
		this.valorPago = 0.0;
	}



	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Hospede getHospede() {
		return hospede;
	}
	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	public Funcionario getFuncionarioReserva() {
		return funcionarioReserva;
	}
	public void setFuncionarioReserva(Funcionario funcionarioReserva) {
		this.funcionarioReserva = funcionarioReserva;
	}
	public Funcionario getFuncionarioFechamento() {
		return funcionarioFechamento;
	}
	public void setFuncionarioFechamento(Funcionario funcionarioFechamento) {
		this.funcionarioFechamento = funcionarioFechamento;
	}
	public Date getDataEntradaReserva() {
		return dataEntradaReserva;
	}
	public void setDataEntradaReserva(Date dataEntradaReserva) {
		this.dataEntradaReserva = dataEntradaReserva;
	}
	public Date getDataSaidaReserva() {
		return dataSaidaReserva;
	}
	public void setDataSaidaReserva(Date dataSaidaReserva) {
		this.dataSaidaReserva = dataSaidaReserva;
	}
	public Date getDataCheckin() {
		return dataCheckin;
	}
	public void setDataCheckin(Date dataCheckin) {
		this.dataCheckin = dataCheckin;
	}
	public Date getDataCheckout() {
		return dataCheckout;
	}
	public void setDataCheckout(Date dataCheckout) {
		this.dataCheckout = dataCheckout;
	}
	public double getValorReserva() {
		return valorReserva;
	}
	public void setValorReserva(double valorReserva) {
		this.valorReserva = valorReserva;
	}
	public double getValorPago() {
		return valorPago;
	}
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	
	public boolean cadastrar(Reserva reserva) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(reserva.toString());
            writer.newLine();
            System.out.println("Funcionario cadastrado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
	}
	
	public boolean editar(Reserva reserva) throws ParseException {
		ArrayList<Reserva> reservas = reserva.listar();
    	
    	for(var i = 0; i < reservas.size(); i++) {
    		Reserva reservaProcurar = reservas.get(i);
        	if(reserva.getCodigo() == reservaProcurar.getCodigo()) {
        		reservas.remove(i);
        		reservas.set(i, reserva); 
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
    	 
    	 
    	 for(Reserva reservaCadastrar : reservas) {
    		 reserva.cadastrar(reservaCadastrar);
         }
		
		return true;
	}
	
	public Reserva consultar(Reserva reserva) throws ParseException {
		ArrayList<Reserva> reservas = new ArrayList<>();

	    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
	        String linha;
	        while ((linha = reader.readLine()) != null) {
	        	Reserva reservaProcurar = Reserva.fromString(linha);
	        	reservas.add(reservaProcurar);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    for (Reserva reservaProcurar : reservas) {
	        if (reserva.getCodigo() == reservaProcurar.getCodigo() ) {
	            return reservaProcurar;
	        }
	    }
	    return null;
	}
	
	public ArrayList<Reserva> listar() throws ParseException{
		ArrayList<Reserva> reservas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
            	Reserva reserva = Reserva.fromString(linha);
            	reservas.add(reserva);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return reservas;
	}
	
	
	@Override
    public String toString() {
        return getCodigo() + "," + getHospede().getCpf() + "," + getQuarto().getCodigo()
        		+ "," + getFuncionarioReserva().getCpf() + "," + getFuncionarioFechamento().getCpf()
        		+ "," + dataToString(dataEntradaReserva) + "," + dataToString(dataSaidaReserva)  
        		+ "," + dataToString(dataCheckin) + "," + dataToString(dataCheckout)
        		+ "," + getValorReserva() + "," + getValorPago();
    }
	
	
    public static Reserva fromString(String linha) throws ParseException {
    	
        String[] partes = linha.split(",");
        int codigo = Integer.parseInt(partes[0]);
        String hospede = partes[1];
        int quarto = Integer.parseInt(partes[2]);
        String funcionarioReserva = partes[3];
        String funcionarioFechamento = partes[4];
        String dataEntradaReserva = partes[5];
        String dataSaidaReserva = partes[6];
        String dataCheckin = partes[7];
        String dataCheckout = partes[8];
        double valorReserva = Double.parseDouble(partes[9]);
        double valorPago = Double.parseDouble(partes[10]);
        
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date data1 = formatter.parse(dataEntradaReserva);
        Date data2 = formatter.parse(dataSaidaReserva);
        Date data3 = formatter.parse(dataCheckin);
        Date data4 = formatter.parse(dataCheckout);
        
        
        Hospede hospedePegar = new Hospede(hospede, "", "", ""); 
        
        Categoria categoriaParaQuarto = new Categoria( 0, "", 0.0);
        Quarto quartoPegar = new Quarto(quarto, categoriaParaQuarto, "");
        
        Funcionario funcionarioReservaPegar = new Funcionario(funcionarioReserva, "", "", "");
        Funcionario funcionarioFechamentoPegar = new Funcionario(funcionarioFechamento, "", "", "");

        return new Reserva(codigo, hospedePegar, quartoPegar, funcionarioReservaPegar, funcionarioFechamentoPegar,
        		data1, data2, data3, data4, valorReserva, valorPago);
  
    }
    
    public String dataToString(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(data);
    }
	
}
