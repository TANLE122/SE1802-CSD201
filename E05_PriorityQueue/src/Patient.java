/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class Patient implements Comparable{
    private String name;
    private int priority;
    private String condition;
    private int age;

    public Patient() {
    }

    public Patient(String name, int priority, String condition, int age) {
        this.name = name;
        this.priority = priority;
        this.condition = condition;
        this.age = age;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Patient)){
            throw new IllegalArgumentException("Can not compare ... ");
        }
        Patient other = (Patient) o;
        if(this.priority != other.priority){
            return this.priority - other.priority;
        }
        return other.age - this.age;
    }
    
    @Override
    public String toString() {
        String priorityStr;
        switch(priority) {
            case 1: priorityStr = "Nguy cấp"; break;
            case 2: priorityStr = "Khẩn cấp"; break;
            default: priorityStr = "Bình thường";
        }
        return String.format("Bệnh nhân: %s (Tuổi: %d) - Mức độ: %s - Tình trạng: %s", 
                           name, age, priorityStr, condition);
    }
}
