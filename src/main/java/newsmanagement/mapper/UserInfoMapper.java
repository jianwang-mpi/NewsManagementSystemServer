package newsmanagement.mapper;

import newsmanagement.dtos.UserInfoDTO;
import newsmanagement.utils.DataBaseUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by yt476 on 2017/5/8.
 */
public class UserInfoMapper {
    public static void main(String []args) throws Exception {
        UserInfoMapper mapper = new UserInfoMapper();
        UserInfoDTO userInfoDTO = mapper.getUserInfo("wangjian");
        System.out.println(userInfoDTO.getPassword());
    }
    public UserInfoDTO getUserInfo(String username) throws Exception{
        String sql = "select * from user_info where username="+"\'"+username+"\';";
        List<Map<String ,Object >> userInfo = DataBaseUtils.queryDB(sql);
        if(CollectionUtils.isEmpty(userInfo)){
            return null;
        }else {
            Map<String, Object> user = userInfo.get(0);
            String password = user.get("password").toString();
            Integer authority = Integer.parseInt(user.get("authority").toString());
            UserInfoDTO userInfoDTO = new UserInfoDTO(username, password, authority);
            return userInfoDTO;
        }
    }
    public void addUser(String username, String password, int authority) throws Exception{
        String sql = "INSERT INTO `news_management`.`user_info`\n" +
                "(`username`,\n" +
                "`password`,\n" +
                "`authority`)\n" +
                "VALUES\n" +
                "(\'"+username+"\',\n" +
                "\'"+password+"\',\n" +
                ""+authority+");\n";
        DataBaseUtils.insertDB(sql);
    }
    public void updateUser(String username, int authority) throws Exception{
        String sql = "UPDATE `news_management`.`user_info`\n" +
                "SET\n" +
                "`username` = \'"+username+"\',\n" +
                "`authority` = "+authority+"\n" +
                "WHERE `username` = \'"+username+"\';\n";
        DataBaseUtils.updateDB(sql);
    }
}
