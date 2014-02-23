public class SudokuApp
{
	public static void printList(DoublyLinkedList<String> list)
	{
		Node node = list.getHead();
		if (node == null)
		{
			System.out.println("Empty list");
			return;
		}
		System.out.println("List:");
		do
		{
			System.out.println("\""+node.getData()+"\"");
			node = node.getNext();
		}while(node != null && node != list.getHead());
	}
	public static void main(String[] args)
	{
		/*Sudoku s = new Sudoku();
		s.printGrid();
		*/
		/*SudokuSolver solver = new SudokuSolver();
		solver.printGrid();
		solver.solveViaBackTracking();
		solver.test();*/
		String[] strList = {"hi","there","I'm","Emma"};
		DoublyLinkedList<String> list = new DoublyLinkedList<String>(strList);
		printList(list);
		System.out.println("Length: "+list.getLength());
		System.out.println("Head Node: "+list.getHead().getData());
		System.out.println("Node at 2: "+list.getNode(2).getData());
		System.out.println("Node with \"Emma\" is at index: "+list.indexOf("Emma"));
		list.append("How are you?");
		printList(list);
		list.insert(1, "you");
		printList(list);
		list.remove("there");
		printList(list);
	}
}