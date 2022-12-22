package com.vika.way.spring.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.net.URLDecoder;

/**
 *
 * @author chenwei.tjw
 * @date 2022/12/18
 **/
public class FileReadUtils {

    /**
     * 读取对象
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static <T> T readObject(String file, TypeReference<T> type) throws IOException {
        String json = readFile(file);
        return JSON.parseObject(json, type);
    }

    /**
     * 读取对象
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static <T> T readObject(String file, Class<T> clazz) throws IOException {
        String json = readFile(file);
        return JSON.parseObject(json, clazz);
    }

    /**
     * 读取文件内容
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static String readFile(String file) throws IOException {
        //注意getResource("")里面是空字符串
        String path = FileReadUtils.class.getClassLoader().getResource(file).getPath();
        //如果路径中带有中文会被URLEncoder,因此这里需要解码
        String filePath = URLDecoder.decode(path, "UTF-8");
        return getFileContent(filePath);
    }

    /**
     * 根据文件路径读取文件内容
     *
     * @param fileInPath
     * @throws IOException
     */
    private static String getFileContent(Object fileInPath) throws IOException {
        BufferedReader br = null;
        if (fileInPath == null) {
            return null;
        }
        if (fileInPath instanceof String) {
            br = new BufferedReader(new FileReader(new File((String) fileInPath)));
        } else if (fileInPath instanceof InputStream) {
            br = new BufferedReader(new InputStreamReader((InputStream) fileInPath));
        }
        String content = StringUtils.EMPTY;
        String line;
        while ((line = br.readLine()) != null) {
            content += line;
        }
        br.close();
        return content;
    }
}
