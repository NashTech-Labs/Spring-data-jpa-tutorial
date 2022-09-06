package com.example.springdatajpatutorial.repository;

import com.example.springdatajpatutorial.Guardian;
import com.example.springdatajpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("anuradha@knoldus.com")
                .firstName("Anuradha")
                .lastName("Kumari")
                /*.guardianName("DhairyaNath")
                .guardianEmail("dhairyanath@gmail.com")
                .guardianMobile("9898989898")*/
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("dhairyanath@gmail.com")
                .name("DhairyaNath")
                .mobile("9898989898")
                .build();

        Student student = Student.builder()
                .firstName("Gaurav")
                .emailId("gaurav@gmail.com")
                .lastName("Jha")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public  void printAllStudent(){
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){

        List<Student> students =
                studentRepository.findByFirstName("Anuradha");

        System.out.println("students =" + students);
    }


    @Test
    public void getStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("anuradha.kumari@knoldus.com");

        System.out.println("student = + student");
    }
}

