package name.wwl.bigdata.hadoop.study.top;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/7/14 17:25
 */
public class TPartitioner extends Partitioner<TKey, IntWritable> {

    @Override
    public int getPartition(TKey key,IntWritable value, int numPartitions){
        return key.getYear()%numPartitions;
    }
}
