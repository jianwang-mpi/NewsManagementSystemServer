package newsmanagement.service;

import newsmanagement.dtos.ArticleDTO;
import newsmanagement.mapper.ArticleInfoMapper;

import java.sql.SQLException;

/**
 * Created by yt476 on 2017/5/10.
 */
public class PublishArticleService {
    public boolean publishArticles(String title, String content) throws SQLException, ClassNotFoundException {
        ArticleInfoMapper mapper = new ArticleInfoMapper();
        ArticleDTO articleDTO = mapper.queryArticle(title);
        if(articleDTO == null){
            mapper.insertArticle(title,content);
            return true;
        }else{
            return false;
        }
    }
}
