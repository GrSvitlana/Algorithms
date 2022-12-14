package baseballGame;

public class Stack {
	private StackItem top;
	
	public void push(int item) {
		StackItem temp = new StackItem();
		temp.value = item;
		temp.next = top;
		top = temp;
	}
	
	public int pop() {
		int a = top.value;
		top = top.next;
		return a;
	}
	
	public int top() {
		return top.value;
	}
	
	// Checking if the stack is empty
	public boolean isEmpty() {
		return (top == null);
	}
	
	private class StackItem {
		int value;
		StackItem next;
	}
}
