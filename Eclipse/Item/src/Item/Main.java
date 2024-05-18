package Item;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Cadastrar novas informações
        Item item1 = new Item(1, "Item 1", 10.50);
        item1.cadastrar();

        Item item2 = new Item(2, "Item 2", 20.75);
        item2.cadastrar();

        // Listar informações do arquivo e colocá-las em um ArrayList de Itens
        ArrayList<Item> informacoes = Item.listar();

        // Imprimir as informações listadas
        for (Item item : informacoes) {
            System.out.println("Código: " + item.getCodigo() +
                               ", Descrição: " + item.getDescricao() +
                               ", Valor: " + item.getValor());
        }
    }
}

