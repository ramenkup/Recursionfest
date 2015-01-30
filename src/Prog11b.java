/*+----------------------------------------------------------------------
 ||
 ||  Class Prog11b
 ||
 ||         Author:  Spencer Klinge
 ||
 ||        Purpose:  Prog11b.java is a recursive computation class that
 					 calculates and generates the Heighway Dragon sequence. It is then 
 					 Graphiclly displayed to the using StdLib's StdDraw. The Main Recursive
 					 Method that calculates the 'L' and 'R'  String sequence, starting with L, and
 					 Recursivly calling the method and adding onto the string in the format outlined by
 					 the assignment spec. after the algorythem is applied to the string for a certian number of
 					 iterations, the information from the string is passed to Turtle.java in mains for loop check,
 					 which decodes the Lefts and rights of the string and graphiclly represents those moves using
 					 the Turtle class.
 
 ||  Inherits From:  N/A
 ||
 ||     Interfaces:  N/A
 |+-----------------------------------------------------------------------
 ||
 ||      Constants:  N/A
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors: dragonCurve(int), dragonCurveHelper(int,String)
 					int- number of recursive iterations
 					String-L/R Sequence String
 					
 ||  Class Methods:  N/A
 ||
 ||  Inst. Methods: flipper(String)

 ++-----------------------------------------------------------------------*/
public class Prog11b {
	
    /*---------------------------------------------------------------------
    |  Method: DragonCurve-> HELPED
    |
    |  Purpose: main constructor and recursive operation for The Prog11b class.
    			Dragon curve utilizes a helper method To protect the returner string from
    			being refreshed by recursion. The first iteration of dragon curve  is by default
    			'L'. Every following iterations conforms to the following alorithm: the next iterations
    			string is set to the prevs+'L'+ flipper(temp). the flipper method does two things: it negates
    			the temp, replacing R's for L's and L's for R's. it the reverses the string all together. it
    			does this for each recursion and base cases when iterations gets down to 1.
    |  Pre-condition: N/a
    |
    |  Post-condition: String of Left Right sequence will be returned.
    |
    |  Parameters: int- number of iterations
    |
    |  Returns:  String- Left and right sequence computed by dragon algorithem.
    *-------------------------------------------------------------------*/
	public static String dragonCurve(int iterations){
					String returner="L";
			returner= dragonCurveHelper(iterations, returner);
			return returner;
			
		}
		public static String dragonCurveHelper(int iterations, String temp){
			
			if( iterations == 1)
				return temp;
			
			return dragonCurveHelper(iterations-1, temp + "L" + flipper(temp));
			
		}
	       /*---------------------------------------------------------------------
        |  Method public static flipper(String)
        |
        |  Purpose:  Part of the dragon algorithem. in the recursive call,
        			flipper is called to append to the current string. all this
        			flipper does is negate each L for an R and R for an L. it then
        			flips the whole string into reverse order. I found an easy way
        			do this was converting the string into a char array.
        			
        |  Pre-condition: Dragon curve has been called.
        |
        |  Post-condition: the current string will be negated and flipped.
        |
        |  Parameters:String- the string to be flipped.
        |
        |  Returns:  The flipped String object.
        *-------------------------------------------------------------------*/
		public static String flipper(String x){
			char[] temp= x.toCharArray();
			for(int i=0; i< x.length(); i++){
				if(temp[i] == 'L')
					temp[i]='R';
					else if(temp[i] == 'R')
							temp[i]='L';
				
			}//end of replacing
			char[] temp2= new char[temp.length];
			for(int n=0; n< temp2.length;n++){
				temp2[n]=temp[temp.length-1-n];
			}
			String returner= new String(temp2);
			return returner;
			
		}
		/*=============================================================================
		 |   Assignment:  Program #[11]:  [Recursionfest]
		 |       Author:  [Spencer Klinge (sklinge@email.arizona.edu)]
		 | Sect. Leader:  [Lizzie]
		 |
		 |       Course:  [CSC227]
		 |   Instructor:  L. McCann
		 |     Due Date:  [Tues, May 6th, 9:00PM MST(LATE DAYS USED)]
		 |
		 |  Description:  Prog11b.java is a recursive computation class that
 					 calculates and generates the Heighway Dragon sequence. It is then 
 					 Graphiclly displayed to the using StdLib's StdDraw. The Main Recursive
 					 Method that calculates the 'L' and 'R'  String sequence, starting with L, and
 					 Recursivly calling the method and adding onto the string in the format outlined by
 					 the assignment spec. after the algorythem is applied to the string for a certian number of
 					 iterations, the information from the string is passed to Turtle.java in mains for loop check,
 					 which decodes the Lefts and rights of the string and graphiclly represents those moves using
 					 the Turtle class.
 					 This main method hadels the connnection between the Prog11b class and the Turtle.java graphical
 					 representation of the recursive method. Mains for loop decodes the string output by Dragon counter.
 					 The only Turtle variable that needs to be set is the set size in the consturctor. all the default settings
 					 are fine. One of the trickey things about this method was correctly placing pauses before and afer the for loop iteration
 					 becuse do these not only act as a pause, but they also act as graphic refresh, because the method itself calls .show().
		 |                
		 | Deficiencies:  [If you know of any problems with the code, provide
		 |                details here, otherwise clearly state that you know
		 |                of no unsatisfied requirements and no logic errors.]
		 *===========================================================================*/				
	public static void main(String args[]){
		String path= dragonCurve(3);
		System.out.println(path);
        double x0 = 0.5;
        double y0 = .5;
        double a0 = 90.0;
       // double step = Math.sqrt(3)/2;
        double step= .125;
        Turtle turtle  = new Turtle(x0, y0, a0);
		turtle.pause(1000);
        turtle.goForward(step);
		System.out.println(turtle.getAngle());
		for(int i=0; i< path.length(); i++){
			if(path.charAt(i) == 'L')
				turtle.turnLeft(90.0);
			if(path.charAt(i) == 'R')
				turtle.turnLeft(-90.0);
			turtle.pause(1000);
			turtle.goForward(step);
			System.out.println(turtle.getAngle());

		}
		turtle.pause(1000);
		
	}
		
		

	


}
