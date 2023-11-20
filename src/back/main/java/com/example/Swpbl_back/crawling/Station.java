package com.example.Swpbl_back.crawling;

import java.lang.String;

public class Station {
    final String[] gyeongbusw = {"서울", "영등포", "수원", "대전", "동대구", "신경주", "울산(통도사)", "부산"};
    final String[] gyeongbugp = {"행신", "서울", "광명", "대전", "김천구미", "동대구", "경산", "밀양", "구포", "부산"};
    final String[] gyeongbu = {"행신", "서울", "광명", "천안아산", "오송", "대전", "김천구미", "서대구", "동대구", "신경주", "울산(통도사)", "부산"};
    final String[] donghae = {"행신", "서울", "광명", "천안아산", "오송", "대전", "김천구미", "동대구", "포항"};
    final String[] gyeongjeon = {"행신", "서울", "광명", "천안아산", "오송", "대전", "서대구", "동대구", "경산", "밀양", "창원중앙", "창원", "마산", "진주"};
    final String[] gyeongjeonjy = {"행신", "서울", "광명", "천안아산", "오송", "대전", "동대구", "경산", "밀양", "진영", "창원중앙", "창원", "마산", "진주"};
    final String[] gangneung = {"서울", "청량리", "상봉", "양평", "만종", "횡성", "둔내", "평창", "진부(오대산)", "강릉"};
    final String[] gangneungdh = {"서울", "청량리", "상봉", "양평", "만종", "횡성", "둔내", "평창", "진부(오대산)", "정동진", "묵호", "동해"};
    final String[] honamhs = {"행신", "용산", "광명", "천안아산", "오송", "공주", "익산", "정읍", "광주송정", "나주", "목포"};
    final String[] honam = {"용산", "광명", "천안아산", "오송", "서대전", "계룡", "논산", "익산", "김제", "정읍", "장성", "광주송정", "나주", "목포"};
    final String[] jeollahs = {"행신", "용산", "광명", "천안아산", "오송", "공주", "익산", "전주", "남원", "곡성", "구례구", "순천", "여천", "여수EXPO"};
    final String[] jeolla = {"용산", "광명", "천안아산", "오송", "서대전", "계룡", "논산"," 익산", "전주", "남원", "곡성", "구례구", "순천", "여천", "여수EXPO"};
    final String[] jungang = {"청량리", "양평", "서원주", "원주", "제천", "단양", "풍기", "영주", "안동"};
    final String[][] line = {gyeongbusw, gyeongbugp, gyeongbu, donghae, gyeongjeon, gyeongjeonjy, gangneung, gangneungdh, honamhs, honam, jeollahs, jeolla, jungang};
    final int lth = line.length;
    private String dep = "";
    private String arr = "";
    public String trsf = "";
    public String trsf1 = "";
    public String trsf2 = "";

