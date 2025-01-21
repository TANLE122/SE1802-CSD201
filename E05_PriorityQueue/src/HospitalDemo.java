/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class HospitalDemo {
    public static void main(String[] args) {
        EmergencyRoom er = new EmergencyRoom();
        System.out.println("=== TIẾP NHẬN BỆNH NHÂN === ");
        // Thêm các bệnh nhân
        er.addPatient("Nguyễn Văn A", 3, "Đau đầu nhẹ", 25);
        er.addPatient("Trần Thị B", 1, "Đau tim cấp tính", 65);
        er.addPatient("Lê Văn C", 2, "Gãy tay", 30);
        er.addPatient("Phạm Thị D", 1, "Khó thở nặng", 45);
        er.addPatient("Hoàng Văn E", 2, "Sốt cao", 70);
        
         System.out.println("\n=== THÔNG TIN BỆNH NHÂN CHỜ ===");
        er.showWaitingPatients();
        
          System.out.println("\n=== BẮT ĐẦU ĐIỀU TRỊ ===");
        // Điều trị bệnh nhân theo thứ tự ưu tiên
        for (int i = 0; i < 3; i++) {
            er.treatNextPatient();
        }
        
        System.out.println("\n=== CẬP NHẬT TÌNH HÌNH ===");
        System.out.println("Số bệnh nhân đã được điều trị: " + er.getTreatedCount());
        er.showWaitingPatients();
        
        System.out.println("\n=== TIẾP NHẬN THÊM BỆNH NHÂN ===");
        er.addPatient("Vũ Thị F", 1, "Chấn thương sọ não", 28);
        er.showWaitingPatients();
    }
}
