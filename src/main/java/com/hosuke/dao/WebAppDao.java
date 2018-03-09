package com.hosuke.dao;

import com.hosuke.model.WebApp;
import com.hosuke.model.dto.WebAppDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Hosuke
 */
@Repository
public interface WebAppDao {
    public void save(WebApp webApp) throws Exception;
    public void update(WebApp webApp) throws Exception;
    public WebAppDto getWebDto(Integer id) throws Exception;
    public Integer getArticlesView() throws Exception;
    public Integer count() throws Exception;
    public List<WebApp> getWebDtos() throws Exception;
}
