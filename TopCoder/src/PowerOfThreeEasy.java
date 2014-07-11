import java.util.LinkedList;

public class PowerOfThreeEasy {

	
	public String ableToGet(int x, int y) {
		
		class Node {
			int x;
			int y;
			int step;
			
			public Node(int x, int y, int step) {
				this.x = x;
				this.y = y;
				this.step = step;
			}
		}
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(new Node(0,0,0));
		
		while(!list.isEmpty()) {
			
			Node node = list.removeFirst();
			int tempx = node.x;
			int tempy = node.y;
			int step = node.step;
			
			if(tempx == x && tempy == y) {
				return "Possible";
			}
			
			list.add(new Node(tempx + (int)Math.pow(3, step), tempy, step + 1));
			list.add(new Node(tempx, tempy + (int)Math.pow(3, step), step + 1));
			
			if(tempx > x && tempy > y)
				break;
			
		}
		return "Impossible";
	}

	public static void main(String[] args) {

		PowerOfThreeEasy obj = new PowerOfThreeEasy();
		System.out.println(obj.ableToGet(3,10));
	}

}

