
import java.io.File;
import java.io.RandomAccessFile;

// Min Heap implementation for waiting tasks
class WaitingHeap {
    private Task[] heap;
    private int size;
    private int capacity;
    
    public WaitingHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new Task[capacity];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
    
    private int parent(int i) {
        return (i - 1) / 2;
    }
    
    private int leftChild(int i) {
        return 2 * i + 1;
    }
    
    private int rightChild(int i) {
        return 2 * i + 2;
    }
    
    private void swap(int i, int j) {
        Task temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    public void loadDataHeap(int k) {
        try {
            // Clear current heap
            this.size = 0;
            
            File dataFile = new File("data.txt");
            if (!dataFile.exists()) {
                System.out.println("File data.txt does not exist.");
                return;
            }
            
            try {
                String[] ids = Lib.readLineToStrArray("data.txt", k);
                String[] names = Lib.readLineToStrArray("data.txt", k + 1);
                String[] priorityStr = Lib.readLineToStrArray("data.txt", k + 2);
                String[] timeStr = Lib.readLineToStrArray("data.txt", k + 3);
                
                if (ids == null || names == null || priorityStr == null || timeStr == null) {
                    System.out.println("Cannot read enough data from data.txt.");
                    return;
                }
                
                int[] priorities = new int[priorityStr.length];
                int[] times = new int[timeStr.length];
                
                for (int i = 0; i < priorityStr.length; i++) {
                    try {
                        priorities[i] = Integer.parseInt(priorityStr[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid priority format at position " + i + ": " + priorityStr[i]);
                        return;
                    }
                }
                
                for (int i = 0; i < timeStr.length; i++) {
                    try {
                        times[i] = Integer.parseInt(timeStr[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid time format at position " + i + ": " + timeStr[i]);
                        return;
                    }
                }
                
                int n = Math.min(Math.min(ids.length, names.length), Math.min(priorities.length, times.length));
                for (int j = 0; j < n; j++) {
                    insert(new Task(ids[j], names[j], priorities[j], times[j]));
                }
                System.out.println("Successfully loaded waiting heap data from file: " + n + " items.");
            } catch (Exception e) {
                System.out.println("Error reading waiting heap data: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Critical error in waiting heap data loading process: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // To be implemented by students
    public void insert(Task task) {
        if (isFull()) {
            System.out.println("Heap is full!");
            return;
        }
        
        // Insert the new task at the end of the heap
        heap[size] = task;
        int current = size;
        size++;
        
        // Heapify up: compare with parent and swap if needed
        while (current > 0 && heap[current].getPriority() < heap[parent(current)].getPriority()) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    
    // To be implemented by students
    public Task removeMin() {
         if (isEmpty()) {
            return null;
        }

        // Get the minimum element (root)
        Task min = heap[0];
        
        // Replace root with last element
        heap[0] = heap[size - 1];
        size--;
        
        // Heapify down: restore min-heap property
        heapifyDown(0);
        
        return min;
    }
    
    private void heapifyDown(int i) {
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);
        
        // Compare with left child
        if (left < size && heap[left].getPriority() < heap[smallest].getPriority()) {
            smallest = left;
        }
        
        // Compare with right child
        if (right < size && heap[right].getPriority() < heap[smallest].getPriority()) {
            smallest = right;
        }
        
        // If smallest is not the current node, swap and continue heapifying
        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }
    
    public Task peek() {
        if (isEmpty()) {
            return null;
        }
        return heap[0];
    }
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Empty";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(heap[i]).append(" ");
        }
        return sb.toString().trim();
    }
    
    // Method to get all tasks for f3 and f4
    public Task[] getAllTasks() {
        Task[] tasks = new Task[size];
        for (int i = 0; i < size; i++) {
            tasks[i] = heap[i];
        }
        return tasks;
    }
    
    // Get size
    public int getSize() {
        return size;
    }
}

// Stack implementation for execution list
class ExecutionStack {
    Node head;
    
    ExecutionStack() {
        head = null;
    }
    
    boolean isEmpty() {
        return (head == null);
    }
    
    void clear() {
        head = null;
    }
    
    void loadDataStack(int k) {
        try {
            clear();
            
            File dataFile = new File("data.txt");
            if (!dataFile.exists()) {
                System.out.println("File data.txt does not exist.");
                return;
            }
            
            try {
                String[] ids = Lib.readLineToStrArray("data.txt", k + 4);
                String[] names = Lib.readLineToStrArray("data.txt", k + 5);
                String[] priorityStr = Lib.readLineToStrArray("data.txt", k + 6);
                String[] timeStr = Lib.readLineToStrArray("data.txt", k + 7);
                
                if (ids == null || names == null || priorityStr == null || timeStr == null) {
                    System.out.println("Cannot read enough execution data from data.txt.");
                    return;
                }
                
                int[] priorities = new int[priorityStr.length];
                int[] times = new int[timeStr.length];
                
                for (int i = 0; i < priorityStr.length; i++) {
                    try {
                        priorities[i] = Integer.parseInt(priorityStr[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid priority format at position " + i + ": " + priorityStr[i]);
                        return;
                    }
                }
                
                for (int i = 0; i < timeStr.length; i++) {
                    try {
                        times[i] = Integer.parseInt(timeStr[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid time format at position " + i + ": " + timeStr[i]);
                        return;
                    }
                }
                
                int n = Math.min(Math.min(ids.length, names.length), Math.min(priorities.length, times.length));
                for (int j = 0; j < n; j++) {
                    push(new Task(ids[j], names[j], priorities[j], times[j]));
                }
                System.out.println("Successfully loaded execution stack data from file: " + n + " items.");
            } catch (Exception e) {
                System.out.println("Error reading execution stack data: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Critical error in execution stack data loading process: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // To be implemented by students
    void push(Task task) {
        Node node = new Node(task);
        if (isEmpty()) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }
    
    // To be implemented by students
    Task pop() {
       if (isEmpty()) {
            return null;
        }
        
        Task topTask = head.info;
        head = head.next;
        return topTask;
    }
    
    Task peek() {
        if (isEmpty()) {
            return null;
        }
        return head.info;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Empty";
        }
        
        StringBuilder sb = new StringBuilder();
        Node p = head;
        while (p != null) {
            sb.append(p.info).append(" ");
            p = p.next;
        }
        return sb.toString().trim();
    }
    
    // Method to get all tasks for f3
    public Task[] getAllTasks() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        
        Task[] tasks = new Task[count];
        p = head;
        count = 0;
        while (p != null) {
            tasks[count++] = p.info;
            p = p.next;
        }
        
        return tasks;
    }
}

// Main class for task scheduling
class TaskScheduler {
    WaitingHeap waitingTasks = new WaitingHeap(20); // Capacity for 20 tasks
    ExecutionStack executionStack = new ExecutionStack();
    
    TaskScheduler() {
    }
    
    void fvisit(Task p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p + " ");
        }
    }
    
    void ftraverse(RandomAccessFile f) throws Exception {
        f.writeBytes("Waiting Heap: " + waitingTasks.toString() + "\r\n");
        f.writeBytes("Execution Stack: " + executionStack.toString() + "\r\n");
    }
    
    void load(int k) throws Exception // do not edit this function
    {
        waitingTasks.loadDataHeap(k);
        executionStack.loadDataStack(k);
    }
    
    // ===========================================================================
    // =======YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
    // ===========================================================================
    void f1() throws Exception {
        load(0);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        
        f.close();
    }
    
    void f2() throws Exception {
        load(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        
        // ------------------------------------------------------------------------------------
        /*
         * You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */
        
        // Pop a task from execution stack
        Task completedTask = executionStack.pop();
        Task nextTask = waitingTasks.removeMin();
        if (nextTask != null) {
            executionStack.push(nextTask);
        }
        
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    void f3() throws Exception {
        load(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        
        // ------------------------------------------------------------------------------------
        /*
         * You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */
        
        int totalTime = 0;
        
        // Calculate total time from waiting heap
        Task[] waitingTasks = this.waitingTasks.getAllTasks();
        for (Task task : waitingTasks) {
            if (task != null) {
                totalTime += task.getEstimatedTime();
            }
        }
        
        // Calculate total time from execution stack
        Task[] executionTasks = this.executionStack.getAllTasks();
        for (Task task : executionTasks) {
            if (task != null) {
                totalTime += task.getEstimatedTime();
            }
        }
        
        f.writeBytes("\r\nTotal Estimated Time: " + totalTime + " minutes\r\n");
        
        // ------------------------------------------------------------------------------------
        f.close();
    }
    
    void f4() throws Exception {
        load(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        
        // ------------------------------------------------------------------------------------
        /*
         * You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */
        
        int threshold = 5;  // Priority threshold (move tasks with priority <= 5)
        f.writeBytes("\r\nThreshold Priority: " + threshold + "\r\n");
        
        int movedCount = 0;
        WaitingHeap tempHeap = new WaitingHeap(20);
        
              // Process all tasks in the waiting heap
        while (!waitingTasks.isEmpty()) {
            Task task = waitingTasks.removeMin();
            
            if (task.getPriority() <= threshold) {
                // Move high priority tasks to execution stack
                executionStack.push(task);
                movedCount++;
            } else {
                // Keep low priority tasks in a temporary heap
                tempHeap.insert(task);
            }
        }
        
        // Reset waiting heap with remaining low priority tasks
        while (!tempHeap.isEmpty()) {
            waitingTasks.insert(tempHeap.removeMin());
        }
        
        f.writeBytes("Tasks moved: " + movedCount + "\r\n\r\n");
        
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}
