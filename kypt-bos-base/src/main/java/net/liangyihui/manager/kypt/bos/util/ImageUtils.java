package net.liangyihui.manager.kypt.bos.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ImageUtils {
    public static byte[] getImageBytes(String imagePathUrl){
        RestTemplate restTemplate1 = new RestTemplate();
        HttpHeaders getheaders = new HttpHeaders();
        ResponseEntity<byte[]> response = restTemplate1.exchange(
                imagePathUrl,
                HttpMethod.GET,
                new HttpEntity<byte[]>(getheaders),
                byte[].class);
        return response.getBody();
    }
}
