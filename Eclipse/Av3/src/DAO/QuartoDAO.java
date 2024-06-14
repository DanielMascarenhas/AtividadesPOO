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
import java.util.Scanner;

import Atividade.CategoriaItem;
import Atividade.Quarto;
import Atividade.Reserva;

public class QuartoDAO {
	public boolean cadastrar(Quarto quarto) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(quarto.getFilePath(), true))) {
			writer.write(quarto.toString());
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (NumberFormatException e) {
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

		try {

			for (Quarto quartoCadastrar : quartos) {
				dao.cadastrar(quartoCadastrar);
			}
		} catch (NullPointerException e) {
			System.err.println("Erro: Alguma das informações não estão cadastradas Coretamente.");
		}


		return true;
	}

	public Quarto consultar(Quarto quarto) {
		DAO dao = new DAO();
		ArrayList<Quarto> quartos = dao.listar(quarto);

		
		try {
			for (Quarto quartoProcurar : quartos) {
				if (quarto.getCodigo() == quartoProcurar.getCodigo()) {
					return quartoProcurar;
				}
			}

		} catch (NullPointerException e) {
			System.err.println("Erro: Alguma das informações não estão cadastradas Coretamente.");
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
	
	public void pagar(int numero) throws ParseException {
		DAO dao = new DAO();
		Quarto quarto = new Quarto();
		quarto.setCodigo(numero);
		if(dao.consultar(quarto).equals(null)) {
			System.out.println("Erro: Quarto Não Cadastrado.");
		}else {
			
			dao.editar(quarto);
			Reserva reserva = new Reserva();
			
			try{
				reserva = dao.consultar(reserva);		
				if(quarto.getStatus() == "Livre") {
					System.out.println("Quarto ja livre");
					return;
				}
				double valor = reserva.getValorReserva() - reserva.getValorPago();
				System.out.println("Pagar R$" + valor + ".");
				Scanner scanner = new Scanner(System.in);
				System.out.println("valor a pago: ");
				valor = scanner.nextDouble();
				valor = reserva.getValorPago() + valor;
				 reserva.setValorPago(valor);
				if(reserva.getValorReserva() == reserva.getValorPago()) {
					quarto.setStatus("Livre");
				}
				

			} catch(NullPointerException e) {
				System.err.println("Sem Reserva para este quarto.");
			
			}
				
			
			
		}
	
	}
}
