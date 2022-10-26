

public class Identical {

	static class Node {
		int data;
		Node next;

		Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	};

	
	static Node insertNode(Node head, Node tail, int d)
	{
		if (head == null) {
			Node newNode = new Node(d);
			head = newNode;
			tail = newNode;
			newNode.next = newNode;
			return newNode;
		}
		else {

			Node temp = new Node(d);
			temp.next = tail.next;
			tail.next = temp;
			return tail.next;
		}
	}

	static void print(Node head)
	{
		Node curr = head;

		if (head == null) {
			System.out.println("List is Empty ");
			return;
		}

		
		do {
			System.out.print(curr.data + " ");
			curr = curr.next;
		} while (curr != head);
		System.out.println();
	}

	static int length(Node head)
	{
		if (head == null) {
			return 0;
		}

		int size = 0;
		Node curr = head;

		do {
			curr = curr.next;
			size++;
		} while (curr != head);
		return size;
	}

	static boolean checkIdentical(Node head1, Node head2)
	{
		int l1 = length(head1);

		int l2 = length(head2);

		if (l1 != l2)
			return false;

		int Count = 0;
		boolean flag = false;

		Node h1 = head1;
		Node h2 = head2;

		while (true) {

			if (h1.data == h2.data) {
				h1 = h1.next;
				Count++;

				
				if (Count == l1)
					return true;
			}

			
			else {
				h1 = head1;
				Count = 0;

			
				if (flag)
					return false;
			}

			if (h2.next == head2)
				flag = true;

			h2 = h2.next;
		}
	}

	static Node head1, tail1, head2, tail2;

	public static void main(String[] args)
	{

		head1 = null;
		tail1 = null;

		head1 = tail1 = insertNode(head1, tail1, 1);
		tail1 = insertNode(head1, tail1, 2);
		tail1 = insertNode(head1, tail1, 3);
		tail1 = insertNode(head1, tail1, 4);
		tail1 = insertNode(head1, tail1, 5);
		tail1 = insertNode(head1, tail1, 1);
		tail1 = insertNode(head1, tail1, 2);
		tail1 = insertNode(head1, tail1, 6);

		head2 = null;
		tail2 = null;

		head2 = tail2 = insertNode(head2, tail2, 5);
		tail2 = insertNode(head2, tail2, 1);
		tail2 = insertNode(head2, tail2, 2);
		tail2 = insertNode(head2, tail2, 6);
		tail2 = insertNode(head2, tail2, 1);
		tail2 = insertNode(head2, tail2, 2);
		tail2 = insertNode(head2, tail2, 3);
		tail2 = insertNode(head2, tail2, 4);

		boolean flag = checkIdentical(head1, head2);
		if (flag)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
