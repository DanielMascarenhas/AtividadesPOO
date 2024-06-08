package Atividade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Consumo {
	private Item item;
	private Categoria categoria;
	private int quantidade;
	private Date dataConsumo;
	
	public static final String FILE_PATH = "Consumos.txt";
	
	public Consumo(Item item, Categoria categoria, int quantidade, Date dataConsumo) {
		this.item = item;
		this.categoria = categoria;
		this.quantidade = quantidade;
		this.dataConsumo = dataConsumo;
	}

	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Date getDataConsumo() {
		return dataConsumo;
	}

	public void setDataConsumo(Date dataConsumo) {
		this.dataConsumo = dataConsumo;
	}
	
	public boolean cadastrar(Consumo consumo) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
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
		
ArrayList<Consumo> consumos = consumo.listar();
    	
    	for(var i = 0; i < consumos.size(); i++) {
    		Consumo consumoProcurar = consumos.get(i);
        	if(consumo.getItem().getCodigo() == consumoProcurar.getItem().getCodigo() && consumo.getCategoria().getCodigo() == consumoProcurar.getCategoria().getCodigo() ){
        		consumos.remove(i);
        		consumos.set(i, consumo); 
            }
        }
    	
    	File arquivo = new File(FILE_PATH);
    	
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
    		 consumo.cadastrar(consumoCadastrar);
         }
		
		return true;
	}
	
	public Consumo consultar(Consumo consumo) throws ParseException {
		ArrayList<Consumo> consumos = consumo.listar();


        
        for(Consumo consumoProcurar : consumos) {
        	if(consumoProcurar.item.getCodigo() == consumoProcurar.item.getCodigo() && consumoProcurar.categoria.getCodigo() == consumoProcurar.categoria.getCodigo()) {
        		return consumoProcurar;
            }
        }
        return null;
	}
	
	public ArrayList<Consumo> listar() throws ParseException{
		ArrayList<Consumo> consumos = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
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
	
	@Override
    public String toString() {
        return item.getCodigo() + "," + categoria.getCodigo() + "," + quantidade + "," + getDataConsumo();
    }
	

    public static Consumo fromString(String linha) throws ParseException {
    	String[] partes = linha.split(",");
        int item = Integer.parseInt(partes[0]);
        int categoria = Integer.parseInt(partes[1]);
        int quantidade = Integer.parseInt(partes[2]);
        String DataConsumo = partes[2];
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formatter.parse(DataConsumo);
        
        Item itemPegar = new Item(item,"", 0.0 );
        
        itemPegar = itemPegar.consultar(itemPegar);
        
        Categoria categoriaPegar = new Categoria(categoria,"", 0.0 );
        
        categoriaPegar = categoriaPegar.consultar(categoriaPegar);
       
        return new Consumo(itemPegar, categoriaPegar, quantidade, data);
    }
	
}
