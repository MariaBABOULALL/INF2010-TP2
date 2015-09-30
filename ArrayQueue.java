

public class ArrayQueue<AnyType> implements Queue<AnyType>
{
	public int size = 0;		//Nombre d'elements dans la file.
	public int startindex = 0;	//Index du premier element de la file
	public AnyType[] table;
   
	@SuppressWarnings("unchecked")
	public ArrayQueue() 
	{
		//A completer
		table = (AnyType[])new Object[0];
		
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
		//A completer
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
		//A completer
		startindex++;
                size--;
	}
	
	//Ajoute un element a la fin de la file
	//Double la taille de la file si necessaire
	//complexit� asymptotique: O(1) ( O(N) lorsqu'un redimensionnement est necessaire )
	public void push(AnyType item)
	{
		//A completer
		if(table.length == 0)
		{
			AnyType[] newTable = (AnyType[])new Object[1];
			table = newTable;
                       
		} else if (table.length == size ) {
                        AnyType[] newTable = (AnyType[])new Object[2*size];
			for (int i=0; i<size; i++)
			{
				newTable[i] = table[i];
			}
			table = newTable;
		} 
		table[size] = item;
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
		for (int i=0; i<=size; i++)
		{
			newTable[i] = table[i];
		}
                table = newTable;
	}   
}

