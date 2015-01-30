
/*+----------------------------------------------------------------------
 ||
 ||  Class Prog11A
 ||
 ||         Author:  Spencer
 ||
 ||        Purpose:  handels the main testing for the Recursion.java class.
 					It tests every method and outputs it with a header to the 
 					user using Sys.out. This class also contains the inOrder
 					and preOrder methods that output a string of a Tree into
 					their respective orders.
 ||  Inherits From:  N/A
 
 ||     Interfaces: N/A
 |+-----------------------------------------------------------------------
 ||
 ||      Constants:  N/A
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  N/A
 ||  Class Methods:  N/A
 ||  Inst. Methods:  preOrder(treeNode), inOrder(treeNode)
 ++-----------------------------------------------------------------------*/


public class Prog11a {

	  /*---------------------------------------------------------------------
    |  Method: preOrder(treeNode head)
    |
    |  Purpose:  This method does the exact oppisite of reinflate tree because,
    			it takes a tree argument and converts it into a preOrder string.
    			It does this recursivly returning the curent data,
    			plus a recursive call to the left + a recursive call to
    			the right.
    |
    |  Pre-condition: Tree is passed into argument
    |
    |  Post-condition: N/A
    ||
    |  Parameters: treeNode head- the head of the treeNode
    |
    |  Returns:  returns the consecutive recursive calls and ultimently the 
    			whole tree in preOrder represented as a String
    *-------------------------------------------------------------------*/
	static String preOrder(treeNode head){
		if(head == null)
			return "";
		else{
			return head.data + preOrder(head.left)    + preOrder(head.right);
		}
	}
	  /*---------------------------------------------------------------------
    |  Method: inOrder(treeNode head)
    |
    |  Purpose:  This method does the exact oppisite of reinflate tree because,
    			it takes a tree argument and converts it into a inOrder string.
    			It does this recursivly returning the curent data,
    			plus a recursive call to the left + a recursive call to
    			the right.
    |
    |  Pre-condition: Tree is passed into argument.
    |
    |  Post-condition: N/A
    ||
    |  Parameters: treeNode head- the head of the treeNode
    |
    |  Returns:  returns the consecutive recursive calls and ultimently the 
    			whole tree in inOrder represented as a String
    *-------------------------------------------------------------------*/
		static String inOrder(treeNode head){
			if(head == null)
				return "";
			else{
				return inOrder(head.left) + head.data + preOrder(head.right);
			}
				
				
		}
	
	
		/*=============================================================================
		 |   Assignment:  Program #[11]:  [Recursionfest]
		 |       Author:  [Spencer Klinge (sklinge@email.arizona.edu)]
		 | Sect. Leader:  [Lizzie]
		 |
		 |       Course:  [Csc227 ]
		 |   Instructor:  L. McCann
		 |     Due Date:  [Tues May 6th, 9:00PM MST]
		 |
		 |  Description:  [Prog11a is main testing for the Recursion.java. it tests
		 					every method and outputs to the user via Sys.out. it does
		 					not make use if Junit testing. The reason I felt it was not 
		 					necessary to use J unit was simply because this is class of,
		 					for the most, of isloated methods-- meaning, each methods
		 					dependency on one another is fairly limited.]
		 |                
		 | Deficiencies:  [N/A]
		 *===========================================================================*/
	public static void main(String args[]){
		int[][]board= new int[3][4];	
		Recursion.knightsTour(board, 0, 0);	
		treeNode head= new treeNode('R',null,null);
		head.setRight(new treeNode('E',null,null));
		head.setLeft(new treeNode('W', new treeNode('T',null,null),null));
		treeNode tree= Recursion.reinflateTree(preOrder(head),inOrder(head));
		System.out.println(preOrder(tree));
		System.out.println(inOrder(tree));
		System.out.println("gcd(7,14)-"+Recursion.gcd(7,14));		
		System.out.println("gcd(7,14)-"+Recursion.gcd(52,65));
		System.out.println("ackermann(2,4)" + Recursion.ackermann(2,4));
		String name= "ssppeenncceerr";
		System.out.println("reverse: "+ Recursion.reverse(name));
		double[] rngSum= {7,-2,4,0,8,-1,2};
		System.out.println("rngSum(1,4): " + Recursion.rangeSum(rngSum,1,4));
		for(int n=0; n<7;n++){
		int[]tri= Recursion.pascalRow(n);
		System.out.println();
		for(int i=0; i< tri.length; i++){
			System.out.print(tri[i]+" ");
		}
		}
	}
}
