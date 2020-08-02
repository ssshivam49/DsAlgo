/*
  @developed by Shivam
*/

boolean util(Node root, Height ht){
        if(root == null){
            ht.h=0;
            return true;
        }
        
        Height lh = new Height();
        Height rh = new Height();
        
        boolean lcheck = util(root.left, lh);
        boolean rcheck = util(root.right, rh);
        
        ht.h = Integer.max(lh.h,rh.h)+1;
        
        return lcheck && rcheck && (Math.abs(lh.h - rh.h) <= 1);
    }
     
    boolean isBalanced(Node root)
    {
	    Height h = new Height();
	    return util(root,h);
    }
