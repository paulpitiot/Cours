package cours;

public class Hachage {

	public static void main(String[] args) {
		String str1 = "Paul";
		String str2 = "Pierre";
		String str3 = "Louis";
		System.out.println(str2.hashCode());
		System.out.println(str1.hashCode());
		System.out.println(str3.hashCode());
		System.out.println(Math.abs(str2.hashCode()%10));
		System.out.println(Math.abs(str1.hashCode()%10));
		System.out.println(Math.abs(str3.hashCode()%10));
	}
}
