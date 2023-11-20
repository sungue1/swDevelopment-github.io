package com.example.Swpbl_back.crawling;

import java.util.Arrays;
import java.lang.String;

public class Location {
    private String[] wonju = {"원주"};
    private String[] jechoen = {"충주", "영월", "제천"};
    private String[] danyang = {"단양"};
    private String[] yeongju = {"울진", "문경", "태백", "영주"};
    private String[] punggi = {"봉화"};
    private String[] andong = {"영양", "의성", "예천", "안동"};

    private String[] yangpyong = {"춘천", "여주", "이천", "가평", "양평"};
    private String[] hoengsung = {"양구", "홍천", "횡성"};
    private String[] pyeongchang = {"인제"};
    private String[] jinbu = {"정선", "평창"};
    private String[] gangneung = {"고성", "속초", "양양", "강릉"};
    private String[] donghae = {"삼척", "동해"};

    private String[] haengsin = {"고양"};
    private String[] seoul = {"철원", "화천", "광주", "하남", "남양주", "구리", "의정부", "양주", "포천", "동두천", "파추", "연천", "김포"};
    private String[] gwangmyung = {"화성", "오산", "성남", "의왕", "과천", "안양", "군포", "안산", "시흥", "부천", "광명"};
    private String[] suwon = {"수원"};
    private String[] cheonanasan = {"천안", "아산", "음성", "진천", "당진", "안성", "평택", "용인"};
    private String[] osong = {"청주", "증평", "괴산", "보은"};
    private String[] daejeon = {"옥천"};
    private String[] gimcheongumi = {"구미", "상주", "김천", "거창", "영동", "무주"};
    private String[] seodaegu = {"성주"};
    private String[] dongdaegu = {"고령", "칠곡", "군위"};
    private String[] singyeongju = {"영천", "경주"};
    private String[] ulsan = {"양산"};
    private String[] busan = {"거제"};

    private String[] pohang = {"영덕", "청송", "포항"};

    private String[] miryang = {"청도", "창녕", "밀양"};
    private String[] jinyeong = {"김해"};
    private String[] changwonjungang = {"함안", "창원"};
    private String[] masan = {"고성", "통영"};
    private String[] jinju = {"합천", "산청", "사천", "남해", "의령", "진주"};

    private String[] gongju = {"공주", "서산", "태안", "예싼", "홍성", "청양", "보령"};
    private String[] gyeryong = {"계룡"};
    private String[] nonsan = {"논산", "부여", "금산"};
    private String[] iksan = {"익산", "서천", "군산"};
    private String[] jeonju = {"완주", "진안", "전주"};
    private String[] namwon = {"함양", "장수", "임실", "순창", "남원"};
    private String[] goksung = {"곡성"};
    private String[] guryegu = {"하동"};
    private String[] suncheon = {"보성", "광양", "순천"};
    private String[] yeocheon = {"고흥"};
    private String[] yeosuEXPO = {"여수"};

    private String[] jeongeup = {"부안", "고창", "정읍"};
    private String[] gwangju = {"영광", "함평", "화순", "담양"};
    private String[] naju = {"강진", "장흥", "나주"};
    private String[] mokpo = {"무안", "신안", "영암", "해남", "진도", "목포"};
    public String dep = "";
    public String arr = "";