    public int Station(String d, String a) {
        dep = d;
        arr = a;
        int i = 0;
        for (int j = 0; j < lth; j++) {
            int len = line[j].length;
            for (int k = 0; k < len; k++) {
                if (line[j][k].equals(dep)) {
                    i++;
                }
            }
            for (int k = 0; k < len; k++) {
                if (line[j][k].equals(arr)) {
                    i++;
                }
            }
            if (i == 2) {
                return 0;
            }
            i = 0;
        }
        final String[] str1 = {"진영", "창원중앙", "창원", "마산", "진주"};
        final String[] str2 = {"서울", "광명", "영등포", "수원", "오송", "천안아산", "대전", "김천구미", "서대구", "동대구", "신경주", "울산(통도사)", "부산"};
        final String[] str3 = {"공주", "서대전", "계룡", "논산", "익산", "전주", "남원", "곡성", "구례구", "순천", "여천", "'여수EXPO"};
        final String[] str4 = {"공주", "서대전", "계룡", "논산", "익산", "김제", "정읍", "장성", "광주송정", "나주", "목포"};

        // 경전선 발착
        for (String ste1 : str1) {
            if (ste1.equals(dep) && arr.equals("포항")) {
                trsf = "동대구";
                return 1;
            }
            else if (ste1.equals(arr) && dep.equals("포항")) {
                trsf = "동대구";
                return 1;
            }
            for (String ste2 : str2) {
                if (ste1.equals(arr) && ste2.equals(dep)) {
                    trsf = "동대구";
                    return 1;
                }
                else if (ste1.equals(dep) && ste2.equals(arr)) {
                    trsf = "동대구";
                    return 1;
                }
            }
            for (String ste3 : str3) {
                if (ste1.equals(arr) && ste3.equals(dep)) {
                    trsf = "오송";
                    return 1;
                }
                else if (ste1.equals(dep) && ste3.equals(arr)) {
                    trsf = "오송";
                    return 1;
                }
            }
            for (String ste4 : str4) {
                if (ste1.equals(arr) && ste4.equals(dep)) {
                    trsf = "오송";
                    return 1;
                }
                else if (ste1.equals(dep) && ste4.equals(arr)) {
                    trsf = "오송";
                    return 1;
                }
            }
            for (String ste5 : jungang) {
                if (ste1. equals(arr) && ste5.equals(dep)) {
                    trsf1 = "청량리";
                    trsf2 = "서울";
                    return 2;
                }
                else if (ste1. equals(dep) && ste5.equals(arr)) {
                    trsf1 = "서울";
                    trsf2 = "청량리";
                    return 2;
                }
            }
            for (String ste6 : gangneung) {
                if (ste1. equals(arr) && ste6.equals(dep)) {
                    trsf = "서울";
                    return 1;
                }
                else if (ste1. equals(dep) && ste6.equals(arr)) {
                    trsf = "서울";
                    return 1;
                }
            }
            for (String ste7 : gangneungdh) {
                if (ste1. equals(arr) && ste7.equals(dep)) {
                    trsf = "서울";
                    return 1;
                }
                else if (ste1. equals(dep) && ste7.equals(arr)) {
                    trsf = "서울";
                    return 1;
                }
            }
        }

        // 경부선 발착
        for (String ste1 : str2) {
            if (ste1.equals(dep) && arr.equals("포항")) {
                trsf = "동대구";
                return 1;
            } else if (ste1.equals(arr) && dep.equals("포항")) {
                trsf = "동대구";
                return 1;
            }
            for (String ste2 : str3) {
                if (ste1.equals(arr) && ste2.equals(dep)) {
                    trsf = "오송";
                    return 1;
                } else if (ste1.equals(dep) && ste2.equals(arr)) {
                    trsf = "오송";
                    return 1;
                }
            }
            for (String ste3 : str4) {
                if (ste1.equals(arr) && ste3.equals(dep)) {
                    trsf = "오송";
                    return 1;
                } else if (ste1.equals(dep) && ste3.equals(arr)) {
                    trsf = "오송";
                    return 1;
                }
            }
            for (String ste4 : jungang) {
                if (ste1.equals(arr) && ste4.equals(dep)) {
                    trsf1 = "청량리";
                    trsf2 = "서울";
                    return 2;
                } else if (ste1.equals(dep) && ste4.equals(arr)) {
                    trsf1 = "서울";
                    trsf2 = "청량리";
                    return 2;
                }
            }
            for (String ste5 : gangneung) {
                if (ste1.equals(arr) && ste5.equals(dep)) {
                    trsf = "서울";
                    return 1;
                } else if (ste1.equals(dep) && ste5.equals(arr)) {
                    trsf = "서울";
                    return 1;
                }
            }
            for (String ste6 : gangneungdh) {
                if (ste1.equals(arr) && ste6.equals(dep)) {
                    trsf = "서울";
                    return 1;
                } else if (ste1.equals(dep) && ste6.equals(arr)) {
                    trsf = "서울";
                    return 1;
                }
            }
        }

        // 전라선 발착
        for (String ste1 : str3) {
            if (ste1.equals(dep) && arr.equals("포항")) {
                trsf = "오송";
                return 1;
            } else if (ste1.equals(arr) && dep.equals("포항")) {
                trsf = "오송";
                return 1;
            }
            for (String ste2 : str4) {
                if (ste1.equals(arr) && ste2.equals(dep)) {
                    trsf = "익산";
                    return 1;
                } else if (ste1.equals(dep) && ste2.equals(arr)) {
                    trsf = "익산";
                    return 1;
                }
            }
            for (String ste3 : jungang) {
                if (ste1.equals(arr) && ste3.equals(dep)) {
                    trsf1 = "청량리";
                    trsf2 = "용산";
                    return 2;
                } else if (ste1.equals(dep) && ste3.equals(arr)) {
                    trsf1 = "서울";
                    trsf2 = "용산";
                    return 2;
                }
            }
            for (String ste4 : gangneung) {
                if (ste1.equals(arr) && ste4.equals(dep)) {
                    trsf1 = "청량리";
                    trsf2 = "용산";
                    return 2;
                } else if (ste1.equals(dep) && ste4.equals(arr)) {
                    trsf1 = "용산";
                    trsf2 = "청량리";
                    return 2;
                }
            }
            for (String ste5 : gangneungdh) {
                if (ste1.equals(arr) && ste5.equals(dep)) {
                    trsf1 = "청량리";
                    trsf2 = "용산";
                    return 2;
                } else if (ste1.equals(dep) && ste5.equals(arr)) {
                    trsf1 = "용산";
                    trsf2 = "청량리";
                    return 2;
                }
            }
        }

        // 호남선 발착
        for (String ste1 : str4) {
            if (ste1.equals(dep) && arr.equals("포항")) {
                trsf = "오송";
                return 1;
            } else if (ste1.equals(arr) && dep.equals("포항")) {
                trsf = "오송";
                return 1;
            }
            for (String ste2 : jungang) {
                if (ste1.equals(arr) && ste2.equals(dep)) {
                    trsf1 = "청량리";
                    trsf2 = "용산";
                    return 2;
                } else if (ste1.equals(dep) && ste2.equals(arr)) {
                    trsf1 = "서울";
                    trsf2 = "용산";
                    return 2;
                }
            }
            for (String ste3 : gangneung) {
                if (ste1.equals(arr) && ste3.equals(dep)) {
                    trsf1 = "청량리";
                    trsf2 = "용산";
                    return 2;
                } else if (ste1.equals(dep) && ste3.equals(arr)) {
                    trsf1 = "용산";
                    trsf2 = "청량리";
                    return 2;
                }
            }
            for (String ste4 : gangneungdh) {
                if (ste1.equals(arr) && ste4.equals(dep)) {
                    trsf1 = "청량리";
                    trsf2 = "용산";
                    return 2;
                } else if (ste1.equals(dep) && ste4.equals(arr)) {
                    trsf1 = "용산";
                    trsf2 = "청량리";
                    return 2;
                }
            }
        }

        // 중앙선 발착
        for (String ste1 : jungang) {
            if (ste1.equals(dep) && arr.equals("포항")) {
                trsf1 = "청량리";
                trsf2 = "서울";
                return 2;
            } else if (ste1.equals(arr) && dep.equals("포항")) {
                trsf1 = "서울";
                trsf2 = "청량리";
                return 2;
            }
            for (String ste2 : gangneung) {
                if (ste1.equals(arr) && ste2.equals(dep)) {
                    trsf = "청량리";
                    return 1;
                } else if (ste1.equals(dep) && ste2.equals(arr)) {
                    trsf = "청량리";
                    return 1;
                }
            }
            for (String ste3 : gangneungdh) {
                if (ste1.equals(arr) && ste3.equals(dep)) {
                    trsf = "청량리";
                    return 1;
                } else if (ste1.equals(dep) && ste3.equals(arr)) {
                    trsf = "청량리";
                    return 1;
                }
            }
        }

        // 강릉선 발착
        for (String ste1 : gangneung) {
            if (ste1.equals(dep) && arr.equals("포항")) {
                trsf = "서울";
                return 1;
            } else if (ste1.equals(arr) && dep.equals("포항")) {
                trsf = "서울";
                return 1;
            }
            for (String ste2 : gangneungdh) {
                if (ste1.equals(arr) && ste2.equals(dep)) {
                    trsf = "진부(오대산)";
                    return 1;
                } else if (ste1.equals(dep) && ste2.equals(arr)) {
                    trsf = "진부(오대산)";
                    return 1;
                }
            }
        }
        // 강릉동해선 발착
        for (String ste1 : gangneung) {
            if (ste1.equals(dep) && arr.equals("포항")) {
                trsf = "서울";
                return 1;
            } else if (ste1.equals(arr) && dep.equals("포항")) {
                trsf = "서울";
                return 1;
            }
        }
        return 0;
    }
}
