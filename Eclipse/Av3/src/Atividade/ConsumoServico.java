package Atividade;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import DAO.DAO;

public class ConsumoServico {
	private Servico servico;
	private Categoria categoria;
	private Reserva reserva;
	private int quantidadeSolicitada;
	private Date dataServico;

	private static final String FILE_PATH = "ConsumoServicos.txt";

	public ConsumoServico(Servico servico, Categoria categoria, Reserva reserva, int quantidadeSolicitada,
			Date dataServico) {
		this.servico = servico;
		this.categoria = categoria;
		this.reserva = reserva;
		this.quantidadeSolicitada = quantidadeSolicitada;
		this.dataServico = dataServico;
	}

	public ConsumoServico() {
		this.servico = new Servico();
		this.categoria = new Categoria();
		this.reserva = new Reserva();
		this.quantidadeSolicitada = 0;
		this.dataServico = new Date();
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

	@Override
	public String toString() {
		return getServico().getCodigo() + "," + getCategoria().getCodigo() + "," + getReserva().getCodigo() + ","
				+ getQuantidadeSolicitada() + "," + dataToString(getDataServico());
	}

	public static ConsumoServico fromString(String linha) throws ParseException, FileNotFoundException {

		try {
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
			Reserva reservaPegar = new Reserva(reserva, new Hospede(), new Quarto(), new Funcionario(),
					new Funcionario(), data, data, data, data, 0.0);

			DAO dao = new DAO();

			return new ConsumoServico(dao.consultar(servicoPegar), dao.consultar(categoriaPegar),
					dao.consultar(reservaPegar), quantidadeSolicitada, data);

		} catch (NumberFormatException e) {
			System.err.println("Erro: as informações fornecidas não são válidas.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Erro: valores não suficientes para a entidade.");
		} catch (NoSuchElementException e) {
			System.err.println("Erro: valores errados a entidade.");
		} catch (NullPointerException e) {
 		    System.err.println("Erro: Alguma das informações não estão cadastradas Coretamente.");
 		}
		return null;
	}

	public String dataToString(Date data) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(data);
	}

	public String getFilePath() {
		return FILE_PATH;
	}

}
