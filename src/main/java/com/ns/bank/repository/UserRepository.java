package com.ns.bank.repository;

import com.ns.bank.entity.User;
import com.ns.bank.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Query(nativeQuery = true,value = "UPDATE bankapplication.user SET row_status_id = ?2 WHERE id=?1")
    int updateUserStatus(Long userId,Integer rowStatusId);

    @Query(nativeQuery = true,value = "SELECT * FROM bankapplication.user WHERE role_id = ?1")
    List<User> findAllByRoleId(Long roleId);

    @Query(nativeQuery = true,value = "SELECT * FROM bankapplication.user WHERE row_status_id = ?1")
    List<User> findAllByRowStatusId(Long rowStatusId);

    @Query(nativeQuery = true,value = "SELECT * FROM bankapplication.user WHERE branch_id = ?1")
    List<User> findAllByBranchId(Long branchId);

    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByEmail(String email);

    @Query(nativeQuery = true,value="SELECT COUNT(*) FROM bankapplication.user WHERE branch_id=?1")
    Integer getCountOfUsersByBranch(Long branchCode);

}