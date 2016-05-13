package com.grsu.service.impl;

import com.grsu.entity.Info;
import com.grsu.repository.InfoRepository;
import com.grsu.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dionp on 11.05.2016.
 */

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoRepository infoRepository;

    @Override
    public void addInfo(Info info) {
        infoRepository.saveAndFlush(info);
    }

    @Override
    public void delete(Long id) {
        infoRepository.delete(id);
    }

    @Override
    public Info editInfo(Info info) {
        return infoRepository.saveAndFlush(info);
    }

    @Override
    public List<Info> getAll() {
        return infoRepository.findAll();
    }
}
