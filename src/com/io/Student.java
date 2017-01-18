package com.io;

import java.io.Serializable;

/**
 * Created by admin on 2016/12/4.
 */
public class Student implements Serializable {
    private String stuName;
    private String stuSex;
    private transient String stuAge;//该元素不会完成jvm默认序列号，可以自己完成这个元素的序列化

    public Student() {
    }

    public Student(String stuName, String stuSex, String strAge) {
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuAge = strAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", strAge='" + stuAge + '\'' +
                '}';
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStrAge() {
        return stuAge;
    }

    public void setStrAge(String strAge) {
        this.stuAge = strAge;
    }

    //完成元素的序列化
    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        s.defaultWriteObject();
        s.writeObject(stuAge);
    }

    //完成元素的反序列化
    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.stuAge = (String) s.readObject();
    }
}
