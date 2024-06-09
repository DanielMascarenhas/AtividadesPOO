package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import Atividade.*;


public class DAO {
	
	public DAO() {
		
	}
	
	//---------------------------CATEGORIA------------------------------------
	
	public boolean cadastrar(Categoria categoria) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(categoria.getFilePath(), true))) {
            writer.write(categoria.toString());
            writer.newLine();
            System.out.println("Categoria cadastrada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
	
	public boolean editar(Categoria categoria) {
		
		ArrayList<Categoria> categorias = listar(categoria);
    	
    	for(var i = 0; i < categorias.size(); i++) {
    		Categoria categoriaProcurar = categorias.get(i);
        	if(categoria.getCodigo() == categoriaProcurar.getCodigo()) {
        		categorias.remove(i);
        		categorias.set(i, categoria); 
            }
        }
    	
    	File arquivo = new File(categoria.getFilePath());
    	
    	 if (arquivo.exists()) {
             if (arquivo.delete()) {
                 System.out.println("O arquivo foi excluído com sucesso.");
             } else {
                 System.out.println("Falha ao excluir o arquivo.");
             }
         } else {
             System.out.println("O arquivo não existe.");
         }
    	 
    	 
    	 for(Categoria categoriaCadastrar : categorias) {
    		 cadastrar(categoriaCadastrar);
         }
		
		return true;
	}

	public Categoria consultar(Categoria categoria) {
		
		ArrayList<Categoria> categorias = listar(categoria);
		
        for(Categoria categoriaProcurar : categorias) {
        	if(categoria.getCodigo() == categoriaProcurar.getCodigo()) {
        		return categoriaProcurar;
            }
        }
        return null;
    }
	
	public ArrayList<Categoria> listar(Categoria categoria2){
		ArrayList<Categoria> categorias = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(categoria2.getFilePath()))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
            	Categoria categoria = Categoria.fromString(linha);
                categorias.add(categoria);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return categorias;
	}
	
	//---------------------------CATEGORIAITEM------------------------------------
	
	public boolean cadastrar(CategoriaItem categoriasIten) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(categoriasIten.getFilePath() , true))) {
            writer.write(categoriasIten.toString());
            writer.newLine();
            System.out.println("Categoria do Item cadastrada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
	
	public boolean editar(CategoriaItem categoriaItem) {
		DAO dao = new DAO();
		
		ArrayList<CategoriaItem> categoriaItens = dao.listar(categoriaItem);
    	
    	for(var i = 0; i < categoriaItens.size(); i++) {
    		CategoriaItem categoriaItemProcurar = categoriaItens.get(i);
        	if(categoriaItem.getItem().getCodigo() == categoriaItemProcurar.getItem().getCodigo() && categoriaItem.getCategoria().getCodigo() == categoriaItemProcurar.getCategoria().getCodigo() ){
        		categoriaItens.remove(i);
        		categoriaItens.set(i, categoriaItem); 
            }
        }
    	
    	File arquivo = new File(categoriaItem.getFilePath());
    	
    	 if (arquivo.exists()) {
             if (arquivo.delete()) {
                 System.out.println("O arquivo foi excluído com sucesso.");
             } else {
                 System.out.println("Falha ao excluir o arquivo.");
             }
         } else {
             System.out.println("O arquivo não existe.");
         }
    	 
    	 
    	 for(CategoriaItem categoriaItemCadastrar : categoriaItens) {
    		 dao.cadastrar(categoriaItemCadastrar);
         }
		
		return true;
	}
	
	
	public CategoriaItem consultar(CategoriaItem categoriaItem) {
		DAO dao = new DAO();
			
		ArrayList<CategoriaItem> categoriasItens = dao.listar(categoriaItem);
	
	    for(CategoriaItem categoriaItemProcurar : categoriasItens) {
	    	if(categoriaItem.getItem().getCodigo() == categoriaItemProcurar.getItem().getCodigo() && categoriaItem.getCategoria().getCodigo() == categoriaItemProcurar.getCategoria().getCodigo()) {
	    		return categoriaItemProcurar;
	            }
	        }
	        return null;
	}
	
	
	
	public ArrayList<CategoriaItem> listar(CategoriaItem categoriaItem2) {
		ArrayList<CategoriaItem> categoriasItens = new ArrayList<>();
	
	    try (BufferedReader reader = new BufferedReader(new FileReader(categoriaItem2.getFilePath()))) {
	        String linha;
	        while ((linha = reader.readLine()) != null) {
	        	CategoriaItem categoriaItem = CategoriaItem.fromString(linha);
	            categoriasItens.add(categoriaItem);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	    return categoriasItens;
	}
	
	
	// -------------ITEM-----------------------------
	
	 public boolean cadastrar(Item item) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(item.getFilePath(), true))) {
	            writer.write(item.toString());
	            writer.newLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	        return true;
	    }
	    
	    public boolean editar(Item item) {
	    	DAO dao = new DAO();
	    	ArrayList<Item> itens = dao.listar(item);
	    	
	    	for(var i = 0; i < itens.size(); i++) {
	    		Item itemProcurar = itens.get(i);
	        	if(item.getCodigo() == itemProcurar.getCodigo()) {
	        		itens.remove(i);
	        		itens.set(i, item); 
	            }
	        }
	    	
	    	File arquivo = new File(item.getFilePath());
	    	
	    	 if (arquivo.exists()) {
	             if (arquivo.delete()) {
	                 System.out.println("O arquivo foi excluído com sucesso.");
	             } else {
	                 System.out.println("Falha ao excluir o arquivo.");
	             }
	         } else {
	             System.out.println("O arquivo não existe.");
	         }
	    	 
	    	 
	    	 for(Item itemCadastrar : itens) {
	    		 dao.cadastrar(itemCadastrar);
	         }
	    	 

			return true;
		}
	    
		public Item consultar(Item item) {
			DAO dao = new DAO();
			ArrayList<Item> itens = dao.listar(item);

	        
	        for(Item itemProcurar : itens) {
	        	if(item.getCodigo() == itemProcurar.getCodigo()) {
	        		return itemProcurar;
	            }
	        }
	        return null;
	    }
	    
	    public ArrayList<Item> listar(Item item2) {
	        ArrayList<Item> itens = new ArrayList<>();

	        try (BufferedReader reader = new BufferedReader(new FileReader(item2.getFilePath()))) {
	            String linha;
	            while ((linha = reader.readLine()) != null) {
	                Item item = Item.fromString(linha);
	                itens.add(item);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return itens;
	    }
	    
	  //---------------------------FUNCIONARIO------------------------------------
	    
	    public boolean cadastrar(Funcionario funcionario) {
			
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(funcionario.getFilePath(), true))) {
	            writer.write(funcionario.toString());
	            writer.newLine();
	            System.out.println("Funcionario cadastrado com sucesso!");
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	        return true;
		}
		
		public boolean editar(Funcionario funcionario) {
			DAO dao = new DAO();
			ArrayList<Funcionario> funcionarios = dao.listar(funcionario);
	    	
	    	for(var i = 0; i < funcionarios.size(); i++) {
	    		Funcionario funcionarioProcurar = funcionarios.get(i);
	        	if(funcionario.getCpf() == funcionarioProcurar.getCpf()) {
	        		funcionarios.remove(i);
	        		funcionarios.set(i, funcionario); 
	            }
	        }
	    	
	    	File arquivo = new File(funcionario.getFilePath());
	    	
	    	 if (arquivo.exists()) {
	             if (arquivo.delete()) {
	                 System.out.println("O arquivo foi excluído com sucesso.");
	             } else {
	                 System.out.println("Falha ao excluir o arquivo.");
	             }
	         } else {
	             System.out.println("O arquivo não existe.");
	         }
	    	 
	    	 
	    	 for(Funcionario funcionarioCadastrar : funcionarios) {
	    		 dao.cadastrar(funcionarioCadastrar);
	         }
			
			return true;
		}
		public Funcionario consultar(Funcionario funcionario) {
			ArrayList<Funcionario> funcionarios = new ArrayList<>();

		    try (BufferedReader reader = new BufferedReader(new FileReader(funcionario.getFilePath()))) {
		        String linha;
		        while ((linha = reader.readLine()) != null) {
		        	Funcionario funcionarioProcurar = Funcionario.fromString(linha);
		        	funcionarios.add(funcionarioProcurar);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }

		    for (Funcionario funcionarioProcurar : funcionarios) {
		        if (funcionario.getCpf().equals(funcionarioProcurar.getCpf()) || funcionario.getNome().equals(funcionarioProcurar.getNome())) {
		            return funcionarioProcurar;
		        }
		    }
		    return null;
		}
		
		public ArrayList<Funcionario> listar(Funcionario funcionario2){

			
			ArrayList<Funcionario> funcionarios = new ArrayList<>();

	        try (BufferedReader reader = new BufferedReader(new FileReader(funcionario2.getFilePath()))) {
	            String linha;
	            while ((linha = reader.readLine()) != null) {
	            	Funcionario funcionario = Funcionario.fromString(linha);
	            	funcionarios.add(funcionario);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return funcionarios;
		}
	
		//---------------------------HOSPEDE------------------------------------
		
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
	    	
	    	for(var i = 0; i < hospedes.size(); i++) {
	    		Hospede funcionarioProcurar = hospedes.get(i);
	        	if(hospede.getCpf() == funcionarioProcurar.getCpf()) {
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
	    	 
	    	 
	    	 for(Hospede hospedeCadastrar : hospedes) {
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
		        if (hospede.getCpf().equals(hospedeProcurar.getCpf()) || hospede.getNome().equals(hospedeProcurar.getNome())) {
		            return hospedeProcurar;
		        }
		    }
		    return null;
		}

		
		
		public ArrayList<Hospede> listar(Hospede hospede2){
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
		
	
		//---------------------------QUARTO------------------------------------
		
		public boolean cadastrar(Quarto quarto) {
			
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(quarto.getFilePath(), true))) {
		        writer.write(quarto.toString());
		        writer.newLine();
		    } catch (IOException e) {
		        e.printStackTrace();
		        return false;
		    }
		    return true;
	    }
		
		public boolean editar(Quarto quarto) {
			DAO dao = new DAO();
			ArrayList<Quarto> quartos = dao.listar(quarto);
	    	
		    	for(var i = 0; i < quartos.size(); i++) {
		    		Quarto quartoProcurar = quartos.get(i);
		        	if(quarto.getCodigo() == quartoProcurar.getCodigo()){
		        		quartos.remove(i);
		        		quartos.set(i, quarto); 
		            }
		        }
		    	
		    	File arquivo = new File(quarto.getFilePath());
		    	
		    	 if (arquivo.exists()) {
		             if (arquivo.delete()) {
		                 System.out.println("O arquivo foi excluído com sucesso.");
		             } else {
		                 System.out.println("Falha ao excluir o arquivo.");
		             }
		         } else {
		             System.out.println("O arquivo não existe.");
		         }
		    	 
		    	 
		    	 for(Quarto quartoCadastrar : quartos) {
		    		 dao.cadastrar(quartoCadastrar);
		         }
				
			return true;
		}
		public Quarto consultar(Quarto quarto) {
			DAO dao = new DAO();
			ArrayList<Quarto> quartos = dao.listar(quarto);
			
		    for(Quarto quartoProcurar : quartos) {
		    	if(quarto.getCodigo() == quartoProcurar.getCodigo() ) {
		    		return quartoProcurar;
		            }
		        }
		        return null;
		}
		
		public ArrayList<Quarto> listar(Quarto quarto2){
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
		
		
		//---------------------------Serviço------------------------------------
		public boolean cadastrar(Servico servico) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(servico.getFilePath(), true))) {
	            writer.write(servico.toString());
	            writer.newLine();
	            System.out.println("Serviço cadastrada com sucesso!");
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	        return true;
		}
		
		public boolean editar(Servico servico) {
			DAO dao = new DAO();
			ArrayList<Servico> servicos = dao.listar(servico);
	    	
	    	for(var i = 0; i < servicos.size(); i++) {
	    		Servico itemProcurar = servicos.get(i);
	        	if(servico.getCodigo() == itemProcurar.getCodigo()) {
	        		servicos.remove(i);
	        		servicos.set(i, servico); 
	            }
	        }
	    	
	    	File arquivo = new File(servico.getFilePath());
	    	
	    	 if (arquivo.exists()) {
	             if (arquivo.delete()) {
	                 System.out.println("O arquivo foi excluído com sucesso.");
	             } else {
	                 System.out.println("Falha ao excluir o arquivo.");
	             }
	         } else {
	             System.out.println("O arquivo não existe.");
	         }
	    	 
	    	 
	    	 for(Servico servicoCadastrar : servicos) {
	    		 dao.cadastrar(servicoCadastrar);
	         }
			
			
			return true;
		}
		
		public Servico consultar(Servico servico) {
			DAO dao = new DAO();
			ArrayList<Servico> servicos = dao.listar(servico);

	        for(Servico servicoProcurar : servicos) {
	        	if(servico.getCodigo() == servicoProcurar.getCodigo()) {
	        		return servicoProcurar;
	            }
	        }
	        return null;
		}
		
		public ArrayList<Servico> listar(Servico servico2){
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
		
		
		//---------------------------RESERVA------------------------------------
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
	    	
	    	for(var i = 0; i < reservas.size(); i++) {
	    		Reserva reservaProcurar = reservas.get(i);
	        	if(reserva.getCodigo() == reservaProcurar.getCodigo()) {
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
	    	 
	    	 
	    	 for(Reserva reservaCadastrar : reservas) {
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
		        if (reserva.getCodigo() == reservaProcurar.getCodigo() ) {
		            return reservaProcurar;
		        }
		    }
		    return null;
		}
		
		public ArrayList<Reserva> listar(Reserva reserva2) throws ParseException{
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
		
		// -------------CONSUMO-----------------------------
		
		public boolean cadastrar(Consumo consumo) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(consumo.getFilePath(), true))) {
	            writer.write(consumo.toString());
	            writer.newLine();
	            System.out.println("Informação cadastrada com sucesso!");
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	        return true;
		}
		
		public boolean editar(Consumo consumo) throws ParseException {
			DAO dao = new DAO();
			ArrayList<Consumo> consumos = dao.listar(consumo);
	    	
	    	for(var i = 0; i < consumos.size(); i++) {
	    		Consumo consumoProcurar = consumos.get(i);
	        	if(consumo.getItem().getCodigo() == consumoProcurar.getItem().getCodigo() && consumo.getCategoria().getCodigo() == consumoProcurar.getCategoria().getCodigo() ){
	        		consumos.remove(i);
	        		consumos.set(i, consumo); 
	            }
	        }
	    	
	    	File arquivo = new File(consumo.getFilePath());
	    	
	    	 if (arquivo.exists()) {
	             if (arquivo.delete()) {
	                 System.out.println("O arquivo foi excluído com sucesso.");
	             } else {
	                 System.out.println("Falha ao excluir o arquivo.");
	             }
	         } else {
	             System.out.println("O arquivo não existe.");
	         }
	    	 
	    	 
	    	 for(Consumo consumoCadastrar : consumos) {
	    		 dao.cadastrar(consumoCadastrar);
	         }
			
			return true;
		}
		
		public Consumo consultar(Consumo consumo) throws ParseException {
			DAO dao = new DAO();
			ArrayList<Consumo> consumos = dao.listar(consumo);


	        
	        for(Consumo consumoProcurar : consumos) {
	        	if(consumoProcurar.getItem().getCodigo() == consumoProcurar.getItem().getCodigo() && consumoProcurar.getCategoria().getCodigo() == consumoProcurar.getCategoria().getCodigo()) {
	        		return consumoProcurar;
	            }
	        }
	        return null;
		}
		
		public ArrayList<Consumo> listar(Consumo consumo2) throws ParseException{
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
		
		// -------------CONSUMO SERVIÇO-----------------------------
		
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
	    	
	    	for(var i = 0; i < consumoServicos.size(); i++) {
	    		ConsumoServico consumoServicoProcurar = consumoServicos.get(i);
	    		if(consumoServico.getServico().getCodigo() == consumoServicoProcurar.getServico().getCodigo() && 
		    			consumoServico.getCategoria().getCodigo() == consumoServicoProcurar.getCategoria().getCodigo() && 
		    					consumoServico.getReserva().getCodigo() == consumoServicoProcurar.getReserva().getCodigo() ){
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
	    	 
	    	 
	    	 for(ConsumoServico consumoServicoCadastrar : consumoServicos) {
	    		 dao.cadastrar(consumoServicoCadastrar);
	         }
			
			return true;
		}
		
		
		public ConsumoServico consultar(ConsumoServico consumoServico) throws ParseException {
			DAO dao = new DAO();
			ArrayList<ConsumoServico> consumoServicos = dao.listar(consumoServico);
			
		    for(ConsumoServico consumoServicoProcurar : consumoServicos) {
		    	if(consumoServico.getServico().getCodigo() == consumoServicoProcurar.getServico().getCodigo() && 
		    			consumoServico.getCategoria().getCodigo() == consumoServicoProcurar.getCategoria().getCodigo() && 
		    					consumoServico.getReserva().getCodigo() == consumoServicoProcurar.getReserva().getCodigo() )
		    	{
		    		return consumoServicoProcurar;
		            }
		        }
		        return null;
		}
		
		public ArrayList<ConsumoServico> listar(ConsumoServico consumoServico2) throws ParseException{
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
