package ru.nikitina.NauJava.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.nikitina.NauJava.entities.Log;
import ru.nikitina.NauJava.entities.LoggingLevel;

import java.util.List;

@Repository
public class LogRepositoryCustomImpl implements LogRepositoryCustom {
    private final EntityManager entityManager;

    @Autowired
    public LogRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Log> findBySource(String source) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Log> criteriaQuery = criteriaBuilder.createQuery(Log.class);
        Root<Log> logRoot = criteriaQuery.from(Log.class);
        Predicate sourcePredicate = criteriaBuilder.equal(logRoot.get("source"), source);
        criteriaQuery.select(logRoot).where(sourcePredicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<Log> findBySourceAndMessage(String source, String message) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Log> criteriaQuery = criteriaBuilder.createQuery(Log.class);
        Root<Log> logRoot = criteriaQuery.from(Log.class);
        Predicate sourcePredicate = criteriaBuilder.equal(logRoot.get("source"), source);
        Predicate messagePredicate = criteriaBuilder.equal(logRoot.get("message"), message);
        criteriaQuery.select(logRoot).where(sourcePredicate, messagePredicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
