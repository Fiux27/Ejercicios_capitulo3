class Node
{
	int data;
	Node next;
	Node(int d)
	{
		this.data = d;
		this.next = null;
	}
}
class LinkedList
{
	Node start;
	LinkedList()
	{
		start = null;
	}
	
	public void push(int data)
	{
		if(this.start == null)
		{
		Node temp = new Node(data);
		this.start = temp;
		}
		else
		{
			Node temp = new Node(data);
			temp.next = this.start;
			this.start = temp;
		}
	}
	
	public int findSecondLastNode(Node ptr)
	{
		Node temp = ptr;
		
		if(temp == null || temp.next == null)
			return -1;
	
		while(temp.next.next != null)
		{
			temp = temp.next;
		}
		return temp.data;
	}
	
	public static void main(String[] args)
	{
		LinkedList ll = new LinkedList();
		
		ll.push(14);
		ll.push(58);
		ll.push(27);
		ll.push(42);
		ll.push(6);
		System.out.println(ll.findSecondLastNode(ll.start));
	}
}
