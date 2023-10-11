package algorithm01.sec05;

public class BinTreeEx01 {

	public static void main(String[] args) {
		
		// BinTree --> Java�� TreeMap�� �ش�
		BinTree<Integer, String> tree = new BinTree<>();
		
		tree.add(5, "ȫ�浿5");
		tree.add(3, "ȫ�浿3");
		tree.add(2, "ȫ�浿2");
		tree.add(4, "ȫ�浿4");
		tree.add(8, "ȫ�浿8");
		
		tree.print();
		
		String data = tree.search(4);
		System.out.println(data);
		data = tree.search(10);
		System.out.println(data);
	}

}
