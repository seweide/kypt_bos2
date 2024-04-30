package net.liangyihui.manager.kypt.bos.util;

import net.liangyihui.manager.kypt.bos.exception.CommonBusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * @author liu_y
 */
public class FileReadUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileReadUtils.class);

    public static byte[] getBytesByFilePath(String filePath) {
        InputStream inputStream = FileReadUtils.class.getClassLoader().getResourceAsStream(filePath);
        if (null == inputStream) {
            throw new CommonBusinessException("not found pem file");
        }
        int maxBatch = 2048;
        byte[] buffer = new byte[maxBatch];
        int count;
        byte[] resArr = new byte[0];
        try {
            while ((count = (inputStream.read(buffer))) > -1) {
                byte[] joinedArray = new byte[resArr.length + count];
                System.arraycopy(resArr, 0, joinedArray, 0, resArr.length);
                System.arraycopy(buffer, 0, joinedArray, resArr.length, count);
                resArr = joinedArray;
            }
        } catch (IOException e) {
            logger.error("read file error ,path=" + filePath, e);
            throw new CommonBusinessException("read file error");
        } finally {
            try {
                inputStream.close();
            } catch (IOException ignored) {
            }
        }
        return resArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getBytesByFilePath("img/question.png")));
    }

}
