package com.jpatest.manytomany.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "COURSE_TABLE")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Course {
@Id
@GeneratedValue
    private long id;
    private String name;
    private String department;
    private int modules;
    private double fee;

    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
//    @JsonIgnore
//    @JsonBackReference
    private Set<Student>students;

}
