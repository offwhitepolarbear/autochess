package com.kihwangkwon.staticdata.champion.service;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kihwangkwon.staticdata.champion.domain.StaticChampion;

public interface StaticChampionRepository extends JpaRepository<StaticChampion,Long>{

}
