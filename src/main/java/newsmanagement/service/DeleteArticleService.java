package newsmanagement.service;

import newsmanagement.dtos.ArticleDTO;
import newsmanagement.mapper.ArticleInfoMapper;

import java.sql.SQLException;

/**
 * Created by yt476 on 2017/5/10.
 */
public class DeleteArticleService {
    public boolean deleteArticle(String title) throws SQLException, ClassNotFoundException {
        ArticleInfoMapper mapper = new ArticleInfoMapper();
        ArticleDTO articleDTO = mapper.queryArticle(title);
        if(articleDTO == null){
            return false;
        }else{
            mapper.deleteArticle(title);
            return true;
        }
    }
}
