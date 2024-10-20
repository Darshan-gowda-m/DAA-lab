package Darshan;
import java.util.*;
public class BST {
	class Node{
		int key;
		Node left,right;
		public Node(int item)
		{
			key=item;
			left=right=null;
		}
	}
	Node root=null;
	  void insert(int key) {
		root=insertrec(root,key);}
	public Node insertrec(Node root,int key)
	{
		if(root==null)
		return	root=new Node(key);
		if(key<root.key)
			root.left=insertrec(root.left, key);
		else
			root.right=insertrec(root.right,key);
		return root;
	}
	void deleterec(int key)
	{
		root=del(root,key);
	}
	public Node del(Node root,int key)
	{
		if(root==null)
			return root;
		if(key<root.key)
			root.left=del(root.left,key);
		else	if(key>root.key)
			root.right=del(root.right,key);
		else
		{
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			else
			{
				root.key=min(root.right);
				root.right=del(root.right,root.key);
			}
		}
		return root;
	}
	public static int min(Node root)
	{
		int min=root.key;
		while(root.left!=null)
		{
			root=root.left;
			min=root.key;
		}
		return min;
	}
	public void inorder(Node root)
	{
		if(root!=null)
		{
			inorder(root.left);
			System.out.print(root.key+"->");
			inorder(root.right);
		}
	}

	public static void main(String[] args)
	{
		BST p=new BST();
		Scanner sc=new Scanner(System.in);
		p.insert(50);
		p.insert(100);
		p.insert(10);
		p.insert(120);
		p.insert(30);
		p.insert(130);
		p.insert(100);
		p.inorder(p.root);
		System.out.println();
		p.deleterec(50);
		p.inorder(p.root);
		System.out.println();
		p.deleterec(100);
		p.inorder(p.root);
	}
}
