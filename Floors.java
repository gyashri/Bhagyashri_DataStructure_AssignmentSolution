package assignment3;

import java.util.Stack;

public class Floors {
    public void Implementation(int arr[] , int n )
    {
    	 Stack<Integer> stack = new Stack<Integer>();
         int curr=1;
         int temp = n;
         for(int i=0;i<temp;i++) {
        	 if(arr[i] == n && n>0)
        	 {
        		 System.out.print(" Day " + curr + " :" + n);
        		while(stack.contains(--n))
        		 {
        			 System.out.print(" " + stack.pop());
        		 }
        		System.out.println();
        	 }
        	 
        	 else {
        		 stack.push(arr[i]);
        			
        		 System.out.println(" Day " + curr);
        	 }
        	curr++;
         }
    }
}
