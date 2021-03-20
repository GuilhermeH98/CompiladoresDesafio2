import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArquivoReader 
{
	
	public static void main(String[] args) throws IOException 
	{
		//Nome do arquivo que vai ser gerado com as respostas.
		File arquivo = new File("respostas.txt");
		FileWriter fw = new FileWriter(arquivo);
		PrintWriter pw = new PrintWriter(fw);
		Scanner scan;
		
		try 
		{
			// Colocar o nome do arquivo aqui para testar.
			scan = new Scanner(new File("nomedoarquivo.txt"));        
			while (scan.hasNext()) 
			{
				String frase = scan.nextLine();
				String[] linhas = { frase } ;
				
				for (String paraValidar : linhas)
				{
					pw.print(paraValidar);
					pw.println(verificaSeTaOK(paraValidar)?"\t OK":"\t invalido");
				}
			}
			
		} 
		catch (Exception e)
		{
			System.out.println("Não encontrou o arquivo");
		}
		finally {
		pw.close();
		System.out.println("Arquivo texto criado");
		}
	}
	
    //Metodo para verificar os parenteses e retornar true se estiver OK.
	public static boolean verificaSeTaOK(String frase) {
        
        Stack stack = new Stack();

        char[] letras = frase.toCharArray();
        for (Character caracter : letras) 
        {

            if (caracter == '(' || caracter == '[' || caracter == '{' || caracter == '<') 
            {

                stack.empilhar(caracter);
            } else if (caracter == ')' || caracter == ']' || caracter == '}' || caracter == '>') 
            {

                try {

                    char comparaSimbolo = stack.desempilhar();

                    if (caracter == ')' && comparaSimbolo == '(') {
                        continue;
                    } else if (caracter == '}' && comparaSimbolo == '{') {
                        continue;
                    } else if (caracter == ']' && comparaSimbolo == '[') {
                        continue;
                    } else if (caracter == '>' && comparaSimbolo == '<') {
                        continue;
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return true;
    }
	
	
}
