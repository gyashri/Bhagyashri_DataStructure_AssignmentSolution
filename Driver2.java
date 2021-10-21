package assignment3;
import java.util.*;


class Node
{
	int val;
	Node left, right;
	Node(int item)
	{
		val = item;
		left = right = null;
	}
}

public class Driver2{
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;
	static int index;

	static void storeInorder(Node node, int inorder[])
	{

		if (node == null)
			return;


		storeInorder(node.left, inorder);


		inorder[index] = node.val;
		index++; 


		storeInorder(node.right, inorder);
	}


	static int countNodes(Node root)
	{
		if (root == null)
			return 0;
		return countNodes(root.left) + countNodes(root.right) + 1;
	}


	static void arrayToBST(int[] arr, Node root)
	{

		if (root == null)
			return;

		arrayToBST(arr, root.left);


		root.val = arr[index];
		index++;


		arrayToBST(arr, root.right);
	}

	static void binaryTreeToBST(Node root)
	{
		if (root == null)
			return;
		int n = countNodes(root);
		int arr[] = new int[n];
		storeInorder(root, arr);
		Arrays.sort(arr);
		index = 0;
		arrayToBST(arr, root);
	}

	static void printInorder(Node node)
	{
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);
	}

	static void flattenBTToSkewed(Node root,
			int order)
	{
		if(root == null)
		{
			return;
		}
		if(order > 0)
		{
			flattenBTToSkewed(root.right, order);
		}
		else
		{
			flattenBTToSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;
		if(headNode == null)
		{
			headNode = root;
			root.left = null;
			prevNode = root;
		}
		else
		{
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		if (order > 0)
		{
			flattenBTToSkewed(leftNode, order);
		}
		else
		{
			flattenBTToSkewed(rightNode, order);
		}
	}

	static void traverseRightSkewed(Node root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);       
	}

	public static void main(String args[])
	{
		Driver2 tree = new Driver2();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left= new Node(40);
		binaryTreeToBST(tree.node);
		int order = 0;
		flattenBTToSkewed(tree.node, order);
		traverseRightSkewed(headNode);
	}
}