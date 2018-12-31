
package com.happy.util.excel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.util.StringUtils;
import com.alibaba.excel.util.TypeUtil;
import com.alibaba.fastjson.JSONObject;
import com.happy.util.Util;
import com.happy.util.pubConst.Const;

/*
 * 解析监听器， 每解析一行会回调invoke()方法。 整个excel解析结束会执行doAfterAllAnalysed()方法
 */
public class ExcelListener extends AnalysisEventListener {

    private Logger logger = LoggerFactory.getLogger(ExcelListener.class);

    private List<PayrollPojo> payrollList = new ArrayList<>();
    private List<String> rowHeader = null;// 表头
    // 自定义用于暂时存储data。
    // 可以通过实例获取该值
    private List<PayrollPojo> datas = new ArrayList<PayrollPojo>();

    public void invoke(Object object, AnalysisContext context) {

        System.out.println("当前行：" + context.getCurrentRowNum());
        System.out.println(object);
        int rowNum = context.getCurrentRowNum();
        if (object instanceof ArrayList) {
            List<String> cellList = (ArrayList<String>)object;
            // 判断是否表头
            if (rowNum == 0) {
                rowHeader = cellList;
            }
            // 表数据
            if (rowNum > 0) {
                // 循环处理每一行数据
                PayrollPojo payRollPojo = new PayrollPojo();
                for (int i = 0; i < rowHeader.size(); i++) {
                    // 先查表头,根据表头查询字段意义
                    String headerName = rowHeader.get(i);
                    // 实际对应数据
                    String cellData = cellList.get(i);
                    Field[] fields = PayrollPojo.class.getDeclaredFields();
                    for (Field field : fields) {
                        PayrollProperty payRollProperty = field.getDeclaredAnnotation(PayrollProperty.class);

                        if (headerName != null && payRollProperty != null
                            && headerName.equals(payRollProperty.name())) {
                            try {
                                Object cellObj = null;
                                // 判断数据类型
                                if (payRollProperty.format().equalsIgnoreCase(PayrollPojo.dateFormat)) {

                                    Date date = Util.getDateFromStr(cellData, Const.DATE_FORMAT_STR_6);
                                    cellObj = date.getTime();
                                } else {

                                    cellObj = TypeUtil.convert(cellData, field, payRollProperty.format(), false);
                                }

                                PropertyUtils.setProperty(payRollPojo, field.getName(), cellObj);
                            } catch (IllegalAccessException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            } catch (NoSuchMethodException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        } else {
                            // 其他详细信息
                            JSONObject jsonObj = payRollPojo.getPayDetail();
                            jsonObj.putIfAbsent(headerName, cellData);
                        }
                    }

                }
                datas.add(payRollPojo);
            }
        }

    }

    public void doAfterAllAnalysed(AnalysisContext context) {
        payrollList.clear();// 解析结束销毁不用的资源
        rowHeader.clear();
    }

    public List<PayrollPojo> getDatas() {
        return datas;
    }

    public List<PayrollPojo> getPayrollList() {
        return payrollList;
    }

}