package View;

import java.text.ParseException;
import java.util.NoSuchElementException;

public class Main {

	public static void main(String[] args) throws ParseException, InterruptedException {
		
		Interface Interface = new Interface();
		
		while(true) {
			try {
				Interface.chamarInterface();        		
			} catch (NumberFormatException e) {
			    System.err.println("Erro: as informações fornecidas não são válidas.");
			} catch (ArrayIndexOutOfBoundsException e) {
			    System.err.println("Erro: valores não suficientes para a entidade.");
			} catch (NoSuchElementException e) {
			    System.err.println("Erro: valores errados a entidade.");
			} 
			

		}

	}

}


 

