package com.lorelib.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.SimpleFSDirectory;
import sun.misc.Version;

import java.io.File;
import java.io.IOException;

/**
 * Created by listening on 2017/5/5.
 */
public class Lucene_01 {
    public static void main(String[] args) throws IOException, ParseException {
        //定义词法分析器
        Analyzer analyzer = new StandardAnalyzer();

        //确定索引文件存储位置
        //Directory directory = new SimpleFSDirectory(new File("/opt/lucene/store").toPath());
        Directory directory = FSDirectory.open(new File("/opt/lucene/store").toPath());

        createIndex(analyzer, directory);

        findKey(analyzer, directory);
    }

    /**
     * 创建索引
     */
    private static void createIndex(Analyzer analyzer, Directory directory) throws IOException {
        //创建IndexWriter，进行索引文件写入
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter writer = new IndexWriter(directory, config);

        //内容提取，进行索引存储
        Document document = new Document(); //申请document对象，类似数据库中的一行
        String text = "Hello World, luo ming is good!"; //将索引的字符串
        document.add(new Field("fieldname", text, TextField.TYPE_STORED)); //存储字符串
        writer.addDocument(document); //加入到索引中
        writer.close(); //关闭indexWriter，提交创建内容
    }

    /**
     * 关键字查询
     */
    private static void findKey(Analyzer analyzer, Directory directory) throws IOException, ParseException {
        //打开存储位置
        DirectoryReader reader = DirectoryReader.open(directory);

        //创建搜索器
        IndexSearcher searcher = new IndexSearcher(reader);

        //类似sql，进行关键字查询
        QueryParser parser = new QueryParser("fieldname", analyzer);
        Query query = parser.parse("good");
        ScoreDoc[] hits = searcher.search(query, null, 1000).scoreDocs;
        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = searcher.doc(hits[i].doc);
            System.out.println(hitDoc.get("fieldname"));
        }

        //关闭查询器
        reader.close();
        directory.close();
    }
}
