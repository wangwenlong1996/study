package name.wwl.bigdata.hadoop.study.top;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;

/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/7/13 16:49
 */
public class MyTopN {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration(true);

        conf.set("mapreduce.framework.name","yarn");
        conf.set("mapreduce.app-submission.cross-platform","true");

        String[] other = new GenericOptionsParser(conf,args).getRemainingArgs();

        Job job = Job.getInstance(conf);

        job.setJarByClass(MyTopN.class);

        job.setJobName("TopN");

        job.setJar("E:\\java大数据学习总结\\大数据\\02Hadoop\\source\\hadoop-study\\target\\hadoop-study-1.0-SNAPSHOT.jar");

        TextInputFormat.addInputPath(job,new Path(other[0]));

        Path outPath = new Path(other[1]);

        if (outPath.getFileSystem(conf).exists(outPath)){
            outPath.getFileSystem(conf).delete(outPath,true);
        }
        TextOutputFormat.setOutputPath(job,outPath);

        job.setMapperClass(TMapper.class);
        job.setMapOutputValueClass(TKey.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setPartitionerClass(TPartitioner.class);

        job.setSortComparatorClass(TSortComparator.class);

        job.setGroupingComparatorClass(TGroupComparator.class);

        job.setReducerClass(TReduce.class);
        job.setNumReduceTasks(1);

        job.waitForCompletion(true);



    }
}
