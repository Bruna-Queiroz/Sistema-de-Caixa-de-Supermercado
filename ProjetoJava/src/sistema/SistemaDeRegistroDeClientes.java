package sistema;

import java.util.HashMap;

public class SistemaDeRegistroDeClientes {
    private HashMap<String, Cliente> clientesPorCPF;

    public SistemaDeRegistroDeClientes() {
        clientesPorCPF = new HashMap<>();
    }

    // Método para adicionar um cliente ao sistema
    public void adicionarCliente(String nome, String cpf, String celular, String email) {
        Cliente cliente = new Cliente(nome, cpf, celular, email);
        clientesPorCPF.put(cpf, cliente);
    }

    // Método para buscar um cliente por CPF
    public Cliente buscarClientePorCPF(String cpf) {
        // Simulação de busca rápida após a resolução do problema
        simularTempoDeBusca();
        return clientesPorCPF.get(cpf);
    }

    // Método para resolver a lentidão, utilizando rehashing do HashMap
    public void resolverLentidao() {
        // Criando uma cópia do HashMap original
        HashMap<String, Cliente> novoHashMap = new HashMap<>(clientesPorCPF);

        // Recriando o HashMap original com um novo tamanho
        clientesPorCPF = new HashMap<>(clientesPorCPF.size() * 2);

        // Reinsere os elementos no novo HashMap, o que pode redistribuir as entradas de forma mais eficiente
        for (Cliente cliente : novoHashMap.values()) {
            clientesPorCPF.put(cliente.getCpf(), cliente);
        }

        System.out.println("Lentidão no sistema resolvida com sucesso utilizando rehashing!");
    }

    // Método para simular um tempo de busca curto
    private void simularTempoDeBusca() {
        try {
            // Simulando um tempo de busca de 1 segundo
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SistemaDeRegistroDeClientes sistema = new SistemaDeRegistroDeClientes();

        // Adicionando clientes
        sistema.adicionarCliente("Humberto", "525252525255", "85 9988 5544", "humberto@unifor.br");
        sistema.adicionarCliente("Isabel", "252525525252", "85 9988 5544", "isabel@unifor.br");

        // Simulando a resolução da lentidão
        sistema.resolverLentidao();

        // Buscando clientes por CPF após a resolução da lentidão
        long inicioBuscaHumberto = System.currentTimeMillis();
        Cliente humberto = sistema.buscarClientePorCPF("525252525255");
        long fimBuscaHumberto = System.currentTimeMillis();

        long inicioBuscaIsabel = System.currentTimeMillis();
        Cliente isabel = sistema.buscarClientePorCPF("252525525252");
        long fimBuscaIsabel = System.currentTimeMillis();

        // Exibindo informações dos clientes encontrados
        if (humberto != null) {
            System.out.println("Cliente Humberto encontrado:");
            System.out.println(humberto);
        } else {
            System.out.println("Cliente Humberto não encontrado.");
        }

        if (isabel != null) {
            System.out.println("Cliente Isabel encontrado:");
            System.out.println(isabel);
        } else {
            System.out.println("Cliente Isabel não encontrado.");
        }

        // Calculando o tempo de busca para Humberto
        long tempoDeBuscaHumberto = fimBuscaHumberto - inicioBuscaHumberto;
        System.out.println("Tempo de busca para Humberto: " + tempoDeBuscaHumberto / 1000.0 + " segundos.");

        // Calculando o tempo de busca para Isabel
        long tempoDeBuscaIsabel = fimBuscaIsabel - inicioBuscaIsabel;
        System.out.println("Tempo de busca para Isabel: " + tempoDeBuscaIsabel / 1000.0 + " segundos.");
    }
}

class Cliente {
    private String nome;
    private String cpf;
    private String celular;
    private String email;

    public Cliente(String nome, String cpf, String celular, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Celular: " + celular + ", E-mail: " + email;
    }
}

