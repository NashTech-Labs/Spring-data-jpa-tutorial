package com.example.springdatajpatutorial.repository;

import com.example.springdatajpatutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);

    List<Student>  findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    Student getStudentFirstNameByEmail(String emailId);

}
