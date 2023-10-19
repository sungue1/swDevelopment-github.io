package com.example.Swpbl_back.crawling;

public class Go {
    public static void main(String[] args) {
        Address address = new Address();
        System.out.println("사용자 위치: " + address.departure + ", 목적지: " + address.arrive);
        System.out.println("출발지: " + address.loc + ", 도착지: " + address.fes);
        Location location = new Location(address.loc, address.fes);
        System.out.println("출발역: " + location.dep + ", 도착역: " + location.arr);

        Station station = new Station();
        int k = station.Station(location.dep, location.arr);
        switch(k) {
            case 0:
                System.out.println("직통구간입니다.");
                System.out.println("구간: " + location.dep + " to " + location.arr);
                TrainCrawling tc1 = new TrainCrawling();
                tc1.query_dep = location.dep;
                tc1.query_arr = location.arr;
                Date Date = new Date();
                tc1.date = Date.td;
                tc1.Run();
                for (int i = 0; i < tc1.size; i++) {
                    System.out.println(tc1.DataTable[i][0] + " " + tc1.DataTable[i][1] + " " + tc1.DataTable[i][2] + " " + tc1.DataTable[i][3]);
                }
                break;
            case 1:
                System.out.println("환승역: " + station.trsf);
                System.out.println("첫 번째 구간: " + location.dep + " to " + station.trsf + ", 두 번째 구간: " + station.trsf + " to " + location.arr);
                TrainCrawling tc2 = new TrainCrawling();
                tc2.query_dep = location.dep;
                tc2.query_arr = station.trsf;
                Date Date2 = new Date();
                tc2.date = Date2.td;
                tc2.Run();
                for (int i = 0; i < tc2.size; i++) {
                    System.out.println(tc2.DataTable[i][0] + " " + tc2.DataTable[i][1] + " " + tc2.DataTable[i][2] + " " + tc2.DataTable[i][3]);
                }
                TrainCrawling tc3 = new TrainCrawling();
                tc3.query_dep = station.trsf;
                tc3.query_arr = location.arr;
                Date Date3 = new Date();
                tc3.date = Date3.td;
                tc3.Run();
                for (int i = 0; i < tc3.size; i++) {
                    System.out.println(tc3.DataTable[i][0] + " " + tc3.DataTable[i][1] + " " + tc3.DataTable[i][2] + " " + tc3.DataTable[i][3]);
                }
                break;
            case 2:
                System.out.println("내리는 역과 탑승 역이 다릅니다!");
                System.out.println("첫 번째 구간: " + location.dep + " to " + station.trsf1 + ", 두 번째 구간: " + station.trsf2 + " to " + location.arr);
                TrainCrawling tc4 = new TrainCrawling();
                tc4.query_dep = location.dep;
                tc4.query_arr = station.trsf1;
                Date Date4 = new Date();
                tc4.date = Date4.td;
                tc4.Run();
                for (int i = 0; i < tc4.size; i++) {
                    System.out.println(tc4.DataTable[i][0] + " " + tc4.DataTable[i][1] + " " + tc4.DataTable[i][2] + " " +  tc4.DataTable[i][3]);
                }
                TrainCrawling tc5 = new TrainCrawling();
                tc5.query_dep = station.trsf2;
                tc5.query_arr = location.arr;
                Date Date5 = new Date();
                tc5.date = Date5.td;
                tc5.Run();
                for (int i = 0; i < tc5.size; i++) {
                    System.out.println(tc5.DataTable[i][0] + " " + tc5.DataTable[i][1] + " " +  tc5.DataTable[i][2] + " " + tc5.DataTable[i][3]);
                }
                break;
        }
    }
}
