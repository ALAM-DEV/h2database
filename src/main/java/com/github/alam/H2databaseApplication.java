package com.github.alam;

import com.github.alam.model.Course;
import com.github.alam.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor

public class H2databaseApplication {


	private CourseRepository courseRepository;


	public static void main(String[] args) {
		SpringApplication.run(H2databaseApplication.class, args);

	}

	@PostConstruct
	private void postInit(){



		List<Course> list = new ArrayList<>();

		Course course = new Course(1,"SQL1","SQL","Mister SQL");
		Course course1 = new Course(2,"JAVA2","JAVA","Mister JAVA");
		Course course2 = new Course(3,"VB","VB","Mister VB");
		Course course3 = new Course(4,"PYTHON","PYTHON","Mister PYTHON");
		list.add(course);
		list.add(course1);
		list.add(course2);
		list.add(course3);

		courseRepository.saveAll(list);

		Logger logger = LoggerFactory.getLogger(H2databaseApplication.class);

		logger.info("all Available course are w w w w w");
		courseRepository.deleteById(2L);
		logger.info("all Available course are  LLL");
	}

}
