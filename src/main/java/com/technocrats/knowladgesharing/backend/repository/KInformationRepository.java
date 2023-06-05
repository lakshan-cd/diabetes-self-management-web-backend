package com.technocrats.knowladgesharing.backend.repository;

import com.technocrats.knowladgesharing.backend.model.KInformation;
import com.technocrats.knowladgesharing.backend.service.CategoryCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
public interface KInformationRepository extends JpaRepository<KInformation , Long> {

    List<KInformation> findByCatergory(String catergory);

    //get count of posts acording to month
    @Query(value = "SELECT MONTH(created_date) as month, COUNT(*) as count FROM KInformation GROUP BY month ORDER BY month ASC", nativeQuery = true)
    List<Object[]> getPostCountByMonth();






    //get count according to category
    @Query("SELECT k.catergory, COUNT(k) FROM KInformation k GROUP BY k.catergory")
    List<Object[]> countByCategory();

}
