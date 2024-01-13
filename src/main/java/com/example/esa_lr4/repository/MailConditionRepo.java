package com.example.esa_lr4.repository;


import org.springframework.stereotype.Repository;
import com.example.esa_lr4.model.MailCondition;

@Repository
public interface MailConditionRepo extends BaseEntityRepo<MailCondition, Long> {
}
