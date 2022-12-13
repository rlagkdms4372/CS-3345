import java.util.*;
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>{

	// The Author Code Start
    public BinarySearchTree( ){
        root = null;
    }


    public void makeEmpty( ){
        root = null;
    }

    public boolean isEmpty( ){
        return root == null;
    }


    public void insert( AnyType x ){
        root = insert( x, root );
    }
    
    private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t ){
        if( t == null )
            return new BinaryNode<>( x, null, null );
        
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = insert( x, t.left );
        else if( compareResult > 0 )
            t.right = insert( x, t.right );
        else
            ;  // Duplicate; do nothing
        return t;
    }

    public void remove( AnyType x ){
        root = remove( x, root );
    }
    
    private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t ){
        if( t == null )
            return t;   // Item not found; do nothing
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = remove( x, t.left );
        else if( compareResult > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
            t.element = findMin( t.right ).element;
            t.right = remove( t.element, t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

    
    public AnyType findMin( ){
        if( isEmpty( ) )
            throw new UnderflowException( );
        return findMin( root ).element;
    }
    
    
    private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t ){
        if( t == null )
            return null;
        else if( t.left == null )
            return t;
        return findMin( t.left );
    }

    
    public AnyType findMax( ){
        if( isEmpty( ) )
            throw new UnderflowException( );
        return findMax( root ).element;
    }
    
    
    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t ){
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }

    
    public boolean contains( AnyType x ){
        return contains( x, root );
    }

    
    private boolean contains( AnyType x, BinaryNode<AnyType> t ){
        if( t == null )
            return false;
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            return contains( x, t.left );
        else if( compareResult > 0 )
            return contains( x, t.right );
        else
            return true;    // Match
    }

    
    public void printTree( ){
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( root );
    
    }
    
    
    private void printTree( BinaryNode<AnyType> t ){
        if( t != null )
        {
            printTree( t.left );
            System.out.print( t.element + " ");
            printTree( t.right );
        }
    }

    private int height( BinaryNode<AnyType> t ){
        if( t == null )
            return -1;
        else
            return 1 + Math.max( height( t.left ), height( t.right ) );    
    }
    
    private static class BinaryNode<AnyType>{
        // Constructors
    	BinaryNode( AnyType theElement ){
    		this( theElement, null, null );
    	}

    	BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt ){
    		element  = theElement;
    		left     = lt;
    		right    = rt;
    	}

    	AnyType element;            // The data in the node
    	BinaryNode<AnyType> left;   // Left child
    	BinaryNode<AnyType> right;  // Right child
    }



  /** The tree root. */
    private BinaryNode<AnyType> root;


    // The Author Code End
    ////////////////////////////////////////////////////////////////////////////////////////////
    
    // My Own Code Start
    
    // This method is to count the number of node
    // I'll use the recursive method
	public int countNode() {
		return countNode(root); // return the number of node
	}
	// This method is to figure out the number of node
    private int countNode(BinaryNode<AnyType> root)
    {	// If the root or node is null, then return 0 and end of recursion
        if( root == null )
            return 0;
        // else is to use the recursion and count the number of node and add 1 by each recursion to count the number of node
        else
            return countNode(root.left) + countNode(root.right) + 1;    
    }
    
    
    
    // This method is to check whether this binary search tree is Full or not
    public boolean isFull() {
    	
    	return isFull(root); // return whether this search tree is Full or not
    }
    private boolean isFull(BinaryNode<AnyType> root) {
    	// when the root of search tree is null, then It is full
    	if(root == null) {
    		return true; // so return true
    	
    	// When the parent or root have only one child node, then it is not the Full
    	}else if((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
    		return false; // so return false
    		
    	// When the parent or root has their child node
    	}else if((root.left != null) && (root.right != null)) {
    		return isFull(root.left) && isFull(root.right); // check all the node (left and right respectively)
    		
    	}else { // the else case is when root.left and root.right are null --> it is full
    		return true; // so return true
    	}
    }
    
    
    // This method is to check whether these two binary search tree have same structure or not
    public boolean compareStructure(BinaryNode<AnyType> root2) {
    	return compareStructure(this.root, root2); // return whether these search trees have same structure or not
    }
    
    private boolean compareStructure(BinaryNode<AnyType> root1, BinaryNode<AnyType> root2){
    // If both of tree are null then return true because they are have same structure
    	if(root1 == null && root2 == null) {
    		return true;
    	// When one has its left child, but the other one doesn't have its left child
    	}else if(((root1.left != null) && (root2.left == null)) || ((root1.left == null) && root2.left != null)) {
    		return false; // return false because it doesn't have the same structure
    		// When one has its right child, but the other one doesn't have its right child
    	}else if(((root1.right != null) && (root2.right == null)) || ((root1.right == null) && root2.right != null)) {
    		return false;// return false because it doesn't have the same structure
    	// when both have the same structure
    	}else // then I'll recurse it until they reach out the end of the tree
    		return compareStructure(root1.left, root2.left) && compareStructure(root1.right, root2.right);
    }
    
    
    // This method is to check whether these two binary search tree are equal or not
    public boolean equals(BinaryNode<AnyType> root2) {
    	return equals(this.root, root2); // return whether these search trees are equal or not
    }
    private boolean equals(BinaryNode<AnyType> root1, BinaryNode<AnyType> root2) {
    	 // If both of tree are null then return true because they are same
    	if(root1 == null && root2 == null) {
    		return true;
    	// If the two trees are the same, they have the same structure
    	}else if(compareStructure(root1, root2)) {
    		// and when they have the same element
    		if(root1.element ==root2.element) {
    			// I'll recurse it until they reach out the end of the tree
    			return equals(root1.left, root2.left) && equals(root1.right, root2.right);
    			// when they have the different element
    		} else
    			// return false
    			return false;
    	}else // If the two tree don't have the same structure
    		return false; // return false
    }
    
    // This method is to copy the binary search tree
    public BinarySearchTree<AnyType> copy(){
    	//Initialize the binary search tree will be copied
    	BinarySearchTree<AnyType> coppy = new BinarySearchTree<>();
    	// return the copied binary search tree by recursion
    	return copy(this.root, coppy);
    }
    
    private BinarySearchTree<AnyType> copy(BinaryNode<AnyType> root, BinarySearchTree<AnyType> coppy){
    	// if the root is null, then the copied tree is also null
    	if(root == null) {
    		coppy = null;
    		return coppy;
    	// if the root isn't null, then copy the node 
    	}else {
    		// insert the root's element
    		coppy.insert(root.element);
    		// if the left root isn't null, then be ready to copy the root left by using the recursion
    		if(root.left != null) {
    			copy(root.left, coppy);
    		}
    		// if the right root isn't null, then be ready to copy the root right by using the recursion
    		if(root.right != null) {
    			copy(root.right, coppy);
    		}
    		// return the coppy, which is the binary search tree copied
    	return coppy;
    	}
    }
    
    // This method is to mirror the binary search tree
    public BinarySearchTree<AnyType> mirror(){
    	// Copy the binary Search Tree to be mirrored
    	BinarySearchTree<AnyType> mirrorred = copy();
    	// starting to mirroring the binary search tree
    	mirrorred.root =  mirror(this.root, mirrorred);
    	// After mirroring, return the mirrored binary search tree
      	return mirrorred;
    	
    }
    
    private BinaryNode<AnyType> mirror(BinaryNode<AnyType> rroot, BinarySearchTree<AnyType> mirrorred){
    //	BinaryNode<AnyType> mirrorr = new BinaryNode<>(rroot.element, null, null);
    	// if the root is null
    	if(rroot == null) {
    		// then the mirror is also null
    		return null;
    	}
    	// if root is not the null
    	else {
    		
    		BinaryNode<AnyType> mirrorr = new BinaryNode<>(rroot.element, null, null);
    		BinaryNode<AnyType> swap;
    		BinaryNode<AnyType> swapp;
    		
    		//swap = mirrorred.root.right;
    		// the mirror's left become the root right because it is mirrored
    		mirrorr.left = mirror(rroot.right, mirrorred);
    	//	mirror(rroot.left, mirrorred);
    		
    	//	swapp = mirrorred.root.left;
    		// the mirror's right become the root left because it is mirrored
    		mirrorr.right = mirror(rroot.left, mirrorred);
    	//	mirror(rroot.right, mirrorred);
    		
    		// return the mirroorr node
    		return mirrorr;
    	}
    		
    }
    
    // This boolean is to check the two trees are mirror each other or not
    public boolean isMirror(BinarySearchTree<AnyType> tree1) {
    	// to check, make the mirror for the input tree 
    		tree1 = tree1.mirror();
    		// to check whether these two are mirror
    		return isMirror(this.root, tree1.root);
    }
    
    private boolean isMirror(BinaryNode<AnyType> root1, BinaryNode<AnyType> root2) {
    	// If the root 1 and root2 are null, then they are mirrored. So return true
    		if(root1 == null && root2 == null) {
    			return true;
    		// if both are null, then check the element are same, and recursing the each childnode are same or not
    		}else if (root1 != null && root2 != null) {
    			if(root1.element == root2.element) {
    				if(isMirror(root1.left, root2.left) && isMirror(root1.right, root2.right))
    					return true;
    				else
    					return false; // if child node are different then return false
    			}else
    				return false; // if the elements are two nodes are different, return false
    		}else
    			return false;// if one is null but the other one is not, return false
    }
    
    // Single rotating right
    public void rotateRight(AnyType pivot){
    	// the parentNode is the parent node of input pivot
    	BinaryNode<AnyType> parentNode = parentNode(root, pivot);
    	// the parentParentNode is the parent node of the parent node
    	BinaryNode<AnyType> paprentParentNode = parentNode(root, parentNode.element);
    	// I'll rotate right, so ppivot is the left node
    	BinaryNode<AnyType> ppivot = parentNode.left;
    	
    	// if the current tree root is null
    	if(root == null) {
    		// I make any action didn't take
    		return;
    	// if the current tree root is not null
     	}else {
     		// if the parent node is same as the root, which mean parentParentNode does not exist
     		if(parentNode == root) {
     		//the left root becomes the right of parentNode'left
     		root.left = ppivot.right;
     		//and pprivot's left become root because the root is smaller than the pivot for the left rotation
     		ppivot.right = root;
     		// root becomes ppivot
     		root = ppivot;
     		return;
     		}
     		// the parentParentNode's left becomes ppivot
     		paprentParentNode.left = ppivot;
     		// and parentNode's left becomes the ppivot's right
    		parentNode.left = ppivot.right;
    		// and ppivot right becomes parentNode after rotation
    		ppivot.right = parentNode;
     		
    	}
    }
    

    public void rotateLeft( AnyType pivot){
    	// the parentNode is the parent node of input pivot
    	BinaryNode<AnyType> parentNode = parentNode(root, pivot);
    	// the parentParentNode is the parent node of the parent node
    	BinaryNode<AnyType> paprentParentNode = parentNode(root, parentNode.element);
    	// I'll rotate right, so ppivot is the right node
    	BinaryNode<AnyType> ppivot = parentNode.right;
    	
    	// if the current tree root is null
    	if(root == null) {
    		// I make any action didn't take
    		return;
    	// if the current tree root is not null
    	}else {
    		// if the parent node is same as the root, which mean parentParentNode does not exist
     		if(parentNode == root) {
     		//root right beomes pivot's left
     		root.right = ppivot.left;
     		//and pprivot's left become root because the root is smaller than the pivot for the left rotation
     		ppivot.left = root;
     		//Finally, root becomes ppivot
     		root = ppivot;
     		return;
     		}
     	// the parentParentNode's right becomes ppivot
     		paprentParentNode.right = ppivot;
     	// and parentNode's right becomes the ppivot's left
    		parentNode.right = ppivot.left;
    	// and ppivot left becomes parentNode after rotation
    		ppivot.left = parentNode;
     		
    	}
    }
    // To find the parentNode with current given the pivot
    private BinaryNode<AnyType> parentNode(BinaryNode<AnyType> root, AnyType pivot){
    	// when the pivot is equal to the root left element or root right element
    	if((pivot == root.left.element)|| (pivot == root.right.element)){
    		return root; // it means r
    	}else if(pivot.compareTo(root.right.element) > 0) {
    		root = parentNode(root.right, pivot);
    	}else if(pivot.compareTo(root.left.element) < 0) {
    		root = parentNode(root.left, pivot);
    	} 	
    	return root;
    }
    
    
    // Print level by level by printing of the tree
    public void printLevel() {
    	printLevel(root);
    }
    // I'll use queue to output the level, it has the characteristic of BFS
    // It must be used queue to output in order (First in and First out)
    private void printLevel(BinaryNode<AnyType> root) {
    	// Initializing the queue from LinkedList
    	Queue<BinaryNode<AnyType>> queue = new LinkedList<>();
    	// First of all, add the root into queue, and its (the root's) level is zero
    	queue.add(root);
    	int level = 0;

    	// Until queue is empty, I'll keep doing the below process
    	while(! queue.isEmpty()) {
    		
    		// I make the array List to store each level's node
    		ArrayList<AnyType> llevel = new ArrayList<>();
    		// To figuring out the queue size
    		int numNode = queue.size();
  
    		// By using the queue size, I'll make for-loop
    		for(int i = 0; i < numNode; i++) {
    			BinaryNode<AnyType> data = queue.remove();
    		//	System.out.print(data.element + " ");
    			llevel.add(data.element);
    			// if the data's left exists
    			if(data.left != null) {
    				// keep going to add the data on left
    				queue.add(data.left);
    			}
    			// if the data's right exist
    			if(data.right != null) {
    				// keep going to add the data on right
    				queue.add(data.right);
    			}
    			
    		}
    		//print out the nodes on each level
    		System.out.print("Level "+ level + ":  ");
			System.out.println(llevel);
    		level = level + 1;
    	}
    	
    }


    public static void main(String [] args) {
    	 BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    	 tree.insert(65);
    	 tree.insert(16);
    	 tree.insert(13);
    	 tree.insert(52);
    	 tree.insert(28);
    	 tree.insert(11);
    	 tree.insert(20);
    	 tree.insert(14);
    	 tree.insert(87);
    	 tree.insert(50);
    	 tree.insert(26);
    	 
    	 BinarySearchTree<Integer> tree1 = new BinarySearchTree<>();
    	 tree1.insert(68);
    	 tree1.insert(52);
    	 tree1.insert(46);
    	 tree1.insert(80);
    	 tree1.insert(78);
    	 tree1.insert(71);
    	 tree1.insert(93);
    	 tree1.insert(88);
    	 tree1.insert(100);
   
    	 BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
    	 tree2.insert(15);
    	 tree2.insert(10);
    	 tree2.insert(20);
    	 tree2.insert(8);
    	 tree2.insert(12);
    	 tree2.insert(18);
    	 tree2.insert(25);
    	 
    	 BinarySearchTree<Integer> tree3 = new BinarySearchTree<>();
    	 tree3.insert(45);
    	 tree3.insert(30);
    	 tree3.insert(50);
    	 tree3.insert(28);
    	 tree3.insert(32);
    	 tree3.insert(47);
    	 tree3.insert(52);
    	 
    	 BinarySearchTree<Integer> tree4 = new BinarySearchTree<>();
    	 tree4.insert(50);
    	 tree4.insert(40);
    	 tree4.insert(30);
    	 tree4.insert(70);
    	 tree4.insert(65);
    	 tree4.insert(60);
    	 tree4.insert(80);
    	 tree4.insert(75);
    	 tree4.insert(90);
    	 
    	 BinarySearchTree<Integer> tree5 = new BinarySearchTree<>();
    	 tree5.insert(5);
    	 tree5.insert(3);
    	 tree5.insert(8);
    	 tree5.insert(1);
    	 tree5.insert(4);
    	 
    	 
    	 BinarySearchTree<Integer> tree6 = new BinarySearchTree<>();
    	 tree6.insert(10);
    	 tree6.insert(5);
    	 tree6.insert(15);
    	 tree6.insert(2);
    	 tree6.insert(7);
    	 
    	 BinarySearchTree<Integer> tree7 = new BinarySearchTree<>();
    	 tree7.insert(10);
    	 tree7.insert(5);
    	 tree7.insert(15);
    	 tree7.insert(2);
    	 tree7.insert(7);
    	 
    	 BinarySearchTree<Integer> tree8 = new BinarySearchTree<>();
    	 tree8.insert(10);
    	 tree8.insert(5);
    	 tree8.insert(14);
    	 tree8.insert(2);
    	 tree8.insert(7);
    	 
    	 BinarySearchTree<Integer> tree9 = new BinarySearchTree<>();
    	 tree9.insert(50);
    	 tree9.insert(40);
    	 tree9.insert(30);
    	 tree9.insert(70);
    	 tree9.insert(65);
    	 tree9.insert(60);
    	 tree9.insert(80);
    	 tree9.insert(75);
    	 tree9.insert(90);
    	 
    	 BinarySearchTree<Integer> tree0 = new BinarySearchTree<>();
    	 tree0.insert(100);
    	 tree0.insert(50);
    	 tree0.insert(150);
    	 tree0.insert(40);
    	 tree0.insert(45);
    	 
    	 BinarySearchTree<Integer> pp = new BinarySearchTree<>();
    		 pp.insert(10);
    		 pp.insert(7);
    		 pp.insert(20);
    		 pp.insert(15);
    		 pp.insert(23);
    		
    		 
    	 
    	 
    	
    	 System.out.println("Named tree : ");
    	 tree.printTree();
    	 System.out.println(" ");
    	 
    	 System.out.println("Named tree1 : ");
    	 tree1.printTree();
    	 System.out.println(" ");
    	 
    	 System.out.println("Named tree2 : ");
    	 tree2.printTree();
    	 System.out.println(" ");
    	 
    	 System.out.println("Named tree3 : ");
    	 tree3.printTree();
    	 System.out.println(" ");
    	 
    	 System.out.println("Named tree4 : ");
    	 tree4.printTree();
    	 System.out.println(" ");
    	 
    	 System.out.println("Named tree5 : ");
    	 tree5.printTree();
    	 System.out.println(" ");
    	 
    	 System.out.println("Named tree6 : ");
    	 tree6.printTree();
    	 System.out.println(" ");
    	 
    	 System.out.println("Named tree7 : ");
    	 tree7.printTree();
    	 System.out.println(" ");
    	 
    	 System.out.println("Named tree8 : ");
    	 tree8.printTree();
    	 System.out.println(" ");
    	 
    	 System.out.println("Named tree9 : ");
    	 tree9.printTree();
    	 System.out.println(" ");
    	 
    	 
    	 // For the countNode method
    	 // The number of node version 1
    	 System.out.println("The number of node of tree: " + tree.countNode());
    	// The number of node version 2
    	 System.out.println("The number of node of tree1: " + tree1.countNode());
    	// The number of node version 3
    	 System.out.println("The number of node of tree2: " + tree2.countNode());
    	 
    	 
    	 // For the isFull() method
    	 // Check isFull() method for not full tree
    	 System.out.println("Is this tree full?: " + tree.isFull());
    	// Check isFull() method for not full tree
    	 System.out.println("Is this tree1 full?: " + tree1.isFull());
    	// Check isFull() method for full tree
    	 System.out.println("Is this tree2 full?: " + tree2.isFull());
    	 
    	 
    	 // For the compareStructure method
    	 // Check compareStructure method for false (not same structure)
    	 System.out.println("Do tree and tree1 have same Structure?: " +tree.compareStructure(tree1.root));
    	// Check compareStructure method for true (same structure)
    	 System.out.println("Do tree2 and tree3 have same Structure?: " +tree2.compareStructure(tree3.root));
    	// Check compareStructure method for false (not same structure)
    	 System.out.println("Do tree3 and tree5 have same Structure?: " +tree3.compareStructure(tree5.root));
    	// Check compareStructure method for true (same structure)
    	 System.out.println("Do tree1 and tree4 have same Structure?: " +tree4.compareStructure(tree1.root));
    	 // Example from the project#2 explanation (true)
    	 System.out.println("Do tree5 and tree6 have same Structure?: " + tree5.compareStructure(tree6.root));
    	 
    	 
    	 //For the equals method
    	 // Check equals method for true
    	 System.out.println("Do tree6 and tree7 equal?: " +tree6.equals(tree7.root));
    	// Check equals method for false (only one node element is changes
    	 System.out.println("Do tree7 and tree8 equal?: " +tree8.equals(tree7.root));
    	// Check equals method for true
    	 System.out.println("Do tree4 and tree9 equal?: " +tree9.equals(tree4.root));
    	// Check equals method for false
    	 System.out.println("Do tree1 and tree5 equal?: " +tree1.equals(tree5.root));
    	 
    	 
    	 //For the copy method
    	 // Copy the tree 2
    	 System.out.print("Copy tree2: ");
    	 tree2.copy();
    	 System.out.println();
    	 // Copy the tree 5
    	 System.out.print("Copy tree5: ");
    	 tree2.copy();
    	 System.out.println();
    	 // Copy the tree 8
    	 System.out.print("Copy tree:8 ");
    	 tree2.copy();
    	 System.out.println();

    	 
    	 //For the mirror method
    	 // Mirror the tree 0
    	 System.out.println("Original tree0: ");
    	 tree0.printLevel();
    	 System.out.println();
    	 System.out.println("mirror tree0: ");
    	 BinarySearchTree<Integer> nn0 = tree0.mirror();
    	 nn0.printLevel();
    	 System.out.println();
    	// Mirror the tree 3
    	 System.out.println("Original tree3: ");
    	 tree3.printLevel();
    	 System.out.println("mirror tree3: ");
    	 BinarySearchTree<Integer> nn3 = tree3.mirror();
    	 nn3.printLevel();
    	 System.out.println();
    	// Mirror the tree 6
    	 System.out.println("Original tree6: ");
    	 tree6.printLevel();
    	 System.out.println("mirror tree6: ");
    	 BinarySearchTree<Integer> nn6 = tree6.mirror();
    	 nn6.printLevel();
    	 System.out.println();
    	 
    	 
    	 //For the isMirror method
    	 // Check isMirror with nn0 and tree0
    	 System.out.println("Are these two mirror?: " + tree0.isMirror(nn0));
    	// Check isMirror with nn3 and tree3
    	 System.out.println("Are these two mirror?: " + nn3.isMirror(tree3));
    	// Check isMirror with nn6 and tree4
    	 System.out.println("Are these two mirror?: " + nn6.isMirror(tree4));
    	 // Check isMirror with nn6 and tree6
    	 System.out.println("Are these two mirror?: " + tree6.isMirror(nn6));
    	 
    	 // For the right rotation
    	 tree0.rotateRight(50);
    	 System.out.println("The right rotation for tree 0 with 50: ");
    	 tree0.printLevel();
    	 System.out.println();
    	 
    	 tree.rotateRight(11);
    	 System.out.println("The right rotation for tree with 11: ");
    	 tree.printLevel();
    	 System.out.println();
    	 
    	// For the left rotation
    	 tree3.rotateRight(50);
    	 System.out.println("The left rotation for tree 3 with 50: ");
    	 tree3.printLevel();
    	 System.out.println();
    	 
    	 tree5.rotateRight(8);
    	 System.out.println("The left rotation for tree5 with 8: ");
    	 tree5.printLevel();
    	 System.out.println();
    	 
    	 // Printing the tree by level
    	 System.out.println("Printing the tree2 by level: ");
    	 tree2.printLevel();
    	 System.out.println();
    	 
    	 System.out.println("Printing the tree4 by level: ");
    	 tree4.printLevel();
    	 System.out.println();
    	 
    }

}


