public class PilingRectsDiv2 {

	public int count(int[] rating) {
		
		int count = 0;
		int prev = 0;
		int current = 0;
		
		if(rating.length == 1 && rating[0] >= 1200)
			return 1;
		else if(rating.length == 1 && rating[0] < 1200)
			return 0;
		
		if(rating[0] >= 1200)
			count++;
		
		for(int i = 1; i < rating.length; i++) {
			prev = rating[i - 1];
			current = rating[i];
			
			if( !((prev >= 1200 && current >= 1200) || (prev < 1200 && current < 1200)) )
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {

		PilingRectsDiv2 obj = new PilingRectsDiv2();
		System.out.println(obj.count(new int[] {33, 91, 136, 49, 19, 105, 143, 58, 188, 135, 195, 84, 119, 52, 168, 29, 161, 2, 180, 195, 68, 25, 174, 67, 62, 20, 93, 72, 192, 86, 91, 57, 128, 137, 91, 136, 33, 26, 71, 63, 84, 128, 36, 15, 115, 65, 14, 184, 48, 186}));
	}

}
