package com.kch.storage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 이상훈
 * @since 2019-10-31
 * */

public class FileStorage {

    public static Map <String, BufferedImage> bufferedImageMap;     //제네릭 - 타입을 적재장소에 맡게 넣음
    static {
        bufferedImageMap = new HashMap<>();     //자료구조 - 해쉬맵에 이미지 형태로 넣어야함
    }

    public static void load(){
        File file = new File(System.getProperty("user.dir") + "/resource/ddd.png");         //지역변수로 메모리에 올라감
        File file2 = new File(System.getProperty("user.dir") + "/resource/man.png");        // 리소스에있는 이미지파일을 가져와야하기때문에절대경로로 적어줘야함!!
                                                                                                      //처음 (System.get.getproperty("user.dir)은 형식이고 그뒤에 +로 이어주고 절대경로

        try {
           BufferedImage ddd = ImageIO.read(file).getSubimage(0, 0, 32, 32);        //X 좌표 0 에서 32 까지, Y좌표 0에서 32까지
           BufferedImage man = ImageIO.read(file2).getSubimage(0,0,32,32);          //      ''

           bufferedImageMap.put("똥",ddd);           //try catch 예외처리
           bufferedImageMap.put("사람",man);         //똥, 사람 이미지 해쉬맵(키, 값)put
        }
        catch (IOException e){
            e.printStackTrace();        //e 도 함수명! 주의!
        }
    }
}
