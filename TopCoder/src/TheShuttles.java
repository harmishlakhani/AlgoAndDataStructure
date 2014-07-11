import java.util.Arrays;

public class TheShuttles {

	
	public int getLeastCost(int[] cnt, int baseCost, int seatCost) {
		
		int location = cnt.length;
		int totalCost = 0;
		int shuttleCost = 0;
		int minCost = 0;
		Arrays.sort(cnt);
		
		int count; 
		for(int i = cnt[0]; i <= cnt[location - 1]; i++) {
			
			int[] temp = Arrays.copyOf(cnt, location);
			count = location;
			for(int j = 0; j < location; j++) {
				while(temp[j] > i) {
					temp[j] -= i;
					count++;
				}
			}
			shuttleCost = baseCost + seatCost * i;
			totalCost = shuttleCost * count;
			if(i==cnt[0])
				minCost = totalCost;
			//System.out.println(totalCost);
			if(minCost > totalCost)
				minCost = totalCost;
		}
		
		return minCost;
	}
	
	
	public static void main(String[] args) {

		System.out.println("hello world!!");

		
		TheShuttles obj = new TheShuttles();
		
		System.out.println("hello world!! + " + obj.getLeastCost(new int[]{51, 1, 77, 14, 17, 10, 80},32,40));
		
		
	}

}
