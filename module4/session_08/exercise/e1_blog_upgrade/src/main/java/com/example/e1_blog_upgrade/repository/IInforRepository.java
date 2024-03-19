package com.example.e1_blog_upgrade.repository;

import com.example.e1_blog_upgrade.model.Infor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInforRepository extends JpaRepository<Infor,Long> {
}
