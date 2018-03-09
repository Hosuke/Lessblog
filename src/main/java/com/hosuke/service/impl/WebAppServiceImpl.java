package com.hosuke.service.impl;

import com.hosuke.dao.WebAppDao;
import com.hosuke.model.WebApp;
import com.hosuke.model.dto.WebAppDto;
import com.hosuke.service.WebAppService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Hosuke
 */
@Service("webAppService")
public class WebAppServiceImpl implements WebAppService {
    @Resource
    private WebAppDao webAppDao;

    @Override
    public void saveWebApp(WebApp webApp) {
        try {
            webAppDao.save(webApp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateWebApp(WebApp webApp) {
        try {
            webAppDao.update(webApp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public WebAppDto getWebDtoWebApp(Integer id) {
        WebAppDto webAppDto = null;
        try {
            webAppDto = webAppDao.getWebDto(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webAppDto;
    }

    @Override
    public Integer getArticlesView() {
        Integer totalViews = 0;
        try {
            totalViews = webAppDao.getArticlesView();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalViews;
    }

    @Override
    public List<WebApp> getWebAppDtos() {
        List<WebApp> webApps = null;
        try {
            webApps = webAppDao.getWebDtos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webApps;
    }

    @Override
    public boolean webAppNotNull() {
        Integer total = 0;
        try {
            total = webAppDao.count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total > 0 ? true : false;
    }
}
