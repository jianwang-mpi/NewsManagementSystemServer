package newsmanagement.server;

import newsmanagement.dtos.ArticleDTO;
import newsmanagement.service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yt476 on 2017/5/8.
 */
public class NewsManagementServer {
    public Map<String, String> comment(String title, String comment) {
        CommentService service = new CommentService();
        Map<String, String> result = new HashMap<String, String>();
        try {
            service.comment(title, comment);
            result.put("err_code", "0");
            result.put("msg", "success");
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            result.put("err_code", "2");
            result.put("msg", "internal error!");
            return result;
        }
    }

    public Map<String, String> login(String username, String password) {
        LoginLogoutService service = new LoginLogoutService();
        Map<String, String> result = new HashMap<String, String>();
        try {
            boolean success = service.login(username, password);
            if (success) {
                result.put("err_code", "0");
                result.put("msg", "success");
                return result;
            } else {
                result.put("err_code", "1");
                result.put("msg", "user not exists!");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("err_code", "2");
            result.put("msg", "internal error!");
            return result;
        }
    }

    public Map<String, String> modifyAuthority(String username, int newAuthority) {
        ModifyAuthorityService service = new ModifyAuthorityService();
        Map<String, String> result = new HashMap<String, String>();
        try {
            boolean success = service.modifyAuthority(username, newAuthority);
            if (success) {
                result.put("err_code", "0");
                result.put("msg", "success");
                return result;
            } else {
                result.put("err_code", "1");
                result.put("msg", "user is not exists!");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("err_code", "2");
            result.put("msg", "internal error!");
            return result;
        }
    }

    public Map<String, String> register(String username, String password, int authority) {
        RegisterService service = new RegisterService();
        Map<String, String> result = new HashMap<String, String>();
        try {
            boolean success = service.register(username, password, authority);
            if (success) {
                result.put("err_code", "0");
                result.put("msg", "success");
                return result;
            } else {
                result.put("err_code", "1");
                result.put("msg", "user exists!");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("err_code", "2");
            result.put("msg", "internal error!");
            return result;
        }
    }
    public Map<String, Object> list() {
        ListArticleService service = new ListArticleService();
        Map<String, Object> result = new HashMap<String, Object>();
        try {

            List<ArticleDTO> articleDTOList = service.listArticle();
            result.put("result",articleDTOList);
            return result;
        } catch (Exception e) {

            e.printStackTrace();
            result.put("err_code", "2");
            result.put("msg", "internal error!");
            return result;
        }
    }
    public Map<String, String> delete(String title) {
        DeleteArticleService service = new DeleteArticleService();
        Map<String, String> result = new HashMap<String, String>();
        try {
            boolean success = service.deleteArticle(title);
            if (success) {
                result.put("err_code", "0");
                result.put("msg", "success");
                return result;
            } else {
                result.put("err_code", "1");
                result.put("msg", "user exists!");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("err_code", "2");
            result.put("msg", "internal error!");
            return result;
        }
    }
    public Map<String, String> publish(String title, String content) {
        PublishArticleService service = new PublishArticleService();
        Map<String, String> result = new HashMap<String, String>();
        try {
            boolean success = service.publishArticles(title, content);
            if (success) {
                result.put("err_code", "0");
                result.put("msg", "success");
                return result;
            } else {
                result.put("err_code", "1");
                result.put("msg", "user exists!");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("err_code", "2");
            result.put("msg", "internal error!");
            return result;
        }
    }
}
