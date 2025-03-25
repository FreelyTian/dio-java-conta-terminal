import java.util.Scanner;
import java.text.MessageFormat;

public class ContaTerminal {
    private int numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void welcomeMessage() {
        // Usei MessageFormat para formatar a mensagem de boas-vindas com os dados do cliente de uma maneira mais profissional e legível.
        String mensagem = MessageFormat.format(
                "Olá {0}, obrigado por criar uma conta em nosso banco, sua agência é {1}, conta {2} e seu saldo {3, number, currency} já está disponível para saque",
                nomeCliente, agencia, String.valueOf(numero), saldo);
        System.out.println(mensagem);
    }
}
