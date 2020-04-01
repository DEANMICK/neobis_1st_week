import java.util.Scanner;

public class DataType {
	public static void main(String[] args) {
		int i = 4, q;
		double d = 4.0, w;
		String s = "HackerRank";
		Scanner scan = new Scanner(System.in);
		q = scan.nextInt();
		w = scan.nextDouble();
		scan.nextLine();
		String e = scan.nextLine();
		scan.close();
		System.out.println(i + q);
		System.out.println(d + w);
		System.out.println(s + " " + e);
	}
}
