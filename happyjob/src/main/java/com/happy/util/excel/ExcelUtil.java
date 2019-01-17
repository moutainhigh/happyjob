
package com.happy.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.support.ExcelTypeEnum;

/**
 * @author sunning
 * @date 2019/12/31
 */
public class ExcelUtil {

    private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);


    /**
     * 解析工资单
     * 
     * @param file 文件对象
     * @return List<PayrollPojo>
     * @throws ExcelParseException
     */
    public static List<PayrollPojo> parseExcelToPayrollPojoList(InputStream inputStream,String fileName) throws ExcelParseException {
//        InputStream inputStream = null;
        try {
//            inputStream = new FileInputStream(file);
            if (inputStream != null) {

                FileInputStream fis = (FileInputStream)inputStream;
//                String fileName = file.getName();
                ExcelListener listener = new ExcelListener();
                ExcelReader excelReader = null;
                if (fileName != null) {
                    if (StringUtils.endsWithIgnoreCase(fileName, ExcelTypeEnum.XLSX.toString())) {
                        excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener);
                    }
                    if (StringUtils.endsWithIgnoreCase(fileName, ExcelTypeEnum.XLS.toString())) {
                        excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null, listener);
                    }
                }
                if (excelReader != null) {
                    excelReader.read();
                    return listener.getDatas();
                }
            }
        } catch (Exception e) {
            logger.info("parseExcelToPayrollPojoList  ExcelParseException : {} ", e);
            throw new ExcelParseException(e.getMessage());
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
