/*+----------------------------------------------------------------------
 ||
 ||  Class [Recursion] 
 ||
 ||         Author:  [Spencer Klinge]
 ||
 ||        Purpose:  [This class is a collection of 7 different isolated operations that utilize
  					  the elements and principles of java recursion. A viaraty of data structues make
  					  use of resucion in cluding 1d arrays, 2d, arrrays, TreeNode 
  					  objects(a private class within Recursion). Some of the more historic methods, including
  					  Ackermans, Pascells Triangle, And the Knights tour-- all historic mathimatical algorythems
  					  that can be computed recursivly.]
 ||
 ||  Inherits From:  [N/A]
 ||
 ||     Interfaces:  [N/A]
 ||
 |+-----------------------------------------------------------------------
 ||
 ||      Constants:  [N/a]
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  [List the names and arguments of all defined
 ||                   constructors.]
 ||
 ||  Class Methods:  [List the names, arguments, and return types of all
 ||                   public class methods.]
 ||
 ||  Inst. Methods:  [List the names, arguments, and return types of all
 ||                   public instance methods.]
 ||
 ++-----------------------------------------------------------------------*/

public class Recursion {
	
	
	
	
	
    /*---------------------------------------------------------------------
    |  Method:GCD(int,int)
    |
    |  Purpose: This method, given to integers, calculates the greatest common
    			devisor between the two. It does this recursivly, calling the method
    			and in they y agrument, placing either x%y or y%x depending on which one
    			is greater.
    |
    |  Pre-condition: N/a
    |
    |  Post-condition: Greatest common devisor will be returned.
    |
    |  Parameters: int x- first integer.	int y- second integer.
    |
    |  Returns:int- Greastest common devisor 
    *-------------------------------------------------------------------*/
	public static int gcd(int x, int y){
		
		if(x == 0)
			return y;
		if(y == 0)
			return x;
		if(x > y)
			return gcd(y, x % y);
		else{
			return gcd(x, y % x);
		}
		/* if (y == 0) {
		        return x;
		    } else if (x >= y && y > 0) {
		        return gcd(y, (x % y));
		    }*/	
		 }
    /*---------------------------------------------------------------------
    |  Method: ackermann(int, int)
    |
    |  Purpose:  This method, given two integers makes basic recursive calls
    			depending on the parameters of the ackermann fuction. at the end,
    			it returns n+1.
    			
    |  Pre-condition: N/a
    |
    |  Post-condition: The ackermann value will be returned.
    |
    |  Parameters:	int,int
    |
    |  Returns:  int- the calculated ackermann value.
    *-------------------------------------------------------------------*/
	public static int ackermann(int m, int n){
		if(m==0)
			return n+1;
		else if(m>0){
		if(n == 0)
			return ackermann(m-1,1);
		else if(n>0)
			return ackermann(m-1 , ackermann(m,n-1));
		
	}
	return 1;
	}
	
