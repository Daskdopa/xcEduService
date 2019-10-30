package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;

public interface CmsPageControllerApi {

    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) ;

    QueryResult<CmsSite> findSiteList();

}
