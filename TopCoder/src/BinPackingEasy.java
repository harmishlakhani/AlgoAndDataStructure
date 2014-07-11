import java.util.Arrays;

public class BinPackingEasy {

	public int minBins(int[] item) {

		int minBins = 0;
		int N = item.length;
		boolean[] flag = new boolean[item.length];

		Arrays.sort(item);

		int count = 0;
		while (count != N) {
			int capacity = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (flag[i] != true && ((capacity + item[i]) <= 300)) {
					flag[i] = true;
					capacity += item[i];
					count++;
				}
			}
			minBins++;
		}
		return minBins;
	}

	public static void main(String[] args) {

		System.out.println("hello world!!");

		BinPackingEasy obj = new BinPackingEasy();

		System.out.println("hello world!! + "
				+ obj.minBins(new int[] { 123, 145, 167, 213, 245, 267, 289,
						132, 154, 176, 198 }));

	}

}
