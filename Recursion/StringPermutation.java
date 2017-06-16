/**
 * The complexity of this solution is O(n!) because what we are doing
 * is going through every possible combination, which is n!
 * For n = 3, this is 3! Before you place the first character,
 * you can choose from 3 (a, b, c). After you're place the first character, you
 * can only chose from 2, since you've already made your choice for the first place,
 * if you chose 'a', then you have a choice between (b,c). After that, you just have on choice c.
 * 
 * (a,b,c) * (a,b,c-1)*(a,b,c,-2) =
 * (3)*(2)*(1) =
 * (n)*(n-1)*(n-2) ... (1) = (n!)
 */
package Recursion;

import java.util.ArrayList;

public class StringPermutation {
	private int strLen;

	StringPermutation(String s) {
		strLen = s.length();
		solve(s);
	}

	ArrayList<String> solve(String input) {
		ArrayList<String> perms = new ArrayList<String>();

		// base case
		if (input.length() == 0) {
			perms.add("");
			return perms;
		}

		char prefix = input.charAt(0);
		String str = input.substring(1);

		ArrayList<String> substrings = solve(str);

		for (String s : substrings) {
			for (int i = 0; i <= s.length(); i++) {
				String beginning = s.substring(0, i);
				String middle = Character.toString(prefix);
				String end = s.substring(i);
				perms.add(beginning + middle + end);
			}
		}

		printResult(perms);
		return perms;
	}

	void printResult(ArrayList<String> list) {
		for (String s : list) {
			if (s.length() == strLen) {
				System.out.println(s);
			}
		}
	}

	public static void main(String[] args) {
		StringPermutation perm = new StringPermutation("abc");
	}

}
