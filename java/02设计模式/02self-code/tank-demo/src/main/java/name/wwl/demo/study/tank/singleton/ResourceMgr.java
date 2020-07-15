package name.wwl.demo.study.tank.singleton;

import name.wwl.demo.study.tank.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/5/18 14:23
 */
public class ResourceMgr {
    public BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
    public  BufferedImage badTankL, badTankU, badTankR, badTankD;

    public  BufferedImage bulletL, bulletU, bulletR, bulletD;

    public BufferedImage[] explores = new BufferedImage[16];

    private volatile static ResourceMgr INSTANCE;

    private ResourceMgr(){
        try{
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/goodTank1.png"));
            goodTankL = ImageUtil.rotateImage(goodTankU,-90);
            goodTankR = ImageUtil.rotateImage(goodTankU,90);
            goodTankD = ImageUtil.rotateImage(goodTankU,180);

            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/badTank1.png"));
            badTankL = ImageUtil.rotateImage(badTankU,-90);
            badTankR = ImageUtil.rotateImage(badTankU,90);
            badTankD = ImageUtil.rotateImage(badTankU,180);

            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletL = ImageUtil.rotateImage(bulletU,-90);

            bulletR =  ImageUtil.rotateImage(bulletU,90);
            bulletD =  ImageUtil.rotateImage(bulletU,180);

            for (int i =0 ;i<16;i++){
                explores[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ResourceMgr getInstance(){
        if (INSTANCE == null){
            synchronized (ResourceMgr.class){
                if (INSTANCE ==null){
                    INSTANCE = new ResourceMgr();
                }
            }
        }
        return INSTANCE;
    }


    
}
