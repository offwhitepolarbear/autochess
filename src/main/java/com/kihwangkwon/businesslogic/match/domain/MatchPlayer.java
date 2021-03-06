package com.kihwangkwon.businesslogic.match.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MatchPlayer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long matchInfoId;
		
	private String matchId;
	private String puuid;
	
	private double tftSetNumberDetail;
	
	private int goldLeft;
	private int lastRound;
	private int level;
	private int placement;
	
	private int damageToPlayers;
	//킬수
	private int playersEliminated;
	//탈락 시간
	private double timeEliminated;
	
	private String contentId;
	private String skinId;
	private String species;
	
	@Builder
	public MatchPlayer(String matchId, String puuid, double tftSetNumberDetail
			, int goldLeft, int lastRound, int level, int placement
			, int damageToPlayers, int playersEliminated, double timeEliminated
			, String contentId, String skinId, String species) {
		this.matchId = matchId;
		this.puuid = puuid;
		this.tftSetNumberDetail = tftSetNumberDetail;
		this.goldLeft = goldLeft; 
		this.lastRound=lastRound;
		this.level=level;
		this.placement=placement;
		this.damageToPlayers=damageToPlayers;
		this.playersEliminated=playersEliminated;
		this.timeEliminated=timeEliminated;
		this.contentId=contentId;
		this.skinId=skinId;
		this.species=species;
	}
	
	/*
	@ManyToOne
	@JoinColumn(name="match_info_match_id",referencedColumnName = "match_id")
	private Match match;
	*/
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	@JoinColumns({
		@JoinColumn(name="matchPlayerId", referencedColumnName = "id"),	
	})
	List<MatchPlayerChampion> matchPlayerChampionList; 
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	@JoinColumns({
		@JoinColumn(name = "matchPlayerId", referencedColumnName = "id")
	})
	List<MatchPlayerTrait> matchPlayerTraitList; 
}
