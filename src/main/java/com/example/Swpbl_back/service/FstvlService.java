package com.example.Swpbl_back.service;

import com.example.Swpbl_back.crawling.FestivalCrawling;
import com.example.Swpbl_back.crawling.FestivalCrawling2;
import com.example.Swpbl_back.domain.Fstvl;
import com.example.Swpbl_back.repository.FstvlMemoryRepository;
import com.example.Swpbl_back.repository.FstvlRepository;
import com.example.Swpbl_back.repository.FstvlRepositoryImp;
import com.example.Swpbl_back.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FstvlService {
    private final FstvlRepository fstvlRepository;
    private final UserRepository userRepository;

    public FstvlService(FstvlRepository fstvlRepository , UserRepository userRepository) {

        this.fstvlRepository = fstvlRepository;
        this.userRepository = userRepository;
    }


    public List<Fstvl> findDefaultFstvl(){
        FestivalCrawling bot1 = new FestivalCrawling();
        List<Fstvl> FstvlList = bot1.Run();
        for (Fstvl fstvl:FstvlList){
            fstvlRepository.save(fstvl);
        }

        return fstvlRepository.findAll();
    }

    public String findWantedFstvl(){
        // 크롤링 하고 FestivalCrawling bot2 = new FestivalCrawling();

        //bot2.Run();
        return "";
    }
    public Fstvl findDetailFstvl(String photo){
        FestivalCrawling bot2 = new FestivalCrawling();
        Fstvl detailFstvl = bot2.detailRun(photo);
        return detailFstvl;
    }

    public Fstvl findDetailFstvl2(Long id){
        Fstvl detail = fstvlRepository.findById(id);
        FestivalCrawling bot2 = new FestivalCrawling();
        Fstvl detailFstvl = bot2.detailRun(detail.getPhoto());
        return detailFstvl;
    }


}



