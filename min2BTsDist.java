/*
  @developed by Shivam
*/

Node findLCA(Node root, int a, int b){
        if(root == null || root.data ==a || root.data == b){
            return root;
        }
        
        Node left = findLCA(root.left, a, b);
        Node right = findLCA(root.right, a, b);
        
        if(left != null && right != null){
            return root;
        }
        
        return (left!=null) ? left : right;
    }
    
    int dist(Node root, int key){
        if(root == null){
            return 0;
        }
        
        if(root.data == key){
            return 1;
        }
        
        int left = dist(root.left, key);
        if(left != 0){
            return 1+left;
        }
      
        int right = dist(root.right, key);
        if(right != 0){
            return 1+right;
        }
        
        return 0;
    }
    
    int findDist(Node root, int a, int b) {
        Node lca = findLCA(root, a, b);
        return dist(lca,a)+dist(lca,b)-2;
    }
