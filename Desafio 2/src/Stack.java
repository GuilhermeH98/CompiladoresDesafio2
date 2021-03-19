import java.util.*;
import java.io.*;


public class Stack
{
	private List<Character> caracter;

	public Stack() {

		this.caracter = new ArrayList<Character>();

	}
    //Coloca caracter na pilha
	public void empilhar(Character empilhado) {

		this.caracter.add(empilhado);

	}
    //Verifica se a pilha está vazia e desempilha
	public Character desempilhar() throws Exception {

		if (this.caracter.isEmpty()) {

			throw new Exception("Stack vazio");
		}
		return this.caracter.remove(this.caracter.size() - 1);
	}
}