    /*---------------------------------------------------------------------
    |  Method: reverse(String)
    |
    |  Purpose: This method does the exact same thing as the Java API's
    			String reversel method, accept the does the operation
    			recursivly.
    			
    |  Pre-condition: The String is not empty(Does not cause an error!)
    |
    |  Post-condition: The given string will be reversed.
    |
    |  Parameters:	String- The string to be reversed.
    |
    |  Returns: String- The reversed String.
    *-------------------------------------------------------------------*/
	public static String reverse(String str){
		if(str.length() != 0){
			return str.charAt(str.length()-1) + reverse(str.substring(0, str.length()-1));
		}
		return str;

	}
    /*---------------------------------------------------------------------
    |  Method: rangesum(double[], int, int)
    |
    |  Purpose: This method accepts a 1d double array and two integers. it then
    			uses those two integers as starting and and ending indexs, and
    			add the sum of each componant of of the double array from one index
    			to another.the base cases are when lower is either equal
    			or greater than upper. it does this all recursivly.
    |
    |  Pre-condition: N/A
    |
    |  Post-condition: N/A
    |
    |  Parameters:	double[] array-the range of variables to be iterated and summed.
    |
    |  Returns: returns the sum of the range.
    *-------------------------------------------------------------------*/
	public static double rangeSum(double [] aray, int lower, int upper){
		if(lower == upper)
			return aray[upper];
		else
		if(lower > upper)
			return 0;
		
		else return aray[lower] +  rangeSum(aray, lower+1, upper);
		
	}
    /*---------------------------------------------------------------------
    |  Method pascalRow(int)
    |
    |  Purpose:  This method is similar to a regular recursive pascalTriangle problem,
    			in in that in recurses each level starting from the base of the triangle,
    			and for looping  the split and add two consecutive terms to eachother to
    			get the next row. The thing that makes it unique, however, is that instead of
    			returning the whole triangle, this method has a single row returned, which
    			in acutallity is the number of recursive calls.
    			
    |  Pre-condition: N/A
    
    |  Parameters: row- row of Pascal Triangle to be returned.
    |
    |  Returns:  IF THIS METHOD SENDS BACK A VALUE VIA THE RETURN
    |      MECHANISM, DESCRIBE THE PURPOSE OF THAT VALUE HERE, OTHERWISE
    |      STATE 'NONE'.
    *-------------------------------------------------------------------*/
	public static int [] pascalRow(int row){
		int [] array= new int[row+1];
		if( row == 0){
			array[0]=1;
			return array;
		}
		
		if(row == 1){
			array[0]=1;
			array[1]=1;
			return array;
		}
		int[] temp= pascalRow(row-1);
		
		for(int i= 0; i < temp.length; i++){
			int sum;
			if(i + 1 < temp.length)
				sum= temp[i] + temp[i+1];
			
			else{
				sum= 1;
			}
			
			array[i+1]= sum;
				
		}
		array[0]=1;
		return array;
	}
	
    /*---------------------------------------------------------------------
    |  Method: KnightsTour
    |
    |  Purpose: This method simulates the movement of a knight peice of a chess board.
    			This method then maps a tour for a night peice placed at any location on the board
    			placing the numerical value of its step in the tour in that block. The while loop condition
    			ends when the counter has reached its max limit, the size of the board. If this while loop is meet
    			each recursive call is made from. The method returns void, so the parent method
    			handels the printing of the array.
    			
    |  Pre-condition: The arguments are valid locations on the board.
    |
    |  Post-condition: Path will be found and printed to the user.
    |
    |  Parameters: 	board:the counter int board
    				row: starting row
    				col: starting col
    |
    |  Returns: void
    *-------------------------------------------------------------------*/
	public static void knightsTour (int [][] board, int row, int col ){
		int counter=1;
		knightsTour(board, row, col, counter);

		
		
	}
	
