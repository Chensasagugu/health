package hdu.cn.hziee.controller;

import hdu.cn.hziee.model.Illness;
import hdu.cn.hziee.model.UserIllness;
import hdu.cn.hziee.model.Userinfo;
import hdu.cn.hziee.service.CompareImage;
import hdu.cn.hziee.service.IllnessService;
import hdu.cn.hziee.service.UserIllnessService;
import hdu.cn.hziee.service.UserinfoService;
import hdu.cn.hziee.util.FaceUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserinfoService userinfoService;

    @Autowired
    CompareImage testservice;

    @Autowired
    IllnessService illnessService;

    @Autowired
    UserIllnessService userIllnessService;

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

    @RequestMapping("uploadPic")
    public String SetUserFace(@RequestParam("openid") String openid, HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");
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

    @RequestMapping("GetUserData")
    public HashMap GetUserData(@RequestParam("openid") String openid){
        Userinfo user= userinfoService.SelectByOpenid(openid);
        int user_id = user.getUserId();
        List<UserIllness> UIlist = userIllnessService.SelectByUserid(user_id);
        List<String> IllnameList = new ArrayList<String>();
        if (UIlist.size() != 0){
            for (int i = 0;i<UIlist.size();i++){
                int ill_id = UIlist.get(i).getIllId();
                Illness ill = illnessService.SelectByPrimaryKey(ill_id);
                String ill_name = ill.getIllName();
                IllnameList.add(ill_name);
            }
        }

        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("userName",user.getUserName());
        map.put("userSex",user.getUserSex());
        map.put("userBirthday",user.getUserBirthday());
        map.put("userHeight",user.getUserHeight());
        map.put("userWeight",user.getUserWeight());
        map.put("userCcupation",user.getUserCcupation());
        map.put("userIllness",IllnameList);

        return map;
    }

    @RequestMapping("updateUserInfo")
    public String UpdateUserinfo(@RequestParam("openid") String openid,@RequestParam("username")String name,
                                 @RequestParam("usersex") int sex_,@RequestParam("userborn") String birthday,
                                 @RequestParam("userheight") double height,@RequestParam("userweight") double weight,
                                 @RequestParam("occupation") String occupation){
        // birthday  传过来的格式不知道 待定

        Userinfo user = userinfoService.SelectByOpenid(openid);
        String sex = "";
        if (sex_ == 0){
            sex = "男";
        }else if (sex_ == 1){
            sex = "女";
        }
        user.setUserName(name);
        user.setUserSex(sex);
        user.setUserHeight(height);
        user.setUserWeight(weight);
        user.setUserCcupation(occupation);

        int end = userinfoService.UpdateByPrimaryKeySelective(user);
        if (end == 1){
            return "成功";
        }else{
            return "失败";
        }
    }

    @RequestMapping("SetUserIllness")
    public String SetUserIllness(@RequestParam("openid") String openid, @RequestParam("userills")String[] IllnessArray){
        Userinfo user = userinfoService.SelectByOpenid(openid);
        int user_id = user.getUserId();
        List<UserIllness> old_UIlist = userIllnessService.SelectByUserid(user_id);

        ArrayList<Integer> insertList = new ArrayList();
        ArrayList<Integer> deleteList = new ArrayList();
        ArrayList<Integer> restList = new ArrayList();

        if (IllnessArray.length != 0){
            for (int i = 0;i<IllnessArray.length;i++){
                Illness ill = illnessService.SelectByIllname(IllnessArray[i]);
                int ill_id = ill.getIllId();
                insertList.add(ill_id);
            }
        }else{
            userIllnessService.DeleteByUserid(user_id);
            return "用户疾病已清空";
        }

        if (old_UIlist.size() != 0 && IllnessArray.length != 0){
            for (int i = 0;i<old_UIlist.size();i++){
                int old_UIid = old_UIlist.get(i).getIllId();
                deleteList.add(old_UIid);
                for (int j = 0;j<insertList.size();j++){
                    if (insertList.get(j) == old_UIid){
                        restList.add(old_UIid);
                        deleteList.remove(Integer.valueOf(old_UIid));
                    }
                }
            }

            if (restList.size() != 0){
                for (int m = 0;m<insertList.size();m++){
                    int in = insertList.get(m);
                    for (int n = 0;n<restList.size();n++){
                        int out = restList.get(n);
                        if (out==in){
                            insertList.remove(Integer.valueOf(in));
                            m--;
                            break;
                        }
                    }
                }
            }
        }

        if (insertList.size() != 0){
            for (int i = 0;i<insertList.size();i++){
                int ill_id = insertList.get(i);
                UserIllness UI = new UserIllness();
                UI.setIllId(ill_id);
                UI.setUserId(user_id);
                userIllnessService.insert(UI);
            }
        }
        if (deleteList.size() != 0){
            for (int i = 0;i<deleteList.size();i++){
                int ill_id = insertList.get(i);
                UserIllness UI = new UserIllness();
                UI.setIllId(ill_id);
                UI.setUserId(user_id);
                userIllnessService.DeleteByUserIll(UI);
            }
        }
        return "成功！";
    }

    @RequestMapping("GetIllnessData")
    public List<Illness> GetIllnessData(){
        return illnessService.SelectAll();
    }

}
