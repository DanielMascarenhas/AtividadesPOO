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

import Atividade.Consumo;

public class ConsumoDAO implements DAOInterface<Consumo> {
	public boolean cadastrar(Consumo consumo) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(consumo.getFilePath(), true))) {
			writer.write(consumo.toString());
			writer.newLine();
			System.out.println("Informação cadastrada com sucesso!");
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

	public boolean editar(Consumo consumo) throws ParseException {
		DAO dao = new DAO();
		ArrayList<Consumo> consumos = dao.listar(consumo);

		for (var i = 0; i < consumos.size(); i++) {
			Consumo consumoProcurar = consumos.get(i);
			if (consumo.getItem().getCodigo() == consumoProcurar.getItem().getCodigo()
					&& consumo.getCategoria().getCodigo() == consumoProcurar.getCategoria().getCodigo()) {
				consumos.set(i, consumo);
			}
		}

		File arquivo = new File(consumo.getFilePath());

		if (arquivo.exists()) {
			arquivo.delete();
        } else {
            System.out.println("Nenhum Consumo Cadastrado.");
        }

		for (Consumo consumoCadastrar : consumos) {
			dao.cadastrar(consumoCadastrar);
		}

		return true;
	}

	public Consumo consultar(Consumo consumo) throws ParseException {
		DAO dao = new DAO();
		ArrayList<Consumo> consumos = dao.listar(consumo);

		for (Consumo consumoProcurar : consumos) {
			if (consumoProcurar.getItem().getCodigo() == consumoProcurar.getItem().getCodigo()
					&& consumoProcurar.getCategoria().getCodigo() == consumoProcurar.getCategoria().getCodigo()) {
				return consumoProcurar;
			}
		}
		return null;
	}

	public ArrayList<Consumo> listar(Consumo consumo2) throws ParseException {
		ArrayList<Consumo> consumos = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(consumo2.getFilePath()))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				Consumo consumo = Consumo.fromString(linha);
				consumos.add(consumo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return consumos;
	}
}
