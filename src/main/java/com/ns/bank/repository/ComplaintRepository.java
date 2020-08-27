package com.ns.bank.repository;

import com.ns.bank.entity.Complaint;
import com.ns.bank.model.ComplaintModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    @Query(nativeQuery = true,value="SELECT  * FROM bankapplication.complaint WHERE status_id=?1")
    public List<Complaint> fetchComplaintByStatusId(Long statusId);

    @Query(nativeQuery = true,value="SELECT  * FROM bankapplication.complaint WHERE account_no=?1")
    public List<Complaint> fetchComplaintByAccountNumber(Long account_no);

    @Query(nativeQuery = true,value="UPDATE  bankapplication.complaint  SET  status_id=?1 WHERE id=?2")
    public Complaint updateStatus(Long statusId,Long complaintId);

    @Query(nativeQuery = true,value="SELECT COUNT(*) FROM bankapplication.complaint WHERE status_id=?1")
    public Integer getCompalintCountByStatus(Long statusId);

    @Query(nativeQuery = true,value="SELECT COUNT(*) FROM bankapplication.complaint")
    Integer getComplaintsCount();
}