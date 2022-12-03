/*
* Name: Kenil C. Shah
* ID: V00903842
* Date: 15 July 2018
* Filename: BinarySearchTree.java
* Details: CSc 115 Assignment 4
*/


import java.util.Iterator;

/**
 * BinarySearchTree is an ordered binary tree, where the element in each node
 * comes after all the elements in the left subtree rooted at that node
 * and before all the elements in the right subtree rooted at that node.
 * For this assignment, we can assume that there are no elements that are
 * identical in this tree. 
 * A small modification will allow duplicates.
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	// the root is inherited from BinaryTree.

	/**
	 * Create an empty BinarySearchTree.
	 */
	public BinarySearchTree() {
		super();
	}

	/**
	 * Creates a BinarySearchTree with a single item.
	 * @param item The single item in the tree.
	 */
	public BinarySearchTree(E item) {
		super(item);
	}

	/**
 	 * <b>This method is not allowed in a BinarySearchTree.</b>
	 * It's description from the subclass:<br>
	 * <br>
	 * {@inheritDoc}
	 * @throws UnsupportedOperationException if this method is invoked.
	 */
	public void attachLeftSubtree(BinaryTree<E> left) {
		throw new UnsupportedOperationException();
	}
	
	/**
 	 * <b>This method is not allowed in a BinarySearchTree.</b>
	 * It's description from the subclass:<br>
	 * <br>
	 * {@inheritDoc}
	 * @throws UnsupportedOperationException if this method is invoked.
	 */
	public void attachRightSubtree(BinaryTree<E> right) {
		throw new UnsupportedOperationException();
	}

	/**
	 *Inserts a new item into the tree, maintaining its order. 
	 *If the item already exists in the tree, nothing happens
	 *@param item - The newest item
	*/
	public void insert(E item){
		
		root = insert(root,item);
	}
	/*
	 *a private helper method used to insert item in
	 *the binary search tree without disturbing the order.
	*/
	private TreeNode<E> insert(TreeNode<E> node, E item)
	{
		//base case
		if(node==null) return new TreeNode<E>(item);
		
		//compares item with the item of the node
		int n = item.compareTo(node.item);
		
		//condition if item is smaller than node item
		if(n<0){
			
			TreeNode<E> leftChild = insert(node.left,item);
			node.left = leftChild;
			leftChild.parent = node;
			return node;
		}
		
		//condition if item is bigger than node item
		TreeNode<E> rightChild = insert(node.right,item);
		node.right = rightChild;
		rightChild.parent = node;
		return node;
	}
	
	/**
	 *Looks for the item in the tree that is equivalent to the item.
	 *@param item - The item that is equivalent to the item we are looking for.
	 *				Equality is determined by the equals method of the item.
	 *@return The item if it's in the tree, null if it is not.
	*/
	public E retrieve(E item) {
		TreeNode<E> searchNode = search(root,item);
		return searchNode.item;
	}
	
	/**
	 *Finds the item that is equivalent to the item and removes it, if it's in the tree.
	 *@param item - The item that is equivalent to the item we are looking for.
	 *				Equality is determined by the equals method of the item.
	 *@return The actual item that was removed, or null if it is not in the tree.
	*/
	public E delete(E item) {
		return delete(root,item);
	}
	
	/*
	 *Private helper method delete used to delete items in 
	 *binary search trees without distubing the order
	*/
	private E delete(TreeNode<E> node, E item){
		
		//searches for the node with the item to be deleted
		TreeNode<E> targetNode = search(node,item);
		
		//returns null if node not found
		if(targetNode == null) return null;
		
		TreeNode<E> parentNode = targetNode.parent;
		
		//leaf
		if(targetNode.left == null && targetNode.right == null){
			
			if(targetNode.item.compareTo(parentNode.item) >= 0){
				
				targetNode.parent.right = null;
			}
			
			else if(targetNode.item.compareTo(parentNode.item) < 0 ){
				targetNode.parent.left = null;
			}
			
		}
		
		// two children
		else if(targetNode.left != null && targetNode.right != null){
			
			TreeNode<E> temp = findLeftMost(targetNode.right);
			targetNode.item = temp.item;
			E trashItem = delete(targetNode.right,temp.item);
		}
		
		//single left child
		else if(targetNode.left != null && targetNode.right == null){
			
			targetNode.item = targetNode.left.item;
			E trashItem = delete(targetNode.left,targetNode.left.item);				
		}
		
		//single right child
		else if(targetNode.left == null && targetNode.right != null){
			
			targetNode.item = targetNode.right.item;
			E trashItem = delete(targetNode.right,targetNode.right.item);
		}
			
		return item;
	}
	
	/*
	 * A private helper method findLeftMost used to find the 
	 * the left most in order successor of a node
	*/
	private TreeNode<E> findLeftMost(TreeNode<E> node){
		
		if(node.left == null) return node;
		
		return findLeftMost(node.left);
	}
	
	/*
	 * A private helper method search used to find a tree node 
	 * based on the item provided
	*/
	private TreeNode<E> search(TreeNode<E> node, E searchKey){
		
		if(node == null) return null;
		
		if(searchKey.compareTo(node.item) > 0) return search(node.right, searchKey);
		
		if(searchKey.compareTo(node.item) < 0) return search(node.left, searchKey);
		
		return node;
		
	}

	/**
	 * Internal test harness.
	 * @param args Not used.
	 */
	public static void main(String[] args) {

		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		String s1 = new String("optimal");
		String s2 = new String("needs");
		String s3 = new String("programmers");
		String s4 = new String("CSC115");
		tree.insert(s1);
		tree.insert(s2);
		tree.insert(s3);
		tree.insert(s4);
		String test = tree.retrieve("needs");
		if (test != null && !test.equals("")) {
			System.out.println("retrieving the node that contains "+s2);
			if (test.equals(s2)) {
				System.out.println("Confirmed");
			} else {
				System.out.println("retrieve returns the wrong item");
			}
		} else {
			System.out.println("retrieve returns nothing when it should not");
		}
		Iterator<String> it = tree.inorderIterator();
		System.out.println("printing out the contents of the tree in sorted order:");
		while (it.hasNext()) {
			System.out.print(it.next()+" ");
		} 
		System.out.println();
		//DrawableBTree<String> dbt = new DrawableBTree<String>(tree);
		//dbt.showFrame();
		
		//Self Testing
		BinarySearchTree<Integer> tree1 = new BinarySearchTree<Integer>();
		tree1.insert(20);
		tree1.insert(18);
		tree1.insert(19);
		tree1.insert(11);
		tree1.insert(14);
		tree1.insert(25);
		tree1.insert(22);
		tree1.insert(27);
		tree1.insert(-1);
		tree1.insert(-34);
		tree1.insert(30);
		tree1.insert(23);
		tree1.insert(78);
		
		
		int test1 = tree1.retrieve(20);
		System.out.println(test1);
		
		
		DrawableBTree<Integer> dbt1 = new DrawableBTree<Integer>(tree1);
		dbt1.showFrame();
		
		int test2 = tree1.delete(14);
		
		int test3 = tree1.delete(25);
		
		int test4 = tree1.delete(20);
		
		int test5 = tree1.delete(11);
		
		DrawableBTree<Integer> dbt3 = new DrawableBTree<Integer>(tree1);
		dbt3.showFrame();
		
	}
}

	

	
