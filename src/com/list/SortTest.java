package com.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by admin on 2016/8/30.
 */
public class SortTest {

    public List<Student> studentList;

    public SortTest(){
        this.studentList = new ArrayList<>();
    }

    public void sortTest1(){
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        int[] nums = new int[3];
        int num = 0;
        for(int i=0;i<3;i++){
            do{
                num = (int) (random.nextDouble()*1000)+100;
            }while (list.contains(num));
            list.add(num);
            nums[i] = num;
        }
        studentList.add(new Student(nums[0],"jack")) ;
        studentList.add(new Student(nums[1],"tom"));
        studentList.add(new Student(nums[2],"maria"));
        studentList.add(new Student(10000,"maria"));
        System.out.println("排序前：");
        for (Student student : studentList) {
            System.out.println(student.getsNum()+":"+student.getsName());
        }
        Collections.sort(studentList);
        System.out.println("排序后：");
        for (Student student : studentList) {
            System.out.println(student.getsNum()+":"+student.getsName());
        }
        Collections.sort(studentList,new StudentComparator());
        System.out.println("姓名排序后：");
        for (Student student : studentList) {
            System.out.println(student.getsNum()+":"+student.getsName());
        }
    }

    public static void main(String[] args){
        SortTest test = new SortTest();
        test.sortTest1();
    }

}
