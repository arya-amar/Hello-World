
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;


public class ClosestDistance {

    // closest pair of points and their Euclidean distance
    private RandomPoint best1, best2;
    private double bestDistance = Double.POSITIVE_INFINITY;
    private static ArrayList<PointPairDistance> myfinalarray=new ArrayList<PointPairDistance>();   // array contains all distances
    private static ArrayList<RandomPoint> points=new ArrayList<RandomPoint>();                     //array contains all generated points

    /**
     * Computes the closest pair of points in the specified array of points.
     *
     * @param  points the array of points
     * @throws IllegalArgumentException if {@code points} is {@code null} or if any
     *         entry in {@code points[]} is {@code null}
     */
    public ClosestDistance(){//RandomPoint[] points) {
        if (points == null) throw new IllegalArgumentException("constructor argument is null");
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i) == null) throw new IllegalArgumentException("array element " + i + " is null");
        }

        int n = points.size();
        if (n <= 1) return;

    }
    
    public  void findDistance(){									//nested for loop->Finds the distance between all points in the array points.
    	for(int i=0;i<points.size()-1;i++) {
    		for (int j=i+1;j<points.size();j++) {
    			double y1=points.get(i).y();                       //represent x1,x2,y1,y2
    			double y2=points.get(j).y();
    			double x1=points.get(i).x();
    			double x2=points.get(j).x();
    			double dist=Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));            //calculates the distance between
    			PointPairDistance appd=new PointPairDistance(points.get(i),points.get(j),dist);		//generates a PointPairDistance object to hold two points and there distance
    			//System.out.println(appd.toString());
    			myfinalarray.add(appd);														//array to hold all PointsPairDistance objects. Essentially holding all possible distances.
    		}
    	}
    	
    }
  
    public static void main(String[] args) {
    	Date start=new Date();

    	System.out.println("Enter the Number of Points to generate");			
    	Scanner sc=new Scanner(System.in);
		int numofpoints=sc.nextInt();
		System.out.println("Enter the Number of Closest Pairs to Return");
		int m=sc.nextInt();
		RandomPoint apoint; 		//create array to hold points
		
	        int min = -200;			//min number for x or y values
	        int max = 200; 			//max number for x or y values
	        int countp=0;
	        while(countp < numofpoints) {
	          
	            // generates x values
	            double x =(int) (min + Math.random() * (max - min));
	            // generates y values
	            double y =(int)(min + Math.random() * (max - min));
	            //System.out.println(Double.toString(x)+","+Double.toString(y));			//used to print all inputs
	            
	            apoint=new RandomPoint(x,y);
	            if( points.isEmpty()){
	            	points.add(apoint);
	            	countp++;
	            	
	            }else {   
	            	if (points.contains(apoint)) {										//Ensures no duplicate points values
	            		//System.out.println(apoint.toString()+" is a duplicate");
	            	}else {
	            		points.add(apoint);
		            	countp++;
	            	}
	            	
	            	
	            }
	            
	            
	        }
	        /*1 st For Trace Test
            RandomPoint mytest=new RandomPoint(2,3);
            points.add(mytest);
            mytest=new RandomPoint(6,4);
            points.add(mytest);
            mytest =new RandomPoint(10, 50);
            points.add(mytest);
            mytest=new RandomPoint(9,0);
            points.add(mytest);
            */
        ClosestDistance closest = new ClosestDistance();

	    closest.findDistance();
        //System.out.println(closest.distance() + " from " + closest.either() + " to " + closest.other());
        Collections.sort(myfinalarray);															//sorts all distances					
        System.out.println("Points with the shortest Distance are:");
        RandomPoint startpointprev=null;
        RandomPoint endpointprev=null;
        //System.out.println(myfinalarray.size());

        for (int index=0;index <m;index++) {										//Prints m closest distances
        	RandomPoint startpoint=myfinalarray.get(index).getstartpoint();
        	RandomPoint endpoint=myfinalarray.get(index).getendpoint();

        		
        		  System.out.println(myfinalarray.get(index).toString());
  

        }
        Date end=new Date();
        long elapsedtime=end.getTime()-start.getTime();
        System.out.println("It took "+elapsedtime+" milliseconds to run with number of points = "+numofpoints);


    }
}


