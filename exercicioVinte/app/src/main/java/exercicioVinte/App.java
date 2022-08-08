package exercicioVinte;
import java.util.Scanner;

public class App {
    public String getGreeting() {
        return "";
    }

    public static void main(String[] args) {
        
        int anoFabricacao = 0;
        float valorCarro = 0.0f;
        float porcentagemDesconto = 0.0f;
        float valorDesconto = 0.0f;
        int totalCarrosSemiNovos = 0;
        int totalCarros =0;
        float valorPagar = 0.0f;
        
        Scanner leitor = new Scanner(System.in);
        
        char desejaRepetir = 'S';
        
        
        while(desejaRepetir == 'S'){
            System.out.println("Digite o ano de fabricação do veículo: ");
            anoFabricacao = leitor.nextInt();
            
            System.out.println("Digite o valor do veículo: ");
            valorCarro = leitor.nextFloat();
            
            if(anoFabricacao <= 2000){
            //12%
            porcentagemDesconto = 0.012f;
        }else{
            //7%
            porcentagemDesconto = 0.007f;
            totalCarrosSemiNovos++;
            
        }
            totalCarros++;
            
        valorDesconto = valorCarro * porcentagemDesconto;
        valorPagar = valorCarro - valorDesconto;
        
        System.out.println("O valor do desconto foi de: " + valorDesconto);
        System.out.println("O valor que deve ser pago é de: " + valorPagar);
        
        System.out.println("Deseja fazer mais cadastros? S - Sim / N - Não");
        desejaRepetir = leitor.next().charAt(0);
        
        }
        
        System.out.println("Total de carros semi novos: " + totalCarrosSemiNovos);
        System.out.println("Total de carros: " + totalCarros);
    }
}
