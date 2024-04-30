package net.liangyihui.manager.kypt.bos.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import net.liangyihui.manager.kypt.bos.exception.CommonBusinessException;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static net.liangyihui.digitalmarketing.constant.ErrorCodeConstant.COMMON_ERROR;

/**
 * JSON工具类
 * @author heww
 * @version 1.0 2021年03月24日
 */
public class JsonUtil {

    /**
     * Object转换为JSON字符串
     * @Description
     * @param obj 指定对象(POJO)
     * @return
     * @author heww
     */
    public static String obj2JsonString(Object obj) {
        ObjectMapper objectMapper = getObjectMapper();
        if (obj == null) {
            return EMPTY_JSON_STRING;
        }
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new CommonBusinessException(COMMON_ERROR, "save label error");
        }
    }


    /**
     * JSON字符串转换为Map
     * @param strJsonString 需要转换的JSON字符串
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <E, V> Map<E, V> jsonString2Map(String strJsonString)  {
        ObjectMapper objectMapper = getObjectMapper();
        if (StringUtils.isEmpty(strJsonString))
            strJsonString = EMPTY_JSON_STRING;
        try {
            return objectMapper.readValue(strJsonString, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonBusinessException(COMMON_ERROR, "save label error");
        }
    }

    /**
     * JSON字符串转换为Object
     * @param strJsonString 需要转换的JSON字符串
     * @param clazz
     * @return
     */
    public static <T> T jsonString2Object(String strJsonString, Class<T> clazz)  {
        ObjectMapper objectMapper = getObjectMapper();
        if (StringUtils.isEmpty(strJsonString)) {
            strJsonString = EMPTY_JSON_STRING;
        }
        try {
            return objectMapper.readValue(strJsonString, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonBusinessException(COMMON_ERROR, "save label error");
        }
    }

    /**
	* JSON字符串转换为List<Object>
	* @param clazz
	* @return
	*/
    public static <T> List<T> jsonString3ListObject(String strJsonString, Class<T> clazz)  {
	   return JSONObject.parseArray(strJsonString, clazz);//把字符串转换成集合
    }

    /**
     * @Description 获取ObjectMapper(单例，线程安全)
     * @return
     * @author caobin
     */
    @SuppressWarnings("deprecation")
    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapperLock.lock();
            try {
                if (objectMapper == null) {
                    objectMapper = new ObjectMapper();
                    objectMapper.setDateFormat(new DateFormat());
                    /** 反序列化处理 **/
                    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                    //所有浮点型用BigDecimal处理
                    objectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
                    /** 序列化处理 **/
                    //科学计数法处理
                    objectMapper.enable(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN);
                    //null字段忽略
                    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                    objectMapper.setDateFormat(new DateFormat());

                    objectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
                    objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
                }
            } finally {
                objectMapperLock.unlock();
            }
        }
        return objectMapper;
    }

    /**
     * 空JSON字符串
     */
    private final static String EMPTY_JSON_STRING = "{}";

    /**
     * ObjectMapper
     */
    private static volatile ObjectMapper objectMapper;

    /**
     * ObjectMapper锁
     */
    private static Lock objectMapperLock = new ReentrantLock();

    private static class DateFormat extends StdDateFormat {
        private static final long serialVersionUID = 5321958243461055519L;

        @Override
        public Date parse(String dateStr) throws ParseException {
            try {
                return super.parse(dateStr);
            } catch (Exception e) {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
            }
        }

        @Override
        public StdDateFormat clone() {
            return new DateFormat();
        }
    }
}
