package com.MIS.MISTalks.EmailSubscribe.Repos;

import com.MIS.MISTalks.EmailSubscribe.Model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribedEmailsRepo extends JpaRepository<Email, Integer> {
}
