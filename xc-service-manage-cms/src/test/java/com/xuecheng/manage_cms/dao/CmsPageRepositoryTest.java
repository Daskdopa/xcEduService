package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    CmsPageRepository cmsPageRepository;

    @Test
    public void testFindAll(){
        List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all);
    }

    @Test
    public void testFindAllPage(){

        int page = 1;
        int size = 10;
        Pageable pageable = PageRequest.of(page,size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println("----------------------------------------------------");
        System.out.println("数据列表："+all.getContent());
        System.out.println("----------------------------------------------------");
    }

    @Test
    public void testFindByPageName(){
        CmsPage page = cmsPageRepository.findByPageName("index.html");
        System.out.println(page);
    }

    @Test
    public void testSave(){
        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageName("测试页面");
        cmsPageRepository.save(cmsPage);
    }

    @Test
    public void testDelete(){
        cmsPageRepository.deleteById("5d425f7041b79a324c3a7876");
    }

}
