package name.wwl.demo.study.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/5/18 17:29
 */
public class PropertyMgr {

    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Object get(String key){
        if (props == null) return null;
        return props.get(key);
    }
}
