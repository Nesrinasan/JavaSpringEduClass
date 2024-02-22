package com.robotdreams.JavaSpringEduClass.week1.SecondDay.SpringOverview.di;

public class Client {

    /**
     * Database rapprlama sistemi yapılacak.
     * 3 farklı database'im var. ORacle, MySql, PostgreSQL
     * Bu databaselerin hepsinin raprlama detayları farklı.
     * ORacle üzerinde müşteri bilgisi, MySql üzerinde ürün bilgisi, PostgreSQl üzerinde ise hata logları tutuluyor.
     *
     * @param args
     */
    public static void main(String[] args) {

        ConnectionService connectionService = new ConnectionService("test");
        String mysql = connectionService.connection("Mysql");
        String oracle = connectionService.connection("Oracle");

        MysqlDB mysqlDB = new MysqlDB(mysql);
        OracleDB oracleDB = new OracleDB(oracle);

        ReporterService exceptionReporter = new ReporterService(mysqlDB, oracleDB);

        exceptionReporter.exceptionReportOracle();
        exceptionReporter.exceptionReportMysql();


    }
}