    public Location(String loc, String fes) {
        String[] corr = {loc, fes};

        for (String str1 : corr) {
            if (str1.equals("서울")) {
                int num = Arrays.asList(corr).indexOf("서울");
                switch (num) {
                    case 0:
                        dep = "서울";

                    case 1:
                        arr = "서울";
                }
            }
            else if (str1.equals("인천")) {
                int num = Arrays.asList(corr).indexOf("인천");
                switch (num) {
                    case 0:
                        dep = "서울";
                    case 1:
                        arr = "서울";
                }
            }
            else if (str1.equals("대전")) {
                int num = Arrays.asList(corr).indexOf("대전");
                switch (num) {
                    case 0:
                        dep = "대전";
                    case 1:
                        arr = "대전";
                }
            }
            else if (str1.equals("대구")) {
                int num = Arrays.asList(corr).indexOf("대구");
                switch (num) {
                    case 0:
                        dep = "동대구";
                    case 1:
                        arr = "동대구";
                }
            }
            else if (str1.equals("광주")) {
                int num = Arrays.asList(corr).indexOf("광주");
                switch (num) {
                    case 0:
                        dep = "광주송정";
                    case 1:
                        arr = "광주송정";
                }
            }
            else if (str1.equals("울산")) {
                int num = Arrays.asList(corr).indexOf("울산");
                switch (num) {
                    case 0:
                        dep = "울산(통도사)";
                    case 1:
                        arr = "울산(통도사)";
                }
            }
            else if (str1.equals("부산")) {
                int num = Arrays.asList(corr).indexOf("부산");
                switch (num) {
                    case 0:
                        dep = "부산";
                    case 1:
                        arr = "부산";
                }
            }
            else if (str1.equals("세종시")) {
                int num = Arrays.asList(corr).indexOf("세종시");
                switch (num) {
                    case 0:
                        dep = "오송";
                    case 1:
                        arr = "오송";
                }
            }
            else {
                for (String str2 : wonju) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "원주";
                            case 1:
                                arr = "원주";
                        }
                    }
                }
                for (String str2 : jechoen) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "제천";
                            case 1:
                                arr = "제천";
                        }
                    }
                }
                for (String str2 : danyang) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "단양";
                            case 1:
                                arr = "단양";
                        }
                    }
                }
                for (String str2 : yeongju) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "영주";
                            case 1:
                                arr = "영주";
                        }
                    }
                }
                for (String str2 : punggi) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "풍기";
                            case 1:
                                arr = "풍기";
                        }
                    }
                }
                for (String str2 : andong) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "안동";
                            case 1:
                                arr = "안동";
                        }
                    }
                }
                for (String str2 : yangpyong) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "양평";
                            case 1:
                                arr = "양평";
                        }
                    }
                }
                for (String str2 : hoengsung) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "횡성";
                            case 1:
                                arr = "횡성";
                        }
                    }
                }
                for (String str2 : pyeongchang) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "평창";
                            case 1:
                                arr = "평창";
                        }
                    }
                }
                for (String str2 : jinbu) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "진부(오대산)";
                            case 1:
                                arr = "진부(오대산)";
                        }
                    }
                }
                for (String str2 : gangneung) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "강릉";
                            case 1:
                                arr = "강릉";
                        }
                    }
                }
                for (String str2 : donghae) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "동해";
                            case 1:
                                arr = "동해";
                        }
                    }
                }
                for (String str2 : haengsin) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "행신";
                            case 1:
                                arr = "행신";
                        }
                    }
                }
                for (String str2 : seoul) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "서울";
                            case 1:
                                arr = "서울";
                        }
                    }
                }
                for (String str2 : gwangmyung) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "광명";
                            case 1:
                                arr = "광명";
                        }
                    }
                }
                for (String str2 : suwon) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "수원";
                            case 1:
                                arr = "수원";
                        }
                    }
                }
                for (String str2 : cheonanasan) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "천안아산";
                            case 1:
                                arr = "천안아산";
                        }
                    }
                }
                for (String str2 : osong) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "오송";
                            case 1:
                                arr = "오송";
                        }
                    }
                }
                for (String str2 : daejeon) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "대전";
                            case 1:
                                arr = "대전";
                        }
                    }
                }
                for (String str2 : gimcheongumi) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "김천구미";
                            case 1:
                                arr = "김천구미";
                        }
                    }
                }
                for (String str2 : seodaegu) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "서대구";
                            case 1:
                                arr = "서대구";
                        }
                    }
                }
                for (String str2 : dongdaegu) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "동대구";
                            case 1:
                                arr = "동대구";
                        }
                    }
                }
                for (String str2 : singyeongju) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "신경주";
                            case 1:
                                arr = "신경주";
                        }
                    }
                }
                for (String str2 : ulsan) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "울산(통도사)";
                            case 1:
                                arr = "울산(통도사)";
                        }
                    }
                }
                for (String str2 : busan) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "부산";
                            case 1:
                                arr = "부산";
                        }
                    }
                }
                for (String str2 : pohang) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "포항";
                            case 1:
                                arr = "포항";
                        }
                    }
                }
                for (String str2 : miryang) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "밀양";
                            case 1:
                                arr = "밀양";
                        }
                    }
                }
                for (String str2 : jinyeong) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "진영";
                            case 1:
                                arr = "진영";
                        }
                    }
                }
                for (String str2 : changwonjungang) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "창원중앙";
                            case 1:
                                arr = "창원중앙";
                        }
                    }
                }
                for (String str2 : masan) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "마산";
                            case 1:
                                arr = "마산";
                        }
                    }
                }
                for (String str2 : jinju) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "진주";
                            case 1:
                                arr = "진주";
                        }
                    }
                }
                for (String str2 : gongju) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "공주";
                            case 1:
                                arr = "공주";
                        }
                    }
                }
                for (String str2 : gyeryong) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "계룡";
                            case 1:
                                arr = "계룡";
                        }
                    }
                }
                for (String str2 : nonsan) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "논산";
                            case 1:
                                arr = "논산";
                        }
                    }
                }
                for (String str2 : iksan) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "익산";
                            case 1:
                                arr = "익산";
                        }
                    }
                }
                for (String str2 : jeonju) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "전주";
                            case 1:
                                arr = "전주";
                        }
                    }
                }
                for (String str2 : namwon) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "남원";
                            case 1:
                                arr = "남원";
                        }
                    }
                }
                for (String str2 : goksung) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "곡성";
                            case 1:
                                arr = "곡성";
                        }
                    }
                }
                for (String str2 : guryegu) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "구례구";
                            case 1:
                                arr = "구례구";
                        }
                    }
                }
                for (String str2 : suncheon) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "순천";
                            case 1:
                                arr = "순천";
                        }
                    }
                }
                for (String str2 : yeocheon) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "여천";
                            case 1:
                                arr = "여천";
                        }
                    }
                }
                for (String str2 : yeosuEXPO) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "여수EXPO";
                            case 1:
                                arr = "여수EXPO";
                        }
                    }
                }
                for (String str2 : jeongeup) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "정읍";
                            case 1:
                                arr = "정읍";
                        }
                    }
                }
                for (String str2 : gwangju) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "광주";
                            case 1:
                                arr = "광주";
                        }
                    }
                }
                for (String str2 : naju) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "나주";
                            case 1:
                                arr = "나주";
                        }
                    }
                }
                for (String str2 : mokpo) {
                    if (str1.equals(str2)) {
                        int num = Arrays.asList(corr).indexOf(str2);
                        switch (num) {
                            case 0:
                                dep = "목포";
                            case 1:
                                arr = "목포";
                        }
                    }
                }
            }
        }
    }
}
