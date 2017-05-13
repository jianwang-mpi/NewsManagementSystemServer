package newsmanagement.mapper;

import newsmanagement.utils.DataBaseUtils;

import java.sql.SQLException;

/**
 * Created by yt476 on 2017/5/13.
 */
public class CommentMapper {
    public void comment(String articleTitle, String content) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `news_management`.`comments`\n" +
                "(`article_title`,\n" +
                "`comment`)\n" +
                "VALUES\n" +
                "(\'"+articleTitle+"\',\n" +
                "\'"+content+"\');\n";
        DataBaseUtils.insertDB(sql);
    }
}