	//Helper
	public static void knightsTour (int [][] board, int row, int col, int counter){
		if(counter == board.length * board[0].length){
			board[row][col]=counter;
			for(int i=0; i< board.length; i++){
				System.out.println();
				for(int n=0; n < board[0].length; n++){
					System.out.print(board[i][n] + " ");
				}
			}
			board[row][col]=0;
			System.out.println();
			return;
		}
		
		//proper barrier?
		//proper check/	
		//should i put board ==
		if(row+2 < board.length && col + 1 < board[0].length &&  board[row+2][col+1]==0 ){
			board[row][col]= counter;
			knightsTour(board, row+2, col+1, counter+1);
				board[row][col]=0;//backtrack
						
		}
		if(row+1 < board.length && col -2 >= 0 &&  board[row+1][col-2]==0){
			board[row][col]=counter;
			knightsTour(board, row+1, col-2, counter+1 );
				board[row][col]=0;
				}
		if(row+1 < board.length && col + 2 < board[0].length &&  board[row+1][col+2]==0){
			board[row][col]=counter;
			knightsTour(board, row+1, col+2, counter+1);
				board[row][col]=0;			
		}
		if(row-1 >= 0 && col + 2 < board[0].length &&  board[row-1][col+2]==0){
			board[row][col]=counter;
			knightsTour(board, row-1, col+2, counter+1);
				board[row][col]=0;			
		}
		if(row-2 >=0 && col - 1 >= 0 &&  board[row-2][col-1]==0){
			board[row][col]=counter;
			knightsTour(board, row-2, col-1, counter+1);
				board[row][col]=0;			
		}
		if(row-2 >= 0 && col + 1 < board[0].length &&  board[row-2][col+1]==0){
			board[row][col]=counter;
			knightsTour(board, row-2, col+1, counter+1);
				board[row][col]=0;			
		}
		if(row-1 >= 0 && col - 2 >= 0 &&  board[row-1][col-2]==0){
			board[row][col]=counter;
			knightsTour(board, row-1, col-2, counter+1);
				board[row][col]=0;			
		}
		if(row+2 < board.length && col -1 >= 0 &&  board[row+2][col+-1]==0){
			board[row][col]=counter++;
			knightsTour(board, row+2, col-1, counter);
				board[row][col]=0;			
		}

		}

	
    /*---------------------------------------------------------------------
    |  Method: reinflateTree
    |
    |  Purpose:  This method, given the preorder traversal and inorder traversal of the
    			tree in String format, Recursivaly calls itself to reconstruct the tree into
    			a treeNode object, a private class within Recursion.java. the base case for the recursive
    			calls is when the length of preorder stubstring becomes zero.
    			the whole method completes at the bottem when it returns the head of
    			the tree.
    |
    |  Pre-condition: The Preorder and Inorder Strings are correct.
    |  Post-condition: WHAT WE CAN EXPECT TO EXIST OR BE TRUE AFTER
    |      THIS METHOD HAS EXECUTED UNDER THE PRE-CONDITION(S).
    |
    |  Parameters: String- The tree represented as a string in preOrder
    				String- the tree represented a a string inOrder.
    |
    |  Returns: treeNode- The head of the tree.
    *-------------------------------------------------------------------*/
	public static treeNode reinflateTree (String preorder, String inorder){
		if(preorder.length() == 0 )
			return null;
		char root= preorder.charAt(0);
		treeNode curr= new treeNode(root, null, null);
		int temp= inorder.indexOf(root);
		curr.setLeft(reinflateTree(preorder.substring(1, temp+1),inorder.substring(0 , temp)));
		curr.setRight(reinflateTree(preorder.substring(temp+1), inorder.substring(temp+1)));
		return curr;
	}
	//helper with reference to orinal header
	//do traversal recursivly
	// add to string recursivly
	// while
	//character to string

	}



	
	/*+----------------------------------------------------------------------
	 ||
	 ||  Class [treeNode] 
	 ||
	 ||         Author:  [Spencer Klinge]
	 ||
	 ||        Purpose:  [This private tree class serves the Recursion.java class
	 					  and some of its method. it exactly resembles the behavior
	 					  of a Java tree class. with a left and right all of its data is entierly publicized.
	 					  This class is mostly used by the reinflateTree method.]
	 ||
	 ||  Inherits From:  [N/A]
	 ||
	 ||     Interfaces:  [N/A]
	 ||
	 |+-----------------------------------------------------------------------
	 ||
	 ||      Constants:  [N/A]
	 ||
	 |+-----------------------------------------------------------------------
	 ||
	 ||   Constructors:  [treeNode(char d, treeNode l, treeNode r)]
	 ||
	 ||  Class Methods:  [N/A]
	 ||
	 ||  Inst. Methods:  [Set/Get prev, left, right, root, data.]
	 ||
	 ++-----------------------------------------------------------------------*/

	class treeNode{
		treeNode left;
		treeNode right;
		char data;

	public treeNode(char d, treeNode l, treeNode r){
		data= d;
		left= l;
		right= r;
	}
	
	public treeNode getLeft(){
		return left;
	}

	public treeNode getRight(){
		return right;
	}
	public char getData(){
		return data;
	}


	public void setLeft(treeNode l){
		left=l;
		
	}
	public void setRight(treeNode r){
		right=r;
	}
	public void setData(char d){
		data=d;
	}

	}




