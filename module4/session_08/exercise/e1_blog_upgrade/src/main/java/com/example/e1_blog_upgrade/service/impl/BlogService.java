package com.example.e1_blog_upgrade.service.impl;

import com.example.e1_blog_upgrade.model.Blog;
import com.example.e1_blog_upgrade.repository.IBlogRepository;
import com.example.e1_blog_upgrade.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
@Autowired
private IBlogRepository repository;

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByBlogTitleContaining(String title, Pageable pageable) {
        return repository.findAllByBlogTitleContaining(title,pageable);
    }

    @Override
    public Page<Blog> findAllByInfor_InforNameContaining(String infor,Pageable pageable ) {
        return repository.findAllByInfor_InforNameContaining(infor,pageable);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByInfor_InforEmail(String searchTxt, Pageable pageable) {
        return repository.findAllByInfor_InforEmail(searchTxt,pageable);
    }


}
