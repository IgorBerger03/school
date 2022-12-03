package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Faculty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

public class FacultyService {
    private final HashMap<Long, Faculty> list = new HashMap<>();
    private long lastId = 0;

    public Faculty addFaculty(Faculty faculty){
        faculty.setId(++lastId);
        list.put(lastId, faculty);
        return faculty;
    }
    public Faculty findFaculty(long id){
        return list.get(id);
    }
    public Faculty editFaculty(Faculty faculty){
        if (list.containsKey(faculty.getId())){
            list.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }
    public Faculty deleteFaculty(long id){
        return list.remove(id);
    }

    public Collection<Faculty> findByColor(String color) {
        ArrayList<Faculty> result = new ArrayList<>();
        for (Faculty faculty : list.values()) {
            if (Objects.equals(faculty.getColor(), color)) {
                result.add(faculty);
            }
        }
        return result;
    }
}
