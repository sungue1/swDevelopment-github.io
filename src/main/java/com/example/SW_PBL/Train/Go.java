package com.example.SW_PBL.Train;

import java.util.ArrayList;
import java.util.List;

public class Go {

    private int length1 = 0;
    private int length2 = 0;
    public int length = 0;
    public int k = -1;
    //public List DaTa1 = new ArrayList();
    //public List DaTa2 = new ArrayList();

    public List<Train> Save(String depa, String arra) {
        List<Train> TrainList = new ArrayList();
        String dep = depa;
        String arr = arra;
        Address address = new Address(dep, arr);
        System.out.println("사용자 위치: " + address.departure + ", 목적지: " + address.arrive);
        System.out.println("출발지: " + address.loc + ", 도착지: " + address.fes);
        Location location = new Location(address.loc, address.fes);
        System.out.println("출발역: " + location.dep + ", 도착역: " + location.arr);
        Station station = new Station();
        k = station.Station(location.dep, location.arr);
        switch(k) {
            case 0:
                System.out.println("직통구간입니다.");
                System.out.println("구간: " + location.dep + " to " + location.arr);
                TrainCrawling tc1 = new TrainCrawling();
                //Table table = new Table();
                tc1.query_dep = location.dep;
                tc1.query_arr = location.arr;
                Date Date = new Date();
                tc1.date = Date.td;
                tc1.Run();
                for (int i = 0; i < tc1.size; i++) {
                    Train train = new Train();
                    train.setDep(tc1.DataTable[i][0]);
                    train.setArr(tc1.DataTable[i][1]);
                    train.setEtd(tc1.DataTable[i][2]);
                    train.setEta(tc1.DataTable[i][3]);
                    train.setPrice(tc1.DataTable[i][4]);
                    train.setDuration(tc1.DataTable[i][5]);
                    TrainList.add(train);
                    //DaTa1.add(table);
                    System.out.println(tc1.DataTable[i][0] + " " + tc1.DataTable[i][1] + " " + tc1.DataTable[i][2] + " " + tc1.DataTable[i][3] + " " + tc1.DataTable[i][4] + " " + tc1.DataTable[i][5]);
                }
                length1 = tc1.length;
                this.length = length1;
                break;
            case 1:
                System.out.println("환승역: " + station.trsf);
                System.out.println("첫 번째 구간: " + location.dep + " to " + station.trsf + ", 두 번째 구간: " + station.trsf + " to " + location.arr);
                TrainCrawling tc2 = new TrainCrawling();
                //Table table1 = new Table();
                tc2.query_dep = location.dep;
                tc2.query_arr = station.trsf;
                Date Date2 = new Date();
                tc2.date = Date2.td;
                tc2.Run();
                for (int i = 0; i < tc2.size; i++) {
                    Train train1 = new Train();
                    train1.setDep(tc2.DataTable[i][0]);
                    train1.setArr(tc2.DataTable[i][1]);
                    train1.setEtd(tc2.DataTable[i][2]);
                    train1.setEta(tc2.DataTable[i][3]);
                    train1.setPrice(tc2.DataTable[i][4]);
                    train1.setDuration(tc2.DataTable[i][5]);
                    TrainList.add(train1);
                    //DaTa1.add(table1);
                    System.out.println(tc2.DataTable[i][0] + " " + tc2.DataTable[i][1] + " " + tc2.DataTable[i][2] + " " + tc2.DataTable[i][3] + " " + tc2.DataTable[i][4] + " " + tc2.DataTable[i][5]);
                }
                this.length1 = tc2.length;
                TrainCrawling tc3 = new TrainCrawling();
                //Table table2 = new Table();
                tc3.query_dep = station.trsf;
                tc3.query_arr = location.arr;
                Date Date3 = new Date();
                tc3.date = Date3.td;
                tc3.Run();
                for (int i = 0; i < tc3.size; i++) {
                    Train train2 = new Train();
                    train2.setDep(tc3.DataTable[i][0]);
                    train2.setArr(tc3.DataTable[i][1]);
                    train2.setEtd(tc3.DataTable[i][2]);
                    train2.setEta(tc3.DataTable[i][3]);
                    train2.setPrice(tc3.DataTable[i][4]);
                    train2.setDuration(tc3.DataTable[i][5]);
                    TrainList.add(train2);
                    //DaTa2.add(table2);
                    System.out.println(tc3.DataTable[i][0] + " " + tc3.DataTable[i][1] + " " + tc3.DataTable[i][2] + " " + tc3.DataTable[i][3] + " " + tc3.DataTable[i][4] + " " + tc3.DataTable[i][5]);
                }
                length2 = tc3.length;
                this.length = length1 + length2;
                break;
            case 2:
                System.out.println("내리는 역과 탑승 역이 다릅니다!");
                System.out.println("첫 번째 구간: " + location.dep + " to " + station.trsf1 + ", 두 번째 구간: " + station.trsf2 + " to " + location.arr);
                TrainCrawling tc4 = new TrainCrawling();
                //Table table3 = new Table();
                tc4.query_dep = location.dep;
                tc4.query_arr = station.trsf1;
                Date Date4 = new Date();
                tc4.date = Date4.td;
                tc4.Run();
                for (int i = 0; i < tc4.size; i++) {
                    Train train3 = new Train();
                    train3.setDep(tc4.DataTable[i][0]);
                    train3.setArr(tc4.DataTable[i][1]);
                    train3.setEtd(tc4.DataTable[i][2]);
                    train3.setEta(tc4.DataTable[i][3]);
                    train3.setPrice(tc4.DataTable[i][4]);
                    train3.setDuration(tc4.DataTable[i][5]);
                    TrainList.add(train3);
                    //DaTa1.add(table3);
                    System.out.println(tc4.DataTable[i][0] + " " + tc4.DataTable[i][1] + " " + tc4.DataTable[i][2] + " " + tc4.DataTable[i][3] + " " + tc4.DataTable[i][4] + " " + tc4.DataTable[i][5]);
                }
                length1 = tc4.length;
                TrainCrawling tc5 = new TrainCrawling();
                //Table table4 = new Table();
                tc5.query_dep = station.trsf2;
                tc5.query_arr = location.arr;
                Date Date5 = new Date();
                tc5.date = Date5.td;
                tc5.Run();
                for (int i = 0; i < tc5.size; i++) {
                    Train train4 = new Train();
                    train4.setDep(tc5.DataTable[i][0]);
                    train4.setArr(tc5.DataTable[i][1]);
                    train4.setEtd(tc5.DataTable[i][2]);
                    train4.setEta(tc5.DataTable[i][3]);
                    train4.setPrice(tc5.DataTable[i][4]);
                    train4.setDuration(tc5.DataTable[i][5]);
                    TrainList.add(train4);
                    //DaTa2.add(table4);
                    System.out.println(tc5.DataTable[i][0] + " " + tc5.DataTable[i][1] + " " +  tc5.DataTable[i][2] + " " + tc5.DataTable[i][3] + " " + tc5.DataTable[i][4] + " " + tc5.DataTable[i][5]);
                }
                length2 = tc5.length;
                this.length = length1 + length2;
                break;
        }
        return TrainList;
    }
}
