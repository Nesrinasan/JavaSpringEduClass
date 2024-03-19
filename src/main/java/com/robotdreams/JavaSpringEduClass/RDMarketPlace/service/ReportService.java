package com.robotdreams.JavaSpringEduClass.RDMarketPlace.service;

import com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity.Report;
import com.robotdreams.JavaSpringEduClass.RDMarketPlace.repository.ReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }


    public void createOrderReport(String orderId, String userId) {
        try {
            Report report = new Report();
            report.setDescription("ürün siparişi oluştu");
            report.setOrderId(orderId);
            report.setUserId(userId);

            reportRepository.save(report);
        } catch (Exception e) {
            log.info("raporlamada hata oldu");
            //send kafka
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createOrderReport2(String orderId, String userId) {

        Report report = new Report();
        report.setDescription("ürün siparişi oluştu");
        report.setOrderId(orderId);
        report.setUserId(userId);

        reportRepository.save(report);
        String s = null;
        s.equals("");

    }


}
