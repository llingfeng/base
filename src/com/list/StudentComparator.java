package com.list;

import java.util.Comparator;

/**
 * Created by admin on 2016/8/30.
 */
public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getsName().compareTo(o2.getsName()) != 0)
            return o1.getsName().compareTo(o2.getsName());
        else {
            return o2.getsNum()-o1.getsNum();
        }
    }
}
