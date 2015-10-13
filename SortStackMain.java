import java.util.Random;
import java.util.Stack;


public class SortStackMain 
{
	static final int COUNT = 30;
	static final int MAX_VALUE = 1000;
	
	public static void main(String[] args) 
	{ 
		boolean sortIsGood = true;
		
		Random generator = new Random( System.nanoTime() );
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < COUNT; i++)
			stack.push(generator.nextInt(MAX_VALUE));
		
		stack = sortStack(stack);
		
		boolean countIsGood = stack.size() == COUNT;
			
		int tmp = stack.pop();
		while(!stack.isEmpty())
		{
			System.out.print(tmp + ", ");
			
			if(tmp > stack.peek())
				sortIsGood = false;
			
			tmp = stack.pop();
		}
		System.out.println(tmp);
		
		if(!countIsGood)
			System.out.println("Erreur: il manque des elements dans la pile");
		else if(!sortIsGood)
			System.out.println("Erreur: le trie a echoue");
		else
			System.out.println("It's all good");
	}
	
	// Solution simple
	static Stack<Integer> sortStackSimple(Stack<Integer> stack)
	{
		/* 
         * Deux piles supplementaires sont utilisees:
         * une qui contient les elements tries (stackSorted) 
         * une qui stocke les elements en attente (stackTemp)
         * Un element est en attente quand l element en tete de stack est superieur a l element en tete de stackSorted
         */
        Stack<Integer> stackSorted = new Stack<Integer>();
        Stack<Integer> stackTemp = new Stack<Integer>();
        while (!stack.empty())
        {
            if(stackSorted.empty() || stackSorted.peek() >= stack.peek())
            {
                // On supprime l element en tete de stack et on le met dans stackSorted
                stackSorted.push(stack.pop());
                while (!stackTemp.empty())
                {
                    // On supprime l element en tete de stackTemp et on le met dans stackSorted
                    stackSorted.push(stackTemp.pop());
                }
            } else {
                // On supprime l element en tete de stackSorted et on le met dans stackTemp
                stackTemp.push(stackSorted.pop());
            }
        }
        return stackSorted;    
	}
	
	
	// Solution récursive
	static Stack<Integer> sortStack(Stack<Integer> stack)
	{
		// Tant que la pile n'est pas vide on sort ses éléments en les popant
		if(!stack.empty()){
	        int tmp = stack.pop();
	        sortStack(stack);
	        // Une fois vidée on la trie au fur et à mesure qu'on la remplie
	        fillStack(stack, tmp);
		}
		return stack;
	}
            
	public static void fillStack(Stack<Integer> stack, Integer value){
		// Si la pile est vide on rajoute l'élément
	    if(stack.empty())
	    {
	        stack.push(value);
	    }
	    // Sinon on remplie la pile en triant
	    else
	    {
	    	// On récupère la tête de la pile
	        int tmp = stack.peek();
	        // Si la tête de pile est plus petite que la valeur qu'on veut rajouter
	        if(tmp < value)
	        {
	        	// On ressort la tête de pile
	            stack.pop();
	            // Et on remplit le reste de la pile avec la valeur
	            fillStack(stack, value);
	            // On replace l'ancienne tête de pile
	            stack.push(tmp);
	        }
	        // Sinon on empile tout simplement l'élément
	        else
	        {
	            stack.push(value);
	        }
	    }
	}
}
