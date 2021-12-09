public class BST {

    public class Node {
        
    	
        public String data;
        public Node left;
        public Node right;

        //constructor
        public Node(String data) 
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    

    public Node root;

    public BST() 
    {
        this.root = null;
    }

    // insert method to insert the new Date
    public void addNode(String newData) {
        this.root = insert(root, newData);
    }

    public Node insert(Node root, String newData) {
        // Base Case: root is null or not
        if (root == null) 
        {
            // Insert the new data, if root is null.
            root = new Node(newData);
            // return the current root to his sub tree
            return root;
        }
        // Here checking for root data is greater or equal to newData or not
        else if (root.data.compareTo(newData)<0) 
        {
            // if current root data is greater than the new data then now process the left sub-tree
            root.left = insert(root.left, newData);
        } 
        
        else 
        {
            // if current root data is less than the new data then now process the right sub-tree
            root.right = insert(root.right, newData);
        }
        return root;
    }

    // method for search the data , is data is present or not in the tree ?
    public boolean search(String data) {
        return search(this.root, data);
    }

    private boolean search(Node root, String data) 
    {
        if (root == null) 
        {
            return false;
        } 
        
        else if (root.data.compareTo(data)==0) 
        {
            return true;
        }
        
        else if (root.data.compareTo(data)<0) 
        {
            return search(root.left, data);
        }
     
        return search(root.right, data);
    }

    //Traversal
    public void preorder() 
    {
        preorder(root);
        System.out.println();
    }

    public void preorder(Node root) 
    {
        if (root == null) 
        {
            return;
        }
 
        System.out.print(root.data + "\n");
        preorder(root.left);
        preorder(root.right);
    }
}