
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class EmergencyRoom {
    private PriorityQueue patientQueue;
    private int treatedCount;

    public EmergencyRoom() {
        patientQueue = new PriorityQueue();
        treatedCount = 0;
    }
    
    public void addPatient(String name, int priority, String codition, int age){
        Patient patient = new Patient(name, priority, codition, age);
        patientQueue.enqueue(patient);
        System.out.println("Đã tiếp nhận: "+patient);
    }
    
    public void treatNextPatient(){
        try {
            if(patientQueue.isEmpty()){
                System.out.println("Không có bệnh nhân đang chờ!");
                return;
            }
            Patient patient = (Patient)patientQueue.dequeue();
            treatedCount++;
            System.out.println("Đang điều trị: "+ patient);
        } catch (Exception ex) {
            Logger.getLogger(EmergencyRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showWaitingPatients(){
         try {
            if(patientQueue.isEmpty()){
                System.out.println("Không có bệnh nhân đang chờ!");
                return;
            }
            Patient patient = (Patient)patientQueue.front();
            System.out.println("Bệnh nhân tiếp theo: "+ patient);
             System.out.println("Số bệnh nhân đang chờ: "+patientQueue.size());
        } catch (Exception ex) {
            Logger.getLogger(EmergencyRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PriorityQueue getPatientQueue() {
        return patientQueue;
    }

    public void setPatientQueue(PriorityQueue patientQueue) {
        this.patientQueue = patientQueue;
    }

    public int getTreatedCount() {
        return treatedCount;
    }

    public void setTreatedCount(int treatedCount) {
        this.treatedCount = treatedCount;
    }
    
    
}
