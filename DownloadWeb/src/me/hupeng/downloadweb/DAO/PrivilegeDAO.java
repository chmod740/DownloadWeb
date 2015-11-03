package me.hupeng.downloadweb.DAO;

import java.util.List;

import me.hupeng.downloadweb.bean.Privilege;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Privilege entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see me.hupeng.downloadweb.bean.Privilege
 * @author MyEclipse Persistence Tools
 */
public class PrivilegeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PrivilegeDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String RIGHTSTR = "rightstr";

	public void save(Privilege transientInstance) {
		log.debug("saving Privilege instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Privilege persistentInstance) {
		log.debug("deleting Privilege instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Privilege findById(java.lang.Integer id) {
		log.debug("getting Privilege instance with id: " + id);
		try {
			Privilege instance = (Privilege) getSession().get(
					"me.hupeng.downloadweb.bean.Privilege", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Privilege instance) {
		log.debug("finding Privilege instance by example");
		try {
			List results = getSession()
					.createCriteria("me.hupeng.downloadweb.bean.Privilege")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Privilege instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Privilege as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByRightstr(Object rightstr) {
		return findByProperty(RIGHTSTR, rightstr);
	}

	public List findAll() {
		log.debug("finding all Privilege instances");
		try {
			String queryString = "from Privilege";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Privilege merge(Privilege detachedInstance) {
		log.debug("merging Privilege instance");
		try {
			Privilege result = (Privilege) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Privilege instance) {
		log.debug("attaching dirty Privilege instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Privilege instance) {
		log.debug("attaching clean Privilege instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}