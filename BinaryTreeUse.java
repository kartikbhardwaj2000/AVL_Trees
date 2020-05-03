import java.util.ArrayList;
import java.util.Scanner;


public class BinaryTreeUse {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// BinaryTreeNode<Integer> root1 = takeInputLevelWise();
		// printTree(root1);
		// Pair<Pair<Integer,Integer>,BinaryTreeNode<Integer>> ans = findImbalanceNode(root1);
		

		
		// if(ans.second!=null)
		// {
		// 	System.out.println("the node data of imbalance is "+ans.second.data);
		// System.out.println("the left hight is  "+ans.first.first);
		// System.out.println("the right hight is  "+ans.first.second);
		// //right-left rotation
		// // BinaryTreeNode<Integer> nodeX =rightRotation(ans.second.right);
		// // ans.second.right=nodeX;
		// // BinaryTreeNode<Integer> nodeY=leftRotation(ans.second);

		// //left right rotation
		// BinaryTreeNode<Integer> nodeX = leftRotation(ans.second.left);
		// ans.second.left=nodeX;
		// BinaryTreeNode<Integer> nodeY =rightRotation(ans.second);
        // printTree(nodeY);

		// }

		


		BinarySearchTree bst = new BinarySearchTree();
		bst.insertData(1);
		System.out.println("----------------");
		bst.printTree();
		System.out.println("----------------");

		bst.insertData(2);
		System.out.println("----------------");

		bst.printTree();
		System.out.println("----------------");

		bst.insertData(3);
		System.out.println("----------------");

		bst.printTree();
		System.out.println("----------------");

		bst.insertData(4);
		System.out.println("----------------");

		bst.printTree();
		System.out.println("----------------");

		bst.insertData(5);
		System.out.println("----------------");

		bst.printTree();
		System.out.println("----------------");


		bst.insertData(6);
		System.out.println("----------------");

		bst.printTree();
		System.out.println("----------------");

		bst.insertData(7);
		System.out.println("----------------");

		bst.printTree();
		System.out.println("----------------");

		bst.insertData(8);
		System.out.println("----------------");

		bst.printTree();
		System.out.println("----------------");

		// bst.insertData(11);
		// bst.insertData(7);
		// bst.insertData(6);


		
		// bst.insertData(5);
		// bst.insertData(6);
		// bst.insertData(7);

		
		bst.printTree();
	}
}
