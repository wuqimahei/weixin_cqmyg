package cn.yuyangyang.weixin.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 消息格式转换
 * xml转map
 * map转xml
 */
public class MessageUtil {

    /**
     * XML2Map
     */
    public static Map<String, String> xml2Map(HttpServletRequest request) throws Exception {

        Map<String, String> map = new HashMap<>();
        SAXReader saxReader = new SAXReader();
        ServletInputStream inputStream = request.getInputStream();
        Document doc = saxReader.read(inputStream);
        Element element = doc.getRootElement();
        List<Element> elements = element.elements();
        for (Element e : elements) {
            map.put(e.getName(), e.getText());
        }
        inputStream.close();
        return map;
    }







}
