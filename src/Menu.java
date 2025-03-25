import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Único Scanner para todo o programa
        ContaTerminal conta = new ContaTerminal();
        while (true) {
            try {
                System.out.println("Bem-vindo ao terminal de conta bancária!");

                if (conta.getNumero() == 0) { // Verifica se o número da conta já foi definido
                    System.out.print("\rDigite o número da conta:     ");
                    conta.setNumero(input.nextInt());
                    input.nextLine(); // Limpa o buffer, também evita um bug que acaba pulando o próximo campo
                }

                if (conta.getAgencia() == null) { // Verifica se a agência já foi definida
                    System.out.print("\rDigite a agência:             ");
                    String agencia = input.nextLine().trim().toUpperCase();
                    if (agencia.isEmpty()) {
                        System.out.println("Erro: A agência não pode ser nula. Por favor, tente novamente.");
                        continue; // Pula para a próxima iteração do loop para tentar novamente (pois acaba voltando pra cá)
                    }
                    conta.setAgencia(agencia);
                }

                if (conta.getNomeCliente() == null) { // Verifica se o nome do cliente já foi definido
                    System.out.print("\rDigite o nome do cliente:     ");
                    String nomeCliente = input.nextLine().trim();
                    if (nomeCliente.isEmpty()) {
                        System.out.println("Erro: O nome do cliente não pode ser vazio. Por favor, tente novamente.");
                        continue; // Pula para a próxima iteração do loop, semelhante a como foi feito com a agência
                    }
                    conta.setNomeCliente(nomeCliente.toUpperCase());
                }

                if (conta.getSaldo() == 0) { // Verifica se o saldo já foi definido
                    System.out.print("\rDigite o saldo da conta:      ");
                    String saldoInput = input.nextLine();
                    double saldo = Double.parseDouble(saldoInput.replace(",", "."));
                    conta.setSaldo(saldo);
                }
                break; // Sai do loop quando tudo for concluído
            } catch (Exception e) {
                System.out.println("Erro: Entrada inválida. Por favor, tente novamente.");
                System.out.println("Detalhes: " + e.getLocalizedMessage());
                continue;
                // input.nextLine(); // Limpa o buffer para evitar loop infinito
            }
        }
        input.close(); // Fechar o Scanner quando não for mais necessário
        conta.welcomeMessage();
    }
}