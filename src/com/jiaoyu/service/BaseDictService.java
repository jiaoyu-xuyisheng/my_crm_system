package com.jiaoyu.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.jiaoyu.domain.base_dict;

public interface BaseDictService {

	List<base_dict> getBaseDictList(DetachedCriteria dc);

}
