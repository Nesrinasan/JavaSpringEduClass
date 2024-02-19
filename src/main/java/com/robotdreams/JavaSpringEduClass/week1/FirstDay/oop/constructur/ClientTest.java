package com.robotdreams.JavaSpringEduClass.week1.FirstDay.oop.constructur;

public class ClientTest {

    public static void main(String[] args) {

        MusteriService musteriService = new MusteriService("admin");
        musteriService.getMusteriListesi();

        MusteriService musteriService2 = new MusteriService("admin", "Turkcell");

//        ClientService musteriService = new ClientService();

    }
}
