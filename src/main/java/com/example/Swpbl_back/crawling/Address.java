package com.example.Swpbl_back.crawling;

public class Address {
    String departure = "";
    String arrive = "";
    String loc = "";
    String fes = "";

    public Address(String depa, String arra) {
        departure = depa;
        arrive = arra;
        // 출발지
        if (departure.indexOf("서울") == 0) {
            loc = "서울";
        }
        else if (departure.indexOf("인천") == 0) {
            loc = "인천";
        }
        else if (departure.indexOf("대전") == 0) {
            loc = "대전";
        }
        else if (departure.indexOf("대구") == 0) {
            loc = "대구";
        }
        else if (departure.indexOf("광주") == 0) {
            loc = "광주";
        }
        else if (departure.indexOf("울산") == 0) {
            loc = "울산";
        }
        else if (departure.indexOf("부산") == 0) {
            loc = "부산";
        }
        else if (departure.indexOf("세종시") == 0) {
            loc = "세종시";
        }
        else if (departure.indexOf("경기도") == 0 || departure.indexOf("강원도") == 0) {
            if (departure.charAt(6) != '시' && departure.charAt(6) != '군') {
                loc = departure.substring(4, 7);
            }
            else {
                loc = departure.substring(4, 6);
            }
        }
        else {
            loc = departure.substring(5, 7);
        }

        // 도착지
        if (arrive.indexOf("서울") == 0) {
            fes = "서울";
        }
        else if (arrive.indexOf("인천") == 0) {
            fes = "인천";
        }
        else if (arrive.indexOf("대전") == 0) {
            fes = "대전";
        }
        else if (arrive.indexOf("대구") == 0) {
            fes = "대구";
        }
        else if (arrive.indexOf("광주") == 0) {
            fes = "광주";
        }
        else if (arrive.indexOf("울산") == 0) {
            fes = "울산";
        }
        else if (arrive.indexOf("부산") == 0) {
            fes = "부산";
        }
        else if (arrive.indexOf("세종시") == 0) {
            fes = "세종시";
        }
        else if (arrive.indexOf("경기도") == 0 || arrive.indexOf("강원도") == 0) {
            if (departure.charAt(6) != '시' && departure.charAt(6) != '군') {
                fes = arrive.substring(4, 7);
            }
            else {
                fes = arrive.substring(4, 6);
            }
        }
        else {
            fes = arrive.substring(5, 7);
        }
    }
}
