package com.grsu.service;

import com.grsu.entity.Info;

import java.util.List;

/**
 * Created by dionp on 11.05.2016.
 */
public interface InfoService {
    void addInfo(Info info);
    void delete(Long id);
    Info editInfo(Info info);
    List<Info> getAll();

}
