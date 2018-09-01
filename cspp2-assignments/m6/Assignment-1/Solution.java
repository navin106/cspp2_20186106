import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author :
 */
public final class Solution {
	/**
	* Empty constructor.
	*/
	private Solution() {
		//not used
	}
	/**
	 * Prints the odd composite numbers between 2 and n.
	 *
	 * @param      n     n value
	 */
	public static void oddComposites(final int n) {
		// write your code here
		int[] a = new int[n];
		int l = 0;
		int cnt = 0;
		for (int i = 1; i <= n ; i++ ) {
			cnt = 0;
			for (int j = 1; j <= i ; j++ ) {
					if (i % j == 0) {
						cnt += 1;
				}else {
					if (j*j == i){
						cnt -=2;
					}
				}


			}
			// System.out.println(cnt);
			if (cnt == 4) {
				a[l] = i;
				l++;
			}

		}
		// System.out.println("---------");
		for (int k= 0;k<a.length ;k++) {
			// System.out.println(a[k]);
			if (a[k] != 0 && a[k]%2 !=0) {
				System.out.println(a[k]);
			}
			
		}
	}
	/**
	* main method as driver program.
	* @param args is the parameter for this method
	*/
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		oddComposites(n);
	}
}

