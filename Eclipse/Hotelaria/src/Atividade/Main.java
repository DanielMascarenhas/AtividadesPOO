package Atividade;

public class Main {

	public static void main(String[] args) {
		
		Hotel hotel = new Hotel("Hotel Do Daniel");
		Cliente cliente1 = new Cliente("João da silva", "445.678.657-85", "2648509295789092");
		Funcionario funcionario1 = new Funcionario("João da silva", "445.678.657-85");
		
		hotel.adicionarCliente(cliente1);
		hotel.adicionarFuncionario(funcionario1);
		
		Frigobar frigobar1 = new Frigobar();
		Categoria categoria1 = new Categoria("Luxo", 2000.0, frigobar1);
		Quarto quarto1 = new Quarto( "001", funcionario1, categoria1);
		
		
		Reserva reserva1 = new Reserva(cliente1, "12/10/2024");
		
		quarto1.reservar(reserva1);
		
		Serviço serviço1 = new Serviço("Massagem", 200.0);
		
		quarto1.serviço(serviço1);
		
		quarto1.fecharQuarto();
		
		
		
		
		
	
	}

}
