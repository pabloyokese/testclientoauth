package com.testing;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;


@NoRepositoryBean
public interface CustomRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID>{
	Page<T> findByEnabled(boolean enabled,Pageable pageable);
}
