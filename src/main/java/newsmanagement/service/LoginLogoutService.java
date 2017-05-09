package newsmanagement.service;

import newsmanagement.dtos.UserInfoDTO;
import newsmanagement.mapper.UserInfoMapper;

/**
 * Created by yt476 on 2017/5/8.
 */
public class LoginLogoutService {
    public void login(String username, String password) throws Exception{
        UserInfoMapper userInfoMapper = new UserInfoMapper();
        UserInfoDTO user = userInfoMapper.getUserInfo(username);
        if(!user.getPassword().equals(password)){
            throw new RuntimeException("user exists!");
        }
    }
    public void logout(String username) throws Exception{

    }
}
