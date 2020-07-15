package name.wwl.bigdata.hadoop.study.top;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/7/14 17:27
 */
public class TSortComparator extends WritableComparator {

    public TSortComparator() {
        super(TKey.class,true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b){
        TKey k1 = (TKey)a;
        TKey k2 = (TKey)b;

        int c1 = Integer.compare(k1.getYear(),k2.getYear());
        if (c1 ==0){
            int c2 = Integer.compare(k1.getMonth(),k2.getMonth());
            if (c2 ==0){
                return -Integer.compare(k1.getWd(),k2.getWd());
            }
            return c2;
        }
        return c1;
    }
}
