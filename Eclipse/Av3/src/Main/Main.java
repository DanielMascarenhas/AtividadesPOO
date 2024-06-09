package Main;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Atividade.*;
import DAO.*;

public class Main {
	
	public static String dataToString(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(data);
    }
	
	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, ParseException {

		
		Item item = new Item(1,"testekrl",11234.0);
		//item.editar(item);
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		String dataStr = "12/12/2000";
		Date data = formatter.parse(dataStr);
		
		
		
		String dataStr2 = "25/04/1988";
		Date data2 = formatter.parse(dataStr2);
		
		ConsumoServico consumosServico = new ConsumoServico(new Servico(1, "", 0.0), new Categoria(1, "", 0.0), new Reserva(), 5, data);
		
		ArrayList<ConsumoServico> consumoServicos = consumosServico.listar();
		
		
		DAO dao = new DAO();
		
		Categoria categoria = new Categoria();
		
		dao.cadastrar(categoria);
		
		
		System.out.println(dao.listar(categoria));
		
		
		

		
	}

}
