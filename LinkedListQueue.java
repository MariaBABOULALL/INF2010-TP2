
public class LinkedListQueue<AnyType> implements Queue<AnyType>
{	
	// Un noeud de la file
	@SuppressWarnings("hiding")
	private class Node<AnyType> 
	{
		private AnyType data;
		private Node next;
		
		public Node(AnyType data, Node next) 
		{
			this.data = data;
			this.next = next;
		}

		public void setNext(Node next) 
		{
			this.next = next;
		}
		
		public Node<AnyType> getNext() 
		{
			return next;
		}
		
		public AnyType getData() 
		{
			return data;
		}
	}
   
	private int size = 0;		//Nombre d'elements dans la file.
	private Node<AnyType> last;	//Dernier element de la liste
	
	public LinkedListQueue() 
	{
		//A completer
                last = new Node (null, null);	
		
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
                if (size==0)
		{
                    return null;
                } else {
                    return (AnyType)last.next.data;
                }
	}
	
	//Retire l'element en tete de file
	//complexit� asymptotique: O(1)
	public void pop() throws EmptyQueueException
	{
		//A completer
		if(size != 0)
		{
			last.next = last.next.next;
            size--;
		}
		else {
			throw new EmptyQueueException();
		}
	}
	
	//Ajoute un element a la fin de la file
	//complexit� asymptotique: O(1)
	public void push(AnyType item)
	{		
		//A completer
                if(last.data==null && last.next==null)
                {
                    Node newNode = new Node(item, null);
                    last = newNode;
                    last.next = newNode;
                } else {
                    Node newNode = new Node(item, last.next);
                    last.next = newNode;
                    last = newNode;    
                }
                size++;
                
	}
        public void afficher()
        {
            Node debut = last.next;
            do 
            {
                System.out.println(debut.data);
                debut = debut.next;
            }while(debut != last.next);
        }
}
