package com.demo.slk;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HackerEarthTest {
	int [][] metric=null;
	public HackerEarthTest(){
		
	}
	public void operation(){
	} 
public void initInput(){
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tCount;
    String rc=null;
	try {
		 tCount = Integer.parseInt(br.readLine());
		 if(!(tCount>0 && tCount<=200))  throw new Exception("Test cases should be in between 1 and 200");
		 rc = br.readLine();
		 int r=Integer.parseInt(rc.split(" ")[0]);
		 int c=Integer.parseInt(rc.split(" ")[1]);
		 if(!(r>0 && r<101 && c>0 && c<101)) throw new Exception("row or column in between 1 and 100");
		 metric=new int[r][c];
		 for(int i=0;i<r;i++){
			 for(int j=0;j<c;j++){
				 metric[i][j]=0;
			 }
		 }
		 for(int k=0;k<c;k++){
			  String[] mVal = br.readLine().split(" ");
			  for(int i=0;i<r;i++){
				  for(int j=0;j<c;j++){
				   int val=Integer.parseInt(mVal[j]);
				 if(!(val==0 || val==1)) throw new Exception("Metric value have only 0 or 1");
				 metric[i][k]=val;
			   }
			  }
		 }
	} catch (Exception e) {
		e.printStackTrace();
	}  
	} 
	
	
	public static void main(String[] args) {
		String tmp[]={"","",""};
		try{
			int c= 4/0;
			
		}catch(Exception ex){
			System.out.println("sdbc");
		}
		HackerEarthTest t=new HackerEarthTest();
		t.initInput();
		t.operation();
     }
}
