package com.example.e1_blog_upgrade.service.impl;

import com.example.e1_blog_upgrade.model.Blog;
import com.example.e1_blog_upgrade.model.Infor;
import com.example.e1_blog_upgrade.repository.IBlogRepository;
import com.example.e1_blog_upgrade.repository.IInforRepository;
import com.example.e1_blog_upgrade.service.IInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InforService implements IInforService {
    @Autowired
    private IInforRepository repository;
    @Override
    public List<Infor> findAll() {
        return repository.findAll();
    }

    @Override
    public Infor findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(Infor infor) {
        repository.save(infor);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
