/* Steque - A stack-ended queue or steque is a data type that supports push, pop, and
 * enqueue. Articulate an API for this ADT. Develop a linked-list-based implementation.
 */

package ch1.section3;

import java.util.Iterator;

public class Ex32_Steque<Item> implements Iterable<Item>{

	private final LinkedList<Item> ll = new LinkedList<>();
	
	public boolean isEmpty() {
		return ll.size() == 0;
	}
	
	public int size() {
		return ll.size();
	}

	public void enqueue(Item it) {
		ll.pushBack(it);
	}
	
	public void push(Item it) {
		ll.pushFront(it);
	}
	
	public Item pop() {
		return ll.removeFront();
	}

	@Override
	public Iterator<Item> iterator() {
		return ll.iterator();
	}

}
