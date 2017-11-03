package com.baizhi.zzy.lucene;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.jupiter.api.Test;

import javax.swing.text.Document;
import java.io.File;
import java.io.IOException;


/**
 * 第一个lucene案例
 */
public class TestLucene {

    @Test
    public void luceneFirst() throws IOException {
        //索引库目录
        Directory d= FSDirectory.open(new File("index"));
        //分词器
       Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_44);
        //对索引写出对象的配置
       IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_44, analyzer);
        //创建索引库写出对象
        IndexWriter indexWriter = new IndexWriter(d,indexWriterConfig);
       /*Document doc = new Document();
       doc.add(new StringField("id","21", Field.Store.YES));*/

    }
}
