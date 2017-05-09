package newsmanagement.service;

import newsmanagement.dtos.UserInfoDTO;
import newsmanagement.mapper.UserInfoMapper;
import newsmanagement.utils.DataBaseUtils;

/**
 * Created by yt476 on 2017/5/9.
 */
public class ModifyAuthorityService {
    public boolean modifyAuthority(String username, int newAuthority) throws Exception {
        UserInfoMapper mapper = new UserInfoMapper();
        UserInfoDTO userInfo = mapper.getUserInfo(username);
        if(userInfo == null){
            return false;
        }else{
            mapper.updateUser(username,newAuthority);
            return true;
        }
    }
}
