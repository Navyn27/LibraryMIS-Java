package com.navyn.librarymanagementsys.Repositories;

import com.navyn.librarymanagementsys.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(
            value="DELETE FROM Book WHERE bk WHERE bk.bookId=?1", nativeQuery = true
    )
    void delete(Long id);
}
