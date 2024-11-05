package Main;

import Controller.AgendamentosController;
import Controller.ClientesController;
import Controller.ColaboradoresController;
import Controller.ContasController;
import Controller.JsonController.ContaDeserializer;
import Controller.Manipulator.ListManipulator;
import Controller.Manipulator.MapManipulator;
import Controller.ProdutoEstoqueController;
import Controller.Sistema;
import Model.Agendamento;
import Model.Cliente;
import Model.Comparator.CompClienteIdCresc;
import Model.Comparator.CompClienteNomeCresc;
import Model.Conta;
import Model.Diaria;
import Model.Funcionario;
import Model.Produto;
import Model.Venda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AcademiaPOO {

    public static void main(String[] args) throws IOException {
        
        Sistema sistema = new Sistema("src/data/colaboradores.json");
        Sistema.adicionarManipuladorContr(new ClientesController(new ListManipulator("src/data/clientes.json", Cliente.class)));
        Sistema.adicionarManipuladorContr(new ColaboradoresController(new ListManipulator("src/data/colaboradores.json", Funcionario.class)));
        Sistema.adicionarManipuladorContr(new AgendamentosController(new ListManipulator("src/data/agendamentos.json", Agendamento.class)));
        Sistema.adicionarManipuladorContr(new ProdutoEstoqueController(new ListManipulator("src/data/produtos.json", Produto.class),
        new MapManipulator("src/data/estoque.json", String.class, Integer.class)));
        
        ContaDeserializer deserializer = new ContaDeserializer("type");
        deserializer.registerContaType("Conta", Conta.class);
        deserializer.registerContaType("Venda", Venda.class);
        deserializer.registerContaType("Diaria", Diaria.class);
        Sistema.adicionarManipuladorContr(new ContasController(new ListManipulator("src/data/contas.json", Conta.class, deserializer)));
        
        // Testando Catraca
        {
            ClientesController clientesController = Sistema.getManipuladorContrPorTipo(ClientesController.class);
            ColaboradoresController colaboradoresController = Sistema.getManipuladorContrPorTipo(ColaboradoresController.class);
            
            
            Sistema.getCatraca().entrar(clientesController.buscarCliente(1));
            Sistema.getCatraca().entrar(clientesController.buscarCliente(2));
            Sistema.getCatraca().entrar(clientesController.buscarCliente(3));
            Sistema.getCatraca().entrar(clientesController.buscarCliente(4));
            
            Sistema.getCatraca().entrar(colaboradoresController.buscarColaborador("Lucas Santos"));
            Sistema.getCatraca().entrar(colaboradoresController.buscarColaborador("Ana Oliveira"));
            
            Sistema.getCatraca().sair(clientesController.buscarCliente(2));
            Sistema.getCatraca().sair(clientesController.buscarCliente(3)); 
        }
        
        // Questão 1
        {
            // Feito
        }
        
        // Questão 2
        {
            // Feito, a interface para o Funcionário e Administrador é diferente na área financeira
        }
        
        // Questão 3
        {
            // Feito
        }
        
        // Questão 4
        {
            // Feito, foi usada herança para as seguintes classes:
            // Para os Manipuladores
            // Para as classes Funcionario e Cliente com Pessoa
            // Para as classes Venda e Daria com Conta
        }
        
        // Questão 5
        {
            // Feito, a array está na classe AgendamentosController
        }
        
        // Questão 6
        {
            // Feito, tais funcionalidades estão presentes na classe ColaboradoresController
        }
        
        // Questão 7
        {
            // Feito, tais funcioalidades estão presentes na classe ClientesController
        }
        
        // Questão 8
        {
            // Feito
            // Para mostrar dados de uma mensalidade ou diária, foi implementado o método mostrarDadosConta em ContasController
            // Para mostrar dados de um cliente, foi implementado o método mostrarDadosCliente em ClientesController
        }
        
        // Questão 9
        {
            // Feito
            // As reservas são armazenadas na Coleção do Manipulador de AgendamentosController
            // As ações da catraca são armazenadas na Lista da classe Catraca
        }
        
        // Questão 10
        {
            // Feito, depois que toda venda é executada, um extrato é gerado com informações da Venda
        }
        
        // Questão 11
        {
            // A abordagem com variáveis private é mais segura porem sacrifica o desempenho, 
            // É segura pois é possível controlar a forma como o usuário acessa as variaveis por meio dos metodos get
            // Sacrifica o desempenho pois o uso de get aumenta a quantidade de ciclos de processador necessários
            
            // A abordagem com variáveis protected é menos segura porem melhor para o desempenho
            // É menos segura pois qualquer classe que herde daquela contendo a variável tem acesso às variaveis
            // É melhor para o desempenho pois menos ciclos de processador são necessários para obter as variáveis.
        }
        
        // Questão 12
        {
            // Feito, método getQuantClientesPriv e getQuantClientesProtec na classe Sistema
        }
        
        // Questão 13
        {
            // Feito, classes que implementam de comparator estão no pacote Model.Comparator
        }
        
        // Questão 14
        {
            // Feito, todos os manipuladores dos controladores que salvam seus dados tem um método salvar
            // Tal método salvar escreve a coleção do Manipulador para um arquivo json
            // Os arquivos json com os dados estão no pacote data
        }
        
        // Questão 15A
        {
            // JavaDoc gerado
        }
        
        // Questão 15B
        {
            ClientesController clientesController = Sistema.getManipuladorContrPorTipo(ClientesController.class);
            List<Cliente> clientes = (ArrayList)clientesController.getManipulador().getColecao();
            Iterator<Cliente> clientesIterator = clientes.iterator();
            
            System.out.println("Usando Iterator para iterar");
            while(clientesIterator.hasNext()){ // usando iterator
                System.out.println(clientesIterator.next());
            }
            System.out.println();
            
            //O Iterator fornece os métodos hasNext() e next() para percorrer os elementos:
            // o hasNext retorna true se ainda houver elementos a serem iterados, ou false se todos os elementos já foram percorridos.
            // o next retorna o próximo elemento da coleção e avança o Iterator.
            
            //O foreach é uma forma simplificada de percorrer coleções em Java. 
            //Ele é usado para simplificar o código de iteração. 
            // Internamente, o foreach usa um Iterator para percorrer a coleção.
            
            System.out.println("Usando foreach para iterar");
            for (Cliente cliente : clientes){ // usando foreach
                System.out.println(cliente);
            }
            System.out.println();
        }
        
        // Questão 16
        {
            ClientesController clientesController = Sistema.getManipuladorContrPorTipo(ClientesController.class);
            List<Cliente> clientes = (ArrayList)clientesController.getManipulador().getColecao();
            
            Collections.sort(clientes, new CompClienteNomeCresc()); // Ordenando por nome de Maneira crescente
            
            System.out.println("Ordenado por Nome");
            for (Cliente cliente : clientes){
                System.out.println(cliente);
            } // Clientes antes de fazer o sort
            System.out.println();
            
            Collections.sort(clientes, new CompClienteIdCresc()); // Ordenando por Id de Maneira crescente

            System.out.println("Ordenado por Id");
            for (Cliente cliente : clientes){
                System.out.println(cliente);
            } // Clientes antes de fazer o sort
            System.out.println();
        }
        
        // Questão 17
        {
            ClientesController clientesController = Sistema.getManipuladorContrPorTipo(ClientesController.class);
            List<Cliente> clientes = (ArrayList)clientesController.getManipulador().getColecao();
            
            Cliente clienteAlvo = clientesController.buscarCliente(780);
            
            double startTime = System.nanoTime();
            Collections.binarySearch(clientes, clienteAlvo, new CompClienteIdCresc());
            double endTime = System.nanoTime();
            
            System.out.printf("Demorou %f nano segundos para encontrar por meio da busca binaria%n", endTime - startTime);
            
            startTime = System.nanoTime();
            clientesController.find(clienteAlvo, new CompClienteIdCresc());
            endTime = System.nanoTime();
            
            System.out.printf("Demorou %f nano segundos para encontrar por meio da busca implementada%n", endTime - startTime);
            System.out.println("");
        }
        
        sistema.run();
    }
}
