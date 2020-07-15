package name.wwl.bigdata.hadoop.study.top;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/7/14 17:33
 */
public class TGroupComparator extends WritableComparator {

    public TGroupComparator() {
        super(TKey.class,true);
    }

    @Override
    public int compare(WritableComparable a,WritableComparable b){
        TKey k1 = (TKey)a;
        TKey k2 = (TKey)b;

        int c1 = Integer.compare(k1.getYear(),k2.getYear());

        if (c1 == 0){
            return Integer.compare(k1.getMonth(),k2.getMonth());
        }

        return c1;
    }
}
