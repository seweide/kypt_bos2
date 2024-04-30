package net.liangyihui.manager.kypt.bos.util;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.function.Function;

/**
 * @author liu_y
 */
public class ListUtil {


    public static <T, R> void segmentedApply(List<T> list, Function<List<T>, R> function) {
        segmentedApply(list, 900, function);
    }

    public static <T, R> void segmentedApply(List<T> list, int batchSize, Function<List<T>, R> function) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        int pos = 0;
        int endPos = 0;
        int listSize = list.size();
        while (pos < listSize) {
            if ((endPos += batchSize) > listSize) {
                endPos = listSize;
            }
            function.apply(list.subList(pos, endPos));
            pos = endPos;
        }
    }

}
