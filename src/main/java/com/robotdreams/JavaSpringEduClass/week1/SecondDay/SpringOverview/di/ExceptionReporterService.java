package com.robotdreams.JavaSpringEduClass.week1.SecondDay.SpringOverview.di;

public class ExceptionReporterService {

    OracleDB oracleDB;
    MysqlDB mysqlDB;
    ConnectionService connectionService;

    public ExceptionReporterService(){
        connectionService = new ConnectionService();
    }

    public void exceptionReportOracle(){
        String oracleConn = connectionService.connection("Oracle");
        oracleDB = new OracleDB(oracleConn);
        oracleDB.report();
    }

    public void exceptionReportMysql(){
        String mysqlConn = connectionService.connection("Mysql");

        mysqlDB = new MysqlDB(mysqlConn);
        mysqlDB.report();
    }
}
