package View;

import java.util.Scanner;

public class TelaInicial {
    
    Scanner scanner = new Scanner(System.in);
    
    public int exibirMenu(){
        System.out.println("1 - Clientes");
        System.out.println("2 - Colaboradores");
        System.out.println("3 - Catalogo/Estoque");
        System.out.println("4 - Agendamentos");
        System.out.println("5 - Financeiro");
        System.out.println("6 - Catraca");
        System.out.println("7 - Salvar Dados");
        System.out.println("8 - Sair");
        System.out.println("Digite a area que deseja acessar: ");
        
        return scanner.nextInt(); 
    }
    
    public void displayMsgDadosSalvos(){
        System.out.println("Os dados foram Salvos");
    }
}
