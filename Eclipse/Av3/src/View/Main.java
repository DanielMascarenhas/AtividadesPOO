package View;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.NoSuchElementException;

import Atividade.Categoria;
import DAO.DAO;

public class Main {

	public static void main(String[] args) throws ParseException, InterruptedException, FileNotFoundException {
		
		Interface Interface = new Interface();
		
		while(true) {
			Interface.chamarInterface();  
			/*try {
			Interface.chamarInterface();   
				     		
			} catch (NumberFormatException e) {
			    System.err.println("Erro: as informações fornecidas não são válidas.");
			} catch (ArrayIndexOutOfBoundsException e) {
			    System.err.println("Erro: valores não suficientes para a entidade.");
			} catch (NoSuchElementException e) {
			    System.err.println("Erro: valores errados a entidade.");
			} */
			

		}
			

	}
}


 

