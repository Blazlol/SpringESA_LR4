package com.example.esa_lr4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import com.example.esa_lr4.model.BaseEntity;

import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface BaseEntityRepo<T extends BaseEntity, ID> extends JpaRepository<T, ID> {

    List<T> findAllByIsDeletedFalse();

    List<T> findAllByIsDeletedTrue();

    T findOneByUniqueIdAndIsDeletedFalse(Long id);

    T findOneByUniqueId(Long id);

    T findOneByUuidAndIsDeletedFalse(UUID uuid);

    T findOneByUuid(UUID uuid);

    @Override
    @Modifying
    @Query(value = "update #{#entityName} f set f.isDeleted=true where f.uniqueId= :id")
    void deleteById(ID id);

    @Override
    @Modifying
    @Query(value = "update #{#entityName} f set f.isDeleted=true where f= :entity")
    void delete(@Param("entity") T entity);

    @Override
    @Modifying
    @Query(value = "update #{#entityName} f set f.isDeleted=true where f in :entities")
    void deleteAll(Iterable<? extends T> entities);
}

