package com.ecram.usersmicroecram.posts.repositories.impl;

import com.ecram.usersmicroecram.posts.dtos.response.PostToListDto;
import com.ecram.usersmicroecram.posts.repositories.ICustomPostRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomPostRepositoryImpl implements ICustomPostRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PostToListDto> listPostsInUserInboxByGroup(Long idGroup, Long cursor) {
        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT new PostToListDto(");
        jpql.append("p.id, p.name, p.likeNumber, p.dislikeNumber, p.createDate, p.id_group ");
        jpql.append(") ");
        jpql.append("from Post p ");
        jpql.append("where 1=1  ");
        jpql.append("and p.status='enable' ");
        jpql.append("and p.id_group= :idGroup ");
        if(cursor> 0L) {
            jpql.append("and p.id < :cursor ");
        }
        jpql.append("ORDER BY p.createDate DESC ");

        TypedQuery<PostToListDto> query = this.entityManager.createQuery(jpql.toString(), PostToListDto.class);
        query.setParameter("idGroup", idGroup);
        if(cursor> 0L) {
            query.setParameter("cursor", cursor);
        }

        return query.setMaxResults(10).getResultList();
    }
}
