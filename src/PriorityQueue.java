import java.util.ArrayList;

public class PriorityQueue {
    private ArrayList<HeapNode> heap;

    public PriorityQueue() {
        // Initialize an empty list to represent the heap
        heap = new ArrayList<>();
    }

    // Heap Node class to store priority and item
    private class HeapNode {
        int priority;
        String item;

        HeapNode(int priority, String item) {
            this.priority = priority;
            this.item = item;
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int i, int j) {
        HeapNode temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    public void insert(int priority, String item) {
        heap.add(new HeapNode(priority, item));
        bubbleUp(heap.size() - 1);
    }
    public String peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Priority Queue is empty.");
        }
        return heap.get(0).item;
    }
    
    private void bubbleUp(int index) {
        int parentIndex = parent(index);
        if (index > 0 && heap.get(index).priority < heap.get(parentIndex).priority) {
            swap(index, parentIndex);
            bubbleUp(parentIndex);
      }
    }


}

