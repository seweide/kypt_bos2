package net.liangyihui.manager.kypt.bos.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname RestTempUtil
 * @Description TODO
 * @Date 2020/4/20 16:31
 * @Created by Seweide
 */
public class RestTempUtil {

    public static String rtPostObject(String url,Object object) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> map = new HashMap<>();
        String jsonString = JsonUtil.obj2JsonString(object);
        map = JsonUtil.jsonString2Map(jsonString);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
        return response.getBody();
    }

}
