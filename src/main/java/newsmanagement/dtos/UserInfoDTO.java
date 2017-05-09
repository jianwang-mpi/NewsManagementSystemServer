package newsmanagement.dtos;

/**
 * Created by yt476 on 2017/5/8.
 */
public class UserInfoDTO {
    private String username;
    private String password;
    private Integer authority;

    public UserInfoDTO(String username, String password, Integer authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }
}
