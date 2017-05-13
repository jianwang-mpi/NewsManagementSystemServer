package newsmanagement.service;

import newsmanagement.dtos.UserInfoDTO;
import newsmanagement.mapper.UserInfoMapper;

/**
 * Created by yt476 on 2017/5/8.
 */
public class LoginLogoutService {
    public boolean login(String username, String password) throws Exception{
        UserInfoMapper userInfoMapper = new UserInfoMapper();
        UserInfoDTO user = userInfoMapper.getUserInfo(username);
        if(user == null || !user.getPassword().equals(password)){
            return false;
        }else{
            return true;
        }

    }
    public void logout(String username) throws Exception{

    }
}
