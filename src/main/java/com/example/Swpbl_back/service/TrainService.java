//package com.example.Swpbl_back.service;
//
//import com.example.Swpbl_back.crawling.*;
//
//public class TrainService {
//
//    Address address = new Address();
//    Location location = new Location(address.loc, address.fes);
//
//    Station station = new Station();
//    /
//    int k = station.Station(location.dep, location.arr);
//    switch(k) {
//        case 0:
//            TrainCrawling tc1 = new TrainCrawling();
//            tc1.query_dep = location.dep;
//            tc1.query_arr = location.arr;
//            Date Date = new Date();
//            tc1.date = Date.td;
//            tc1.Run();
//            break;
//        case 1:
//            TrainCrawling tc2 = new TrainCrawling();
//            tc2.query_dep = location.dep;
//            tc2.query_arr = station.trsf;
//            Date Date2 = new Date();
//            tc2.date = Date2.td;
//            tc2.Run();
//            TrainCrawling tc3 = new TrainCrawling();
//            tc3.query_dep = station.trsf;
//            tc3.query_arr = location.arr;
//            Date Date3 = new Date();
//            tc3.date = Date3.td;
//            tc3.Run();
//            break;
//        case 2:
//            TrainCrawling tc4 = new TrainCrawling();
//            tc4.query_dep = location.dep;
//            tc4.query_arr = station.trsf1;
//            Date Date4 = new Date();
//            tc4.date = Date4.td;
//            tc4.Run();
//            TrainCrawling tc5 = new TrainCrawling();
//            tc5.query_dep = station.trsf2;
//            tc5.query_arr = location.arr;
//            Date Date5 = new Date();
//            tc5.date = Date5.td;
//            tc5.Run();
//            break;
//    }
//}
