package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import Atividade.*;

public class DAO {

	public DAO() {

	}

	// ---------------------------CATEGORIA------------------------------------

	public boolean cadastrar(Categoria categoria) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		return categoriaDAO.cadastrar(categoria);
	}

	public boolean editar(Categoria categoria) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		return categoriaDAO.editar(categoria);

	}

	public Categoria consultar(Categoria categoria) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		return categoriaDAO.consultar(categoria);

	}

	public ArrayList<Categoria> listar(Categoria categoria) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		return categoriaDAO.listar(categoria);
	}

	// ---------------------------CATEGORIAITEM------------------------------------

	public boolean cadastrar(CategoriaItem categoriaIten) {
		CategoriaItemDAO categoriaItenDAO = new CategoriaItemDAO();
		return categoriaItenDAO.cadastrar(categoriaIten);
	}

	public boolean editar(CategoriaItem categoriaItem) {
		CategoriaItemDAO categoriaItenDAO = new CategoriaItemDAO();
		return categoriaItenDAO.editar(categoriaItem);
	}

	public CategoriaItem consultar(CategoriaItem categoriaItem) {
		CategoriaItemDAO categoriaItenDAO = new CategoriaItemDAO();
		return categoriaItenDAO.consultar(categoriaItem);
	}

	public ArrayList<CategoriaItem> listar(CategoriaItem categoriaItem) {
		CategoriaItemDAO categoriaItenDAO = new CategoriaItemDAO();
		return categoriaItenDAO.listar(categoriaItem);
	}

	// -------------ITEM-----------------------------

	public boolean cadastrar(Item item) {
		ItemDAO itenDAO = new ItemDAO();
		return itenDAO.cadastrar(item);
	}

	public boolean editar(Item item) {
		ItemDAO itenDAO = new ItemDAO();
		return itenDAO.editar(item);
	}

	public Item consultar(Item item) {
		ItemDAO itenDAO = new ItemDAO();
		return itenDAO.consultar(item);
	}

	public ArrayList<Item> listar(Item item) {
		ItemDAO itenDAO = new ItemDAO();
		return itenDAO.listar(item);
	}

	// ---------------------------FUNCIONARIO------------------------------------

	public boolean cadastrar(Funcionario funcionario) {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		return funcionarioDAO.cadastrar(funcionario);
	}

	public boolean editar(Funcionario funcionario) {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		return funcionarioDAO.editar(funcionario);
	}

	public Funcionario consultar(Funcionario funcionario) {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		return funcionarioDAO.consultar(funcionario);
	}

	public ArrayList<Funcionario> listar(Funcionario funcionario) {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		return funcionarioDAO.listar(funcionario);
	}

	// ---------------------------HOSPEDE------------------------------------

	public boolean cadastrar(Hospede hospede) {
		HospedeDAO hospedeDAO = new HospedeDAO();
		return hospedeDAO.cadastrar(hospede);
	}

	public boolean editar(Hospede hospede) {
		HospedeDAO hospedeDAO = new HospedeDAO();
		return hospedeDAO.editar(hospede);
	}

	public Hospede consultar(Hospede hospede) {
		HospedeDAO hospedeDAO = new HospedeDAO();
		return hospedeDAO.consultar(hospede);
	}

	public ArrayList<Hospede> listar(Hospede hospede) {
		HospedeDAO hospedeDAO = new HospedeDAO();
		return hospedeDAO.listar(hospede);
	}

	// ---------------------------QUARTO------------------------------------

	public boolean cadastrar(Quarto quarto) {
		QuartoDAO quartoDAO = new QuartoDAO();
		return quartoDAO.cadastrar(quarto);
	}

	public boolean editar(Quarto quarto) {
		QuartoDAO quartoDAO = new QuartoDAO();
		return quartoDAO.editar(quarto);
	}

	public Quarto consultar(Quarto quarto) {
		QuartoDAO quartoDAO = new QuartoDAO();
		return quartoDAO.consultar(quarto);
	}

	public ArrayList<Quarto> listar(Quarto quarto) {
		QuartoDAO quartoDAO = new QuartoDAO();
		return quartoDAO.listar(quarto);
	}

	// ---------------------------Serviço------------------------------------
	public boolean cadastrar(Servico servico) {
		ServicoDAO servicoDAO = new ServicoDAO();
		return servicoDAO.cadastrar(servico);
	}

	public boolean editar(Servico servico) {
		ServicoDAO servicoDAO = new ServicoDAO();
		return servicoDAO.editar(servico);
	}

	public Servico consultar(Servico servico) {
		ServicoDAO servicoDAO = new ServicoDAO();
		return servicoDAO.consultar(servico);
	}

	public ArrayList<Servico> listar(Servico servico) {
		ServicoDAO servicoDAO = new ServicoDAO();
		return servicoDAO.listar(servico);
	}

	// ---------------------------RESERVA------------------------------------
	public boolean cadastrar(Reserva reserva) {
		ReservaDAO reservaDAO = new ReservaDAO();
		return reservaDAO.cadastrar(reserva);
	}

	public boolean editar(Reserva reserva) throws ParseException {
		ReservaDAO reservaDAO = new ReservaDAO();
		return reservaDAO.editar(reserva);
	}

	public Reserva consultar(Reserva reserva) throws ParseException {
		ReservaDAO reservaDAO = new ReservaDAO();
		return reservaDAO.consultar(reserva);
	}

	public ArrayList<Reserva> listar(Reserva reserva) throws ParseException {
		ReservaDAO reservaDAO = new ReservaDAO();
		return reservaDAO.listar(reserva);
	}

	// -------------CONSUMO-----------------------------

	public boolean cadastrar(Consumo consumo) {
		ConsumoDAO consumoDAO = new ConsumoDAO();
		return consumoDAO.cadastrar(consumo);
	}

	public boolean editar(Consumo consumo) throws ParseException {
		ConsumoDAO consumoDAO = new ConsumoDAO();
		return consumoDAO.editar(consumo);
	}

	public Consumo consultar(Consumo consumo) throws ParseException {
		ConsumoDAO consumoDAO = new ConsumoDAO();
		return consumoDAO.consultar(consumo);
	}

	public ArrayList<Consumo> listar(Consumo consumo) throws ParseException {
		ConsumoDAO consumoDAO = new ConsumoDAO();
		return consumoDAO.listar(consumo);
	}

	// -------------CONSUMO SERVIÇO-----------------------------

	public boolean cadastrar(ConsumoServico consumoServico) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(consumoServico.getFilePath(), true))) {
			writer.write(consumoServico.toString());
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean editar(ConsumoServico consumoServico) throws ParseException {
		DAO dao = new DAO();
		ArrayList<ConsumoServico> consumoServicos = dao.listar(consumoServico);

		for (var i = 0; i < consumoServicos.size(); i++) {
			ConsumoServico consumoServicoProcurar = consumoServicos.get(i);
			if (consumoServico.getServico().getCodigo() == consumoServicoProcurar.getServico().getCodigo()
					&& consumoServico.getCategoria().getCodigo() == consumoServicoProcurar.getCategoria().getCodigo()
					&& consumoServico.getReserva().getCodigo() == consumoServicoProcurar.getReserva().getCodigo()) {
				consumoServicos.remove(i);
				consumoServicos.set(i, consumoServico);
			}
		}

		File arquivo = new File(consumoServico.getFilePath());

		if (arquivo.exists()) {
			if (arquivo.delete()) {
				System.out.println("O arquivo foi excluído com sucesso.");
			} else {
				System.out.println("Falha ao excluir o arquivo.");
			}
		} else {
			System.out.println("O arquivo não existe.");
		}

		for (ConsumoServico consumoServicoCadastrar : consumoServicos) {
			dao.cadastrar(consumoServicoCadastrar);
		}

		return true;
	}

	public ConsumoServico consultar(ConsumoServico consumoServico) throws ParseException {
		DAO dao = new DAO();
		ArrayList<ConsumoServico> consumoServicos = dao.listar(consumoServico);

		for (ConsumoServico consumoServicoProcurar : consumoServicos) {
			if (consumoServico.getServico().getCodigo() == consumoServicoProcurar.getServico().getCodigo()
					&& consumoServico.getCategoria().getCodigo() == consumoServicoProcurar.getCategoria().getCodigo()
					&& consumoServico.getReserva().getCodigo() == consumoServicoProcurar.getReserva().getCodigo()) {
				return consumoServicoProcurar;
			}
		}
		return null;
	}

	public ArrayList<ConsumoServico> listar(ConsumoServico consumoServico2) throws ParseException {
		ArrayList<ConsumoServico> consumoServicos = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(consumoServico2.getFilePath()))) {
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

}
