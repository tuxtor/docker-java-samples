package com.vorozco.repository;

import com.vorozco.model.AdmBook;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AdmBookRepository implements PanacheRepository<AdmBook> {

    public AdmBook update(AdmBook admBook) {
        return this.getEntityManager().merge(admBook);
    }


}
