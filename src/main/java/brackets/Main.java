package brackets;
/*
Write a program that checks if brackets of type (, ), {, }, [, ] in a string of characters are closed in time
(if the string consists of only brackets of these types). Thus the string (([]{})) is correct, while the strings (({}[))
and (([{]})) - are wrong: the first one is missing one bracket, and the second one has a broken logic
(the closing bracket should be of the same type as the last opening one).
 */
public class Main {
	
	public static void main(String[] args) {
		Stack st1 = new Stack();
		char[] brackets = {'(', ')', '[', ']', '{', '}'};
		String str = "(([{]}))";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (isOpenBracket(c, brackets)) {
				st1.push(c);
			} else {
				if (st1.isEmpty()) {
					System.out.println("Wrong bracket string");
					return;
				}
				char b = st1.pop();
				// Matching bracket types b and c
				if (!isBracketsMatch(b, c, brackets)) {
					System.out.println("Wrong bracket string");
					return;
				}
			}
		}
		if (st1.isEmpty()) {
			System.out.println("Correct bracket string");
		} else {
			System.out.println("Wrong bracket string");
		}
	}
	
	private static boolean isOpenBracket(char c, char[] brackets) {
		for (int i = 0; i < brackets.length; i += 2) {
			if (brackets[i] == c) {
				return true;
			}
		}
		return false;
	}
	
	// b - opening brackets
	// c - closing brackets
	private static boolean isBracketsMatch(char b, char c, char[] brackets) {
		for (int i = 0; i < brackets.length; i += 2) {
			if (brackets[i] == b && brackets[i + 1] == c) {
				return true;
			}
		}
		return false;
	}
}