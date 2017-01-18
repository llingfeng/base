package com.list;

/**
 * Created by admin on 2016/8/29.
 */
public class Course {
    private int id;
    private String name;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (this.getName() == null) {
            if (course.getName() == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (this.getName().equals(course.getName())) {
                return true;
            } else
                return false;
        }
    }

}
