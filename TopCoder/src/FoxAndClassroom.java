
public class FoxAndClassroom {

	
	String ableTo(int n, int m) {
		
		int startN = 0;
		int startM = 0;
		
		for(int i = 0; i < n; i++) {
		
			for(int j = 0; j < m; j++) {
				
				startN = i;
				startM = j;
				
				int r = (startN+1)%n;
				int c = (startM+1)%m;
				int count = 1;
				
				while(!(r== startN && c==startM)) {
					r = (r + 1) % n;
					c = (c + 1) % m;
					count++;
				}
				System.out.println("count" + count);
				if(count == n*m)
					return "Possible";
			}
		}
		
		return "Impossible";
	}
	
	
	public static void main(String[] args) {

		System.out.println("hello world!!");

		
		FoxAndClassroom obj = new FoxAndClassroom();
		
		System.out.println("hello world!! + " + obj.ableTo(3,6));
		
		
	}

}
