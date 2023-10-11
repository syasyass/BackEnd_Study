package algorithm01.sec05;

import java.util.Comparator;

public class BinTree<K,V> {
	
	static class Node<K, V> { // Node ���� Ŭ����
		private K key;// Ű��
		private V data;// ������
		Node<K,V> left;// ����������
		Node<K,V> right;// ������������
		
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
	
	private Node<K, V> root; // ��Ʈ
	private Comparator<? super K> comparator = null; // ����(Comparator)
	// �ڽ��̸� �ȴٴ� ���� �Ƿ��� extends K��� ��
	
	//---������(constructor) ---//
	public BinTree() {
		root = null;
	}
	//---������(constructor) ---//
	public BinTree(Comparator<? super K> c) {
		this();
		comparator = c;
	}
	
	//---�� Ű ���� ��---//
	private int comp(K key1, K key2) { // ������ 0
	return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2)
			: comparator.compare(key1, key2);
	}
	
	//---Ű�� �˻�---//
	public V search (K key) {
		Node<K, V> p = root; // ��Ʈ�� �ָ�
		
		while (true) {
			if (p == null) // �� �̻� ���ư� �� ������
				return null; // ���˻� ����
			int cond = comp(key, p.getKey()); // key�� ���p�� Ű�� ��
			if (cond == 0) // ������
				return p.getData(); // ���˻� ����
			else if (cond< 0) // key ���� ������
				p = p.left; // ������ ����Ʈ������ �˻�
			else // key ���� ũ��
				p = p.right; // �������� ����Ʈ������ �˻�
		}
	}
	
	//---node�� �Ѹ��� �ϴ� ����Ʈ���� ���<K,V>�� ����---//
	private void addNode(Node<K,V> node, K key, V data) {
		int cond = comp(key, node.getKey());
		if (cond == 0)
			return; // key�� �����˻�Ʈ���� �̹� ����
		else if (cond< 0) {
			if (node.left== null)
				node.left= new Node<K,V>(key, data, null, null);
			else
				addNode(node.left, key, data); // ���ȣ��. ���� ����Ʈ���� �ָ�
		} else {
			if (node.right== null)
				node.right= new Node<K,V>(key, data, null, null);
			else
				addNode(node.right, key, data); // ���ȣ��. ������ ����Ʈ���� �ָ�
		}
	}
	
	//---������---//
	public void add(K key, V data) {
		if (root == null)
			root = new Node<K,V>(key, data, null, null);
		else
			addNode(root, key, data);
	}
	
	//---node�� ��Ʈ�� �ϴ� ����Ʈ���� ��带 Ű���� ������������ ǥ��---//
	private void printSubTree(Node node) {
		if (node != null) {
// Preorder
//			System.out.println(node.key+ " " + node.data); // node�� ǥ��
//			printSubTree(node.left);// ���� ����Ʈ���� Ű���� ������������ ǥ��
//			printSubTree(node.right); // ������ ����Ʈ���� Ű���� ������������ ǥ��
			
// Inorder
			printSubTree(node.left);// ���� ����Ʈ���� Ű���� ������������ ǥ��
			System.out.println(node.key+ " " + node.data); // node�� ǥ��
			printSubTree(node.right); // ������ ����Ʈ���� Ű���� ������������ ǥ��
			
// Postorder
//			printSubTree(node.left);// ���� ����Ʈ���� Ű���� ������������ ǥ��
//			printSubTree(node.right); // ������ ����Ʈ���� Ű���� ������������ ǥ��
//			System.out.println(node.key+ " " + node.data); // node�� ǥ��
		}
	}
	
	//---��ü ��带 Ű���� ������������ ǥ��---//
	public void print() {
		printSubTree(root);
	}
}

