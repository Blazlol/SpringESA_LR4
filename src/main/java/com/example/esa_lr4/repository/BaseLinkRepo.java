package com.example.esa_lr4.repository;


import com.example.esa_lr4.model.BaseLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface BaseLinkRepo<T extends BaseLink, ID> extends JpaRepository<T, ID> {

    T findOneByUniqueId(ID id);

}