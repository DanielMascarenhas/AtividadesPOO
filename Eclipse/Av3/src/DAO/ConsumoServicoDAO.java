package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import Atividade.ConsumoServico;

public class ConsumoServicoDAO implements DAOInterface<ConsumoServico>{

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
