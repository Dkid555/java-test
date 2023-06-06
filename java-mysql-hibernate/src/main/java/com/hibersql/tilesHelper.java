package com.hibersql;


import com.hibersql.entity.TilesEntity;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class tilesHelper {
    private SessionFactory sessionFactory;

    public tilesHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<TilesEntity> getTilesList() {
        Session session = sessionFactory.openSession(); // entrance to session
        // preparation
        session.get(TilesEntity.class, 1L);

        // Query construct
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(TilesEntity.class);

        Root<TilesEntity> root = cq.from(TilesEntity.class);

        cq.select(root);


        // Query insertion
        Query query = session.createQuery(cq);

        List<TilesEntity> TilesList = query.getResultList();

        session.close();
        System.out.println("====================================================================");
        for (TilesEntity tile : TilesList
        ) {
            System.out.println("ID: " + tile.getId());
            System.out.println("Country: " + tile.getCountry());
            System.out.println("Collection: " + tile.getCollection());
            System.out.println("Fab_Art: " + tile.getFabArticle());
            System.out.println("Tile Name: " + tile.getTileName());
            System.out.println("Color1: " + tile.getColor1());
            System.out.println("Color2: " + tile.getColor2());
            System.out.println("Color3: " + tile.getColor3());
            System.out.println("==================================================================");
        }
        return TilesList;
    }

    public void addCsv(List<TilesEntity> newOnes) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            for (TilesEntity tile : newOnes
            ) {
                session.persist(tile); //save
            }
            session.getTransaction().commit();
            System.out.println("List of new tiles added");
        } catch (Exception e) {
            System.out.println("Excepton:" + e);
        }
    }

    public void deleteBy(String val) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            String hql = "delete TilesEntity where id = :val";

            Query query = session.createQuery(hql);
//            query.setParameter("parameter", parameter.replaceAll("\"", ""));
            query.setParameter("val", val);//
            int res = query.executeUpdate();
            if (res == 1) {
                System.out.println("Your delete successful");
            } else System.out.println("not succesful");
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
