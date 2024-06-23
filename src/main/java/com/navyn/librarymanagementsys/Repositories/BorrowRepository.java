package com.navyn.librarymanagementsys.Repositories;

import com.navyn.librarymanagementsys.Enums.BorrowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import com.navyn.librarymanagementsys.Models.Borrow;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {
    @Query(
            value="SELECT * FROM Borrow br WHERE br.status=?1", nativeQuery = true
    )
    List<Borrow> findByStatus(BorrowStatus borrowStatus);

    @Query(
            value="UPDATE Borrows br SET br.borrowStatus= 'RETURNED' WHERE br.id=?1", nativeQuery = true
    )
    Borrow markStatusReturned(Long id);
}
