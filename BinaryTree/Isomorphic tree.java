// two trees are isomorphic of each other if 
// Case 1 : right child of tree1 == left child of tree 2  &&  left child of tree1 == right child of tree2
// Case 2 : right child of tree1 == right child of tree2  &&  left child of tree1 == left child of tree2


class Solution  
{ 
    boolean isIsomorphic(Node root1, Node root2)  
    { 
         
         if(root1 == null && root2 == null){
             return true;
         }
         
         if(root1 != null && root2 != null){
             if(root1.data == root2.data){
                 return (isIsomorphic(root1.left, root2.right) &&
                 isIsomorphic(root1.right , root2.left)) || 
                 (isIsomorphic(root1.left, root2.left) &&
                                         isIsomorphic(root1.right, root2.right));
             }
         }
         return false;
    }
    
}    
