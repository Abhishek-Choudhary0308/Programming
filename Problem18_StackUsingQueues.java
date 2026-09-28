import java.util.*;

public class Problem18_StackUsingQueues {
    static class MyStack {
        private final Queue<Integer> queue = new ArrayDeque<>();

        void push(int value) {
            queue.offer(value);
            int size = queue.size();
            for (int i = 1; i < size; i++) {
                queue.offer(queue.poll());
            }
        }

        int pop() {
            if (queue.isEmpty()) throw new NoSuchElementException("Stack is empty");
            return queue.poll();
        }

        int top() {
            if (queue.isEmpty()) throw new NoSuchElementException("Stack is empty");
            return queue.peek();
        }

        boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Empty: " + stack.empty());
    }
}