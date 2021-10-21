package assignment3;
import java.util.*;
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter total number of floors in building");
     int n = sc.nextInt();
     int arr[] = new int[n];
     int k=1;
     for(int i=0;i<n;i++)
     {
    	 System.out.println("enter floor size given on day :" + k);
    	 arr[i] = sc.nextInt();
    	 k++;
     }
     
     Floors obj = new Floors();
     System.out.println("The order of construction is as follows");
     
     obj.Implementation(arr , n);
    
     
	}

}
