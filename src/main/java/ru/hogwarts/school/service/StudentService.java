package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class StudentService {
    private final HashMap<Long, Student> list = new HashMap<>();
    private long lastId = 0;

    public Student addStudent(Student student){
        student.setId(++lastId);
        list.put(lastId, student);
        return student;
    }
    public Student findStudent(long id){
        return list.get(id);
    }
    public Student editStudent(Student student){
        if (list.containsKey(student.getId())){
            list.put(student.getId(), student);
            return student;
        }
        return null;
    }
    public Student deleteStudent(long id){
        return list.remove(id);
    }

    public Collection<Student> findByAge(int age) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : list.values()) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }
}
