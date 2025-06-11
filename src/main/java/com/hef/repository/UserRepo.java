package com.hef.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hef.entity.User;

@Repository
public class UserRepo {

	@Autowired
	SessionFactory sf;

	public String save(User u) {

		String msg = null;
		Session ss = null;
		Transaction tx = null;
		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();

			ss.persist(u);

			tx.commit();
			msg = "record added successfully...!";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (ss != null) {
				ss.close();
			}
		}

		return msg;
	}
	
	 public String saveAll(List<User> ulist) {
	        String msg = null;
	        Session ss = null;
	        Transaction tx = null;

	        try {
	            ss = sf.openSession();
	            tx = ss.beginTransaction();

	            for (User user : ulist) {
	                ss.persist(user);
	            }

	            tx.commit();
	            msg = "Records added successfully...!";

	        } catch (Exception e) {
	            if (tx != null) {
	                tx.rollback();
	            }
	            msg = "Failed: " + e.getMessage();

	        } finally {
	            if (ss != null) {
	                ss.close();
	            }
	        }

	        return msg;
	    }


	public User login(User u) {

		User user = null;
		Session ss = null;
		Transaction tx = null;

		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();
			String hql = "from User where emailid=:email and password=:pass";
			Query<User> query = ss.createQuery(hql, User.class);
			query.setParameter("email", u.getEmailid());
			query.setParameter("pass", u.getPassword());
			user = query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
		}finally {
			if(ss!=null) {
				ss.close();
			}
		}

		return user;
	}

}
