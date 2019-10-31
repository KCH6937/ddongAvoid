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
//NDY가 협업할때 이렇게 하는거래 ㅋㅋ 알려줌 ㅈ간지 따라하지마셈

public class FileStorage {
    public static Map <String, BufferedImage> bufferedImageMap;     //제네릭 - 타입을 적재장소에 맡게 넣음
    static {
        bufferedImageMap = new HashMap<>();     //자료구조 - 해쉬맵에 이미지 형태로 넣어야함
    }

    public static void load(){
        File file = new File(System.getProperty("user.dir") + "/resource/ddd.png");         //지역변수로 메모리에 올라감
        File file2 = new File(System.getProperty("user.dir") + "/resource/man.png");

        try {
           BufferedImage ddd = ImageIO.read(file).getSubimage(0, 0, 32, 32);
           BufferedImage man = ImageIO.read(file2).getSubimage(0,0,32,32);

           bufferedImageMap.put("똥",ddd);
           bufferedImageMap.put("사람",man);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
