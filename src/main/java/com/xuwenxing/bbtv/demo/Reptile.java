package com.xuwenxing.bbtv.demo;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by xuwx on 2018/9/14.
 */
public class Reptile {
        public static void main(String[] args) {
            //传入你所要爬取的页面地址
            String url1 = "http://www.dytt8.net/";
            //创建输入流用于读取流
            InputStream is = null;
            //包装流,加快读取速度
            BufferedReader br = null;
            //用来保存读取页面的数据.
            StringBuffer html = new StringBuffer();
            //创建临时字符串用于保存每一次读的一行数据，然后html调用append方法写入temp;
            String temp = "";
            try {
                //获取URL;
                URL url2 = new URL(url1);
                //打开流，准备开始读取数据;
                is = url2.openStream();
                //将流包装成字符流，调用br.readLine()可以提高读取效率，每次读取一行;
                br= new BufferedReader(new InputStreamReader(is));
                //读取数据,调用br.readLine()方法每次读取一行数据,并赋值给temp,如果没数据则值==null,跳出循环;
                while ((temp = br.readLine()) != null) {
                    //将temp的值追加给html,这里注意的时String跟StringBuffere的区别前者不是可变的后者是可变的;
                    html.append(temp);
                }
                //接下来是关闭流,防止资源的浪费;
                if(is != null) {
                    is.close();
                    is = null;
                }
                //通过Jsoup解析页面,生成一个document对象;
                Document doc = Jsoup.parse(html.toString());
                //通过class的名字得到（即XX）,一个数组对象Elements里面有我们想要的数据,至于这个div的值呢你打开浏览器按下F12就知道了;
                Elements elements = doc.getElementsByClass("inddline");
                for (Element element : elements) {
                    //打印出每一个节点的信息;你可以选择性的保留你想要的数据,一般都是获取个固定的索引;
                    System.out.println(element.text());
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

}
}
