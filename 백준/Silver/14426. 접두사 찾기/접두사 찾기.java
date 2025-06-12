import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {
	
	
	static String [] input;
	static int N;
	static int count;
	
    public static void main(String[] args)  throws IOException {
  
    	
    	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           StringTokenizer st = new StringTokenizer(br.readLine(), " ");
       	   N = Integer.parseInt(st.nextToken());
       	   int M = Integer.parseInt(st.nextToken());
       	   input = new String[N];
       	   
       	   
       	   for(int i=0; i<N; i++) {
       		st = new StringTokenizer(br.readLine(), " ");
       		input[i]= st.nextToken();
       	   }
       	   
       	   Arrays.sort(input);
       	   
       	   while(M-->0) {
       		   
       		st = new StringTokenizer(br.readLine(), " ");
       		String word = st.nextToken();
       		
       		solve(word);   		   
       		   
       		   
       	   }
       	   
       	   System.out.println(count);
       	   
       	   
       	   }
    
    
    public static void solve(String word) {
    	
    	
    	int left = 0;
    	int right = N-1;
    	
    	while(left<=right) {    		
    		
    		int mid = (left + right)/2;
    	
    		
    		if(input[mid].substring(0,word.length()).equals(word)) {
    			count++;
    			break;
    			
    		}else {
    			
    			
    			if(input[mid].compareTo(word)>=0) {
    		
    				right = mid-1;
    			}else {
    				
    				left = mid + 1;
    			}
    			
    		} 		
    		
    	}   	
    }
}