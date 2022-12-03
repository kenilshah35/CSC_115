/**
  Derived from page 582 of J. J. Prichard and F. M. Carrano, 3rd Edition.
*/
import java.util.Queue;
import java.util.LinkedList;

public class SBinaryST
{
	private STreeNode root;
	
	//default constructor, construct an empty string binary search tree
	public SBinaryST(){
		
		root=null;
	}
	
	//return true if the tree is empty, false otherwise
	public boolean isEmpty(){
		
		return (root==null);
	}
	
	//make the tree empty
	public void makeEmpty(){
		
		root = null;
	}
	
	//return the string at root, throw a TreeException if it is empty
	public String getRootStr(){
		
		if(this.isEmpty()== true) throw new TreeException("The tree is empty");
		return root.item; 
	}
	
	//insert the string str into the binary search tree (in alphabetical order)
	public void insert(String str){
		
		root = insert(root,str);
	}
	
	//insert the string str into the binary search sub-tree rooted at node(in alphabetical order)
	private STreeNode insert(STreeNode node, String str)
	{
		if(node==null) return new STreeNode(str);
		
		int n = str.compareTo(node.item);
		
		if(n<0){
			
			node.left = insert(node.left,str);
			return node;
		}
		
		node.right = insert(node.right,str);
		return node;
	}
	
	//return a string representation of the shape of the tree, tilted 90 degrees
	public String printTree()
	{
		//optional
		return null;
	}
	
	//StringBuilder object "output" contains the shape of the tree, tilted 90 degrees
	private void printTree(STreeNode node, int indent,StringBuilder output)
	{
		//optional
	}
	
	//return the height of the tree. return 0 is the tree is null
	public int height(){
		
		return height(root);
	}
	
	//return the height of the tree rooted at node. return 0 is the node is null
	private int height(STreeNode node){
		
		if(node == null) return 0;
		
		if(height(node.left)>height(node.right)) return height(node.left) + 1;
		else return height(node.right) + 1;
	}
	//return string representation of the tree, one level at a time
	public String levelOrderStr()
	{
		Queue<STreeNode> q = new LinkedList<STreeNode>();
		StringBuilder s = new StringBuilder("{"); 
		STreeNode temp = root;
		q.add(root);
		
		while(!q.isEmpty()){
			STreeNode n = q.remove();
			
			if(n != null){
				s.append(n.item);
				s.append(", ");
			}
			
			if(n.left != null) q.add(n.left);
			if(n.right != null) q.add(n.right);
		}
		
		int i = s.lastIndexOf(",");
		s.deleteCharAt(i);
		s.deleteCharAt(i);
		s.append('}');
		return s.toString();
	}
	//return the in-order string representation of the tree rooted
	public String toString()
	{
		return inOrderStr();
	}
	
	//return the in-order string representation of the tree rooted
	public String inOrderStr(){

		return inOrder(root);
	}
	
	//return the in-order string representation of the sub tree rooted at node
	private String inOrder(STreeNode node){

		if(node == null) return "";	
		
		return inOrder(node.left) + node.item +" "+inOrder(node.right) ;
	}
	
	//return the post-order string representation of the tree
	public String postOrderStr(){
		
		return postOrder(root);
	}
	
	//return the post-order string representation of the sub tree rooted at node
	private String postOrder(STreeNode node){
		
		if(node == null) return "";	
		
		return postOrder(node.left) + postOrder(node.right) + node.item+ " ";
	}
	
	//return the pre-order string representation of the tree
	public String preOrderStr(){
	
		return preOrder(root);
	}
	//return the pre-order string representation of the sub tree rooted at node
	private String preOrder(STreeNode node){
		
		if(node == null) return "";	
		
		return node.item+ " " + preOrder(node.left) + preOrder(node.right);
	}
	
	public static void main(String[] args)
	{
		SBinaryST tree=new SBinaryST();
		tree.insert("d");
		tree.insert("b");
		tree.insert("a");
		tree.insert("c");
		tree.insert("e");
		System.out.println("inorder: "+tree);
		System.out.println("pre: "+tree.preOrderStr());
		System.out.println("post: "+tree.postOrderStr());
		System.out.println("level: "+tree.levelOrderStr());
		System.out.println("height = "+tree.height());
		System.out.println(tree.printTree());
	}
}