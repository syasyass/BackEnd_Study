package algorithm01.sec05;

import java.util.Comparator;

public class BinTree<K,V> {
	
	static class Node<K, V> { // Node 내부 클래스
		private K key;// 키값
		private V data;// 데이터
		Node<K,V> left;// 왼쪽포인터
		Node<K,V> right;// 오른쪽포인터
		
		public Node(K key, V data, Node<K, V> left, Node<K, V> right) {
			super();
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public K getKey() {
			return key;
		}
		
		public V getData() {
			return data;
		}
		
		public void print() {
			System.out.println(data);
		}
	}
	
	private Node<K, V> root; // 루트
	private Comparator<? super K> comparator = null; // 비교자(Comparator)
	// 자식이면 된다는 뜻이 되려면 extends K라고 씀
	
	//---생성자(constructor) ---//
	public BinTree() {
		root = null;
	}
	//---생성자(constructor) ---//
	public BinTree(Comparator<? super K> c) {
		this();
		comparator = c;
	}
	
	//---두 키 값을 비교---//
	private int comp(K key1, K key2) { // 같으면 0
	return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2)
			: comparator.compare(key1, key2);
	}
	
	//---키로 검색---//
	public V search (K key) {
		Node<K, V> p = root; // 루트에 주목
		
		while (true) {
			if (p == null) // 더 이상 나아갈 수 없으면
				return null; // …검색 실패
			int cond = comp(key, p.getKey()); // key와 노드p의 키를 비교
			if (cond == 0) // 같으면
				return p.getData(); // …검색 성공
			else if (cond< 0) // key 쪽이 작으면
				p = p.left; // …왼쪽 서브트리에서 검색
			else // key 쪽이 크면
				p = p.right; // …오른쪽 서브트리에서 검색
		}
	}
	
	//---node를 뿌리로 하는 서브트리에 노드<K,V>를 삽입---//
	private void addNode(Node<K,V> node, K key, V data) {
		int cond = comp(key, node.getKey());
		if (cond == 0)
			return; // key가 이진검색트리에 이미 존재
		else if (cond< 0) {
			if (node.left== null)
				node.left= new Node<K,V>(key, data, null, null);
			else
				addNode(node.left, key, data); // 재귀호출. 왼쪽 서브트리에 주목
		} else {
			if (node.right== null)
				node.right= new Node<K,V>(key, data, null, null);
			else
				addNode(node.right, key, data); // 재귀호출. 오른쪽 서브트리에 주목
		}
	}
	
	//---노드삽입---//
	public void add(K key, V data) {
		if (root == null)
			root = new Node<K,V>(key, data, null, null);
		else
			addNode(root, key, data);
	}
	
	//---node를 루트로 하는 서브트리의 노드를 키값의 오름차순으로 표시---//
	private void printSubTree(Node node) {
		if (node != null) {
// Preorder
//			System.out.println(node.key+ " " + node.data); // node를 표시
//			printSubTree(node.left);// 왼쪽 서브트리를 키값의 오름차순으로 표시
//			printSubTree(node.right); // 오른쪽 서브트리를 키값의 오름차순으로 표시
			
// Inorder
			printSubTree(node.left);// 왼쪽 서브트리를 키값의 오름차순으로 표시
			System.out.println(node.key+ " " + node.data); // node를 표시
			printSubTree(node.right); // 오른쪽 서브트리를 키값의 오름차순으로 표시
			
// Postorder
//			printSubTree(node.left);// 왼쪽 서브트리를 키값의 오름차순으로 표시
//			printSubTree(node.right); // 오른쪽 서브트리를 키값의 오름차순으로 표시
//			System.out.println(node.key+ " " + node.data); // node를 표시
		}
	}
	
	//---전체 노드를 키값의 오름차순으로 표시---//
	public void print() {
		printSubTree(root);
	}
}

