package com.kiran.jpa.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.kiran.jpa.dao.CourseDao;
import com.kiran.jpa.entitymodels.Course;
import com.kiran.jpa.hibernateutil.HibernateUtil;

public class CourseService implements CourseDao {

	@Override
	public List<Course> getAllCourses() {
		Session session = null;
		try{
			session = HibernateUtil.getConnection();
			String hql = "FROM Course";
			TypedQuery<Course> query = session.createQuery(hql,Course.class);	
			List<Course> listOfCourse = query.getResultList();
			return listOfCourse;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}		
		return null;
	}

	public Course getCourseById(Integer cid) { 	

		Session session = null;
		try{
			session = HibernateUtil.getConnection();
			String hql = "FROM Course c WHERE c.cId = :cid";
			TypedQuery<Course> query = session.createQuery(hql,Course.class);	
			query.setParameter("cid", cid);
			Course c = (Course)query.getSingleResult();
			return c;	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}		
		return null;
	}



}


