package com.example.library_management.repository;

import com.example.library_management.model.BorrowDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBorrowRepository extends JpaRepository<BorrowDetail,Long> {
    Page<BorrowDetail> findAll(Pageable pageable);
}
