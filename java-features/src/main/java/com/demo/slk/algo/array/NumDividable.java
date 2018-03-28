package com.demo.slk.algo.array;

public class NumDividable {

	public static void getMinStep(int n) {
		int dp[] = new int[n + 1];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		for (int i = 4; i <= n; i++) {
			dp[i] = 1 + dp[i - 1];
			if (i % 2 == 0)
				dp[i] = dp[i] < (1 + dp[i / 2]) ? dp[i] : 1 + dp[i / 2];
				else if (i % 3 == 0)
				dp[i] = dp[i] < (1 + dp[i / 3]) ? dp[i] : 1 + dp[i / 3];
		}
		System.out.println(" ** steps-- " + dp[n]);
	}
	/*Largest continuece sub sequence if i<j then a[i]<a[j]*/
	
	 static int lisCount(int arr[],int n)
	    {
	          int lis[] = new int[n];
	          int i,j,max = 0;
	 
	          /* Initialize LIS values for all indexes */
	           for ( i = 0; i < n; i++ ){
	              lis[i] = 1;
	           }
	           /* Compute optimized LIS values in bottom up manner */
	           for ( i = 1; i < n; i++ ){
	              for ( j = 0; j < i; j++ ){ 
	                         if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
	                    lis[i] = lis[j] + 1;
	              }
	           }
	 
	          
	           /* Pick maximum of all LIS values */
	           int p=0;
	           for ( i = 0; i < n; i++ ){
	              if ( max < lis[i] ){
	                  max = lis[i];   
	                  p=i;
	              }
	           }
	
	           int count=0;
	           int c=0;
	           String result="";
	           for(int i1=p;i1>=0;i1--){
	        	  // System.out.println("index "+i1+" index val ** "+lis[i1]+"--cur --"+c);
	        	   if(c>0 && c==lis[i1]+1){
	        		   count++;
	        		  // System.out.println("Subsequence values ** "+c);
	        		   result=result+arr[i1]+",";
	        		   c=lis[i1];
	        		   if(count==max) break;
	        	   }
	        	   else if(c==0) {
	        		   c=lis[i1];
	        		   result=arr[i1]+",";
	        	   }
	        	   
	        	   System.out.println("--"+lis[i1]);
	           }
	           if(count==max) result=result+arr[0];
	           System.out.println("** result ** "+result);
	            return max;
	    }
	 static int maxSumLIS(int arr[],int n)
	    {
	          int maxSumLIC[] = new int[n];
	          int i,j,max = 0;
	 
	          /* Initialize LIS values for all indexes */
	           for ( i = 0; i < n; i++ ){
	        	   maxSumLIC[i] = arr[i];
	           }
	           /* Compute optimized LIS values in bottom up manner */
	           for ( i = 1; i < n; i++ ){
	              for ( j = 0; j < i; j++ ){ 
	                         if ( arr[i] > arr[j] && maxSumLIC[i] < maxSumLIC[j] + arr[i])
	                        	 maxSumLIC[i] = maxSumLIC[j] + arr[i];
	              }
	           }
	 
	          
	           /* Pick maximum of all LIS values */
	           int p=0;
	           for ( i = 0; i < n; i++ ){
	        	   System.out.println(" ** maxSumLIC ** "+maxSumLIC[i]);
	              if ( max < maxSumLIC[i] ){
	                  max = maxSumLIC[i];   
	                  p=i;
	              }
	           }
	
	           int count=0;
	           int c=0;
	           String result="";
	           for(int i1=p;i1>=0;i1--){
	        	  // System.out.println("index "+i1+" index val ** "+lis[i1]+"--cur --"+c);
	        	   if(c>0 && c==maxSumLIC[i1]+arr[i1+1]){
	        		   count=count+arr[i1];
	        		  // System.out.println("Subsequence values ** "+c);
	        		   result=result+arr[i1]+",";
	        		   c=maxSumLIC[i1];
	        		   if(count==max) break;
	        	   }
	        	   else if(c==0) {
	        		   c=maxSumLIC[i1];
	        		   result=arr[i1]+",";
	        		   count=count+arr[i1];
	        	   }
	        	   
	        	   System.out.println("--"+maxSumLIC[i1]);
	           }
	           if(count!=max) result=result+arr[0];
	           System.out.println("** result ** "+result);
	            return max;
	    }
	public static void main(String str[]) {
	//	NumDividable.getMinStep(9);
	//	int[] arr={1,2,3,43,1,32,4,3,4,5,6,7};
	//  NumDividable.longestSequence(arr);
		 int arr[] ={1, 101, 2, 3, 100, 4, 5};// { 10, 22, 9, 33, 21, 50, 55, 60 };
         int n = arr.length;
       //  System.out.println("Length of lis is " + lisCount( arr, n ) + "n" );
         maxSumLIS(arr, n);
	}
}
