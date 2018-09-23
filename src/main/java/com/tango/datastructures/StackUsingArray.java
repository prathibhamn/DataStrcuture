package com.tango.datastructures;

/**
 * Hello world!
 *
 */

/**
 * This is a unbound stack with different growth strategy. The options are Tight
 * and Double. This is same implementation as ArrayList. In Tight strategy it
 * creates a new Stack with current capacity + 5 and in Double strategy it
 * creates a Stack of double size of current capacity and then copies all the
 * elements from the Old Stack to New Stack.
 */
class ArrayStack<E> implements Stack<E> {
	private int top = -1;
	private int capacity;
	private static int defaultSize = 1024;
	private int overflowStrategy;
	private E[] stack;

	public ArrayStack() {
		this(0);
	}

	public ArrayStack(int overflowStrategy) {
		this(defaultSize, overflowStrategy);
	}

	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity, int overflowStrategy) {
		this.capacity = capacity;
		stack = (E[]) new Object[capacity];
		this.overflowStrategy = overflowStrategy;
	}

	@Override
	public int size() {
		return top + 1;
	}

	@Override
	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}

	@Override
	public void push(E element) throws Exception {
		if (top == capacity - 1) {
			// different strategies to deal with overflow
			if (this.overflowStrategy == 2)
				tightStrategy();
			else if (this.overflowStrategy == 1)
				growthStrategy();
			else
				throw new Exception("stack full..cant enter");
		}
		stack[++top] = element;
	}

	@Override
	public E pop() throws Exception {
		if (top == -1)
			throw new Exception("stack empty..cant pop");
		return stack[top--];
	}

	@Override
	public E top() throws Exception {
		if (top == -1)
			throw new Exception("stack empty");
		return stack[top];
	}

	@SuppressWarnings("unchecked")
	public void tightStrategy() {
		E[] newStack = (E[]) new Object[capacity + 5];
		for (int i = 0; i < capacity; i++)
			newStack[i] = stack[i];
		stack = newStack;
		capacity = capacity + 5;
	}

	@SuppressWarnings("unchecked")
	public void growthStrategy() {
		E[] newStack = (E[]) new Object[capacity * 2];
		for (int i = 0; i < capacity; i++)
			newStack[i] = stack[i];
		stack = newStack;
		capacity = capacity * 2;
	}

	public void showStack() {
		for (int i = 0; i < capacity; i++) {
			if (i > top)
				System.out.print(" - ");
			else
				System.out.print(" " + stack[i] + " ");
		}
		System.out.println(" ");
	}

}

public class StackUsingArray {
	public static void main(String[] args) {
		try {
			for (int n = 10; n <= 10000; n = n * 10) {
				long startTime = System.currentTimeMillis();
				ArrayStack<Integer> myStack = new ArrayStack<Integer>(2);
				System.out.println("Running test for " + n + " elements");
				for (int i = 0; i < n; i++)
					myStack.push(i);
				System.out.println(myStack.size());
				System.out.println(((System.currentTimeMillis() - startTime)) + " miliseconds with tight strategy");
				startTime = System.currentTimeMillis();
				ArrayStack<Integer> myStackTwo = new ArrayStack<Integer>(1);
				for (int i = 0; i < n; i++)
					myStackTwo.push(i);
				System.out.println(((System.currentTimeMillis() - startTime)) + " miliseconds with growth strategy");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
