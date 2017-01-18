package com.list;


import java.util.*;

/**
 * Created by admin on 2016/8/29.
 */
public class ListTest {

    public List<Course> coursesToList;
    private Scanner scanner;

    public ListTest(){
        this.coursesToList = new ArrayList<Course>();
        this.scanner = new Scanner(System.in);
    }

    public void testAdd(){
        Course course = new Course(1,"C语言");
        coursesToList.add(course);
        Course temp = (Course) coursesToList.get(0);
        System.out.println(temp.getId()+":"+temp.getName());

        Course course2 = new Course(2,"C++");
        coursesToList.add(0,course2);
        Course temp2 = (Course) coursesToList.get(0);
        System.out.println(temp2.getId()+":"+temp2.getName());

        Course course3 = new Course(3,"数据结构");
        coursesToList.add(1,course3);
        Course temp3 = (Course) coursesToList.get(0);
        System.out.println(temp3.getId()+":"+temp3.getName());

        Course[] courses1 = {new Course(4,"高等数学"),new Course(5,"java")};
        coursesToList.addAll(Arrays.asList(courses1));
        Course temp4 = (Course) coursesToList.get(3);
        Course temp5 = (Course) coursesToList.get(4);
        System.out.println(temp4.getId()+":"+temp4.getName()+"---"+temp5.getId()+":"+temp5.getName());
    }

    public void testIterator(){
        System.out.println("迭代之后的值：");
        Iterator iterator = coursesToList.iterator();
        while(iterator.hasNext()){
            Course course = (Course) iterator.next();
            System.out.println(course.getId()+":"+course.getName());
        }
    }

    public void studentSelectCourse(){
        Student student = new Student(1,"小明");
        System.out.println("请输入要选课的编号：");
        Scanner input = new Scanner(System.in);
        for(int i=0;i<3;i++){
            System.out.println("第"+(i+1)+"门课：");
            int num = input.nextInt();
            for(Course course:coursesToList){
                if(course.getId() == num){
                    student.courseSet.add(course);
                }
            }
        }
        for(Course course:student.courseSet){
            System.out.println(course.getId()+":"+course.getName());
        }
    }

    /**
     * contain用法
     * @param
     */
    public void testContain(){
        Course course = coursesToList.get(0);
        /*System.out.println("course的名字："+course.getName()+",是否包含该："+coursesToList.contains(course));
        Course course2 = new Course(1,"C++");
        System.out.println("是否包含："+coursesToList.contains(course2));*/
        System.out.println("请输入一门课程：");
        String name = scanner.next().trim();
        Course course1 = new Course(9,name);
        System.out.println("是否包含这门课程："+coursesToList.contains(course1));
    }

    public static void main(String[] args){
        ListTest listTest = new ListTest();
        listTest.testAdd();
        listTest.testContain();
        /*listTest.testIterator();
        listTest.studentSelectCourse();*/
    }

}
