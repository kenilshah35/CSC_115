/*
* Name: Kenil C. Shah
* ID: V00903842
* Date: 15 July 2018
* Filename: BinaryTree.java
* Details: CSc 115 Assignment 4
*/


import java.util.Iterator;

/**
 * BinaryTree is a basic generic BinaryTree data structure.
 * It is referenced based, using TreeNodes to connect the tree.
 * It contains any element determined by the placeholder E.
 * The basic ADT is adapted from <i>Java, Walls &amp; Mirrors,</i> by Prichard and Carrano.
 */
public class BinaryTree<E> {

	protected TreeNode<E> root;

	/**
	 * Create an empty BinaryTree.
	 */
	public BinaryTree() {
	}

	/**
	 * Create a BinaryTree with a single item.
	 * @param item The only item in the tree.
	 */
	public BinaryTree(E item) {
		root = new TreeNode<E>(item);
	}

	/**
	 * Used only by subclasses and classes in the same package (directory).
	 * @return The root node of the tree.
	 */
	protected TreeNode<E> getRoot() {
		return root;
	}

	/**
	 * Creates a binary tree from a single item for the root and two subtrees.
	 * Once the two subtrees are attached, their references are nullified to prevent
	 * multiple entries into <i>this</i> tree.
	 * @param item The item to be inserted into the root of this tree.
	 * @param leftTree A binary tree, which may be empty.
	 * @param rightTree A binary tree, which may be empty.
	 */
	public BinaryTree(E item, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		root = new TreeNode<E>(item);
		attachLeftSubtree(leftTree);
		attachRightSubtree(rightTree);
	}

	/**
	 * Attaches a subtree to the left of the root node, replacing any subtree that was 
	 * previously there.
	 * @param left The new left subtree of the root.
	 *	This subtree may be empty.
	 *	Once attached, this parameter reference is nullified to prevent multiple
	 *	access to <i>this</i> tree.
	 * @throws TreeException if <i>this</i> tree is empty.
	 */
	public void attachLeftSubtree(BinaryTree<E> left) {
		if (root == null) {
			throw new TreeException("Cannot attach to an empty tree.");
		}
		if (left == null) {
			return;
		}
		root.left = left.root;
		left.root.parent = root;
		left = null;
	}

	/**
	 * @return a preorder iterator of the binary tree.
	 */
	public Iterator<E> preorderIterator() {
		return new BinaryTreeIterator<E>("preorder",root);
	}

	/**
	 * @return an inorder iterator of the binary tree.
	 */
	public Iterator<E> inorderIterator() {
		return new BinaryTreeIterator<E>("inorder", root);
	}

	/**
	 * @return a postorder iterator of the binary tree.
	 */
	public Iterator<E> postorderIterator() {
		return new BinaryTreeIterator<E>("postorder",root);

	}

	/**
	 * @return True if the tree is empty, false otherwise.
	*/
	public boolean isEmpty() {
		return (root == null);
	}
	
	/**
	 * Attaches a subtree to the right of the root node, replacing any subtree that was 
	 * previously there.
	 * @param right The new left subtree of the root.
	 *	This subtree may be empty.
	 *	Once attached, this parameter reference is nullified to prevent multiple
	 *	access to <i>this</i> tree.
	 * @throws TreeException if <i>this</i> tree is empty.
	 */
	public void attachRightSubtree(BinaryTree<E> right) {
		
		if (root == null) {
			throw new TreeException("Cannot attach to an empty tree.");
		}
		if (right == null) {
			return;
		}
		
		root.right = right.root;
		right.root.parent = root;
		right = null;
	}
		
	/**
	 * The maximum number of nodes from the root to the leaf
	 * @return int height of the tree 
	*/
	public int height() {
		
		return height(root);
	}
	
	/*
	 * Private helper method height used to find the 
	 * height of the tree, recursively.
	*/
	private int height(TreeNode<E> node) {
		
		if(node == null) return 0;
		
		if(height(node.left)>height(node.right)) return height(node.left) + 1;
		else return height(node.right) + 1;
	}


}

	
