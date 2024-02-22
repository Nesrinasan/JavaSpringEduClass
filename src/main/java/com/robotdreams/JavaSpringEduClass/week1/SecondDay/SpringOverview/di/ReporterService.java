package com.robotdreams.JavaSpringEduClass.week1.SecondDay.SpringOverview.di;

public class ReporterService {

    MysqlDB mysqlDB;
    OracleDB oracleDB;

    public ReporterService(MysqlDB mysqlDB, OracleDB oracleDB){
        this.mysqlDB= mysqlDB;
        this.oracleDB = oracleDB;

    }

    public void exceptionReportOracle() {
        oracleDB.report();
    }

    public void exceptionReportMysql() {
        mysqlDB.report();
    }
}
