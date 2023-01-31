package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
//		create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
//		create session
		Session session = factory.getCurrentSession();
		
		try {
//			add comment
//			start a transaction
			session.beginTransaction();
			
//			get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("===> Instructor: " + tempInstructor);
			
			System.out.println("===> Courses: " + tempInstructor.getCourses());
						
//			commit the transaction
			session.getTransaction().commit();
			
			session.close();
			System.out.println("\n\nThe session is closed...\n\n");
//			option 1: call getter method while session is open
			System.out.println("===> Courses: " + tempInstructor.getCourses());
			
			System.out.println("===> Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
