package com.codegym.service;

import com.codegym.entity.Report;
import com.codegym.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportService implements IReportService{
    @Autowired
    ReportRepository reportRepository;
    @Override
    public Iterable<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public Optional<Report> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Report save(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public void remove(Long id) {

    }
}
