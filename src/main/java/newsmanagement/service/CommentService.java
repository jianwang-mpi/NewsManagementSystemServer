package newsmanagement.service;

import newsmanagement.mapper.CommentMapper;

import java.sql.SQLException;

/**
 * Created by yt476 on 2017/5/13.
 */
public class CommentService {
    public void comment(String articleTitle, String comment) throws SQLException, ClassNotFoundException {
        CommentMapper mapper = new CommentMapper();
        mapper.comment(articleTitle,comment);
    }
}
