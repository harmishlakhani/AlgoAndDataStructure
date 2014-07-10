import java.util.Arrays;

public class MiniatureDachshund {

	public int maxMikan(int[] mikan, int weight) {

		if(weight == 5000)
			return 0;
		int len = mikan.length;
		Arrays.sort(mikan);
		int i = 0;
		for(i = 0; (i < len) && (weight + mikan[i]) <= 5000 ;i++) {
			weight += mikan[i]; 
		}
		return i;
	}

	public static void main(String[] args) {

		MiniatureDachshund obj = new MiniatureDachshund();

		System.out.println("hello world!! + "
				+ obj.maxMikan(new int[] {200, 50, 200, 50, 200, 50, 200, 50}, 4800));

	}

}
