package algorithm01.sec05;

public class BinTreeEx01 {

	public static void main(String[] args) {
		
		// BinTree --> JavaÀÇ TreeMap¿¡ ÇØ´ç
		BinTree<Integer, String> tree = new BinTree<>();
		
		tree.add(5, "È«±æµ¿5");
		tree.add(3, "È«±æµ¿3");
		tree.add(2, "È«±æµ¿2");
		tree.add(4, "È«±æµ¿4");
		tree.add(8, "È«±æµ¿8");
		
		tree.print();
		
		String data = tree.search(4);
		System.out.println(data);
		data = tree.search(10);
		System.out.println(data);
	}

}
