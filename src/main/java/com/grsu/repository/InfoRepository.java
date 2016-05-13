package com.grsu.repository;

import com.grsu.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dionp on 11.05.2016.
 */
public interface InfoRepository extends JpaRepository<Info, Long> {
}
