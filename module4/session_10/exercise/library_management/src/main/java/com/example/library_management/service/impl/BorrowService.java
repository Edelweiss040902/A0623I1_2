package com.example.library_management.service.impl;

import com.example.library_management.model.BorrowDetail;
import com.example.library_management.repository.IBorrowRepository;
import com.example.library_management.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private IBorrowRepository borrowRepository;
    @Override
    public List<BorrowDetail> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public BorrowDetail findById(Long id) {
        return borrowRepository.findById(id).get();
    }

    @Override
    public void save(BorrowDetail borrowDetail) {
        borrowRepository.save(borrowDetail);
    }

    @Override
    public void deleteById(Long id) {
        borrowRepository.deleteById(id);
    }

    @Override
    public Page<BorrowDetail> findAll(Pageable pageable) {
        return borrowRepository.findAll(pageable);
    }
}
