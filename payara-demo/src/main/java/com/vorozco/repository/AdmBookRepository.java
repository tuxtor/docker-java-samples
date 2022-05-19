package com.vorozco.repository;

import com.vorozco.model.AdmBook;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;

@Repository(forEntity = AdmBook.class)
public abstract class AdmBookRepository extends AbstractEntityRepository<AdmBook, Long> {

    public abstract List<AdmBook> findByAuthorLike(String author);
}
