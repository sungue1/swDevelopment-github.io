package com.example.Swpbl_back.crawling;

public class Address {
    String departure = "서울특별시 은평구 득량길 20";
    String arrive = "대구광역시 수성구 진주대로 501";
    String loc = "";
    String fes = "";

    public Address() {
        // 출발지
        if (departure.indexOf("서울특별시") == 0) {
            loc = "서울특별시";
        }
        else if (departure.indexOf("인천광역시") == 0) {
            loc = "인천광역시";
        }
        else if (departure.indexOf("대전광역시") == 0) {
            loc = "대전광역시";
        }
        else if (departure.indexOf("대구광역시") == 0) {
            loc = "대구광역시";
        }
        else if (departure.indexOf("광주광역시") == 0) {
            loc = "광주광역시";
        }
        else if (departure.indexOf("울산광역시") == 0) {
            loc = "울산광역시";
        }
        else if (departure.indexOf("부산광역시") == 0) {
            loc = "부산광역시";
        }
        else if (departure.indexOf("세종특별자치시") == 0) {
            loc = "세종특별자치시";
        }
        else if (departure.indexOf("경기도") == 0 || departure.indexOf("강원도") == 0) {
            if (departure.charAt(7) != ' ') {
                loc = departure.substring(4, 7);
            }
            else {
                loc = departure.substring(4, 6);
            }
        }
        else {
            if (departure.charAt(8) != ' ') {
                loc = departure.substring(5, 8);
            }
            else {
                loc = departure.substring(5, 7);
            }
        }

        // 도착지
        if (arrive.indexOf("서울특별시") == 0) {
            fes = "서울특별시";
        }
        else if (arrive.indexOf("인천광역시") == 0) {
            fes = "인천광역시";
        }
        else if (arrive.indexOf("대전광역시") == 0) {
            fes = "대전광역시";
        }
        else if (arrive.indexOf("대구광역시") == 0) {
            fes = "대구광역시";
        }
        else if (arrive.indexOf("광주광역시") == 0) {
            fes = "광주광역시";
        }
        else if (arrive.indexOf("울산광역시") == 0) {
            fes = "울산광역시";
        }
        else if (arrive.indexOf("부산광역시") == 0) {
            fes = "부산광역시";
        }
        else if (arrive.indexOf("세종특별자치시") == 0) {
            fes = "세종특별자치시";
        }
        else if (arrive.indexOf("경기도") == 0 || arrive.indexOf("강원도") == 0) {
            if (arrive.charAt(7) != ' ') {
                fes = arrive.substring(4, 7);
            }
            else {
                fes = arrive.substring(4, 6);
            }
        }
        else {
            if (arrive.charAt(8) != ' ') {
                fes = arrive.substring(5, 8);
            }
            else {
                fes = arrive.substring(5, 7);
            }
        }
    }
}
