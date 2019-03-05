package hdu.cn.hziee.controller;

import hdu.cn.hziee.model.Userinfo;
import hdu.cn.hziee.service.CompareImage;
import hdu.cn.hziee.service.UserinfoService;
import hdu.cn.hziee.util.FaceUtil;
import org.apache.catalina.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserinfoService userinfoService;

    @Autowired
    CompareImage testservice;

    public String insert(String openid){
        Userinfo user = new Userinfo();
        user.setUserOpenid(openid);
        int end = userinfoService.insert(user);
        if (end == 1){
            return "成功";
        }else{
            return "失败";
        }
    }

    public String SetUserFace(String openid,MultipartFile file) throws IOException {
        if (file == null || "".equals(file.getOriginalFilename())) {
            return "上传的照片为空";
        } else {
            String str = FaceUtil.check(file.getBytes());
            try {
                JSONObject json = new JSONObject(str);
                JSONArray faceArray = json.getJSONArray("faces");
                String faces = faceArray.toString();
                if ("[]".equals(faces)) {
                    return "对不起，您上传的不是用户头像或者照片质量不达标，请重新上传！";
                }
                JSONObject josnToken = new JSONObject(faces.substring(1, faces.length() - 1));
                String token = josnToken.getString("face_token");
                System.out.println("token"+token);
                //保存用户的facetoken
                Userinfo user = userinfoService.SelectByOpenid(openid);
                user.setUserFaceToken(token);
                int end = userinfoService.UpdateByPrimaryKeySelective(user);
                if (end == 1){
                    return "成功";
                }else{
                    return "失败";
                }
//                User user = new User();
//                user.setFaceToken(token);
//              testservice.add(user);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                return "系统繁忙，请稍后重试！";
            }
        }
    }

    //比对用户
    @RequestMapping("/compare")
    public void CompareFace() throws JSONException {
        List<String> faceList=testservice.test2();
        List<Userinfo> userList=userinfoService.SelectAll();  //获取所有用户
//        String token="5fa320fbf715f1b0857b555e62d52006";   //测试用
        for(int i=0;i<faceList.size();i++){
            for(int j=0;j<userList.size();j++){                 //将拍摄图片所得facetoken与用户的facetoken进行比对
                boolean isExit=FaceUtil.compare(userList.get(j).getUserFaceToken(),faceList.get(i));
                if(isExit){
                    //推送内容
                    System.out.println("chenggong");    //测试用
                }
            }
//            boolean isExit= FaceUtil.compare(token,faceList.get(i));  //测试用

//            System.out.println(" zhe"+i+isExit);     //测试用
        }
    }


    public Userinfo SelectByOpenid(String openid){
        return userinfoService.SelectByOpenid(openid);
    }

    public String UpdateUserinfo(String openid,String name,
                                 String sex,int age,
                                 double height,double weight,
                                 String work,int special){
        Userinfo user = userinfoService.SelectByOpenid(openid);
        user.setUserName(name);
        user.setUserSex(sex);
        user.setUserAge(age);
        user.setUserHeight(height);
        user.setUserWeight(weight);
        if (sex.equals("男")||sex.equals("")){
            special = 0;
        }
        user.setUserSpecial(special);

        int end = userinfoService.UpdateByPrimaryKeySelective(user);
        if (end == 1){
            return "成功";
        }else{
            return "失败";
        }
    }

    public String SetUserIllness(String openid, HttpServletRequest request){
        String[] IllnessArray=request.getParameterValues("checkboxname");
        return "";
    }

    public String DelUserIllness(String openid, HttpServletRequest request){

        return "";
    }
}
