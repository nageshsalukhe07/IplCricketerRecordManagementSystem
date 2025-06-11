package com.hef.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hef.entity.Team;

@Repository
public class TeamRepo {

	@Autowired
	SessionFactory sf;

	public String save(Team t) {

		Session ss = null;
		Transaction tx = null;
		String msg = null;

		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();
			ss.persist(t);
			tx.commit();
			msg = "Team record inserted successfully...!";
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

	public String saveAll(List<Team> tlist) {

		Session ss = null;
		Transaction tx = null;
		String msg = null;

		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();
			 for (Team team : tlist) {
		            ss.persist(team);  
		        }
			tx.commit();
			msg = "Team record inserted successfully...!";
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

	public Team findById(int id) {

		Team team = null;
		Session ss = null;
		Transaction tx = null;

		try {

			ss = sf.openSession();
			tx = ss.beginTransaction();
			team = ss.get(Team.class, id);
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
		return team;
	}

	public List<Team> findAll() {

		List<Team> team = null;
		Session ss = null;
		Transaction tx = null;

		try {

			ss = sf.openSession();
			tx = ss.beginTransaction();
			String hql = "from Team";

			Query<Team> query = ss.createQuery(hql, Team.class);
			team = query.list();
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
		return team;

	}

	public String update(Team t1) {

		String msg = null;
		Session ss = null;
		Transaction tx = null;
		Team t2 = null;

		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();
			t2 = ss.get(Team.class, t1.getId());
			if (t1 != null) {
				if (t1.getName() != null) {
					t2.setName(t1.getName());
				}
				if (t1.getCity() != null) {
					t2.setCity(t1.getCity());
				}
				if (t1.getCoachName() != null) {
					t2.setCoachName(t1.getCoachName());
				}
				if (t1.getOwnerName() != null) {
					t2.setOwnerName(t1.getOwnerName());
				}
				if (t1.getTotalTitles() != 0) {
					t2.setTotalTitles(t1.getTotalTitles());
				}

			}
			ss.merge(t2);
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
			Team team = ss.get(Team.class, id);
			ss.remove(team);
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

	public List<Team> searchByName(String keyword) {
		Session ss = null;
		Transaction tx = null;
		List<Team> list = null;

		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();

			String hql = "FROM Team WHERE lower(name) LIKE :keyword";
			Query<Team> query = ss.createQuery(hql, Team.class);
			query.setParameter("keyword", "%" + keyword.toLowerCase() + "%");
			list = query.list();

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			if (ss != null)
				ss.close();
		}

		return list;
	}

	public Team findByName(String name) {
		Session ss = null;
		Transaction tx = null;
		Team team = null;

		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();

			String hql = "FROM Team WHERE lower(name) = :name";
			Query<Team> query = ss.createQuery(hql, Team.class);
			query.setParameter("name", name.toLowerCase());
			team = query.uniqueResult();

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			if (ss != null)
				ss.close();
		}

		return team;
	}

	public List<Team> searchByCoach(String coachName) {
		Session ss = null;
		Transaction tx = null;
		List<Team> teams = null;

		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();

			String hql = "FROM Team WHERE lower(coachName) LIKE :coach";
			Query<Team> query = ss.createQuery(hql, Team.class);
			query.setParameter("coach", "%" + coachName.toLowerCase() + "%");
			teams = query.list();

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			if (ss != null)
				ss.close();
		}

		return teams;
	}

	public List<Team> findByOwner(String ownerName) {
		Session ss = null;
		Transaction tx = null;
		List<Team> list = null;

		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();

			String sql = "SELECT * FROM team WHERE lower(owner_name) LIKE :owner";
			Query<Team> query = ss.createNativeQuery(sql, Team.class);
			query.setParameter("owner", "%" + ownerName.toLowerCase() + "%");
			list = query.list();

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			if (ss != null)
				ss.close();
		}

		return list;
	}

	public List<Team> findByTitlesGreaterThan(int titles) {
		Session ss = null;
		Transaction tx = null;
		List<Team> list = null;

		try {
			ss = sf.openSession();
			tx = ss.beginTransaction();

			String sql = "SELECT * FROM team WHERE total_titles > :titles";
			Query<Team> query = ss.createNativeQuery(sql, Team.class);
			query.setParameter("titles", titles);
			list = query.list();

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			if (ss != null)
				ss.close();
		}

		return list;
	}

}
