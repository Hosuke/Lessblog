package com.hosuke.service;

import com.hosuke.model.WebApp;
import com.hosuke.model.dto.WebAppDto;

import java.util.List;

/**
 * @Author Hosuke
 */
public interface WebAppService {
    public void saveWebApp(WebApp webApp);
    public void updateWebApp(WebApp webApp);
    public WebAppDto getWebDtoWebApp(Integer id);
    public Integer getArticlesView();
    public boolean webAppNotNull();
    public List<WebApp> getWebAppDtos();
}
