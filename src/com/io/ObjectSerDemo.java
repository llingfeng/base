package com.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/12/4.
 */
public class ObjectSerDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String file = "app//h.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        List<Student> studentList = new ArrayList<>();
        Student stu1 = new Student("jack", "male", "12");
        Student stu2 = new Student("ice", "female", "12");
        studentList.add(stu1);
        studentList.add(stu2);
        oos.writeObject(studentList);
        oos.flush();
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        List<Student> students = (List<Student>) ois.readObject();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
