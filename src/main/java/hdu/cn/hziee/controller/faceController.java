package hdu.cn.hziee.controller;

import hdu.cn.hziee.service.CompareImage;
import hdu.cn.hziee.util.FaceUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class faceController {

    @Autowired
    CompareImage testservice;

    @GetMapping ("/face/face")
    public String toFace() {
        return "index.html";
    }
//比对用户
    @GetMapping("/face/compare")
    public void getFace2(Model  model) throws JSONException {
        List<String> faceList=testservice.test2();
//        List<User> userList=userService.getAllUser();  //获取所有用户
        String token="5fa320fbf715f1b0857b555e62d52006";   //测试用
        for(int i=0;i<faceList.size();i++){
//            for(int j=0;j<userList.size();j++){                 //将拍摄图片所得facetoken与用户的facetoken进行比对
//                boolean isexit=FaceUtil.compare(userList.getfaceToken(j),faceList.get(i));
//            }
            boolean isExit= FaceUtil.compare(token,faceList.get(i));  //测试用
            if(isExit){
                //推送内容
                System.out.println("chenggong");    //测试用
            }
            System.out.println(" zhe"+i+isExit);     //测试用
        }
    }
    //用户上传图片并存储facetoken;
    @RequestMapping(value="/picture")
    public String picture(MultipartFile file) throws IOException {
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
//                User user = new User();
//                user.setFaceToken(token);
//              testservice.add(user);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                return "系统繁忙，请稍后重试！";
            }
            return "上传成功";
        }
    }
}
