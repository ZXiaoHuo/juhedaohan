package com.zqh.juhedaohan.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.zqh.juhedaohan.repository.BaseRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface BaseService<R extends BaseRepository<T, ID>, T, ID> {

    R getRepository();


    default List<T> findAll() {
        return getRepository().findAll();
    }

    default List<T> findAll(Sort sort) {
        return getRepository().findAll(sort);
    }

    default List<T> findAllById(Iterable<ID> ids) {
        return getRepository().findAllById(ids);
    }

    default <S extends T> List<S> saveAll(Iterable<S> entities) {
        return getRepository().saveAll(entities);
    }

    default void flush() {
        getRepository().flush();
    }

    default <S extends T> S saveAndFlush(S entity) {
        return getRepository().saveAndFlush(entity);
    }

    default void deleteInBatch(Iterable<T> entities) {
        getRepository().deleteInBatch(entities);
    }

    default void deleteAllInBatch() {
        getRepository().deleteAllInBatch();
    }

    default T getOne(ID id) {
        return getRepository().getOne(id);
    }

    default <S extends T> List<S> findAll(Example<S> example) {
        return getRepository().findAll(example);
    }

    default <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return getRepository().findAll(example, sort);
    }

    default Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    default <S extends T> void save(S entity) {
        getRepository().save(entity);
    }

    default Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    default boolean existsById(ID id) {
        return getRepository().existsById(id);
    }

    default long count() {
        return getRepository().count();
    }

    default void deleteById(ID id) {
        getRepository().deleteById(id);
    }

    default void delete(T entity) {
        getRepository().delete(entity);
    }

    default void deleteAll(Iterable<? extends T> entities) {
        getRepository().deleteAll(entities);
    }

    default void deleteAll() {
        getRepository().deleteAll();
    }

    default <S extends T> Optional<S> findOne(Example<S> example) {
        return getRepository().findOne(example);
    }

    default <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return getRepository().findAll(example, pageable);
    }

    default <S extends T> long count(Example<S> example) {
        return getRepository().count(example);
    }

    default <S extends T> boolean exists(Example<S> example) {
        return getRepository().exists(example);
    }

    default Optional<T> findOne(Predicate predicate) {
        return getRepository().findOne(predicate);
    }

    default List<T> findAll(Predicate predicate) {
        return getRepository().findAll(predicate);
    }

    default List<T> findAll(Predicate predicate, Sort sort) {
        return getRepository().findAll(predicate, sort);
    }

    default List<T> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers) {
        return getRepository().findAll(predicate, orderSpecifiers);
    }

    default List<T> findAll(OrderSpecifier<?>... orderSpecifiers) {
        return getRepository().findAll(orderSpecifiers);
    }

    default Page<T> findAll(Predicate predicate, Pageable pageable) {
        return getRepository().findAll(predicate, pageable);
    }

    default long count(Predicate predicate) {
        return getRepository().count(predicate);
    }

    default boolean exists(Predicate predicate) {
        return getRepository().exists(predicate);
    }
}
