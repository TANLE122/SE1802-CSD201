/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 *
 * @author tungi
 */
public class Graph {

    int[][] a; // adjacency matrix
    String[] v; // vertex labels
    int n; // number of vertices

    public Graph() {
        n = 0;
        a = new int[20][20];
        v = new String[20];
    }


    // Add vertex to the graph
    void addVertex(String vertex) {
        v[n] = vertex;
        n++;
    }

    // Add edge with weight
    void addEdge(int start, int end, int weight) {
        a[start][end] = weight;
        a[end][start] = weight;
    }

    // Breadth-first traversal
    void breadthFirst(int k) {
        MyQueue q = new MyQueue();
        int i, h;
        boolean[] enqueued = new boolean[n];
        for (i = 0; i < n; i++) {
            enqueued[i] = false;
        }

        q.enqueue(new Integer(k));
        enqueued[k] = true;

        while (!q.isEmpty()) {
            h = Integer.parseInt(q.dequeue().toString().trim());
            visit(h);
            for (i = 0; i < n; i++) {
                if ((!enqueued[i]) && a[h][i] > 0) {
                    q.enqueue(new Integer(i));
                    enqueued[i] = true;
                }
            }
        }
        System.out.println();
    }

    // Visit vertex
    void visit(int i) {
        System.out.print(" " + v[i]);
    }

    // Recursive depth-first traversal
    void depthFirst(boolean visited[], int i) {
        visit(i);
        visited[i] = true;
        for (int j = 0; j < n; j++) {
            if (a[i][j] > 0 && (!visited[j])) {
                depthFirst(visited, j);
            }
        }
    }

    // Depth-first traversal from vertex k
    void depthFirst(int k) {
        boolean[] visited = new boolean[20];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }

        depthFirst(visited, k);

