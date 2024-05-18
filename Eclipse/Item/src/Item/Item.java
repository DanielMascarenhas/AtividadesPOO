package Item;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Item {
    private int codigo;
    private String descricao;
    private double valor;

    private static final String FILE_PATH = "informacoes.txt";

    public Item(int codigo, String descricao, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return codigo + "," + descricao + "," + valor;
    }

    public static Item fromString(String linha) {
        String[] partes = linha.split(",");
        int codigo = Integer.parseInt(partes[0]);
        String descricao = partes[1];
        double valor = Double.parseDouble(partes[2]);
        return new Item(codigo, descricao, valor);
    }

    // Método para cadastrar o próprio item no arquivo de texto
    public void cadastrar() {
        // Usando try-with-resources para garantir que o BufferedWriter será fechado
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(this.toString());
            writer.newLine(); // Adiciona uma nova linha após cada registro
            System.out.println("Informação cadastrada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para listar os itens do arquivo de texto
    public static ArrayList<Item> listar() {
        ArrayList<Item> informacoes = new ArrayList<>();

        // Usando try-with-resources para garantir que o BufferedReader será fechado
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Item item = Item.fromString(linha);
                informacoes.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return informacoes;
    }
}


