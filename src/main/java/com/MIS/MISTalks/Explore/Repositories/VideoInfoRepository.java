package com.MIS.MISTalks.Explore.Repositories;

import com.MIS.MISTalks.Explore.Model.VideoInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoInfoRepository extends JpaRepository<VideoInfo, Integer> {

        @Query(value = "SELECT * FROM videos " +
                "WHERE POSITION(?1 IN LOWER(head_line)) > 0 " +
                "OR position(?1 in LOWER(tags)) > 0", nativeQuery = true)
    public Page<VideoInfo> findAllByName(String headLine, Pageable pageable);
}
