package com.example.SW_PBL.Festival;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FstvlService {
    public int length = 0;
    private final FstvlRepositoryImp fstvlRepositoryImp;

    public FstvlService(FstvlRepositoryImp fstvlRepositoryImp) {

        this.fstvlRepositoryImp = fstvlRepositoryImp;
    }


    public List<Fstvl> findAllFstvl() throws SQLException, ClassNotFoundException {
        FestivalCrawling bot1 = new FestivalCrawling();
        List<Fstvl> FstvlList = bot1.Run();
        while (bot1.lock == 0) {

        }
        length = bot1.length;
        for (Fstvl fstvl:FstvlList){
            fstvlRepositoryImp.save(fstvl);
        }

        return fstvlRepositoryImp.findAll(length);
    }

    public List<Fstvl> findDateFstvl(String date) throws SQLException, ClassNotFoundException {
        FestivalCrawling run = new FestivalCrawling();
        List<Fstvl> FstvlList = run.seletedDateRun(date);
        length = run.length;
        for (Fstvl fstvl:FstvlList) {
            fstvlRepositoryImp.save(fstvl);
        }
        System.out.println("run length is " + length);
        return fstvlRepositoryImp.findAll(length);
    }


    public List<Fstvl> findKeyFstvl(String[] keyList) throws SQLException {
        ArrayList<String> titleList = new ArrayList<>();
        int length = keyList.length;

        // 키워드에 해당하는 축제 분류
        for (int keylength = 0; keylength < length; keylength++) {
            String[][] DS;
            ListSort LS = new ListSort();
            DS = LS.GetList();
            String KeyWord = keyList[keylength];
            for (int i = 0; i < LS.rw; i++) {
                if (DS[i][1].contains(KeyWord)) {
                    titleList.add(DS[i][0]);
                }
            }
        }

        // 중복 타이틀 제거
        ArrayList<String> newTitleList = new ArrayList<>();
        for(String ttl : titleList){
            if(!newTitleList.contains(ttl))
                newTitleList.add(ttl);
        }

        // 타이틀 검색으로 객체반환
        List<Fstvl> FstvlList = new ArrayList<>();
        for (String titles : newTitleList) {
            Fstvl fstvl = fstvlRepositoryImp.findByTitle(titles);
            FstvlList.add(fstvl);
        }
        return FstvlList;
    }

    public Fstvl findDetailFstvl (int id) throws SQLException {
        Fstvl detail = fstvlRepositoryImp.findById(id);
        System.out.println(detail.getTitle());
        FestivalCrawling bot2 = new FestivalCrawling();
        Fstvl detailFstvl = bot2.detailRun(detail.getPhoto());
        return detailFstvl;
    }

    public void clearfstvl() throws SQLException {
        fstvlRepositoryImp.clearStore();
    }
}

