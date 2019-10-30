package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmsSiteService {

    @Autowired
    CmsSiteRepository cmsSiteRepository;

    public QueryResult<CmsSite> findSiteList() {
        QueryResult<CmsSite> queryResult = new QueryResult<>();
        List<CmsSite> list = cmsSiteRepository.findAll();
        queryResult.setList(list);
        queryResult.setTotal(list.size());
        return queryResult;
    }
}
