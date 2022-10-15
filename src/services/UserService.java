package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import models.User;
import utils.Common;

public class UserService {

	EntityManager em;
	EntityTransaction tss;

	public UserService() {
		this.em = Common.getEntityManager();
		this.tss = this.em.getTransaction();
	}

	// Add new user
	public int add(User user) {
		try {
			tss.begin();
			// Code here...
			em.persist(user);
			tss.commit();
		} catch (Exception e) {
			tss.rollback();
			System.out.println("Error when add user");
			// Insert fail
			return -1;
		} finally {
			// Close connection
			em.close();
		}
		// Insert success
		return 1;

	}

	// Update user by id => Update general
	public int update(String userId, String fullname, String phonenumber, String address) {
		try {
			User uSelected = this.findBy("user_id", userId);
			if (uSelected != null) {
				tss.begin();
				uSelected.setFullname(fullname);
				uSelected.setAddress(address);
				uSelected.setPhonenumber(phonenumber);
				em.merge(uSelected);
				tss.commit();
				return 1;
			}
			return 0;
		} catch (Exception e) {
			tss.rollback();
			return -1;
		}
	}

	// Delete user by user id
	public int delete(String uid) {
		try {
			User u = this.findBy("user_id", uid);
			if (u != null) {
				tss.begin();
				em.remove(u);
				tss.commit();
				// 1 row deleted;
				return 1;
			}
			// 0 row deleted;
			return 0;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			// Error;
			return -1;
		}
	}

	// Find by id or email
	public User findBy(String field, String value) {
		User uSelected = null;
		try {
			String qString = "SELECT * FROM Users AS U WHERE U." + field + " = :field";
			Query q = this.em.createNativeQuery(qString, User.class);
			q.setParameter("field", value);
			uSelected = (User) q.getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return uSelected;
	}

}
