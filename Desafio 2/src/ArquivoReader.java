import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArquivoReader 
{
	
	
	public static void main(String[] args) 
	{
		Scanner scan;
		// Colocar o nome do arquivo aqui para testar.
		try {
			scan = new Scanner(new File("nomedoarquivo.txt"));
            //Verifica se o arquivo ainda tem linhas e faz a analise de cada linha.
			while (scan.hasNext()) 
			{
				String frase = scan.nextLine();
				String[] linhas = { frase } ;
				
				for (String paraValidar : linhas)
				{

	                System.out.println(verificaSeTaOK(paraValidar)?"\t OK":"\t invalido");
				}
			}
			
		} 
		catch (Exception e)
		{
			System.out.println("Não encontrou o arquivo");
		}
	}
    //Metodo para verificar os parenteses e retornar true se estiver OK.
	public static boolean verificaSeTaOK(String frase) {
        System.out.print(frase);

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
