package exercicioVinte;
import java.util.Scanner;

public class App {
    public String getGreeting() {
        return "";
    }

    public static void main(String[] args) {
        
        //Variaveis do sisteminha
        int anoFabricacao = 0;
        float valorCarro = 0.0f;
        float porcentagemDesconto = 0.0f;
        float valorDesconto = 0.0f;
        int totalCarrosSemiNovos = 0;
        int totalCarros =0;
        float valorPagar = 0.0f;
        
        //Adicionando leitor ao sisteminha
        Scanner leitor = new Scanner(System.in);
       
        /*
          variavel do tipo char 1 caracter recebendo 
          atribui��o S  
        */
        char desejaRepetir = 'S'; 
        
        /*
          Estrutura de repeticao simples enquanto o valor for S o sisteminha 
          ir� executar a repeti��o at� que a condi��o n�o for aplicada
        */
        while(desejaRepetir == 'S' || desejaRepetir == 's'){
            System.out.println("Digite o ano de fabrica��o do ve�culo: ");
            anoFabricacao = leitor.nextInt();
            
            System.out.println("Digite o valor do ve�culo: ");
            valorCarro = leitor.nextFloat();
         /*
            Fazendo uma checagem se o ano de fabrica��o for menor ou igual a  
            2000 ir� aplicar o desconto de 12 % se n�o ir� aplicar o desconto
            de 7%.
         */
            if(anoFabricacao <= 2000){
            //12%
            porcentagemDesconto = 0.12f;
        }else{
            //7%
            porcentagemDesconto = 0.07f;
            totalCarrosSemiNovos++;
            
        }
            totalCarros++;
        
        // Calculos do sisteminha       
        valorDesconto = valorCarro * porcentagemDesconto;
        valorPagar = valorCarro - valorDesconto;
        
       // Imprimindo valores na tela
        System.out.println("O valor do desconto foi de: " + valorDesconto);
        System.out.println("O valor que deve ser pago � de: " + valorPagar);
        
        System.out.println("Deseja fazer mais cadastros? S - Sim / N - N�o");
        // entrada de dados, � preciso digitar os valores "S" ou "N" para
        // continuar no sisteminha ou sair dele.
        desejaRepetir = leitor.next().charAt(0);
        
        }
        
        System.out.println("Total de carros semi " + "novos: "
                + totalCarrosSemiNovos);
        System.out.println("Total de carros: " + totalCarros);
    }
}
