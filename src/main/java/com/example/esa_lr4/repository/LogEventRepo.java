package com.example.esa_lr4.repository;

import org.springframework.stereotype.Repository;
import com.example.esa_lr4.model.LogEvent;

@Repository
public interface LogEventRepo extends BaseEntityRepo<LogEvent, Long> {
}