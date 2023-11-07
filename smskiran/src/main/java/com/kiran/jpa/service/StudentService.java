package com.kiran.jpa.service;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.kiran.jpa.dao.CourseDao;
import com.kiran.jpa.dao.StudentDao;
import com.kiran.jpa.entitymodels.Course;
import com.kiran.jpa.entitymodels.Student;
import com.kiran.jpa.entitymodels.StudentCourses;
import com.kiran.jpa.hibernateutil.HibernateUtil;


public class StudentService implements StudentDao{

	private CourseDao courseDAO;

	@Override
	public List<Student> getAllStudents() {
		Session session = null;
		try{
			session = HibernateUtil.getConnection();
			String hql = "FROM Student";
			TypedQuery<Student> query = session.createQuery(hql,Student.class);	
			List<Student> listOfStudent = query.getResultList();
			return listOfStudent;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}		
		return null;

	}	
	@Override
	public Student getStudentByEmail(String sEmail) {
		Session session = null;
		try{
			session = HibernateUtil.getConnection();
			String hql = "FROM Student s WHERE s.sEmail = :email";
			TypedQuery<Student> query = session.createQuery(hql,Student.class);	
			query.setParameter("email", sEmail);
			Student s = query.getSingleResult();
			return s;	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}		
		return null;
	}


	@Override
	public boolean validateStudent(String sEmail, String sPassword) {
		Session session = null;
		try{
			session = HibernateUtil.getConnection();
			String hql = "FROM Student s WHERE s.sEmail = :email AND s.sPass = :password";
			TypedQuery<Student> query = session.createQuery(hql,Student.class);	
			query.setParameter("email", sEmail);
			query.setParameter("password", sPassword);			
			Student s = query.getSingleResult();
			if(s != null) {
				if(sEmail.equals(s.getsEmail()) && sPassword.equals(s.getsPassword())) {
					return true;
				}else {
					return false;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public void registerStudentToCourse(String sEmail, int cId) {
		Session session = null;
		try { 
			session = HibernateUtil.getConnection();
			Transaction t = session.beginTransaction();
			String hql = "from StudentCourses s WHERE s.email = :email AND s.courseID = :cId";
			TypedQuery<StudentCourses> query = session.createQuery(hql,StudentCourses.class);
			query.setParameter("email",sEmail);
			query.setParameter("cId", cId);
			List<StudentCourses> listSC = query.getResultList();

			Student student = getStudentByEmail(sEmail);
			courseDAO = new CourseService();
			Course course = courseDAO.getCourseById(cId);
			if (listSC.size() == 0) {				
				student.getsCourse().add(course);
				session.update(student);
				t.commit();
			}else {
				System.out.println("You Are Already Registered with this Course.");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}				

	}
	@Override
	public List<Course> getStudentCourses(String sEmail) {
		Session session = null;
		try { 	
			session = HibernateUtil.getConnection();
			String hql = "select sCourses from Student s WHERE s.sEmail = :email";
			Query query = session.createQuery(hql);			
			query.setParameter("email",sEmail);
			List<Course> listCourses = query.getResultList();
			return listCourses;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}


}





