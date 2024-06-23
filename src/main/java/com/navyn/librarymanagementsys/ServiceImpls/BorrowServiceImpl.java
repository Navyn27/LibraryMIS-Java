package com.navyn.librarymanagementsys.ServiceImpls;

import com.navyn.librarymanagementsys.Enums.BorrowStatus;
import com.navyn.librarymanagementsys.Models.Borrow;
import com.navyn.librarymanagementsys.Repositories.BorrowRepository;
import com.navyn.librarymanagementsys.Services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService{

    @Autowired
    BorrowRepository borrowRepository;

    @Override
    public List<Borrow> findAll(){
        return borrowRepository.findAll();
    }

    @Override
    public List<Borrow> findOverdue(){
        return borrowRepository.findByStatus(BorrowStatus.OVERDUE);
    }

    @Override
    public Borrow save(Borrow borrow){
        return borrowRepository.save(borrow);
    }

    @Override
    public Borrow markStatusReturned(Long id){
        return borrowRepository.markStatusReturned(id);
    }
}
