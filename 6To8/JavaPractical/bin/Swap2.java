
import java.util.Scanner;


class SwitchCase {

	public static void main(String[] args)
	{
		int ch = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter your choice : ");
			
			ch = sc.nextInt();
			switch (ch) {
			case 1:System.out.println("1. Sunday");
				break;
			case 2:System.out.println("2. Monday");
				break;
			case 3:System.out.println("3. Tuseday");
				break;
			case 4:System.out.println("4. Wednesday");
				break;
			case 5:System.out.println("5. Thrusday");
				break;
			case 6:System.out.println("6. Friday");
				break;
			case 7:System.out.println("7. Saturday");
				break;
			case 8:System.out.println("8. Bye");
				System.out.println("bye");
				break;
 			default:
				System.out.println("Invalid choice");
			}
		} while (ch!=8);
	}
}
