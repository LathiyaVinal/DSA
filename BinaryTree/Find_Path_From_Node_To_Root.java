

/*   

===========Question================ 
Find And Node to rootpath In Binary Tree

===========Description===============
check if node is present in tree, and if present then print path from Node to Tree .  

============= Input =================
Total Nodes in tree : 19
Node to find : 30
Tree given : 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n

============= Output =================
true // present node
[30, 37, 25, 50]  // path from node to root 

*/


  public static ArrayList<Integer> paths;

  public static boolean find(Node node, int data) {

    if (node == null) {
      return false;
    }
    if (node.data == data) {
      paths.add(node.data);
      return true;
    }

    boolean foundInLeftTree = find(node.left, data);
    if (foundInLeftTree) {
      paths.add(node.data);
      return true;
    }
    boolean foundInRightTree = find(node.right, data);
    if (foundInRightTree) {
      paths.add(node.data);
      return true;
    }
    return false;
  }

