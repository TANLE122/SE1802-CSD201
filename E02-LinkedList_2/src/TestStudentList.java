/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class TestStudentList {
    public static void main(String[] args){
        MyList<Student> list = new MyList();
        list.add(new Student("01", "Nguyen Xuan Son", 10));
        list.add(new Student("02", "Supachok", 9.5));
        
        list.traverse();
    }
}
