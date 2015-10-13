import java.io.*;
import java.util.Stack;

public class PostfixSolverMain 
{
	public static void main(String[] args) throws IOException 
	{
		Stack<Double> stack = new Stack<Double>();
		
		String s = "25 5 2 * + 15 3 / 5 - +";
		
		//L'expression est separee en tokens selon les espaces
		for(String token : s.split("\\s")) 
		{
			//A completer
            double item = 0;
            double resultat = 0;
            // Si l element est un nombre, on le parse en double et on l insere dans la stack
            if(token.matches("-?\\d+(\\.\\d+)?"))
            {
                item = Double.parseDouble(token);
                stack.push(item);  
            }
            // Sinon on extrait les deux derniers elements et on cherche le type de l operation
            else 
            {
                double premier = stack.pop();
                double deuxieme = stack.pop();
                if(token.equals("+"))
                {
                    resultat = deuxieme + premier;
                }
                else if(token.equals("-"))
                {
                    resultat = deuxieme - premier;  
                }
                else if(token.equals("*"))
                {
                    resultat = deuxieme * premier; 
                }
                else if(token.equals("/"))
                {
                    resultat = deuxieme / premier;
                }
                // On insere le resultat dans la stack
                stack.push(resultat);
            }
		}
     
		System.out.println(s + " " +stack.peek());
		if(stack.peek() == 35)
			System.out.println("It's all good");
		else
			System.out.println("Erreur: mauvais resultat");
                
     }
}
