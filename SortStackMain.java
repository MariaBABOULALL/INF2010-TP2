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
	
	static Stack<Integer> sortStack(Stack<Integer> stack)
	{
		//A completer
            
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
}
