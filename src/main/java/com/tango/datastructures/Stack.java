/**
 * 
 */
package com.tango.datastructures;

/**
 * @author MN.Prathibha
 *
 */
public interface Stack<E> {

	int size();

	boolean isEmpty();
	void push(E element) throws Exception;

	E pop() throws Exception;

	E top() throws Exception;

}
