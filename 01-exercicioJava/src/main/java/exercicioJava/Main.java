/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicioJava;

/**
 *
 * @author cbih9
 */
public class Main {

    public static void main(String[] args) {
/* 1. Faça um algoritmo que receba dois números e exiba o resultado da sua soma;
// 2. Faça um algoritmo que receba dois números e ao final mostre a soma, subtração, multiplicação e a divisão dos dois números lidos;
*/

//variaveis do algoritmo
int numeroUm                      = 12;
int numeroDois                    = 13;
int soma                          = numeroUm + numeroDois;
int subtracao                     = numeroUm - numeroDois;
double divisao                    = numeroUm / numeroDois;
int multiplicacao                 = numeroUm * numeroDois;
String resultadoSoma              = "Resultado da soma é ";
String resultadoDivisao           = "Resultado da divisão é ";
String resultadoSubtracao         = "Resultado da subtração é ";
String resultadoMultiplicacao     = "Resultado da multiplicação é ";

//Resultado do exercicio 1
System.out.println(resultadoSoma + soma);
//Resultado do exercicio 2
System.out.println(resultadoSoma + soma);
System.out.println(resultadoSubtracao + subtracao);
System.out.println(resultadoDivisao + divisao);
System.out.println(resultadoMultiplicacao + multiplicacao);

// 3. Escreva um algoritmo para determinar o consumo médio de um automóvel sendo fornecida a distância total percorrida pelo automóvel e o total de combustível gasto;

// variaveis 
double consumo     = 0.3d; // estou considerando 0,3 litro de combustivel por metro percorrido 
int distanciaTotal = 1000 ; // estou considerando 1000 como 1km
double consumoMedio   = (consumo * distanciaTotal) / 2;
double totalGasto     = consumo / distanciaTotal;

System.out.println ("o consumo médio é de: " + consumoMedio);
System.out.println ("O total gasto é de: " + totalGasto);
    }
    
}
