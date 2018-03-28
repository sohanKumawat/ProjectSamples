package com.demo.slk.test;

public class MainNumber {
	 static int getMissingNo (int a[], int n){
        int i;
        int x1 = a[0]; 
        int x2 = 1; 
         
        /* For xor of all the elements 
           in array *
           01,10
           011,100->7->111
           101->010
           110->100
           */
        for (i = 1; i< n; i++){
        	x1 = x1^a[i];
        	System.out.println(x1);
        }
                 
        /* For xor of all the elements 
           from 1 to n+1 */        
        for ( i = 2; i <= n+1; i++){
            x2 = x2^i;      
             System.out.println(x2);
           }
        System.out.println("--->"+x2 );
        System.out.println("--->"+x1 );
        return (x1^x2);
    }
      
    /* program to test above function */
	
    public static void main(String args[])
    {
        int a[] = {1, 2, 1, 2, 3};
        int miss = getMissingNo(a,5);
        System.out.println(miss);
    }
}
