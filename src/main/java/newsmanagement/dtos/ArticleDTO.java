package newsmanagement.dtos;

/**
 * Created by yt476 on 2017/5/9.
 */
public class ArticleDTO {
    private String title;
    private String content;

    public ArticleDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
