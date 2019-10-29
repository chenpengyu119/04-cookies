package com.yu.testhashmap;

import java.util.Objects;

public class Course {
    public String id;
    public String name;

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course course = (Course) o;
        return id.equals(course.id) &&
                name.equals(course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
