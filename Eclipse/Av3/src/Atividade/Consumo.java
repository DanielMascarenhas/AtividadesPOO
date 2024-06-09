package Atividade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import DAO.DAO;

public class Consumo {
	private Item item;
	private Categoria categoria;
	private int quantidade;
	private Date dataConsumo;
	
	private static final String FILE_PATH = "Consumos.txt";
	
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
        Categoria categoriaPegar = new Categoria(categoria,"", 0.0 );
        
        DAO dao = new DAO();
        return new Consumo(dao.consultar(itemPegar), dao.consultar(categoriaPegar), quantidade, data);
    }
    
    public String getFilePath() {
        return FILE_PATH;
    }
	
}
