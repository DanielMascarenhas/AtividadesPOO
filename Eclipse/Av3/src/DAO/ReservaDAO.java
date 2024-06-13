package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import Atividade.Reserva;

public class ReservaDAO implements DAOInterface<Reserva> {
	public boolean cadastrar(Reserva reserva) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(reserva.getFilePath(), true))) {
			writer.write(reserva.toString());
			writer.newLine();
			System.out.println("Reserva cadastrado com sucesso!");
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}catch (NumberFormatException e) {
		    System.err.println("Erro: as informações fornecidas não são válidas.");
		    return false;
		} catch (ArrayIndexOutOfBoundsException e) {
		    System.err.println("Erro: valores não suficientes para a entidade.");
		    return false;
		} catch (NoSuchElementException e) {
		    System.err.println("Erro: valores errados a entidade.");
		    return false;
		} catch (NullPointerException e) {
 		    System.err.println("Erro: Alguma das informações não estão cadastradas Coretamente.");
 		}
		return true;
	}

	public boolean editar(Reserva reserva) throws ParseException {
		DAO dao = new DAO();

		ArrayList<Reserva> reservas = dao.listar(reserva);

		for (var i = 0; i < reservas.size(); i++) {
			Reserva reservaProcurar = reservas.get(i);
			if (reserva.getCodigo() == reservaProcurar.getCodigo()) {
				reservas.set(i, reserva);
			}
		}

		File arquivo = new File(reserva.getFilePath());

		if (arquivo.exists()) {
			arquivo.delete();
        } else {
            System.out.println("Nenhuma Reserva Cadastrada.");
        }

		try {

			for (Reserva reservaCadastrar : reservas) {
				dao.cadastrar(reservaCadastrar);
			}
		} catch (NullPointerException e) {
			System.err.println("Erro: Alguma das informações não estão cadastradas Coretamente.");
		}

		return true;
	}

	public Reserva consultar(Reserva reserva) throws ParseException, NullPointerException{
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

		try {
			for (Reserva reservaProcurar : reservas) {
				if (reserva.getCodigo() == reservaProcurar.getCodigo()) {
					return reservaProcurar;
				}
			}

		} catch (NullPointerException e) {
			System.err.println("Erro: Alguma das informações não estão cadastradas Coretamente.");
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
