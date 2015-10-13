

public class ArrayQueue<AnyType> implements Queue<AnyType>
{
	public int size = 0;		//Nombre d'elements dans la file.
	public int startindex = 0;	//Index du premier element de la file
	public AnyType[] table;
   
	@SuppressWarnings("unchecked")
	public ArrayQueue() 
	{
		// On crée un nouveau tableau de la taille size (0 à l'initialisation)
		table = (AnyType[])new Object[size];
		
	}
	
	//Indique si la file est vide
	public boolean empty() 
	{ 
		return size == 0; 
	}
	
	//Retourne la taille de la file
	public int size() 
	{ 
		return size; 
	}
	
	//Retourne l'element en tete de file
	//Retourne null si la file est vide
	//complexit� asymptotique: O(1)
	public AnyType peek()
	{
		if(size==0)
		{ 
			return null;
		} else { 
			return table[startindex]; 
		} 
		
	}
	
	//Retire l'element en tete de file
	//complexit� asymptotique: O(1)
	public void pop() throws EmptyQueueException
	{
		// Si la taille est supérieure à zéro
		if(size > 0)
		{
			// On remplace l'élément en tête de file par null
			table[startindex] = null;
			// On incrémente l'index du début et diminue la taille
			startindex++;
	        size--;	
		}
		// Sinon on lance l'exception
		else {
			throw new EmptyQueueException();
		}
		
	}
	
	//Ajoute un element a la fin de la file
	//Double la taille de la file si necessaire
	//complexit� asymptotique: O(1) ( O(N) lorsqu'un redimensionnement est necessaire )
	public void push(AnyType item)
	{
		// Si le tableau n'a aucune case on le remplace par un tableau à une case
		if(table.length == 0)
		{
			AnyType[] newTable = (AnyType[])new Object[1];
			table = newTable;            
		}
		// Si la taille du tableau - le start index est égal à la taille
		else if (table.length-startindex == size) {
			// On double la taille du tableau en prenant bien en compte la position du startindex
            AnyType[] newTable = (AnyType[])new Object[2*(size+startindex)];
			for (int i = 0; i < size+startindex; i++)
			{
				newTable[i] = table[i];
			}
			table = newTable;
		}
		// On place l'objet item à la fin de la file
		table[size+startindex] = item;	
		size++;	
	}
   
	//Redimensionne la file. La capacite est multipliee par un facteur de resizeFactor.
	//Replace les elements de la file au debut du tableau
	//complexit� asymptotique: O(N)
	@SuppressWarnings("unchecked")
	private void resize(int resizeFactor)
	{
		//A completer
		AnyType[] newTable = (AnyType[])new Object[size*resizeFactor];
		for (int i = 0; i <= size; i++)
		{
			newTable[i] = table[i];
		}
        table = newTable;
	}   
}

