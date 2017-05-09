package newsmanagement.mapper;

import newsmanagement.dtos.ArticleDTO;
import newsmanagement.utils.DataBaseUtils;
import org.springframework.util.CollectionUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yt476 on 2017/5/9.
 */
public class ArticleInfoMapper {
    public ArticleDTO queryArticle(String title) throws SQLException, ClassNotFoundException {
        String sql = "SELECT `articles`.`id`,\n" +
                "    `articles`.`title`,\n" +
                "    `articles`.`content`\n" +
                "FROM `news_management`.`articles` where title=\'"+title+"\';\n";
        List<Map<String,Object>> articles = DataBaseUtils.queryDB(sql);
        if(CollectionUtils.isEmpty(articles)){
            return null;
        }else{
            Map<String ,Object> article = articles.get(0);
            ArticleDTO articleDTO = new ArticleDTO(article.get("title").toString(),article.get("content").toString());
            return articleDTO;
        }
    }
    public List<ArticleDTO> listArticles() throws SQLException, ClassNotFoundException {
        String sql = "select * from articles;";
        List<ArticleDTO> result = new ArrayList<ArticleDTO>();
        List<Map<String ,Object>> articles = DataBaseUtils.queryDB(sql);
        for(Map<String,Object> article:articles){
            ArticleDTO articleDTO = new ArticleDTO(article.get("title").toString(),article.get("content").toString());
            result.add(articleDTO);
        }
        return result;
    }
    public void deleteArticle(String title) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM `news_management`.`articles`\n" +
                "WHERE title=\'"+title+"\';\n";
        DataBaseUtils.deleteDB(sql);
    }
    public void insertArticle(String title, String content) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `news_management`.`articles`\n" +
                "(`title`,\n" +
                "`content`)\n" +
                "VALUES\n" +
                "(\'"+title+"\',\n" +
                "\'"+content+"\');\n";
        DataBaseUtils.insertDB(sql);
    }
}
