package com.example.e1_blog_upgrade.service;

import com.example.e1_blog_upgrade.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {
   Page<Blog> findAllByBlogTitleContaining(String title, Pageable pageable);
    Page<Blog> findAllByInfor_InforNameContaining(String title,Pageable pageable);
    Page<Blog> findAll(Pageable pageable);


    Page<Blog> findAllByInfor_InforEmail(String searchTxt, Pageable pageable);
}
