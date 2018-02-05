import com.aliyun.odps.OdpsException;
import com.aliyun.odps.data.Record;
import com.aliyun.odps.data.TableInfo;
import com.aliyun.odps.mapred.JobClient;
import com.aliyun.odps.mapred.MapperBase;
import com.aliyun.odps.mapred.ReducerBase;
import com.aliyun.odps.mapred.conf.JobConf;
import com.aliyun.odps.mapred.utils.InputUtils;
import com.aliyun.odps.mapred.utils.OutputUtils;
import com.aliyun.odps.mapred.utils.SchemaUtils;

import java.io.IOException;
import java.util.Iterator;

public class MyWordCount {
    public static class WordFreqMapper extends MapperBase {
        private Record word;
        private Record one;

        @Override
        public void setup(TaskContext context) throws IOException {
            word = context.createMapOutputKeyRecord();
            one = context.createMapOutputValueRecord();
            one.set(new Object[] { 1L });
            System.out.println("TaskID: " + context.getTaskID());
        }

        @Override
        public void map(long key, Record record, TaskContext context) throws IOException {
            Object rec = record.get(0);
            if (rec != null) {
                String line = rec.toString();
                for (String w : line.split("[^a-zA-Z]+")) {
                    word.set(new Object[] { w.toLowerCase().trim() });
                    context.write(word, one);
                }
            }
        }
    }


    public static class WordFreqCombiner extends ReducerBase {
        private Record count;

        @Override
        public void setup(TaskContext context) throws IOException {
            count = context.createMapOutputValueRecord();
        }

        @Override
        public void reduce(Record key, Iterator<Record> values, TaskContext context) throws IOException {
            long c = 0;
            while(values.hasNext()) {
                Record value = values.next();
                c += (Long) value.get(0);
            }
            count.set(0, c);
            context.write(key, count);
        }
    }

    public static class WordFreqReducer extends ReducerBase {
        private Record result;

        @Override
        public void setup(TaskContext context) throws IOException {
            result = context.createOutputRecord();
        }

        @Override
        public void reduce(Record key, Iterator<Record> values, TaskContext context) throws IOException {
            long c = 0;
            while(values.hasNext()) {
                Record value = values.next();
                c += (Long) value.get(0);
            }
            result.set(0, key.get(0));
            result.set(1, c);
            context.write(result);
        }
    }

    public static void main(String[] args) throws OdpsException {
        if (args.length != 2) {
            System.err.println("Usage: WordCount <in_table> <out_table>");
            System.exit(2);
        }
        JobConf job = new JobConf();
        job.setMapperClass(WordFreqMapper.class);
        job.setCombinerClass(WordFreqCombiner.class);
        job.setReducerClass(WordFreqReducer.class);
        job.setMapOutputKeySchema(SchemaUtils.fromString("word:string"));
        job.setMapOutputValueSchema(SchemaUtils.fromString("count:bigint"));
        InputUtils.addTable(TableInfo.builder().tableName(args[0]).build(), job);
        OutputUtils.addTable(TableInfo.builder().tableName(args[1]).build(), job);
        JobClient.runJob(job);
    }
}
