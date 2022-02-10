package com.example.esserver.controller;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
/*
*
* 第一种：使用ES helper构造
* */
public class EClient {


    public  static void createDocument() throws UnknownHostException, IOException {
        // on startup
        Settings settings = Settings.builder().put("cluster.name", "my-application").build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

        // 构造数据
        // 第一种：使用es heler
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().field("username", "qiaozhi")
                .field("fullname", "乔治").field("created", new Date()).field("deleted", false).endObject();
        IndexResponse response = client.prepareIndex("accounts", "person", "1").setSource(builder).get();

        // 第二种： 自己构造JSON数据
        // IndexResponse response = client.prepareIndex("twitter", "_doc")
        // .setSource(json, XContentType.JSON)
        // .get();

        // 打印保存信息
        // Index name
        String _index = response.getIndex();
        System.out.println("_index " + _index);
        // Type name
        String _type = response.getType();
        System.out.println("_type " + _type);
        // Document ID (generated or not)
        String _id = response.getId();
        System.out.println("_id " + _id);
        // Version (if it's the first time you index this document, you will
        // get: 1)
        long _version = response.getVersion();
        System.out.println("_version " + _version);
        // status has stored current instance statement.
        RestStatus status = response.status();
        System.out.println("status " + status);

        // on shutdown
        client.close();
    }


    public static void main(String[] args) throws IOException {
        createDocument();
    }
}
