package com.hef.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hef.entity.Cricketer;

@Repository
public class CricketerRepo {

	@Autowired
	SessionFactory sf;

	public String save(Cricketer c) {

		Session ss = null;
		Transaction tx = null;
		String msg = null;

		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();
			ss.persist(c);
			tx.commit();
			msg = "Cricketer record inserted successfully...!";
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
	
	public String saveAll(List<Cricketer> cricketers) {
        String msg;
        Session session = null;
        Transaction tx = null;

        try {
            session = sf.openSession();
            tx = session.beginTransaction();

            for (Cricketer cricketer : cricketers) {
                session.persist(cricketer);
            }

            tx.commit();
            msg = "Cricketers saved successfully!";
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            msg = "Failed to save cricketers: " + e.getMessage();
        } finally {
            if (session != null) session.close();
        }

        return msg;
    }
	
	public Cricketer findById(int id) {

		Cricketer cricketer = null;
		Session ss = null;
		Transaction tx = null;

		try {

			ss = sf.openSession();
			tx = ss.beginTransaction();
			cricketer = ss.get(Cricketer.class, id);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return cricketer;
	}

	public List<Cricketer> findAll() {

		List<Cricketer> cricketer = null;
		Session ss = null;
		Transaction tx = null;

		try {

			ss = sf.openSession();
			tx = ss.beginTransaction();
			String hql = "from Cricketer";

			Query<Cricketer> query = ss.createQuery(hql, Cricketer.class);
			cricketer = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return cricketer;

	}
	
	public String update(Cricketer c1) {
		
		String msg=null;
		Session ss =null;
		Transaction tx = null;
		Cricketer c2 = null;
		
		try {
			ss=sf.openSession();
		    tx = ss.beginTransaction();
		    c2 = ss.get(Cricketer.class, c1.getId());
			if(c1!=null) {
				if(c1.getFullName()!=null) {
					c2.setFullName(c1.getFullName());
				}
				
				if(c1.getRole()!=null) {
					c2.setRole(c1.getRole());
				}
				
				if(c1.getBattingStyle()!=null) {
					c2.setBattingStyle(c1.getBattingStyle());
				}
				
				if(c1.getBowlingStyle()!=null) {
					c2.setBowlingStyle(c1.getBowlingStyle());
				}
				
				if(c1.getAge()!=0) {
					c2.setAge(c1.getAge());
				}
				
				if(c1.getMatchesPlayed()!=0) {
					c2.setMatchesPlayed(c1.getMatchesPlayed());
				}
				
				if(c1.getRunsScored()!=0) {
					c2.setRunsScored(c1.getRunsScored());
				}
				
				if(c1.getWicketsTaken()!=0) {
					c2.setWicketsTaken(c1.getWicketsTaken());
				}
				
				if(c1.getBattingAverage()!=0) {
					c2.setBattingAverage(c1.getBattingAverage());
				}
				
				if(c1.getBowlingAverage()!=0) {
					c2.setBowlingAverage(c1.getBowlingAverage());
				}
				
				if(c1.getStrikeRate()!=0) {
					c2.setStrikeRate(c1.getStrikeRate());
				}
				
				if(c1.getSalary()!=0) {
					c2.setSalary(c1.getSalary());
				}
				
				if(c1.getContactNumber()!=null) {
					c2.setContactNumber(c1.getContactNumber());
				}
				
				if(c1.getEmailId()!=null) {
					c2.setEmailId(c1.getEmailId());
				}
				
				if(c1.getCreatedBy()!=null) {
					c2.setCreatedBy(c1.getCreatedBy());
				}
				
				if(c1.getCreatedDate()!=null) {
					c2.setCreatedDate(c1.getCreatedDate());
				}
				
				if(c1.getUpdatedBy()!=null) {
					c2.setUpdatedBy(c1.getUpdatedBy());
				}
				
				if(c1.getUpdatedDate()!=null) {
					c2.setUpdatedDate(c1.getUpdatedDate());
				}
			}
			ss.merge(c2);
			tx.commit();
			msg="updated successfully";
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
		}finally {
			if(ss!=null) {
				ss.close();
			}
		}
		return msg;
	}
	
	public String deleteById(int id) {
		String msg=null;
		Session ss = null;
		Transaction tx = null;

		try {

			ss = sf.openSession();
			tx = ss.beginTransaction();
			Cricketer cricketer = ss.get(Cricketer.class, id);
			ss.remove(cricketer);
			tx.commit();
			msg="delete record successfully...!";

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
	
	public List<Cricketer> searchByName(String fullName) {
		List<Cricketer>  cricketer = null;
		
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		String hql="From Cricketer where lower(fullName) Like :name";
		Query<Cricketer> query = ss.createQuery(hql,Cricketer.class);
		query.setParameter("name","%"+ fullName.toLowerCase()+"%");
		cricketer = query.list();
		 
		tx.commit();
		ss.close();
		
		return cricketer;
	}
	
	public List<Cricketer> findByRole(String role) {
	    Session ss = sf.openSession();
	    Transaction tx = ss.beginTransaction();

	    String hql = "FROM Cricketer WHERE lower(role) = :role";
	    Query<Cricketer> query = ss.createQuery(hql, Cricketer.class);
	    query.setParameter("role", role.toLowerCase());
	    List<Cricketer> list = query.list();

	    tx.commit();
	    ss.close();
	    return list;
	}

	public List<Cricketer> findByBattingStyle(String style) {
	    Session ss = sf.openSession();
	    Transaction tx = ss.beginTransaction();

	    String hql = "FROM Cricketer WHERE lower(battingStyle) = :style";
	    Query<Cricketer> query = ss.createQuery(hql, Cricketer.class);
	    query.setParameter("style", style.toLowerCase());
	    List<Cricketer> list = query.list();

	    tx.commit();
	    ss.close();
	    return list;
	}

	public List<Cricketer> findByBowlingStyle(String style) {
	    Session ss = sf.openSession();
	    Transaction tx = ss.beginTransaction();

	    String hql = "FROM Cricketer WHERE lower(bowlingStyle) = :style";
	    Query<Cricketer> query = ss.createQuery(hql, Cricketer.class);
	    query.setParameter("style", style.toLowerCase());
	    List<Cricketer> list = query.list();

	    tx.commit();
	    ss.close();
	    return list;
	}

	public List<Cricketer> findByAgeRange(int minAge, int maxAge) {
	    Session ss = sf.openSession();
	    Transaction tx = ss.beginTransaction();

	    String hql = "FROM Cricketer WHERE age BETWEEN :min AND :max";
	    Query<Cricketer> query = ss.createQuery(hql, Cricketer.class);
	    query.setParameter("min", minAge);
	    query.setParameter("max", maxAge);
	    List<Cricketer> list = query.list();

	    tx.commit();
	    ss.close();
	    return list;
	}

	public List<Cricketer> findTopBatsmen() {
	    Session ss = sf.openSession();
	    Transaction tx = ss.beginTransaction();

	    String hql = "FROM Cricketer ORDER BY battingAverage DESC";
	    Query<Cricketer> query = ss.createQuery(hql, Cricketer.class);
	    List<Cricketer> list = query.list();

	    tx.commit();
	    ss.close();
	    return list;
	}

	public List<Cricketer> findTopBowlers() {
	    Session ss = sf.openSession();
	    Transaction tx = ss.beginTransaction();

	    String hql = "FROM Cricketer WHERE wicketsTaken > 50";
	    Query<Cricketer> query = ss.createQuery(hql, Cricketer.class);
	    List<Cricketer> list = query.list();

	    tx.commit();
	    ss.close();
	    return list;
	}

	

	public Cricketer findByEmail(String emailId) {
	    Session ss = sf.openSession();
	    Transaction tx = ss.beginTransaction();

	    String hql = "FROM Cricketer WHERE lower(emailId) = :email";
	    Query<Cricketer> query = ss.createQuery(hql, Cricketer.class);
	    query.setParameter("email", emailId.toLowerCase());
	    Cricketer cricketer = query.uniqueResult();

	    tx.commit();
	    ss.close();
	    return cricketer;
	}

	public List<Cricketer> findRecentPlayers() {
	    Session ss = sf.openSession();
	    Transaction tx = ss.beginTransaction();

	    String hql = "SELECT * FROM cricketers ORDER BY created_date DESC";
	    Query<Cricketer> query = ss.createNativeQuery(hql, Cricketer.class);
	    List<Cricketer> list = query.list();

	    tx.commit();
	    ss.close();
	    return list;
	}

	public List<String> findDistinctRoles() {
	    Session ss = sf.openSession();
	    Transaction tx = ss.beginTransaction();

	    String hql = "SELECT DISTINCT role FROM cricketers";
	    Query<String> query = ss.createNativeQuery(hql, String.class);
	    List<String> roles = query.list();

	    tx.commit();
	    ss.close();
	    return roles;
	}

	public List<Cricketer> findByStrikeRateAbove(double rate) {
	    Session ss = sf.openSession();
	    Transaction tx = ss.beginTransaction();

	    String hql = "SELECT * FROM cricketers WHERE strike_rate > :rate";
	    Query<Cricketer> query = ss.createNativeQuery(hql, Cricketer.class);
	    query.setParameter("rate", rate);
	    List<Cricketer> list = query.list();

	    tx.commit();
	    ss.close();
	    return list;
	}

}
