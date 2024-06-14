package View;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Atividade.*;
import DAO.DAO;

public class Interface {
	
		public Interface() {
				
		}

		public void chamarInterface() throws ParseException, FileNotFoundException {
		    Scanner scanner = new Scanner(System.in);
		    DAO dao = new DAO();
		    
		    System.out.println("Digite uma acão seguida de uma entidade (por exemplo, 'Cadastrar Hospede'):");
		    
		    String input = scanner.nextLine();
		        // Faca algo com o input


		    
		    
		    String[] parts = input.split(" ", 2);

	        if (parts.length < 2) {
	            System.out.println("Entrada inválida. Por favor, forneca uma acão e uma entidade.");
	            return;
	        }

	        String action = parts[0].toLowerCase();
	        String entity = parts[1].toLowerCase(); 
	        
	        if (action.equals("cadastrar")) {
	            if (entity.equals("categoria")) {
	                System.out.println("Cadastrando Categoria...");
	                System.out.print("Digite o nome da categoria: ");
	                String inputData = scanner.nextLine();
	                Categoria categoria = Categoria.fromString(inputData);
	                File arquivo = null;
	                try{
	                	arquivo = new File(categoria.getFilePath());
	                }
	                catch (NullPointerException e) {
	        			return;
	        		}

	                if (arquivo.exists()) {
	                	if (dao.consultar(categoria) == null) {
	                		
		                   dao.cadastrar(categoria);
		                     
		                } else {
		                    System.out.println("Categoria já cadastrada.");
		                }
	                } else {
	                	dao.cadastrar(categoria);
	                }
	            } else if (entity.equals("categoriaitem")) {
	                System.out.println("Cadastrando CategoriaItem...");
	                System.out.print("Digite o nome da categoriaItem: ");
	                String inputData = scanner.nextLine();
	                CategoriaItem categoriaItem = CategoriaItem.fromString(inputData);
	                File arquivo = null;
	                try{
	                	arquivo = new File(categoriaItem.getFilePath());
	                }
	                catch (NullPointerException e) {
	        			return;
	        		}

	                if (arquivo.exists()) {
	                	if (dao.consultar(categoriaItem) == null) {
		                    dao.cadastrar(categoriaItem);
		                } else {
		                    System.out.println("CategoriaItem já cadastrada.");
		                }
	                } else {
	                	dao.cadastrar(categoriaItem);
	                }
	            } else if (entity.equals("consumo")) {
	                System.out.println("Cadastrando Consumo...");
	                System.out.print("Digite a descricão do consumo: ");
	                String inputData = scanner.nextLine();
	                Consumo consumo = Consumo.fromString(inputData);
	                File arquivo = null;
	                try{
	                	arquivo = new File(consumo.getFilePath());
	                }
	                catch (NullPointerException e) {
	        			return;
	        		}

	                if (arquivo.exists()) {
	                	if (dao.consultar(consumo) == null) {
		                    dao.cadastrar(consumo);
		                } else {
		                    System.out.println("Consumo já cadastrado.");
		                }
	                } else {
	                	dao.cadastrar(consumo);
	                }
	            } else if (entity.equals("consumoservico")) {
	                System.out.println("Cadastrando Consumoservico...");
	                System.out.print("Digite a descricão do Consumoservico: ");
	                String inputData = scanner.nextLine();
	                ConsumoServico consumoServico = ConsumoServico.fromString(inputData);
	                File arquivo = null;
	                try{
	                	arquivo = new File(consumoServico.getFilePath());
	                }
	                catch (NullPointerException e) {
	        			return;
	        		}

	                if (arquivo.exists()) {
	                	if (dao.consultar(consumoServico) == null) {
		                    dao.cadastrar(consumoServico);
		                } else {
		                    System.out.println("ConsumoServico já cadastrado.");
		                }
	                } else {
	                	dao.cadastrar(consumoServico);
	                }
	            } else if (entity.equals("funcionario")) {
	                System.out.println("Cadastrando Funcionário...");
	                System.out.print("Digite o nome do funcionário: ");
	                String inputData = scanner.nextLine();
	                Funcionario funcionario = Funcionario.fromString(inputData);
	                File arquivo = null;
	                try{
	                	arquivo = new File(funcionario.getFilePath());
	                }
	                catch (NullPointerException e) {
	        			return;
	        		}

	                if (arquivo.exists()) {
	                	if (dao.consultar(funcionario) == null) {
		                    dao.cadastrar(funcionario);
		                } else {
		                    System.out.println("Funcionario já cadastrado.");
		                }
	                } else {
	                	dao.cadastrar(funcionario);
	                }
	            } else if (entity.equals("hospede")) {
	                System.out.println("Cadastrando Hóspede...");
	                System.out.print("Digite o nome do hóspede: ");
	                String inputData = scanner.nextLine();
	                Hospede hospede = Hospede.fromString(inputData);
	                File arquivo = null;
	                try{
	                	arquivo = new File(hospede.getFilePath());
	                }
	                catch (NullPointerException e) {
	        			return;
	        		}

	                if (arquivo.exists()) {
	                	if (dao.consultar(hospede) == null) {
		                    dao.cadastrar(hospede);
		                } else {
		                    System.out.println("Hospede já cadastrado.");
		                }
	                } else {
	                	dao.cadastrar(hospede);
	                }
	            } else if (entity.equals("item")) {
	                System.out.println("Cadastrando Item...");
	                System.out.print("Digite a descricão do item: ");
	                String inputData = scanner.nextLine();
	                Item item = Item.fromString(inputData);
	                File arquivo = null;
	                try{
	                	arquivo = new File(item.getFilePath());
	                }
	                catch (NullPointerException e) {
	        			return;
	        		}
	                

	                if (arquivo.exists()) {
	                	if (dao.consultar(item) == null) {
		                    dao.cadastrar(item);
		                } else {
		                    System.out.println("Item já cadastrado.");
		                }
	                } else {
	                	dao.cadastrar(item);
	                }
	            } else if (entity.equals("quarto")) {
	                System.out.println("Cadastrando Quarto...");
	                System.out.print("Digite o número do quarto: ");
	                String inputData = scanner.nextLine();
	                Quarto quarto = Quarto.fromString(inputData);
	                File arquivo = null;
	                try{
	                	arquivo = new File(quarto.getFilePath());
	                }
	                catch (NullPointerException e) {
	        			return;
	        		}

	                if (arquivo.exists()) {
	                	if (dao.consultar(quarto) == null) {
		                    dao.cadastrar(quarto);
		                } else {
		                    System.out.println("Quarto já cadastrado.");
		                }
	                } else {
	                	dao.cadastrar(quarto);
	                }
	            } else if (entity.equals("reserva")) {
	                System.out.println("Cadastrando Reserva...");
	                System.out.print("Digite a descricão da reserva: ");
	                String inputData = scanner.nextLine();
	                Reserva reserva = Reserva.fromString(inputData);
	                File arquivo = null;
	                try{
	                	arquivo = new File(reserva.getFilePath());
	                }
	                catch (NullPointerException e) {
	        			return;
	        		}

	                if (arquivo.exists()) {
	                	if (dao.consultar(reserva) == null) {
		                    dao.cadastrar(reserva);
		                } else {
		                    System.out.println("Reserva já cadastrada.");
		                }
	                } else {
	                	dao.cadastrar(reserva);
	                }
	            } else if (entity.equals("servico")) {
	                System.out.println("Cadastrando Servico...");
	                System.out.print("Digite a descricão do Servico: ");
	                String inputData = scanner.nextLine();
	                Servico servico = Servico.fromString(inputData);
	                File arquivo = null;
	                try{
	                	arquivo = new File(servico.getFilePath());
	                }
	                catch (NullPointerException e) {
	        			return;
	        		}

	                if (arquivo.exists()) {
	                	if (dao.consultar(servico) == null) {
		                    dao.cadastrar(servico);
		                } else {
		                    System.out.println("Servico já cadastrado.");
		                }
	                } else {
	                	dao.cadastrar(servico);
	                }
	            } else {
	                System.out.println("Entidade desconhecida: " + parts[1]);
	            }
	        } else if (action.equals("consultar")) {
	            if (entity.equals("categoria")) {
	                System.out.println("Consultando Categoria...");
	                System.out.print("Digite o nome da categoria para consultar: ");
	                String inputData = scanner.nextLine();
	                Categoria categoria = Categoria.fromString(inputData);
	                File arquivo = new File(categoria.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(categoria) == null){
	                		System.out.println("Categoria Não Cadastrada.");
	                		return;
	                	}
	                	System.out.println(dao.consultar(categoria));
	                } else {
	                	System.out.println("Nenhuma Categoria Cadastrada.");
	                }
	                
	            } else if (entity.equals("categoriaitem")) {
	                System.out.println("Consultando CategoriaItem...");
	                System.out.print("Digite o nome da categoriaItem para consultar: ");
	                String inputData = scanner.nextLine();
	                CategoriaItem categoriaItem = CategoriaItem.fromString(inputData);
	                
	                File arquivo = new File(categoriaItem.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(categoriaItem) == null){
	                		System.out.println("CategoriaItem Não Cadastrada.");
	                		return;
	                	}
	                	System.out.println(dao.consultar(categoriaItem));
	                } else {
	                	System.out.println("Nenhuma CategoriaItem Cadastrada.");
	                }
	                
	            } else if (entity.equals("consumo")) {
	                System.out.println("Consultando Consumo...");
	                System.out.print("Digite a descricão do consumo para consultar: ");
	                String inputData = scanner.nextLine();
	                Consumo consumo = Consumo.fromString(inputData);
	                File arquivo = new File(consumo.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(consumo) == null){
	                		System.out.println("consumo Não Cadastrado.");
	                		return;
	                	}
	                	System.out.println(dao.consultar(consumo));
	                } else {
	                	System.out.println("Nenhum Consumo Cadastrado.");
	                }
	            } else if (entity.equals("consumoservico")) {
	                System.out.println("Consultando Consumoservico...");
	                System.out.print("Digite a descricão do Consumoservico para consultar: ");
	                String inputData = scanner.nextLine();
	                ConsumoServico consumoServico = ConsumoServico.fromString(inputData);
	                File arquivo = new File(consumoServico.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(consumoServico) == null){
	                		System.out.println("ConsumoServico Não Cadastrado.");
	                		return;
	                	}
	                	System.out.println(dao.consultar(consumoServico));
	                } else {
	                	System.out.println("Nenhum ConsumoServico Cadastrado.");
	                }
	            } else if (entity.equals("funcionario")) {
	                System.out.println("Consultando Funcionário...");
	                System.out.print("Digite o nome do funcionário para consultar: ");
	                String inputData = scanner.nextLine();
	                Funcionario funcionario = Funcionario.fromString(inputData);
	                File arquivo = new File(funcionario.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(funcionario) == null){
	                		System.out.println("Funcionario Não Cadastrado.");
	                		return;
	                	}
	                	System.out.println(dao.consultar(funcionario));
	                } else {
	                	System.out.println("Nenhum Funcionario Cadastrado.");
	                }
	            } else if (entity.equals("hospede")) {
	                System.out.println("Consultando Hóspede...");
	                System.out.print("Digite o nome do hóspede para consultar: ");
	                String inputData = scanner.nextLine();
	                Hospede hospede = Hospede.fromString(inputData);
	                File arquivo = new File(hospede.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(hospede) == null){
	                		System.out.println("Hospede Não Cadastrado.");
	                		return;
	                	}
	                	System.out.println(dao.consultar(hospede));
	                } else {
	                	System.out.println("Nenhum Hospede Cadastrado.");
	                }
	            } else if (entity.equals("item")) {
	                System.out.println("Consultando Item...");
	                System.out.print("Digite a descricão do item para consultar: ");
	                String inputData = scanner.nextLine();
	                Item item = Item.fromString(inputData);
	                File arquivo = new File(item.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(item) == null){
	                		System.out.println("Item Não Cadastrado.");
	                		return;
	                	}
	                	System.out.println(dao.consultar(item));
	                } else {
	                	System.out.println("Nenhum Item Cadastrado.");
	                }
	            } else if (entity.equals("quarto")) {
	                System.out.println("Consultando Quarto...");
	                System.out.print("Digite o número do quarto para consultar: ");
	                String inputData = scanner.nextLine();
	                Quarto quarto = Quarto.fromString(inputData);
	                File arquivo = new File(quarto.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(quarto) == null){
	                		System.out.println("Quarto Não Cadastrado.");
	                		return;
	                	}
	                	System.out.println(dao.consultar(quarto));
	                } else {
	                	System.out.println("Nenhum Quarto Cadastrado.");
	                }
	            } else if (entity.equals("reserva")) {
	                System.out.println("Consultando Reserva...");
	                System.out.print("Digite a descricão da reserva para consultar: ");
	                String inputData = scanner.nextLine();
	                Reserva reserva = Reserva.fromString(inputData);
	                File arquivo = new File(reserva.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(reserva) == null){
	                		System.out.println("Reserva Não Cadastrada.");
	                		return;
	                	}
	                	System.out.println(dao.consultar(reserva));
	                } else {
	                	System.out.println("Nenhuma Reserva Cadastrada.");
	                }
	            } else if (entity.equals("servico")) {
	                System.out.println("Consultando Servico...");
	                System.out.print("Digite a descricão do Servico para consultar: ");
	                String inputData = scanner.nextLine();
	                Servico servico = Servico.fromString(inputData);
	                File arquivo = new File(servico.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(servico) == null){
	                		System.out.println("Servico Não Cadastrado.");
	                		return;
	                	}
	                	System.out.println(dao.consultar(servico));
	                } else {
	                	System.out.println("Nenhum Servico Cadastrado.");
	                }
	            } else {
	                System.out.println("Entidade desconhecida: " + parts[1]);
	            }
	        } else if (action.equals("editar")) {
	            if (entity.equals("categoria")) {
	                System.out.println("Editando Categoria...");
	                System.out.print("Digite o nome da categoria para editar: ");
	                String inputData = scanner.nextLine();
	                Categoria categoria = Categoria.fromString(inputData);
	                File arquivo = new File(categoria.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(categoria) == null){
	                		System.out.println("Categoria Não Cadastrada.");
	                		return;
	                	}
	                	dao.editar(categoria);
	                } else {
	                	System.out.println("Nenhuma Categoria Cadastrada.");
	                }
	            } else if (entity.equals("categoriaitem")) {
	                System.out.println("Editando CategoriaItem...");
	                System.out.print("Digite o nome da categoriaItem para editar: ");
	                String inputData = scanner.nextLine();
	                CategoriaItem categoriaItem = CategoriaItem.fromString(inputData);
	                File arquivo = new File(categoriaItem.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(categoriaItem) == null){
	                		System.out.println("CategoriaItem Não Cadastrada.");
	                		return;
	                	}
	                	dao.editar(categoriaItem);
	                } else {
	                	System.out.println("Nenhuma categoriaItem Cadastrada.");
	                }
	            } else if (entity.equals("consumo")) {
	                System.out.println("Editando Consumo...");
	                System.out.print("Digite a descricão do consumo para editar: ");
	                String inputData = scanner.nextLine();
	                Consumo consumo = Consumo.fromString(inputData);
	                File arquivo = new File(consumo.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(consumo) == null){
	                		System.out.println("Consumo Não Cadastrado.");
	                		return;
	                	}
	                	dao.editar(consumo);
	                } else {
	                	System.out.println("Nenhum Consumo Cadastrado.");
	                }
	            } else if (entity.equals("consumoservico")) {
	                System.out.println("Editando Consumoservico...");
	                System.out.print("Digite a descricão do Consumoservico para editar: ");
	                String inputData = scanner.nextLine();
	                ConsumoServico consumoServico = ConsumoServico.fromString(inputData);
	                File arquivo = new File(consumoServico.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(consumoServico) == null){
	                		System.out.println("ConsumoServico Não Cadastrado.");
	                		return;
	                	}
	                	dao.editar(consumoServico);
	                } else {
	                	System.out.println("Nenhum ConsumoServico Cadastrado.");
	                }
	            } else if (entity.equals("funcionario")) {
	                System.out.println("Editando Funcionário...");
	                System.out.print("Digite o nome do funcionário para editar: ");
	                String inputData = scanner.nextLine();
	                Funcionario funcionario = Funcionario.fromString(inputData);
	                File arquivo = new File(funcionario.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(funcionario) == null){
	                		System.out.println("Funcionario Não Cadastrado.");
	                		return;
	                	}
	                	dao.editar(funcionario);
	                } else {
	                	System.out.println("Nenhum Funcionario Cadastrado.");
	                }
	            } else if (entity.equals("hospede")) {
	                System.out.println("Editando Hóspede...");
	                System.out.print("Digite o nome do hóspede para editar: ");
	                String inputData = scanner.nextLine();
	                Hospede hospede = Hospede.fromString(inputData);
	                File arquivo = new File(hospede.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(hospede) == null){
	                		System.out.println("Hospede Não Cadastrado.");
	                		return;
	                	}
	                	dao.editar(hospede);
	                } else {
	                	System.out.println("Nenhum Hospede Cadastrado.");
	                }
	            } else if (entity.equals("item")) {
	                System.out.println("Editando Item...");
	                System.out.print("Digite a descricão do item para editar: ");
	                String inputData = scanner.nextLine();
	                Item item = Item.fromString(inputData);
	                File arquivo = new File(item.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(item) == null){
	                		System.out.println("Item Não Cadastrado.");
	                		return;
	                	}
	                	dao.editar(item);
	                } else {
	                	System.out.println("Nenhum Item Cadastrado.");
	                }
	            } else if (entity.equals("quarto")) {
	                System.out.println("Editando Quarto...");
	                System.out.print("Digite o número do quarto para editar: ");
	                String inputData = scanner.nextLine();
	                Quarto quarto = Quarto.fromString(inputData);
	                File arquivo = new File(quarto.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(quarto) == null){
	                		System.out.println("Quarto Não Cadastrado.");
	                		return;
	                	}
	                	dao.editar(quarto);
	                } else {
	                	System.out.println("Nenhum Quarto Cadastrado.");
	                }
	            } else if (entity.equals("reserva")) {
	                System.out.println("Editando Reserva...");
	                System.out.print("Digite a descricão da reserva para editar: ");
	                String inputData = scanner.nextLine();
	                Reserva reserva = Reserva.fromString(inputData);
	                File arquivo = new File(reserva.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(reserva) == null){
	                		System.out.println("Reserva Não Cadastrada.");
	                		return;
	                	}
	                	dao.editar(reserva);
	                } else {
	                	System.out.println("Nenhuma Reserva Cadastrada.");
	                }
	            } else if (entity.equals("servico")) {
	                System.out.println("Editando Servico...");
	                System.out.print("Digite a descricão do Servico para editar: ");
	                String inputData = scanner.nextLine();
	                Servico servico = Servico.fromString(inputData);
	                File arquivo = new File(servico.getFilePath());
	                if (arquivo.exists()) {
	                	if(dao.consultar(servico) == null){
	                		System.out.println("Servico Não Cadastrada.");
	                		return;
	                	}
	                	dao.editar(servico);
	                } else {
	                	System.out.println("Nenhum Servico Cadastrado.");
	                }
	            } else {
	                System.out.println("Entidade desconhecida: " + parts[1]);
	            }
	        } else if (action.equals("listar")) {
	            if (entity.equals("categoria")) {
	                System.out.println("Listando Categorias...");
	                Categoria categoria = new Categoria();
	                File arquivo = new File(categoria.getFilePath()); 
	                if (arquivo.exists()) {
	                	for(Categoria categoriaPrintar : dao.listar(new Categoria())){
	                		System.out.println(categoriaPrintar);
	                	}
	                } else {
	                	System.out.println("Nenhum Servico Cadastrado.");
	                }                
	            } else if (entity.equals("categoriaitem")) {
	            	System.out.println("Listando categoriasitens...");
	            	CategoriaItem categoriaItem = new CategoriaItem();
	                File arquivo = new File(categoriaItem.getFilePath());
	                
	                if (arquivo.exists()) {
	                	for(CategoriaItem categoriaItemPrintar : dao.listar(new CategoriaItem())){
	                		System.out.println(categoriaItemPrintar);
	                	}
	                } else {
	                	System.out.println("Nenhuma CategoriaItem Cadastrada.");
	                }   
	            } else if (entity.equals("consumo")) {
	            	System.out.println("Listando Consumos...");
	            	Consumo consumo = new Consumo();
	                File arquivo = new File(consumo.getFilePath());
	                
	                if (arquivo.exists()) {
	                	for(Consumo consumoPrintar : dao.listar(new Consumo())){
	                		System.out.println(consumoPrintar);
	                	}
	                } else {
	                	System.out.println("Nenhum Consumo Cadastrado.");
	                } 
	            } else if (entity.equals("consumoservico")) {
	            	System.out.println("Listando Consumoservico...");
	            	ConsumoServico consumoServico = new ConsumoServico();
	                File arquivo = new File(consumoServico.getFilePath());
	                
	                if (arquivo.exists()) {
	                	for(ConsumoServico consumoServicoPrintar : dao.listar(new ConsumoServico())){
	                		System.out.println(consumoServicoPrintar);
	                	}
	                } else {
	                	System.out.println("Nenhum ConsumoServico Cadastrado.");
	                } 
	            } else if (entity.equals("funcionario")) {               
	                System.out.println("Listando Funcionários...");
	                Funcionario funcionario = new Funcionario();
	                File arquivo = new File(funcionario.getFilePath());
	                
	                if (arquivo.exists()) {
	                	for(Funcionario funcionarioPrintar : dao.listar(new Funcionario())){
	                		System.out.println(funcionarioPrintar);
	                	}
	                } else {
	                	System.out.println("Nenhum ConsumoServico Cadastrado.");
	                } 
	            } else if (entity.equals("hospede")) {	                
	                System.out.println("Listando Hóspedes...");
	                Hospede hospede = new Hospede();
	                File arquivo = new File(hospede.getFilePath());
	                if (arquivo.exists()) {
	                	for(Hospede hospedePrintar : dao.listar(new Hospede())){
	                		System.out.println(hospedePrintar);
	                	}
	                } else {
	                	System.out.println("Nenhum Funcionario Cadastrado.");
	                } 
	            } else if (entity.equals("item")) {	                
	                System.out.println("Listando Itens...");
	                Item item = new Item();
	                File arquivo = new File(item.getFilePath());
	                if (arquivo.exists()) {
	                	for(Item itemPrintar : dao.listar(new Item())){
	                		System.out.println(itemPrintar);
	                	}
	                } else {
	                	System.out.println("Nenhum Item Cadastrado.");
	                }   
	            } else if (entity.equals("quarto")) {
	                System.out.println("Listando Quartos...");
	                Quarto quarto = new Quarto();
	                File arquivo = new File(quarto.getFilePath());
	                if (arquivo.exists()) {
	                	for(Quarto quartoPrintar : dao.listar(new Quarto())){
	                		System.out.println(quartoPrintar);
	                	}
	                } else {
	                	System.out.println("Nenhum Quarto Cadastrado.");
	                }   
	            } else if (entity.equals("reserva")) {	                
	                System.out.println("Listando Reservas...");
	                Reserva reserva = new Reserva();
	                File arquivo = new File(reserva.getFilePath());
	                if (arquivo.exists()) {
	                	for(Reserva reservaPrintar : dao.listar(new Reserva())){
	                		System.out.println(reservaPrintar);
	                	}
	                } else {
	                	System.out.println("Nenhum Quarto Cadastrado.");
	                }   
	            } else if (entity.equals("servico")) {
	                System.out.println("Listando Servico...");               
	                Servico servico = new Servico();
	                File arquivo = new File(servico.getFilePath());
	                if (arquivo.exists()) {
	                	for(Servico servicoPrintar : dao.listar(new Servico())){
	                		System.out.println(servicoPrintar);
	                	}
	                } else {
	                	System.out.println("Nenhum Servico Cadastrado.");
	                }  
	            }  else {
	                System.out.println("Entidade desconhecida: " + parts[1]);
	            }
	        }  else if (action.equals("pagar")) {
	        	if (entity.equals("quarto")) {
	        		System.out.print("Digite o numero do Quarto: ");
	        		int numero = 0;
	        		try{
	        			numero = scanner.nextInt();
	        		} catch (NumberFormatException e) {
	        		    System.err.println("Erro: Numero de quarto inválido.");
	        		} 
	                
	        		dao.pagar(numero);
	        		     
	        		
	        	}
	        	
	        } else{
	            System.out.println("Acao desconhecida: " + parts[0]);
	        }
	        
	        
		}
}



	

