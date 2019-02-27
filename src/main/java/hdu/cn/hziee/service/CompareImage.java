package hdu.cn.hziee.service;

import hdu.cn.hziee.util.FaceUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Service
public class CompareImage {

    public List<String> test2 () throws JSONException {

        File file = new File("C:\\Users\\Shinelon\\Desktop\\timg.jpg");    //假装是拍摄的图片
        byte[] buff = FaceUtil.getBytesFromFile(file);
        String str = FaceUtil.check(buff);
        //facetoken 集合
        List<String> faceList = new ArrayList<String>();
        try{
            JSONObject myjsom = new JSONObject(str);
            JSONArray faceArray = myjsom.getJSONArray("faces");

            for (int i = 0; i < faceArray.length(); i++) {
                JSONObject faceObject = faceArray.getJSONObject(i);
                String face_token = faceObject.getString("face_token");
                faceList.add(face_token);
                System.out.println("token"+" "+i+face_token);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return faceList;
    }
}
