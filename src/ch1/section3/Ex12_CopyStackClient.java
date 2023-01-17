/* Write an iterable Stack client that has a static method copy() that takes a stack
 * of strings as argument and returns a copy of the stack.
 * Note : This ability is a prime example of the value of having an iterator, because
 * it allows development of such functionality without changing the basic API.
 */

package ch1.section3;

public class Ex12_CopyStackClient {
	public static Stack<String> copy(Stack<String> stack) {
		Stack<String> temp = new Stack<String>();
		for(String s: stack) {
			temp.push(s);
		}
		Stack<String> result =  new Stack<String>();
		for(String s: temp) {
			result.push(s);
		}
		return result;
	}
}
