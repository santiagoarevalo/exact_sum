import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	public static int[] binarySearching(int[] array, int money) {
		int[] bestPrices = new int[2];
        int diffMin = Integer.MAX_VALUE;

	    for(int x = 0; x<array.length; x++) {    
    		int k = money-array[x];
    		int found = Arrays.binarySearch(array, k);
    		int diff = Math.abs(array[x]-k);
    		if(x != found && found>=0 && diff<diffMin) {
    			diffMin = diff;
    			bestPrices[0] = array[x];
    			bestPrices[1] = k;
    		}
	    }
	    Arrays.sort(bestPrices);
        return bestPrices;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int availableBooks = Integer.parseInt(br.readLine());
		int[] prices = new int[availableBooks];
		String[] pricesParts = br.readLine().split(" ");
		
		for(int i = 0; i<pricesParts.length; i++) {
			prices[i] = Integer.parseInt(pricesParts[i]);
		}
		
		int money = Integer.parseInt(br.readLine());
		Arrays.sort(prices);
		int[] bestPrices = binarySearching(prices, money);
			
		bw.write("Peter should buy books whose prices are "+bestPrices[0]+" and "+bestPrices[1]+".");
		bw.newLine();
		
		br.close();
		bw.close();
	}

}
