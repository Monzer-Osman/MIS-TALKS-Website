package com.MIS.MISTalks.ContactUs.Repository;

import com.MIS.MISTalks.ContactUs.Model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackRepository extends JpaRepository<Feedback, Integer> {
}
