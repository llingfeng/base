package com.list;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by admin on 2016/8/30.
 */
public class MapTest {
    public Map<String, Student> studentsMap;

    public MapTest() {
        this.studentsMap = new HashMap<String, Student>();
    }

    /**
     * 录入三位学生的信息
     * 判定录入的学生信息是否存在
     * 添加到studentsMap
     */
    public void testPut(){
        Scanner input = new Scanner(System.in);
        int i = 0;
        while(i<3){
            System.out.println("请录入学生ID:");
            String id = input.next().trim();
            Student student = studentsMap.get(id);
            if(student == null){
                System.out.println("请录入学生的姓名：");
                student = new Student();
                student.setsNum(Integer.valueOf(id));
                student.setsName(input.next());
                studentsMap.put(id,student);
                i++;
            }else{
                System.out.println("学生ID已存在！");
                continue;
            }
        }
    }

    /**
     * contain用法
     */
    public void testContian(){

    }

    /**
     * keySet遍历studentsMap
     * @param
     */
    public void test(){
        Set<String> stringSet =  studentsMap.keySet();
        for(String s:stringSet){
            Student student = studentsMap.get(s);
            if(student!=null){
                System.out.println("学生ID："+student.getsNum()+",学生Name:"+student.getsName());
            }
        }
    }

    /**
     * 删除Map
     * @param
     */
    public void testDelete(){
        while (true){
            System.out.println("请输入要删除的学生ID：");
            Scanner input = new Scanner(System.in);
            String id = input.next();
            Student student = studentsMap.get(id);
            if(student == null){
                System.out.println("该学生不存在！");
                continue;
            }
            studentsMap.remove(id);
            System.out.println("删除成功！");
            break;
        }
    }

    /**
     *遍历Map
     * @param
     */
    public void testEntry(){
        Set<Map.Entry<String,Student>> set = studentsMap.entrySet();
        for(Map.Entry<String,Student> studentEntry:set){
            Student student = studentEntry.getValue();
            System.out.println("ID："+student.getsNum()+",Name:"+student.getsName());
        }
    }

    public static void main(String[] args) {
        MapTest mapTest = new MapTest();
        mapTest.testPut();
        /*mapTest.test();
        mapTest.testDelete();
        mapTest.testEntry();*/
    }

}
