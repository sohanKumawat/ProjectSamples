package com.demo.slk.algo;

import java.util.Stack;

public class GetAllSubsetByStack {
	

    private Stack<Integer> stack = new Stack<Integer>();
    private int sumInStack = 0;
    public void populateSubset(int[] data, int fromIndex, int endIndex) {
        if (sumInStack == TARGET_SUM) {
            print(stack);
        }
// private static final int[] DATA ={ 1, 3, 4, 5, 6, 15 };
        for (int currentIndex = fromIndex; currentIndex < endIndex; currentIndex++) {
            if (sumInStack + data[currentIndex] <= TARGET_SUM) {
                stack.push(data[currentIndex]);
                sumInStack += data[currentIndex];
                populateSubset(data, currentIndex + 1, endIndex);
                sumInStack -= (Integer) stack.pop();
            }
        }
    }

    private void print(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        sb.append(TARGET_SUM).append(" = ");
        for (Integer i : stack) {
            sb.append(i).append("+");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
    
    private static final int[] DATA ={ 1, 3, 4, 5, 6, 15 };
    public static final int TARGET_SUM = 9;
        public static void main(String[] args) {
            GetAllSubsetByStack get = new GetAllSubsetByStack();
            get.populateSubset(DATA, 0, DATA.length);
        }
}
