package newsmanagement.service;

import newsmanagement.dtos.UserInfoDTO;
import newsmanagement.mapper.UserInfoMapper;

/**
 * Created by yt476 on 2017/5/9.
 */
public class RegisterService {
    public boolean register(String username, String password, int authority) throws Exception {
        UserInfoMapper mapper = new UserInfoMapper();
        UserInfoDTO userInfoDTO = mapper.getUserInfo(username);
        if(userInfoDTO == null){
            mapper.addUser(username,password,authority);
            return true;
        }else{
            return false;
        }
    }
}
