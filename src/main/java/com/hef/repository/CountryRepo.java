package com.hef.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hef.entity.Country;

@Repository
public class CountryRepo {

	@Autowired
	SessionFactory sf;

	public String save(Country c) {

		Session ss = null;
		Transaction tx = null;
		String msg = null;

		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();
			ss.persist(c);
			tx.commit();
			msg = "country record inserted successfully...!";
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

	public String saveAll(List<Country> clist) {
		String msg = null;
		Session ss = null;
		Transaction tx = null;

		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();

			for (Country country : clist) {
				ss.persist(country);
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

	public Country findById(Integer id) {
		Session ss = null;
		Transaction tx = null;
		Country country = null;

		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();

			if (id != null) {
				country = ss.get(Country.class, id);
			}
			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
		return country;

	}

	public List<Country> findAll() {

		List<Country> country = null;
		Session ss = null;
		Transaction tx = null;

		try {

			ss = sf.openSession();
			tx = ss.beginTransaction();
			String hql = "from Country";

			Query<Country> query = ss.createQuery(hql, Country.class);
			country = query.list();
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
		return country;

	}

	public String update(Country c1) {

		String msg = null;
		Session ss = null;
		Transaction tx = null;
		Country c2 = null;

		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();
			c2 = ss.get(Country.class, c1.getId());
			if (c1 != null) {
				if (c1.getCountryCode() != null) {
					c2.setCountryCode(c1.getCountryCode());
				}
				if (c1.getName() != null) {
					c2.setName(c1.getName());
				}

			}
			ss.merge(c2);
			tx.commit();
			msg = "updated successfully";

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

	public String deleteById(int id) {
		String msg = null;
		Session ss = null;
		Transaction tx = null;

		try {

			ss = sf.openSession();
			tx = ss.beginTransaction();
			Country country = ss.get(Country.class, id);
			ss.remove(country);
			tx.commit();
			msg = "delete record successfully...!";

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

	public List<Country> searchByName(String keyword) {
		Session ss = null;
		Transaction tx = null;
		List<Country> list = null;

		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();
			String hql = "FROM Country WHERE lower(name) LIKE :keyword";
			Query<Country> query = ss.createQuery(hql, Country.class);
			query.setParameter("keyword", "%" + keyword.toLowerCase() + "%");
			list = query.list();
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

		return list;
	}

	public Country findByCountryCode(String code) {
		Session ss = null;
		Transaction tx = null;
		Country c = null;

		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();
			String hql = "FROM Country WHERE lower(countryCode) = :code";
			Query<Country> query = ss.createQuery(hql, Country.class);
			query.setParameter("code", code.toLowerCase());
			c = query.uniqueResult();
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
		
		return c;
	}

}
