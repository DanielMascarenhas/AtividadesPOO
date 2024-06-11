package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Atividade.Hospede;

public class HospedeDAO implements DAOInterface<Hospede>{

	public boolean cadastrar(Hospede hospede) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(hospede.getFilePath(), true))) {
			writer.write(hospede.toString());
			writer.newLine();
			System.out.println("Hospede cadastrado com sucesso!");
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean editar(Hospede hospede) {
		DAO dao = new DAO();
		ArrayList<Hospede> hospedes = dao.listar(hospede);

		for (var i = 0; i < hospedes.size(); i++) {
			Hospede funcionarioProcurar = hospedes.get(i);
			if (hospede.getCpf() == funcionarioProcurar.getCpf()) {
				hospedes.remove(i);
				hospedes.set(i, hospede);
			}
		}

		File arquivo = new File(hospede.getFilePath());

		if (arquivo.exists()) {
			if (arquivo.delete()) {
				System.out.println("O arquivo foi excluído com sucesso.");
			} else {
				System.out.println("Falha ao excluir o arquivo.");
			}
		} else {
			System.out.println("O arquivo não existe.");
		}

		for (Hospede hospedeCadastrar : hospedes) {
			dao.cadastrar(hospedeCadastrar);
		}

		return true;
	}

	public Hospede consultar(Hospede hospede) {
		ArrayList<Hospede> hospedes = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(hospede.getFilePath()))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				Hospede hospedeProcurar = Hospede.fromString(linha);
				hospedes.add(hospedeProcurar);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Hospede hospedeProcurar : hospedes) {
			if (hospede.getCpf().equals(hospedeProcurar.getCpf())
					|| hospede.getNome().equals(hospedeProcurar.getNome())) {
				return hospedeProcurar;
			}
		}
		return null;
	}

	public ArrayList<Hospede> listar(Hospede hospede2) {
		ArrayList<Hospede> hospedes = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(hospede2.getFilePath()))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				Hospede hospede = Hospede.fromString(linha);
				hospedes.add(hospede);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return hospedes;
	}
	
}
