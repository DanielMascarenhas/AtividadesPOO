package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

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
		}catch (NumberFormatException e) {
		    System.err.println("Erro: as informações fornecidas não são válidas.");
		    return false;
		} catch (ArrayIndexOutOfBoundsException e) {
		    System.err.println("Erro: valores não suficientes para a entidade.");
		    return false;
		} catch (NoSuchElementException e) {
		    System.err.println("Erro: valores errados a entidade.");
		    return false;
		} 
		return true;
	}

	public boolean editar(Hospede hospede) {
		DAO dao = new DAO();
		ArrayList<Hospede> hospedes = dao.listar(hospede);

		for (var i = 0; i < hospedes.size(); i++) {
			Hospede hospedeProcurar = hospedes.get(i);
			if (hospede.getCpf().equals(hospedeProcurar.getCpf()) ) {
				hospedes.set(i, hospede);
			}
		}

		File arquivo = new File(hospede.getFilePath());

		if (arquivo.exists()) {
			arquivo.delete();
        } else {
            System.out.println("Nenhum Hospede Cadastrado.");
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
			if (hospede.getCpf().equals(hospedeProcurar.getCpf())) {
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