        // Visit unvisited vertices
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                depthFirst(visited, i);
            }
        }
        System.out.println();
    }

    // Dijkstra's algorithm implementation
    void dijkstra(int first) {
        int[] currDist = new int[n];
        int[] predecessor = new int[n];
        boolean[] checked = new boolean[n];

        // Initialize distances
        for (int i = 0; i < n; i++) {
            currDist[i] = Integer.MAX_VALUE;
            checked[i] = false;
            predecessor[i] = -1;
        }
        currDist[first] = 0;

        while (true) {
            // Find unchecked vertex with minimum distance
            int u = -1;
            int minDist = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!checked[i] && currDist[i] < minDist) {
                    u = i;
                    minDist = currDist[i];
                }
            }

            if (u == -1) {
                break; // All vertices checked
            }
            checked[u] = true;

            // Update distances to adjacent vertices
            for (int v = 0; v < n; v++) {
                if (!checked[v] && a[u][v] > 0) {
                    int newDist = currDist[u] + a[u][v];
                    if (newDist < currDist[v]) {
                        currDist[v] = newDist;
                        predecessor[v] = u;
                    }
                }
            }
        }

        // Print results
        System.out.println("Shortest paths from vertex " + v[first] + ":");
        for (int i = 0; i < n; i++) {
            if (i != first) {
                System.out.print("To " + v[i] + ": ");
                if (currDist[i] == Integer.MAX_VALUE) {
                    System.out.println("No path exists");
                } else {
                    System.out.println("Distance = " + currDist[i] + ", Path: " + getPath(predecessor, first, i));
                }
            }
        }
    }

    // Helper method to construct path for Dijkstra's algorithm
    private String getPath(int[] predecessor, int start, int end) {
        if (predecessor[end] == -1) {
            return v[start] + " -> " + v[end];
        }
        return getPath(predecessor, start, predecessor[end]) + " -> " + v[end];
    }

    // Floyd-Warshall Algorithm implementation
    void floydWarshall() {
        int[][] D = new int[n][n];  // Distance matrix
        int[][] P = new int[n][n];  // Predecessor matrix

        // Initialize D and P matrices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    D[i][j] = 0;
                } else if (a[i][j] > 0) {
                    D[i][j] = a[i][j];
                } else {
                    D[i][j] = Integer.MAX_VALUE;
                }
                P[i][j] = 0;
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (D[i][k] != Integer.MAX_VALUE && D[k][j] != Integer.MAX_VALUE) {
                        if (D[i][j] > D[i][k] + D[k][j]) {
                            D[i][j] = D[i][k] + D[k][j];
                            P[i][j] = k;
                        }
                    }
                }
            }
        }

        // Print results
        System.out.println("All-Pairs Shortest Paths:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    System.out.print("From " + v[i] + " to " + v[j] + ": ");
                    if (D[i][j] == Integer.MAX_VALUE) {
                        System.out.println("No path exists");
                    } else {
                        System.out.println("Distance = " + D[i][j] + ", Path: " + getFloydPath(P, i, j));
                    }
                }
            }
        }
    }

    // Helper method to reconstruct path for Floyd-Warshall algorithm
    private String getFloydPath(int[][] P, int i, int j) {
        if (P[i][j] == 0) {
            return v[i] + " -> " + v[j];
        }
        int k = P[i][j];
        return getFloydPath(P, i, k) + " -> " + getFloydPath(P, k, j).substring(v[k].length() + 4);
    }

    // Prim's Algorithm implementation
    void primMST() {
        // Mảng lưu trọng số nhỏ nhất từ MST đến các đỉnh chưa được thêm vào MST
        int[] key = new int[n];
        
        // Mảng lưu các đỉnh cha trong MST
        int[] parent = new int[n];
        
        // Mảng đánh dấu các đỉnh đã thêm vào MST
        boolean[] mstSet = new boolean[n];
        
        // Khởi tạo tất cả các key là vô cùng và mstSet[] là false
        for (int i = 0; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        
        // Đỉnh đầu tiên luôn được chọn
        key[0] = 0;     // Make key 0 so that this vertex is picked as first
        parent[0] = -1; // First node is always root of MST
        
        // Tìm MST
        for (int count = 0; count < n - 1; count++) {
            // Tìm đỉnh có key nhỏ nhất từ tập các đỉnh chưa thêm vào MST
            int u = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!mstSet[i] && key[i] < min) {
                    min = key[i];
                    u = i;
                }
            }
            
            // Thêm đỉnh được chọn vào MST
            mstSet[u] = true;
            
            // Cập nhật key và parent của các đỉnh kề
            for (int v = 0; v < n; v++) {
                // Cập nhật chỉ khi có cạnh từ u đến v, v chưa được thêm vào MST và a[u][v] nhỏ hơn key[v] hiện tại
                if (a[u][v] > 0 && !mstSet[v] && a[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = a[u][v];
                }
            }
        }
        
        // In kết quả MST
        System.out.println("Cây khung nhỏ nhất sử dụng thuật toán Prim:");
        int totalWeight = 0;
        for (int i = 1; i < n; i++) {
            System.out.println(v[parent[i]] + " - " + v[i] + " : " + a[i][parent[i]]);
            totalWeight += a[i][parent[i]];
        }
        System.out.println("Tổng trọng số: " + totalWeight);
    }
    
    // Cài đặt thuật toán Prim sử dụng hàng đợi ưu tiên
    void primMSTWithPriorityQueue() {
        // Hàng đợi ưu tiên để lưu trữ các đỉnh chưa xét và key tương ứng
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        // key[i] = trọng số nhỏ nhất của cạnh kết nối đỉnh i với MST hiện tại
        int[] key = new int[n];
        
        // parent[i] = đỉnh cha của i trong MST
        int[] parent = new int[n];
        
        // Đánh dấu các đỉnh đã thêm vào MST
        boolean[] inMST = new boolean[n];
        
        // Khởi tạo tất cả các key là vô cùng
        Arrays.fill(key, Integer.MAX_VALUE);
        
        // Bắt đầu từ đỉnh 0
        pq.add(new int[]{0, 0}); // [đỉnh, key]
        key[0] = 0;
        parent[0] = -1;
        
        // MST có n đỉnh, cần n-1 cạnh
        while (!pq.isEmpty() && pq.size() < n) {
            // Lấy đỉnh có key nhỏ nhất
            int u = pq.poll()[0];
            
            // Nếu đỉnh đã thêm vào MST, bỏ qua
            if (inMST[u]) continue;
            
            // Thêm đỉnh vào MST
            inMST[u] = true;
            
            // Cập nhật key và parent của các đỉnh kề
            for (int v = 0; v < n; v++) {
                if (a[u][v] > 0 && !inMST[v] && a[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = a[u][v];
                    pq.add(new int[]{v, key[v]});
                }
            }
        }
        
        // In kết quả MST
        System.out.println("Cây khung nhỏ nhất sử dụng thuật toán Prim (với Priority Queue):");
        int totalWeight = 0;
        for (int i = 1; i < n; i++) {
            System.out.println(v[parent[i]] + " - " + v[i] + " : " + a[i][parent[i]]);
            totalWeight += a[i][parent[i]];
        }
        System.out.println("Tổng trọng số: " + totalWeight);
    }
    
    // Kruskal's Algorithm implementation
    void kruskalMST() {
        // Mảng để lưu trữ kết quả MST
        Edge[] result = new Edge[n - 1];
        
        // Tạo danh sách cạnh từ ma trận kề
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        
        // Thêm tất cả các cạnh vào hàng đợi ưu tiên
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i][j] > 0) {
                    pq.add(new Edge(i, j, a[i][j]));
                }
            }
        }
        
        // Tạo tập hợp rời rạc
        DisjointSet ds = new DisjointSet(n);
        
        int e = 0; // Số cạnh đã thêm vào MST
        
        // Xử lý các cạnh theo thứ tự tăng dần của trọng số
        while (e < n - 1 && !pq.isEmpty()) {
            // Lấy cạnh có trọng số nhỏ nhất
            Edge edge = pq.poll();
            
            int x = ds.find(edge.source);
            int y = ds.find(edge.destination);
            
            // Nếu thêm cạnh này không tạo chu trình
            if (x != y) {
                result[e++] = edge;
                ds.union(x, y);
            }
        }
        
        // In kết quả MST
        System.out.println("Cây khung nhỏ nhất sử dụng thuật toán Kruskal:");
        int totalWeight = 0;
        for (int i = 0; i < e; i++) {
            Edge edge = result[i];
            System.out.println(v[edge.source] + " - " + v[edge.destination] + " : " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Tổng trọng số: " + totalWeight);
    }

    // Main method with example usage
    public static void main(String[] args) {
        Graph g = new Graph();

        // Add vertices
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");

        // Add edges with weights
        g.addEdge(0, 1, 2);  // A to B with weight 2
        g.addEdge(0, 2, 4);  // A to C with weight 4
        g.addEdge(1, 2, 1);  // B to C with weight 1
        g.addEdge(1, 3, 7);  // B to D with weight 7
        g.addEdge(2, 4, 3);  // C to E with weight 3
        g.addEdge(3, 4, 1);  // D to E with weight 1

        System.out.println("Breadth-First Traversal starting from A:");
        g.breadthFirst(0);

        System.out.println("\nDepth-First Traversal starting from A:");
        g.depthFirst(0);

        System.out.println("\nDijkstra's Algorithm starting from A:");
        g.dijkstra(0);

        System.out.println("\nFloyd-Warshall Algorithm for All-Pairs Shortest Paths:");
        g.floydWarshall();
        
        System.out.println("\nPrim's Minimum Spanning Tree Algorithm:");
        g.primMST();
        
        System.out.println("\nPrim's Minimum Spanning Tree Algorithm (with Priority Queue):");
        g.primMSTWithPriorityQueue();
        
        System.out.println("\nKruskal's Minimum Spanning Tree Algorithm:");
        g.kruskalMST();
    }
}