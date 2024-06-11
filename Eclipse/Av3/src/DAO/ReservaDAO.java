package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import Atividade.Reserva;

public class ReservaDAO implements DAOInterface<Reserva> {
	public boolean cadastrar(Reserva reserva) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(reserva.getFilePath(), true))) {
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
		DAO dao = new DAO();

		ArrayList<Reserva> reservas = dao.listar(reserva);

		for (var i = 0; i < reservas.size(); i++) {
			Reserva reservaProcurar = reservas.get(i);
			if (reserva.getCodigo() == reservaProcurar.getCodigo()) {
				reservas.remove(i);
				reservas.set(i, reserva);
			}
		}

		File arquivo = new File(reserva.getFilePath());

		if (arquivo.exists()) {
			if (arquivo.delete()) {
				System.out.println("O arquivo foi excluído com sucesso.");
			} else {
				System.out.println("Falha ao excluir o arquivo.");
			}
		} else {
			System.out.println("O arquivo não existe.");
		}

		for (Reserva reservaCadastrar : reservas) {
			dao.cadastrar(reservaCadastrar);
		}

		return true;
	}

	public Reserva consultar(Reserva reserva) throws ParseException {
		ArrayList<Reserva> reservas = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(reserva.getFilePath()))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				Reserva reservaProcurar = Reserva.fromString(linha);
				reservas.add(reservaProcurar);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Reserva reservaProcurar : reservas) {
			if (reserva.getCodigo() == reservaProcurar.getCodigo()) {
				return reservaProcurar;
			}
		}
		return null;
	}

	public ArrayList<Reserva> listar(Reserva reserva2) throws ParseException {
		ArrayList<Reserva> reservas = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(reserva2.getFilePath()))) {
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
}