package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import Atividade.Servico;

public class ServicoDAO implements DAOInterface<Servico> {
	public boolean cadastrar(Servico servico) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(servico.getFilePath(), true))) {
			writer.write(servico.toString());
			writer.newLine();
			System.out.println("Serviço cadastrada com sucesso!");
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

	public boolean editar(Servico servico) {
		DAO dao = new DAO();
		ArrayList<Servico> servicos = dao.listar(servico);

		for (var i = 0; i < servicos.size(); i++) {
			Servico itemProcurar = servicos.get(i);
			if (servico.getCodigo() == itemProcurar.getCodigo()) {
				servicos.set(i, servico);
			}
		}

		File arquivo = new File(servico.getFilePath());

		if (arquivo.exists()) {
			arquivo.delete();
        } else {
            System.out.println("Nenhum Serviço Cadastrado.");
        }

		for (Servico servicoCadastrar : servicos) {
			dao.cadastrar(servicoCadastrar);
		}

		return true;
	}

	public Servico consultar(Servico servico) {
		DAO dao = new DAO();
		ArrayList<Servico> servicos = dao.listar(servico);

		for (Servico servicoProcurar : servicos) {
			if (servico.getCodigo() == servicoProcurar.getCodigo()) {
				return servicoProcurar;
			}
		}
		return null;
	}

	public ArrayList<Servico> listar(Servico servico2) {
		ArrayList<Servico> servicos = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(servico2.getFilePath()))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				Servico servico = Servico.fromString(linha);
				servicos.add(servico);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return servicos;
	}
}
