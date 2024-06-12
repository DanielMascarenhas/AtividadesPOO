package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import Atividade.Quarto;

public class QuartoDAO {
	public boolean cadastrar(Quarto quarto) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(quarto.getFilePath(), true))) {
			writer.write(quarto.toString());
			writer.newLine();
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

	public boolean editar(Quarto quarto) {
		DAO dao = new DAO();
		ArrayList<Quarto> quartos = dao.listar(quarto);

		for (var i = 0; i < quartos.size(); i++) {
			Quarto quartoProcurar = quartos.get(i);
			if (quarto.getCodigo() == quartoProcurar.getCodigo()) {
				quartos.set(i, quarto);
			}
		}

		File arquivo = new File(quarto.getFilePath());

		if (arquivo.exists()) {
			arquivo.delete();
        } else {
            System.out.println("Nenhum Quarto Cadastrado.");
        }

		for (Quarto quartoCadastrar : quartos) {
			dao.cadastrar(quartoCadastrar);
		}

		return true;
	}

	public Quarto consultar(Quarto quarto) {
		DAO dao = new DAO();
		ArrayList<Quarto> quartos = dao.listar(quarto);

		for (Quarto quartoProcurar : quartos) {
			if (quarto.getCodigo() == quartoProcurar.getCodigo()) {
				return quartoProcurar;
			}
		}
		return null;
	}

	public ArrayList<Quarto> listar(Quarto quarto2) {
		ArrayList<Quarto> quartos = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(quarto2.getFilePath()))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				Quarto quarto = Quarto.fromString(linha);
				quartos.add(quarto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return quartos;
	}
}
