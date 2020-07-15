package name.wwl.bigdata.hadoop.study.top;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/7/14 16:58
 */
public class TMapper extends Mapper<LongWritable, Text,TKey, IntWritable>{

    TKey mkey = new TKey();
    IntWritable mval = new IntWritable();

    @Override
    protected void map(LongWritable key,Text value,Context context) throws IOException,InterruptedException {
        String[] strs = StringUtils.split(value.toString(),'\t');
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = sdf.parse(strs[0]);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            mkey.setYear(cal.get(Calendar.YEAR));
            mkey.setMonth(cal.get(Calendar.MONDAY)+1);
            mkey.setDay(cal.get(Calendar.DAY_OF_MONTH));
            int wd = Integer.parseInt(strs[2]);
            mkey.setWd(wd);
            mval.set(wd);
            context.write(mkey,mval);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
