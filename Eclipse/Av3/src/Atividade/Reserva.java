package Atividade;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import DAO.DAO;

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
        
        DAO dao = new DAO();

        return new Reserva(codigo, dao.consultar(hospedePegar), dao.consultar(quartoPegar), dao.consultar(funcionarioReservaPegar), dao.consultar(funcionarioFechamentoPegar),
        		data1, data2, data3, data4, valorReserva, valorPago);
  
    }
    
    public String dataToString(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(data);
    }
    
    public String getFilePath() {
        return FILE_PATH;
    }
	
}
