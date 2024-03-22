package com.example.library_management.service;

import com.example.library_management.model.BorrowDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBorrowService extends IGeneralService<BorrowDetail> {
    Page<BorrowDetail> findAll(Pageable pageable);
}
