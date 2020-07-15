package name.wwl.bigdata.hadoop.study.wc;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/7/13 16:11
 */
public class MyReducer extends Reducer<Text, IntWritable,Text,IntWritable> {

    private IntWritable result = new IntWritable();

    @Override
    public void reduce(Text key,Iterable<IntWritable> values,Context context) throws IOException,InterruptedException{

        int sum =0 ;
        for (IntWritable val : values){
            sum += val.get();
        }

        result.set(sum);

        context.write(key,result);
    }
}
