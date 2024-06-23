package com.navyn.librarymanagementsys.Repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.navyn.librarymanagementsys.Models.UserData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {
    @Query(
            value="SELECT * FROM User usr WHERE usr.role=?1", nativeQuery = true
    )
    List<UserData> findByRole(String role);

    @Modifying
    @Transactional
    @Query(
            value="DELETE FROM User usr WHERE usr.user_id=?1", nativeQuery = true
    )
    void delete(Long id);

    Optional<UserData> findByEmail(String email);
}
