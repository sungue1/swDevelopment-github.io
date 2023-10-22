package com.example.Swpbl_back.service;

import com.example.Swpbl_back.crawling.FestivalCrawling;
import com.example.Swpbl_back.crawling.FestivalCrawling2;
import com.example.Swpbl_back.domain.Fstvl;
import com.example.Swpbl_back.repository.FstvlMemoryRepository;
import com.example.Swpbl_back.repository.FstvlRepository;
import com.example.Swpbl_back.repository.FstvlRepositoryImp;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FstvlService {
    private final FstvlRepository fstvlRepository;

    public FstvlService(FstvlRepository fstvlRepository) {

        this.fstvlRepository = fstvlRepository;
    }


    public List<Fstvl> findAllFstvl(){
        FestivalCrawling bot1 = new FestivalCrawling();
        List<Fstvl> FstvlList = bot1.Run();
        for (Fstvl fstvl:FstvlList){
            fstvlRepository.save(fstvl);
        }

        return fstvlRepository.findAll();
    }
   /*
    public Fstvl findId(Fstvl fstvl){
        return fstvlRepositoryImp.findId(fstvl.getFstvl_id());
    }
    */

}
