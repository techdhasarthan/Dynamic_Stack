public class DStack {

    int capacity = 2;
    int[] stack = new int[capacity];
    int top = 0;

    public void push(int data) {
        if (size() == capacity)
            expand();
        stack[top] = data;
        top++;
    }

    private void expand() {
        int length = size();
        int[] newStack = new int[capacity * 2];
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
        capacity *= 2;
        System.out.println("The capacity " + capacity);
    }

    public void pop() {
        if (!isEmpty()) {
            top--;

            shrink();
        } else {
            System.out.println("Stack underflow");
        }
    }

    private void shrink() {
        int length = size();
        if (length <= (capacity / 2) / 2) {
            capacity = capacity / 2;
            int[] newStack = new int[capacity];
            System.arraycopy(stack, 0, newStack, 0, length);
            stack = newStack;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return stack[top - 1];
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top <= 0;
    }

    public void show() {
        for (int stacks : stack) {
            System.out.print(stacks + " ");
        }
        System.out.println();
    }
}
