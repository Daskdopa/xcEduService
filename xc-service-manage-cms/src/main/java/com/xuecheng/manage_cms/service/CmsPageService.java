package com.xuecheng.manage_cms.service;


import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class CmsPageService {

    @Autowired
    CmsPageRepository cmsPageRepository;

    public QueryResponseResult findList(int page,int size, QueryPageRequest queryPageRequest) {
        //条件对象判空
        if(queryPageRequest == null)
            queryPageRequest = new QueryPageRequest();

        //定义条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();

        exampleMatcher = exampleMatcher.withMatcher("pageAliase",
                ExampleMatcher.GenericPropertyMatchers.contains());

        //设置条件属性
        CmsPage cmsPage = new CmsPage();

        if(StringUtils.isNotEmpty(queryPageRequest.getSiteId()))
            cmsPage.setSiteId(queryPageRequest.getSiteId());

        if(StringUtils.isNotEmpty(queryPageRequest.getTemplateId()))
            cmsPage.setTemplateId(queryPageRequest.getTemplateId());

        if(StringUtils.isNotEmpty(queryPageRequest.getPageAliase()))
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());

        //设置条件
        Example<CmsPage> example = Example.of(cmsPage,exampleMatcher);


        if(page <= 0){
            page = 1;
        }
        page = page - 1;
        if(size <= 0){
            size = 10;
        }
        //封装分页参数
        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> pages = cmsPageRepository.findAll(example,pageable);
        QueryResult<CmsPage> queryResult = new QueryResult<>();
        queryResult.setList(pages.getContent());
        queryResult.setTotal(pages.getTotalElements());
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);

        return queryResponseResult;
    }

}
