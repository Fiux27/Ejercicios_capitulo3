
    
import java.io.*;
import java.util.*;

class Node
{
	int data;
	Node next, anter;
	Node(int val)
	{
		data = val;
		next = null;
		anter = null;
	}
}

class GFG
{

	static Node push(Node head, int data)
	{
		Node new_node = new Node(data);
		new_node.next = head;
		new_node.anter = null;
		if (head != null)
			head.anter = new_node;
		head = new_node;
			
		return head;
	}

	static int findSize(Node node)
	{
		int res = 0;
		while (node != null)
		{
				res++;
				node = node.next;
		}

		return res;
	}

	public static void main(String args[])
	{
		Node head = null;
		head = push(head, 4);
		head = push(head, 3);
		head = push(head, 2);
		head = push(head, 1);
		System.out.println(findSize(head));
	}
}
