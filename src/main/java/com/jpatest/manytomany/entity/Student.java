package com.jpatest.manytomany.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import java.util.Set;

@Entity
@Table(name ="STUDENT_TABLE")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
@Id
@GeneratedValue
    private long id;
    private String name;
    private String Departments;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "STUDENT_COURSE_TABLE",
            joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id") // related entity (Course)
    )
    //@JsonManagedReference
    private Set<Course> courses;





}
