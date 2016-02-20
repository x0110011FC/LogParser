import java.security.SecureRandom;
import java.util.Scanner;

/*
 * This program creates a password according to specified logic.
 * 
 * Logic description:
 * 
 * DONE 1. list of random characters
 * DONE 2. some characters in upper case - depends of 'keyWord'
 * 3. random numbers of digits
 * DONE 4. random 'hash #' character in password.
 * DONE 5. password length defined by user
 * 6. add special characters like '!,.:;=+?-'' - merge or add two arrays @letters and @specialCharacters
 * when special characters allowed in passsword
 * 7. keyWord - data must be changed randomly or with reminder to change for user
 * 8. clean code
 * 9. GUI
 * 10. Unit tests
 * DONE 11. Change Random to SecureRandom
 */
public class Password_Main {

	private static final char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
			'v', 'w', 'x', 'y', 'z','#' };
	private static final char[] specialCharacters = {'!',',','.',':',';','=','+','?','-','\''};
	
	// Key word or list of characters which must be upper case
	private static final char[] keyWord = { 'a', 'b', 'k', 'r', 'f', 'l', 'w' };
	private static int passworLength;
	private static final int lettersArrayLength = letters.length;
	private static int specialCharsAllowed;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		
		// Tip: Test for integer before pass (only Integer accepted)
		System.out.println("Provide password length and put '1' if special characters ex. \"!,.:;=+?-'':\" allowed in password: ");

		passworLength = in.nextInt();
		//specialCharsAllowed = in.nextInt();
		

		
		while (passworLength < 10) {
			System.out.println("Password length must be more than 10!" + "\n");

			System.out.println("\nProvide password length (number):");
			passworLength = in.nextInt();
		}

		System.out.println(randomChar(letters, keyWord, passworLength));
	}

	/*
	 * randomChar method creates password on logic provided before
	 * 
	 * @param l - list of letters used in password
	 * 
	 * @param k - keyWord which characters must be in upper case
	 * 
	 * @param a - password length, defined by user
	 */
	public static char[] randomChar(char[] l, char[] k, int a) {		

		char[] selectedChar = new char[a];
		SecureRandom randomQualifier = new SecureRandom();

		/*
		 * Tip: The following tests required: 1. - all characters upper or lower
		 * case (not allowed) 2. - more then 2 the same characters in row is not
		 * allowed
		 */

		for (int i = 0; i < selectedChar.length; i++) {
			int key = (int) (randomQualifier.nextDouble() * lettersArrayLength);
			selectedChar[i] = l[key];
			for (int j = 0; j < k.length; j++) {
				if (selectedChar[i] == k[j]) {
					selectedChar[i] = Character.toUpperCase(selectedChar[i]);
				}
			}
		}

		return selectedChar;
	}
}
