package group2it81.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import group2it81.configs.HibernateUtils;
import group2it81.pojo.User;

public class DangNhapService {
    public List<User> getUser(String username, String pass){
        String hql = String.format("FROM User user WHERE user.username = \"%s\" AND user.password = \"%s\"",username,pass);
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            Query<User> query = session.createQuery(hql);
            return query.list();
        }
    }
}
