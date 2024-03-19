package com.example.e1_blog_upgrade.repository;

import com.example.e1_blog_upgrade.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {
    Page<Blog> findAllByBlogTitleContaining(String title, Pageable pageable);
    Page<Blog> findAllByInfor_InforNameContaining(String infor,Pageable pageable);
    Page<Blog> findAll (Pageable pageable);
    Page<Blog> findAllByInfor_InforEmail(String name,Pageable pageable);
}
