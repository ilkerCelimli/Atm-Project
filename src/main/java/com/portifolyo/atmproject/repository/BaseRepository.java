package com.portifolyo.atmproject.repository;

import com.portifolyo.atmproject.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T,String> {
}
