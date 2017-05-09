package newsmanagement.service;

import newsmanagement.dtos.ArticleDTO;
import newsmanagement.mapper.ArticleInfoMapper;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by yt476 on 2017/5/9.
 */
public class ListArticleService {
    public List<ArticleDTO> listArticle() throws SQLException, ClassNotFoundException {
        ArticleInfoMapper mapper = new ArticleInfoMapper();
        List<ArticleDTO> result = mapper.listArticles();
        return result;
    }
}
