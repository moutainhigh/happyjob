/**
 * @CreateTime: sunning2018年12月31日
 * @CreateUser: sunning
 * @Copyright: http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
 */

package com.happy.util.excel;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.poifs.filesystem.FileMagic;

import com.alibaba.excel.support.ExcelTypeEnum;

/**
 * @author sunning
 * @date 2019/12/31
 */
public class ExcelTypeParse {

    public static ExcelTypeEnum valueOf(InputStream inputStream) {
        try {

            FileMagic fileMagic = FileMagic.valueOf(inputStream);
            if (FileMagic.OLE2.equals(fileMagic)) {
                return ExcelTypeEnum.XLS;
            }
            if (FileMagic.OOXML.equals(fileMagic)) {
                return ExcelTypeEnum.XLSX;
            }
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
