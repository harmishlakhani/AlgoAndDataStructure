import java.util.Scanner;

public class Solution {

	int T;
	int Q;
	int N;
	double[][] topicsLocation;
	int[][] qtAssociation;
	
	public void takeBasicInputs(Scanner sc) {
	
		T = sc.nextInt();
		Q = sc.nextInt();
		N = sc.nextInt();
		
		topicsLocation = new double[T][2];
		qtAssociation = new int[Q][10];
		
		for(int i = 0; i < T; i++) {
			sc.nextInt();
			topicsLocation[i][0] = sc.nextDouble();
			topicsLocation[i][1] = sc.nextDouble();
		}
		
		for(int i = 0; i < Q; i++) {
			sc.nextInt();
			int topics = sc.nextInt();
			int j = 0;
			if(topics != 0) {
				for(j = 0; j < topics; j++)
					qtAssociation[i][j] = sc.nextInt();
				if(topics < 10)
					qtAssociation[i][j] = -1;
			}
			else
				qtAssociation[i][0] = -1;
			
		}
	}
	
	public void queryOutput(int count, double x, double y) {
		
		double[] distance = new double[T];
		int[][] tempQ = new int[Q][2];
		
		for(int i = 0; i < T; i++) {
			distance[i] = Math.sqrt(Math.pow(x - topicsLocation[i][0], 2) + Math.pow(y - topicsLocation[i][1], 2));
		}
		
		int k = 0;
		for(int i = 0; i < Q; i++) {
			tempQ[k][1] = qtAssociation[i][0];
			tempQ[k][0] = i;
			int j = 0;
			for(; j < 10 && qtAssociation[i][j] != -1; j++) {
				if(distance[qtAssociation[i][j]] < distance[tempQ[k][1]]) {
					tempQ[k][1] = qtAssociation[i][j];
				}
			}
			if(j != 0)
				k++;
		}
		
		for(int i = 0; i < k && i < count; i++) {
			for(int j = 0; j < k - i - 1; j++) {
				if(distance[tempQ[j][1]] < distance[tempQ[j + 1][1]]) {
					int temp = tempQ[j][0];
					tempQ[j][0] = tempQ[j + 1][0];
					tempQ[j + 1][0] = temp;
				}
				else if(distance[tempQ[j][1]] == distance[tempQ[j + 1][1]] && 
						tempQ[j][0] > tempQ[j + 1][0]) {
					int temp = tempQ[j][0];
					tempQ[j][0] = tempQ[j + 1][0];
					tempQ[j + 1][0] = temp;
				}
			}
			System.out.print(tempQ[k - i - 1][0] + " ");
		}
		System.out.println();
	}
	
	public void topicOutput(int count, double x, double y) {
		
		double[] distance = new double[T];
		int[] tempT = new int[T];
		for(int i = 0; i < T; i++) {
			distance[i] = Math.sqrt(Math.pow(x - topicsLocation[i][0], 2) + Math.pow(y - topicsLocation[i][1], 2));
			tempT[i] = i;
		}
		
		for(int i = 0; i < count; i++) {
			
			for(int j = 0; j < T - i - 1; j++) {
				if(distance[j] < distance[j + 1]) {
					int temp = tempT[j];
					tempT[j] = tempT[j + 1];
					tempT[j + 1] = temp;
				}
			}
			System.out.print(tempT[T - i - 1] + " ");
		}
		System.out.println();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		Solution obj = new Solution();
		Scanner sc = new Scanner(System.in);
		obj.takeBasicInputs(sc);
		
		for(int i = 0; i < obj.N; i++) {
			/*String[] array = sc.nextLine().split("\\s+");
			if(array[0].charAt(0) == 'q')
				obj.queryOutput(Integer.parseInt(array[1]), Double.parseDouble(array[2]), Double.parseDouble(array[3]));
			else if(array[0].charAt(0) == 't')
				obj.topicOutput(Integer.parseInt(array[1]), Double.parseDouble(array[2]), Double.parseDouble(array[3]));*/
			String array = sc.next();
			if(array.charAt(0) == 'q')
				obj.queryOutput(Integer.parseInt(sc.next()), Double.parseDouble(sc.next()), Double.parseDouble(sc.next()));
			else if(array.charAt(0) == 't')
				obj.topicOutput(Integer.parseInt(sc.next()), Double.parseDouble(sc.next()), Double.parseDouble(sc.next()));
		}
	}

}
