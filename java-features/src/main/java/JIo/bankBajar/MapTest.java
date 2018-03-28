package JIo.bankBajar;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<Integer,Integer> map=new HashMap<>();
		for(Map.Entry<Integer, Integer> entry:map.entrySet()){
			entry.getValue();
		}

	}
	 static int[] getMinimumDifference(String[] a, String[] b) {
	       
	        int[] diff=new int[a.length];
	        
	        for(int j=0;j<a.length;j++){
	            if(a[j].length()!=b[j].length()) {
	                diff[j]=-1;
	               continue;
	            }
	           int count= diffCount(a[j],b[j]);
	            diff[j]=count;
	        }
	        return diff;
	    }
	public static int diffCount(String s1,String s2){
	    int r=0;
	    int[] ch=new int[26];
	    for(int i=0;i<s1.length();i++){
	        ch[s1.charAt(i)-'a']++;
	    }
	    for(int i=0;i<s2.length();i++){
	        if(ch[s2.charAt(i)-'a']--<=0) r++;
	    }
	    return r;
	}

}
