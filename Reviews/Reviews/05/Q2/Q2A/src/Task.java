// Task class
class Task {
    private String id;
    private String name;
    private int priority;
    private int estimatedTime; // in minutes
    
    public Task(String id, String name, int priority, int estimatedTime) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.estimatedTime = estimatedTime;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    public int getEstimatedTime() {
        return estimatedTime;
    }
    
    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
    
    @Override
    public String toString() {
        return "(" + id + "," + name + "," + priority + "," + estimatedTime + ")";
    }
}
