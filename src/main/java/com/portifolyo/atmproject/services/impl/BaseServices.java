package com.portifolyo.atmproject.services.impl;

import com.portifolyo.atmproject.annonations.Log;
import com.portifolyo.atmproject.entity.BaseEntity;
import com.portifolyo.atmproject.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public abstract class BaseServices<T extends BaseEntity> {

    private final BaseRepository<T> repository;

    protected BaseServices(BaseRepository<T> repository) {
        this.repository = repository;
    }

    @Log(log = "inserted")
    @Transactional
    public Mono<T> addEntity(T entity) throws SQLException {
        T temp = this.repository.save(entity);
        if(temp.getId() != null) {
          return Mono.create(tMonoSink -> tMonoSink.success());
        }
        else {
            throw new SQLException();
        }
    }

    @Log(log = "finded by id")
    @Transactional
    public T findById(String id) throws ClassNotFoundException {
        Optional<T> o = this.repository.findById(id);
        if(o.isPresent()) return Mono.just(o.get()).block();
        else throw new ClassNotFoundException();
    }

    @Log(log = "updated")
    @Transactional
    public Mono updateEntity(T entity) throws SQLException {

        Date date = new Date();
        entity.setUpdatedDate(date);
        T temp = this.repository.save(entity);
        if(temp.getUpdatedDate().equals(date)) return Mono.create(monoSink -> monoSink.success());
        else throw new SQLException();
    }

    @Log(log ="findend all entity")
    @Transactional
    public Flux<List<T>> findAllEntity() {
        return Flux.create(listFluxSink -> listFluxSink.next(this.repository.findAll(Sort.by(Sort.Order.asc("id")))));
    }

    @Log(log = "deleted by id and entity")
    @Transactional
    public Mono<T> deleteById(String id) throws SQLException {
        this.repository.deleteById(id);
        Optional<T> o = repository.findById(id);
        if(o.isEmpty()) {
           return Mono.empty();
        }
        else {
            throw new SQLException();
        }

    }

    @Log(log = "findend all entity by page")
    @Transactional
    public Flux<Page<T>> findAllEntityPagable(Pageable pageable) {
        return Flux.just(this.repository.findAll(pageable));
    }


}
