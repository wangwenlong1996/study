package name.wwl.bigdata.hadoop.study.wc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;

//
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.Text;
//import org.apache.hadoop.mapreduce.Job;
//import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
//import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
//import org.apache.hadoop.util.GenericOptionsParser;


/**
 * @Description:
 * @Author: 王文龙
 * @Date: 2020/7/13 15:15
 */
public class MyWordCount {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        System.setProperty("HADOOP_USER_NAME", "wwl");
        System.setProperty("user.name", "wwl");
        Configuration conf = new Configuration(true);

        GenericOptionsParser parse = new GenericOptionsParser(conf,args);

        String[] othArgs = parse.getRemainingArgs();

        conf.set("mapreduce.app-submission.cross-platform","true");

        conf.set("mapreduce.framework.name","local");

        Job job = Job.getInstance(conf);
        job.setJar("E:\\java大数据学习总结\\大数据\\02Hadoop\\source\\hadoop-study\\target\\hadoop-study-1.0-SNAPSHOT.jar");
        job.setJarByClass(MyWordCount.class);

        job.setJobName("wordcount");

        Path infile = new Path(othArgs[0]);

        TextInputFormat.addInputPath(job,infile);

        Path outfile = new Path(othArgs[1]);

        if (outfile.getFileSystem(conf).exists(outfile)){
            outfile.getFileSystem(conf).delete(outfile,true);
        }
        TextOutputFormat.setOutputPath(job,outfile);
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setReducerClass(MyReducer.class);

        job.setNumReduceTasks(1);
       job.waitForCompletion(true);





    }
}
