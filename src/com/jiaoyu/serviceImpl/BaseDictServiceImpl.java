package com.jiaoyu.serviceImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.jiaoyu.dao.BaseDictDao;
import com.jiaoyu.domain.base_dict;
import com.jiaoyu.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {
	private BaseDictDao bdd;

	@Override
	public List<base_dict> getBaseDictList(DetachedCriteria dc) {
		return bdd.getListByDc(dc);
	}

	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}

	

}
