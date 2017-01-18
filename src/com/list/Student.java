package com.list;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2016/8/30.
 */
public class Student implements Comparable<Student>{
    private int sNum;
    private String sName;

    public int getsNum() {
        return sNum;
    }

    public void setsNum(int sNum) {
        this.sNum = sNum;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Set<Course> courseSet;

    public Student(int sNum,String sName){
        this.sName = sName;
        this.sNum = sNum;
        this.courseSet = new HashSet<Course>();
    }

    public Student(){

    }

    @Override
    public int compareTo(Student o) {
        return this.getsNum()-o.getsNum();
    }
}
