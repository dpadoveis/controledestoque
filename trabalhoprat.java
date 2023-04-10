 //TRABALHO PRÁTICO
//Nomes dos programadores: Ana Luiza Santos Gomes e Diogo Padoveis Antunes
//Objetivo do programa: O objetivo do nosso programa é auxiliar um produtor local no controle do estoque, vendas e lucro de seus produtos, assim como no cálculo do lucro diário de cada produto, e também no lucro total do dia.
//Data da escrita: 27/06/2022 e 28/06/2022
//Última Atualização: 30/06/2022


import java.util.Scanner;
import java.io.*;
public class trabalhoprat {

	public static void  main(String[] args) {
				try {
          //Declaração de Scanner, arquivo,escritor, variável que representa o lucro,string, matriz que representa as máscaras, e vetor que representa as vendas

		 Scanner entrada =  new Scanner (System.in);	
		 File arq = new File ("C:\\arquivos\\relatorio.txt");
		 FileWriter escritor = new FileWriter (arq);
	   Scanner dado = new Scanner (arq);
		 double lucro = 0;
		 String x = new String();
		 double [][] mascaras = new double [4][3];
		 double [] vendas = new double [4];

//Colocamos um aviso inicial sobre a ordem do preenchimento dos registros diários para o usuário ter o controle de qual produto ele estará preenchendo// 
          
		  System.out.println("Seja Bem Vindo(a)!"+"\n O preenchimento será feito de tal ordem:"+ "\n0:Máscaras Infantis e Lisas"+"\n1:Máscaras Infantis e Estampadas"
		  +"\n2:Máscaras Adultas e Lisas"+"\n3:Máscaras Adultas e Estampadas");
		  System.out.println(" ");
		  System.out.println("Se não houver dados sobre alguma máscara digite 0");
		  System.out.println(" ");

//O preenchimento dos dados: Estoque, preço de custo e preço de venda serão registrados diretamente numa matriz 4x3, onde esses dados serão as colunas e o tipo de máscara serão as linhas da matriz. 
          
		    for(int ln=0;ln<4;ln++) {
		    	for(int col=0;col<3;col++) {

//Os if's colunas == 0, 1 e 2, são para que fique mais claro pra o usuário que produto ele está preenchendo no momento e seu respectivo dado.
            
		    	if(col==0) {
		    		System.out.println("Quantidade em estoque da máscara do tipo:"+ln);		
		    		mascaras[ln][col] = entrada.nextDouble();
		    		 }
		    	if(col==1) {
		    		System.out.println("Preço do custo de produção da máscara do tipo:"+ln);		
		    		mascaras[ln][col] = entrada.nextDouble();
		    		 }
		    	if(col==2) {
		    		System.out.println("Preço de venda da máscara do tipo:"+ln);		
		    		mascaras[ln][col] = entrada.nextDouble();
		    		 }
		    	
		    		 
		    	
		    	}}
		  
//No arquivo será registrado todos os dados que o usuário informou no programa, para pegar cada um desses dados e diferencia-los do tipo usamos a linha do respectivo produto juntamente com o número da coluna dos dados daquele produto.
       
		    escritor.write("Infantil e lisa:"+"\nQuantidade em Estoque:"+mascaras[0][0]);
		   escritor.write("\nPreço de custo:R$"+mascaras[0][1]);
		   escritor.write("\nPreço de venda:R$"+mascaras[0][2]);
		    
		    escritor.write("\nInfantil e estampada:"+"\nQuantidade em Estoque:"+mascaras[1][0]);
		    escritor.write("\nPreço de custo:R$"+mascaras[1][1]);
		    escritor.write("\nPreço de venda:R$"+mascaras[1][2]);
		    
		    escritor.write("\nAdulta e lisa:"+"\nQuantidade em Estoque:"+mascaras[2][0]);
		    escritor.write("\nPreço de custo:R$"+mascaras[2][1]);
		    escritor.write("\nPreço de venda:R$"+mascaras[2][2]);
		    
		    escritor.write("\nAdulta e Estampada:"+"\nQuantidade em Estoque:"+mascaras[3][0]);
		    escritor.write("\nPreço de custo:R$"+mascaras[3][1]);
		    escritor.write("\nPreço de venda:R$"+mascaras[3][2]);
		    
		    System.out.println("Ok! Agora registre suas vendas diárias para o cálculo do lucro:");
          
          //Uma estrutura de repetição, para preencher o vetor de vendas de máscaras de cada tipo.
			  for(int i=0;i<4;i++) {
				  System.out.println("\nDigite as máscaras vendidas do dia de hoje da máscara do tipo:"+i);
				  vendas[i]=entrada.nextInt(); 
          //Uma estrutura de condição para que se a matriz de mascaras e o vetor de vendas for menor ou igual a 1, aparecer mensagem de erro de registro.
				  if(mascaras[i][0]<=0 && vendas[i]>=1) {
		    			 System.out.println("Não é possível registrar vendas de um produto não disponível no estoque");}}
          //Outra estrutura de condição para que se a matriz de máscaras for menor que 0 e o vetor de vendas maior que 1, as vendas se igualam a 0.
		   
              if(mascaras[0][0]<=0 && vendas[0]>=1) {
	    			  vendas[0]=0;
	    			  }
			         if(mascaras[1][0]<=0 && vendas[1]>=1) {
		    			  vendas[1]=0;
			        }
			        if(mascaras[2][0]<=0 && vendas[2]>=1) {
		    			  vendas[2]=0;}
			         if(mascaras[3][0]<=0 && vendas[3]>=1) {
		    			  vendas[3]=0;
			        }  

                if(vendas[0]>mascaras[0][0]){
                 vendas[0]=mascaras[0][0];
                }   
                 if(vendas[1]>mascaras[1][0]){
                 vendas[1]=mascaras[1][0];
                }      
                if(vendas[2]>mascaras[2][0]){
                 vendas[2]=mascaras[2][0];
                }      
                if(vendas[3]>mascaras[3][0]){
                 vendas[3]=mascaras[3][0];
                }     
                 //Um escritor detalhando o relatório de vendas e lucros diários de cada máscara
					      else if(mascaras[0][0]>0 && vendas[0]>=0 ||mascaras[1][0]>0 && vendas[1]>=0 || mascaras[2][0]>0 && vendas[2]>=0 || mascaras[3][0]>0 && vendas[3]>=0) {
			        	 escritor.write("\n\nVendas e Lucros Diários:"+"\n\nInfantil e Lisa(Unidadades Vendidas):"+vendas[0]+"\n\nInfantil e Lisa(lucro do dia):R$"+ (mascaras[0][2] * vendas[0] - (vendas[0] * mascaras[0][1])));
		    			  escritor.write("\n\nInfantil e Estampada(Unidadades Vendidas):"+vendas[1]+"\n\nInfantil e Estampada(lucro do dia):R$"+ (mascaras[1][2] * vendas[1] - (vendas[1] *mascaras[1][1])));
						  escritor.write("\n\nAdulta e Lisa(Unidadades Vendidas):"+vendas[2]+"\n\nAdulta e Lisa(lucro do dia):R$"+ (mascaras[2][2] * vendas[2] - (vendas[2] *mascaras[2][1])));
						  escritor.write("\n\nAdulta e Estampada(Unidadades Vendidas):"+vendas[3]+"\n\nAdulta e Estampada(lucro do dia):R$"+ (mascaras[3][2] * vendas[3] - (vendas[3] * mascaras[3][1])));
			         }
                  //Um else if  para que se o vetor e a matriz forem menor que 0, um aviso de que não foram registradas vendas.
	    else if(mascaras[0][0]<=0 && vendas[0]<=0 ||mascaras[1][0]<=0 && vendas[1]<=0 || mascaras[2][0]<=0 && vendas[2]<=0 || mascaras[3][0]<=0 && vendas[3]<=0){
	    System.out.println("Não foram registradas vendas para o cálculo do lucro");}

          //A utilização da variável lucro para representar o cálculo mostrando o lucro total do dia
     lucro=(vendas[0]*mascaras[0][2]+vendas[1]*mascaras[1][2]+vendas[2]*mascaras[2][2]+vendas[3]*mascaras[3][2])-(mascaras[0][1]*vendas[0]+mascaras[1][1]*vendas[1]+mascaras[2][1]*vendas[2]+mascaras[3][1]*vendas[3]);
			 		
			 			escritor.write("\nO Lucro total diário foi:"+lucro);
	    	
	    
	      //Término do escritor
		    escritor.close();
		    while (dado.hasNextLine()) {
				x = dado.nextLine();
				System.out.println(x);} 
	  
		    
			    //Término do scanner de dados
		      dado.close();
          //Término do scanner entrada
		      entrada.close();
		 
		}
          
		
		    catch (IOException erro) {
			System.out.println(erro.getMessage());
		}		
		 

	
	}

	
	}

