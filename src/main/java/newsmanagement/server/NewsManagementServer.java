package newsmanagement.server;

import newsmanagement.service.ModifyAuthorityService;
import newsmanagement.service.RegisterService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yt476 on 2017/5/8.
 */
public class NewsManagementServer {
    public Map<String,String> login(String name, String password){
        Map<String, String> map = new HashMap<String, String>();
        map.put(name,password);
        map.put(password,name);
        return map;
    }
    
    public Map<String, String> modifyAuthority(String username, int newAuthority){
        ModifyAuthorityService service = new ModifyAuthorityService();
        Map<String, String > result = new HashMap<String, String>();
        try {
            boolean success = service.modifyAuthority(username,newAuthority);
            if(success){
                result.put("err_code","0");
                result.put("msg","success");
                return result;
            }else{
                result.put("err_code","1");
                result.put("msg","user is not exists!");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("err_code","2");
            result.put("msg","internal error!");
            return result;
        }
    }
    public Map<String, String> register(String username, String password, int authority){
        RegisterService service = new RegisterService();
        Map<String, String > result = new HashMap<String, String>();
        try {
            boolean success = service.register(username,password,authority);
            if(success){
                result.put("err_code","0");
                result.put("msg","success");
                return result;
            }else{
                result.put("err_code","1");
                result.put("msg","user exists!");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("err_code","2");
            result.put("msg","internal error!");
            return result;
        }
    }
}
