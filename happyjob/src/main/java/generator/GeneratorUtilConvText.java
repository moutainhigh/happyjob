package generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.happy.util.Util;

import generator.data.ColumnInfoData;
import generator.data.TableInfoData;


public class GeneratorUtilConvText {
	private static Map<String, String> javaTypeMap = new HashMap<String, String>();
	/**
	 * 需要修改的路径 FILE_PATH_MAPPER：mapper接口的绝对路径 FILE_PATH_BATIS：mybatis生成文件的绝对路径
	 * FILE_PATH_ENTITY：实体类生成文件的绝对路径 XD_PATH_MAPPER：mybatis中xml中mapper的相对路径
	 * XD_PATH_ENTITY：mybatis中xml中entity的相对路径
	 */
	public static final String GENERATOR_STR_PREFIX_0 = "com.happy";
	public static final String FILE_PATH_MAPPER = System.getProperty("user.dir") + "\\src\\main\\java" + "\\com\\happy\\sqlMapper\\";
	public static final String FILE_PATH_BATIS = System.getProperty("user.dir") + "\\src\\main\\java" + "\\com\\happy\\sqlMapper\\";
	public static final String FILE_PATH_ENTITY = System.getProperty("user.dir") + "\\src\\main\\java" + "\\com\\happy\\entity\\";
	public static final String FILE_PATH_DATA_SERVICEIMPL = System.getProperty("user.dir") + "\\src\\main\\java" + "\\com\\happy\\service\\exportService\\impl\\";
	public static final String XD_PATH_MAPPER = GENERATOR_STR_PREFIX_0+".sqlMapper.";
	public static final String XD_PATH_ENTITY = GENERATOR_STR_PREFIX_0+".entity.";
	public static final String XD_PATH_SERVICEIMP = GENERATOR_STR_PREFIX_0+".service.exportService.impl.";
	/**
	 * 详细自动生成代码
	 */
	public static final String GENERATOR_STR_PREFIX_1 = "package "+GENERATOR_STR_PREFIX_0+".sqlMapper;";
	public static final String GENERATOR_STR_PREFIX_2 = "import org.springframework.stereotype.Repository;";
	public static final String GENERATOR_STR_PREFIX_3 = "import "+GENERATOR_STR_PREFIX_0+".sqlMapper.IConditionMapper;";
	public static final String GENERATOR_STR_PREFIX_4 = "import "+GENERATOR_STR_PREFIX_0+".entity.";
	public static final String GENERATOR_STR_PREFIX_5 = "@Repository(\"";
	public static final String GENERATOR_STR_PREFIX_6 = "\")";
	public static final String GENERATOR_STR_PREFIX_7 = "public interface ";
	public static final String GENERATOR_STR_PREFIX_8 = " extends IConditionMapper<";
	public static final String GENERATOR_STR_PREFIX_9 = "}";
	public static final String GENERATOR_STR_PREFIX_10 = ">{";
	public static final String GENERATOR_ENTITY_PREFIX_1 = "package "+GENERATOR_STR_PREFIX_0+".entity;";
	public static final String GENERATOR_ENTITY_PREFIX_8 = "\")";
	public static final String GENERATOR_ENTITY_PREFIX_9 = "public class ";
	public static final String GENERATOR_ENTITY_PREFIX_10 = " {";
	public static final String GENERATOR_ENTITY_PREFIX_14 = "	";
	public static final String GENERATOR_ENTITY_PREFIX_15 = "private";
	public static final String GENERATOR_ENTITY_PREFIX_16 = " void ";
	public static final String GENERATOR_ENTITY_PREFIX_17 = "return ";
	public static final String GENERATOR_ENTITY_PREFIX_18 = ";";
	public static final String GENERATOR_ENTITY_PREFIX_19 = "public ";
	public static final String GENERATOR_ENTITY_PREFIX_20 = " get";
	public static final String GENERATOR_ENTITY_PREFIX_21 = " set";
	public static final String GENERATOR_ENTITY_PREFIX_22 = "this.";
	public static final String GENERATOR_ENTITY_PREFIX_23 = " = ";
	public static final String GENERATOR_MYBATIS_PREFIX_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";
	public static final String GENERATOR_MYBATIS_PREFIX_2 = "<!DOCTYPE mapper";
	public static final String GENERATOR_MYBATIS_PREFIX_3 = "  PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"";
	public static final String GENERATOR_MYBATIS_PREFIX_4 = "  \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">";
	public static final String GENERATOR_MYBATIS_PREFIX_5 = "<mapper namespace=\"";
	public static final String GENERATOR_MYBATIS_PREFIX_6 = "\">";
	public static final String GENERATOR_MYBATIS_PREFIX_7 = "<insert id=\"insert\" />";
	public static final String GENERATOR_MYBATIS_PREFIX_8 = "<update id=\"updateByPk\" />";
	public static final String GENERATOR_MYBATIS_PREFIX_9 = "<delete id=\"deleteByPk\" />";
	public static final String GENERATOR_MYBATIS_PREFIX_10 = "<select id=\"selectByPk\" resultType=\"";
	public static final String GENERATOR_MYBATIS_PREFIX_16 = "<delete id=\"deleteByCond\" />";
	public static final String GENERATOR_MYBATIS_PREFIX_17 = "<update id=\"updateByCond\" />";
	public static final String GENERATOR_MYBATIS_PREFIX_11 = "<select id=\"selectByCondPage\" resultType=\"";
	public static final String GENERATOR_MYBATIS_PREFIX_12 = "\" />";
	public static final String GENERATOR_MYBATIS_PREFIX_13 = "<select id=\"selectByCond\" resultType=\"";
	public static final String GENERATOR_MYBATIS_PREFIX_14 = "\" />";
	public static final String GENERATOR_MYBATIS_PREFIX_15 = "</mapper>";
	public static final String GENERATOR_SERVICE_PREFIX_1 = "package "+GENERATOR_STR_PREFIX_0+".service.exportService.impl;";
	public static final String GENERATOR_PREFIX_1 = " implements ";
	public static final String GENERATOR_PREFIX_2 = " extends ";
	public static final String GENERATOR_PREFIX_3 = " Serializable ";
	public static final String GENERATOR_PREFIX_4 = "private static final long serialVersionUID = 1L;";
	public static final String GENERATOR_PREFIX_5 = "(";
	public static final String GENERATOR_PREFIX_6 = ")";
	public static final String GENERATOR_PREFIX_7 = "\"";
	public static final String GENERATOR_API_PREFIX_1 = "@ApiModelProperty";
	public static final String GENERATOR_API_PREFIX_2 = "name";
	public static final String GENERATOR_API_PREFIX_3 = "value";
	public static final String GENERATOR_API_PREFIX_4 = "dataType";
	public static final String GENERATOR_API_PREFIX_5 = "example";
	public static final String GENERATOR_API_PREFIX_6 = "@ApiModel";
	public static final String GENERATOR_API_PREFIX_7 = "description";
	public static final String FILE_MAPPER = "Mapper";
	public static final String FILE_ENTITY = "Entity";
	public static final String FILE_HZ = ".java";
	public static final String FILE_HZ_2 = ".xml";
	public static final String FILE_SERVICE = "Service";
	public static final String FILE_SERVICE_IMPL = "ServiceImpl";
	public static final String FILE_HH = "\n";

	public static void main(String[] args) throws Exception {
		String resource = "generator/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		// 清空目录
		System.out.println(System.getProperty("user.dir"));
		System.out.println(FILE_PATH_MAPPER);
		Util.delAllFile(FILE_PATH_MAPPER);
		Util.delAllFile(FILE_PATH_BATIS);
		Util.delAllFile(FILE_PATH_ENTITY);
		Util.delAllFile(FILE_PATH_DATA_SERVICEIMPL); // 导出类
		// 初始化javaType对应
		initJavaTypeMap();
		IGeneratorMapper mapper = session.getMapper(IGeneratorMapper.class);
		List<TableInfoData> tableNmLst = mapper.selTableNmList();
		for (TableInfoData tableItem : tableNmLst) {
			// 如果为空 不可能进for循环
			if (Util.isEmpty(tableItem)) {
				continue;
			}
			
			List<ColumnInfoData> columnInfoLst = mapper.selTblColumnInfoList(tableItem.getName());
			autoMapper(tableItem,Util.convUnderline2Camel(columnInfoLst.get(0).getColumnName()),columnInfoLst);
			System.out.println("pk==============="+Util.convUnderline2Camel(columnInfoLst.get(0).getColumnName()));
			autoEntity(tableItem, columnInfoLst);
			autoMybatis(tableItem, columnInfoLst);
			System.out.println("-------------------------------------------------------------over-----------------------------------------------");
		}
//		autoServiceImpl(tableNmLst);
	}

	/**
	 * 表名对应的实体类名驼峰化
	 * 
	 * @param param
	 * @return
	 * @author xuhb
	 * @date 2016-12-6
	 * @modified xhb
	 */
	public static String convToUpper(String param) {
		if (Util.isEmpty(param)) {
			return "";
		}
		String[] strs = param.split("_");
		StringBuffer sb = new StringBuffer();
		for (String str : strs) {
			sb.append(str.substring(0, 1).toUpperCase());
			sb.append(str.substring(1).toLowerCase());
		}
		return sb.toString();
	}

	/**
	 * 生成实体mapper的java文件
	 * 
	 * @param tableItem
	 * @author xhb
	 * @date 2016-12-6
	 * @modified xhb
	 */
	public static void autoMapper(TableInfoData tableItem,String pk,List<ColumnInfoData> columnInfoLst) {
		try {
			String name2 = convToUpper(tableItem.getName());
			String name3 =  name2.substring(0, 1).toLowerCase() + name2.substring(1, name2.length());
			File file = new File(FILE_PATH_MAPPER + "/" + name2 + FILE_MAPPER + FILE_HZ);
			System.out.println(FILE_PATH_MAPPER + "/" + name2 + FILE_MAPPER + FILE_HZ);
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(GENERATOR_STR_PREFIX_1 + FILE_HH + FILE_HH);
			bw.write("import java.util.List;"+FILE_HH);
			bw.write(GENERATOR_STR_PREFIX_2 + FILE_HH);
			bw.write(GENERATOR_STR_PREFIX_4 + name2 + FILE_ENTITY + ";" + FILE_HH + FILE_HH);
			bw.write(GENERATOR_STR_PREFIX_5 + name3 + FILE_MAPPER + GENERATOR_STR_PREFIX_6 + FILE_HH);
			bw.write(GENERATOR_STR_PREFIX_7 + name2 + FILE_MAPPER  + "{" + FILE_HH+ FILE_HH);
			bw.write("\t"+"void insert(" + name2+"Entity "+ name3+");"+ FILE_HH+ FILE_HH);
			bw.write("\t"+ name2+"Entity selectByPK(long "+ pk+");"+ FILE_HH+ FILE_HH);
			bw.write("\t"+"void updateByPK(" + name2+"Entity "+ name3+");"+ FILE_HH+ FILE_HH);
			bw.write("\t"+"void deleteByPK(long "+ pk+");"+ FILE_HH+ FILE_HH); 
			bw.write("\t"+"List< "+ name2+"Entity> selectAll();"+ FILE_HH+ FILE_HH); 
			bw.write("\t"+"List< "+ name2+"Entity> selectAllIsUse();"+ FILE_HH+ FILE_HH); 
			boolean deleteFlag = false;
			for (ColumnInfoData columnData : columnInfoLst) {
				if ("ISDEL".equalsIgnoreCase(columnData.getColumnName())) {
					deleteFlag = true;
					break;
				}
			}
			if(deleteFlag){
				bw.write("\t"+"void logicDelete(long "+ pk+");"+ FILE_HH+ FILE_HH);  
			}
			bw.write(GENERATOR_STR_PREFIX_9 + FILE_HH);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void autoMybatis(TableInfoData tableItem, List<ColumnInfoData> columnInfoLst) {
		try {
			String name2 = convToUpper(tableItem.getName());
			String name3 = convToUpper(tableItem.getName())+"Entity";
			String name4 = Util.convUnderline2Camel(columnInfoLst.get(0).getColumnName());
			File file = new File(FILE_PATH_BATIS + "/" + name2 + FILE_MAPPER + FILE_HZ_2);
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(GENERATOR_MYBATIS_PREFIX_1 + FILE_HH);
			bw.write(GENERATOR_MYBATIS_PREFIX_2 + FILE_HH);
			bw.write(GENERATOR_MYBATIS_PREFIX_3 + FILE_HH);
			bw.write(GENERATOR_MYBATIS_PREFIX_4 + FILE_HH);
			bw.write(GENERATOR_MYBATIS_PREFIX_5 + XD_PATH_MAPPER + name2 + FILE_MAPPER + GENERATOR_MYBATIS_PREFIX_6 + FILE_HH);
			boolean deleteFlag = false;
			boolean delete_Flag = false;
			for (ColumnInfoData columnData : columnInfoLst) {
				if ("ISDEL".equalsIgnoreCase(columnData.getColumnName())) {
					deleteFlag = true;
					break;
				}else if("IS_DEL".equalsIgnoreCase(columnData.getColumnName())){
					delete_Flag = true;
					break;
				}
			}
			boolean useFlag = false;
			for (ColumnInfoData columnData : columnInfoLst) {
				if ("IS_USE".equalsIgnoreCase(columnData.getColumnName())
						||"ISUSE".equalsIgnoreCase(columnData.getColumnName())) {
					useFlag = true;
					break;
				}
			}
			// 添加ResultMap
			bw.write(GENERATOR_ENTITY_PREFIX_14 + "<resultMap id=\"BaseResultMap\" type=\"" + XD_PATH_ENTITY + name3 + "\">\n");
			for (ColumnInfoData columnInfoData : columnInfoLst) {
				System.out.println(columnInfoData.getColumnName() );
				bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + "<result column=\"" + columnInfoData.getColumnName() + "\" property=\"" + Util.convUnderline2Camel(columnInfoData.getColumnName() + "\"/>\n"));
			}
			bw.write(GENERATOR_ENTITY_PREFIX_14 + "</resultMap>\n");
			// 如果是自增长
//			if (hasAutoAddFlg) {
//				bw.write(GENERATOR_ENTITY_PREFIX_14 + "<insert id=\"insert\" useGeneratedKeys=\"true\" keyProperty=\"" + Util.convUnderline2Camel(columnNm) + "\" />" + FILE_HH);
//			} else {
//				bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_MYBATIS_PREFIX_7 + FILE_HH);
//			}
			//insert start
			bw.write(GENERATOR_ENTITY_PREFIX_14 + "<insert id=\"insert\" useGeneratedKeys=\"true\" keyProperty=\""+name4+"\" parameterType=\""+GENERATOR_STR_PREFIX_0+".entity."+name3+"\">" + FILE_HH);
			bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + "insert into "+tableItem.getName()+"("); 
			for(int i=1;i<columnInfoLst.size();i++){
				bw.write(columnInfoLst.get(i).getColumnName());
				if(i<(columnInfoLst.size()-1)){
					bw.write(",");
				}
			}
			bw.write(")"+FILE_HH);
			bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + " values ("); 
			for(int i=1;i<columnInfoLst.size();i++){
				bw.write("#{"+Util.convUnderline2Camel(columnInfoLst.get(i).getColumnName())+"}");
				if(i<(columnInfoLst.size()-1)){
					bw.write(",");
				}
			}
			bw.write(");"+FILE_HH);
			bw.write(GENERATOR_ENTITY_PREFIX_14 + "</insert>" + FILE_HH);
			//insert end
			//selectByPK start  where wuser_id=#{wuserId}
			bw.write(GENERATOR_ENTITY_PREFIX_14 + "<select id=\"selectByPK\" resultMap=\"BaseResultMap\" parameterType=\"long\">" + FILE_HH);
			bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + "select * from "+tableItem.getName());
			bw.write(" where "+columnInfoLst.get(0).getColumnName()+"=#{"+Util.convUnderline2Camel(columnInfoLst.get(0).getColumnName())+"}"+ FILE_HH);	
			bw.write(GENERATOR_ENTITY_PREFIX_14 + "</select>" + FILE_HH);
			//selectByPK end
			//selectByPK end
			//selectAll start 
			bw.write(GENERATOR_ENTITY_PREFIX_14 + "<select id=\"selectAll\" resultMap=\"BaseResultMap\" >" + FILE_HH);
			bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + "select * from "+tableItem.getName()+FILE_HH);
			if(deleteFlag){
				bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14+" where isdel=0 "+FILE_HH);
			}
			bw.write(GENERATOR_ENTITY_PREFIX_14 + "</select>" + FILE_HH);
			//selectAll end
			//selectAllIsUse start 
			bw.write(GENERATOR_ENTITY_PREFIX_14 + "<select id=\"selectAllIsUse\" resultMap=\"BaseResultMap\" >" + FILE_HH);
			bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + "select * from "+tableItem.getName()+FILE_HH);
			if(deleteFlag || useFlag){
				bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14+" where 1=1");
				if(deleteFlag){
					bw.write(" and isdel=0 ");
				}
				if(delete_Flag){
					bw.write(" and is_del=0 ");
				}
				if(useFlag){
					bw.write(" and is_use=1 ");
				}
				bw.write( FILE_HH);
			}
			bw.write(GENERATOR_ENTITY_PREFIX_14 + "</select>" + FILE_HH);
			//selectAllIsUse end
			//update start
			bw.write(GENERATOR_ENTITY_PREFIX_14 + "<update id=\"updateByPK\" parameterType=\""+GENERATOR_STR_PREFIX_0+".entity."+name3+"\">" + FILE_HH);
			bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + "update "+tableItem.getName()+FILE_HH);
			bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + "<set>"+FILE_HH);
			
			for(int i=1;i<columnInfoLst.size();i++){
				String columnName = columnInfoLst.get(i).getColumnName();
				String camalColumnName = Util.convUnderline2Camel(columnName);
				if("CHAR".equalsIgnoreCase(columnInfoLst.get(i).getTypeName()) || "VARCHAR".equalsIgnoreCase(columnInfoLst.get(i).getTypeName()) 
						|| "TEXT".equalsIgnoreCase(columnInfoLst.get(i).getTypeName())){
					bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14);
					bw.write("<if test=\""+ camalColumnName+"!=null\">"+ FILE_HH);
					
					bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14+ GENERATOR_ENTITY_PREFIX_14);
					bw.write(columnName+"=#{"+camalColumnName+"},"+ FILE_HH);
					
					bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14);
					bw.write("</if>"+ FILE_HH);
				}else if("int".equalsIgnoreCase(columnInfoLst.get(i).getTypeName()) || "TINYINT".equalsIgnoreCase(columnInfoLst.get(i).getTypeName()) 
						|| "SMALLINT".equalsIgnoreCase(columnInfoLst.get(i).getTypeName())){
					bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14);
					if(columnName.startsWith("is")){
						bw.write("<if test=\""+ camalColumnName+"!=null \">"+ FILE_HH);
					}else{
						bw.write("<if test=\""+ camalColumnName+"!=null \">"+ FILE_HH);
					}
					
					bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14+ GENERATOR_ENTITY_PREFIX_14);
					bw.write(columnName+"=#{"+camalColumnName+"},"+ FILE_HH);
					
					bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14);
					bw.write("</if>"+ FILE_HH);
				}else if("BIGINT".equals(columnInfoLst.get(i).getTypeName())){
					bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14);
					bw.write("<if test=\""+ camalColumnName+"!=null and "+ camalColumnName+"!=0L\">"+ FILE_HH);
					
					bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14+ GENERATOR_ENTITY_PREFIX_14);
					bw.write(columnName+"=#{"+camalColumnName+"},"+ FILE_HH);
					
					bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14);
					bw.write("</if>"+ FILE_HH);
				}else{
					bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14);
					bw.write("<if test=\""+ camalColumnName+"!=null \">"+ FILE_HH);
					
					bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14+ GENERATOR_ENTITY_PREFIX_14);
					bw.write(columnName+"=#{"+camalColumnName+"},"+ FILE_HH);
					
					bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14);
					bw.write("</if>"+ FILE_HH);
				}
				
			}
			
			bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + "</set>"+FILE_HH);
			bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 +" where "+columnInfoLst.get(0).getColumnName()+"=#{"+Util.convUnderline2Camel(columnInfoLst.get(0).getColumnName())+"}"+FILE_HH);	
			bw.write(GENERATOR_ENTITY_PREFIX_14 + "</update>" + FILE_HH);
			//update end
			
			//delete start 
			bw.write(GENERATOR_ENTITY_PREFIX_14 + "<delete id=\"deleteByPK\"  parameterType=\"long\">" + FILE_HH);
			bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + "delete from "+tableItem.getName());
			bw.write(" where "+columnInfoLst.get(0).getColumnName()+"=#{"+Util.convUnderline2Camel(columnInfoLst.get(0).getColumnName())+"}"+FILE_HH);	
			bw.write(GENERATOR_ENTITY_PREFIX_14 + "</delete>" + FILE_HH);
			//delete end
			
			if(deleteFlag){
				bw.write(GENERATOR_ENTITY_PREFIX_14 + "<update id=\"logicDelete\"  parameterType=\"long\">" + FILE_HH);
				bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + "update "+tableItem.getName()+" set isdel=1 ");
				bw.write(" where "+columnInfoLst.get(0).getColumnName()+"=#{"+Util.convUnderline2Camel(columnInfoLst.get(0).getColumnName())+"}"+FILE_HH);	
				bw.write(GENERATOR_ENTITY_PREFIX_14 + "</update>" + FILE_HH);
			}
			
			bw.write("</mapper>" + FILE_HH);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param tableItem
	 * @param columnInfoLst
	 * @author xhb
	 * @date 2016-12-26 
	 * @modified  xhb
	 */
	public static void autoEntity(TableInfoData tableItem, List<ColumnInfoData> columnInfoLst) {
		try {
			 String name2 = convToUpper(tableItem.getName());
			 String desc = tableItem.getDescription();
			 desc = desc == null ? null : desc.replaceAll("\"", "'").replaceAll("\r", "");
			 desc = desc == null ? null : desc.replaceAll("\n", "");
			 
	            File file = new File(FILE_PATH_ENTITY + "/" + name2 + FILE_ENTITY + FILE_HZ);
	            file.createNewFile();
	            FileWriter fw = new FileWriter(file);
	            BufferedWriter bw = new BufferedWriter(fw);
	            bw.write(GENERATOR_ENTITY_PREFIX_1 + FILE_HH + FILE_HH);
	            bw.write("import java.io.Serializable" + GENERATOR_ENTITY_PREFIX_18 + FILE_HH);
	            bw.write("import io.swagger.annotations.ApiModel" + GENERATOR_ENTITY_PREFIX_18 + FILE_HH);
	            bw.write("import io.swagger.annotations.ApiModelProperty" + GENERATOR_ENTITY_PREFIX_18 + FILE_HH);
	            bw.write("/**" + FILE_HH);
	            bw.write(" * " + FILE_HH);
	            bw.write(" * " + tableItem.getDescription() + FILE_HH);
	            bw.write(" */" + FILE_HH);
	            bw.write(GENERATOR_API_PREFIX_6 +"(value=\"" + name2 + "对象\",description=\"" + desc + "\")" + FILE_HH);
	            bw.write(GENERATOR_ENTITY_PREFIX_9 + name2 + FILE_ENTITY + GENERATOR_PREFIX_1 + GENERATOR_PREFIX_3 + GENERATOR_ENTITY_PREFIX_10 + FILE_HH);
	            
	            bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_PREFIX_4 + FILE_HH + FILE_HH);
	            StringBuffer methods = new StringBuffer();
			for (ColumnInfoData columnInfo : columnInfoLst) {
				bw.write("\t//" + columnInfo.getDescription() + FILE_HH);
				/*
				 * if (columnInfo.isPkFlg()) {
				 * bw.write(GENERATOR_ENTITY_PREFIX_11 + FILE_HH); } if
				 * (columnInfo.isAutoAddFlg()) { bw.write("\t@Id" + FILE_HH); }
				 */
				columnInfo.setColumnName(columnInfo.getColumnName().toLowerCase());
				String javaType = getJavaType(columnInfo.getTypeName());
				String value = columnInfo.getDescription();
				
				value = value == null ? null : value.replaceAll("\"", "'").replaceAll("\r", "");
				value = value == null ? null : value.replaceAll("\n", "");
				String name = Util.convUnderline2Camel(columnInfo.getColumnName());
				if("loginFailIp".equals(name)) {
					System.out.println(value.contentEquals("\r"));
					System.out.println(value.contentEquals("\n"));
					System.out.println(value.contentEquals("\r\n"));
				}
				// swagger2注解
				String annotations = GENERATOR_API_PREFIX_1 + "(name=\"" + name + "\",value=\"" + value + "\",dataType=\"" + javaType + "\")";
				
				bw.write(GENERATOR_ENTITY_PREFIX_14 + annotations + FILE_HH);
				bw.write(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_15 + " " + javaType + " " + name + GENERATOR_ENTITY_PREFIX_18 + FILE_HH);
				methods.append(getMethod(name, javaType));
				methods.append(setMethod(name, javaType));
			}
			bw.write(methods + GENERATOR_STR_PREFIX_9);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 *@Description: 
	 *@param tableItem
	 *@param columnInfoLst    
	 *@author chenwei
	 *@date 2018-4-17
	 */
	public static void autoServiceImpl(List<TableInfoData> tableList) {
		try {
			String name3 = "ExportTable";
			
			File file = new File(FILE_PATH_DATA_SERVICEIMPL + "/" + name3 + FILE_SERVICE_IMPL + FILE_HZ);
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(GENERATOR_SERVICE_PREFIX_1 + FILE_HH + FILE_HH);
			bw.write("import java.lang.reflect.Field;" + FILE_HH);
			bw.write("import java.lang.reflect.InvocationTargetException;" + FILE_HH);
			bw.write("import java.lang.reflect.Method;" + FILE_HH);
			bw.write("import java.util.List;" + FILE_HH);
			bw.write("import org.springframework.beans.factory.annotation.Autowired;" + FILE_HH);
			bw.write("import org.springframework.stereotype.Service;" + FILE_HH);
			bw.write("import "+GENERATOR_STR_PREFIX_0+".service.exportService.ExportTableService;" + FILE_HH);
			bw.write("import "+GENERATOR_STR_PREFIX_0+".util.Util;" + FILE_HH);
			for (TableInfoData tableInfo : tableList) {
				String originalName = Util.convUnderline2Camel(tableInfo.getName());
				bw.write("import "+GENERATOR_STR_PREFIX_0+".sqlMapper."+ Character.toUpperCase(originalName.charAt(0))+originalName.substring(1) +"Mapper;" + FILE_HH);
			}
			
			bw.write("/**" + FILE_HH);
			bw.write(" * " + FILE_HH);
			bw.write(" * " + "数据导出公用实现类" + FILE_HH);
			bw.write(" */" + FILE_HH);
			bw.write("@SuppressWarnings(\"unused\")" + FILE_HH);
			bw.write("@Service" + FILE_HH);
			bw.write(GENERATOR_ENTITY_PREFIX_9 + name3 + FILE_SERVICE_IMPL + " " + GENERATOR_PREFIX_1 + " " + name3 + "Service" + GENERATOR_ENTITY_PREFIX_10 + FILE_HH);
			for (TableInfoData tableInfo : tableList) {
				bw.write("@Autowired" + FILE_HH);
				String originalName = Util.convUnderline2Camel(tableInfo.getName());
				bw.write("private "+ Character.toUpperCase(originalName.charAt(0))+originalName.substring(1) +"Mapper " + originalName + "Mapper;" + FILE_HH);
			}
			
			bw.write("\t"+"@Override" + FILE_HH);
			bw.write("\t"+"public List<?> getTableAllData(String tableName)" + GENERATOR_ENTITY_PREFIX_10 + FILE_HH);
			bw.write("\t"+"String originalName = Util.convUnderline2Camel(tableName);" + FILE_HH);
			bw.write("\t"+"String entityName = Character.toUpperCase(originalName.charAt(0)) + originalName.substring(1);" + FILE_HH);
			bw.write("\t"+"String entityPath = \""+GENERATOR_STR_PREFIX_0+".entity.\"+entityName+\"Entity\";" + FILE_HH);
			bw.write("\t"+"String mapperPath = \""+GENERATOR_STR_PREFIX_0+".sqlMapper.\"+entityName+\"Mapper\";" + FILE_HH);
			bw.write("\t"+"try {" + FILE_HH);
			bw.write("\t"+"Class<?> c = Class.forName(entityPath);" + FILE_HH);
			bw.write("\t"+"Class<?> mapperC = Class.forName(mapperPath);" + FILE_HH);
			bw.write("\t"+"Field field = this.getClass().getDeclaredField(originalName + \"Mapper\");" + FILE_HH);
			bw.write("\t"+"Method mothed = mapperC.getDeclaredMethod(\"selectAll\");" + FILE_HH);
			bw.write("\t"+"List<?> dataList = (List<?>) mothed.invoke(field.get(this));" + FILE_HH);
			bw.write("\t"+"return dataList;" + FILE_HH);
			bw.write("\t"+"} catch (ClassNotFoundException e) {" + FILE_HH);
			bw.write("\t"+"e.printStackTrace();" + FILE_HH);
			bw.write("\t"+"} catch (SecurityException e) {" + FILE_HH);
			bw.write("\t"+"e.printStackTrace();" + FILE_HH);
			bw.write("\t"+"} catch (NoSuchMethodException e) {" + FILE_HH);
			bw.write("\t"+"e.printStackTrace();" + FILE_HH);
			bw.write("\t"+"} catch (IllegalAccessException e) {" + FILE_HH);
			bw.write("\t"+"e.printStackTrace();" + FILE_HH);
			bw.write("\t"+"} catch (IllegalArgumentException e) {" + FILE_HH);
			bw.write("\t"+"e.printStackTrace();" + FILE_HH);
			bw.write("\t"+"} catch (InvocationTargetException e) {" + FILE_HH);
			bw.write("\t"+"e.printStackTrace();" + FILE_HH);
			bw.write("\t"+"} catch (NoSuchFieldException e) {" + FILE_HH);
			bw.write("\t"+"e.printStackTrace();" + FILE_HH);
			bw.write(GENERATOR_STR_PREFIX_9 + FILE_HH);
			bw.write("\t"+"return null;" + FILE_HH);
			bw.write("\t"+GENERATOR_STR_PREFIX_9 + FILE_HH);
			bw.write(GENERATOR_STR_PREFIX_9);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void initJavaTypeMap() {
		javaTypeMap.put("CHAR", "String");
		javaTypeMap.put("VARCHAR", "String");
		javaTypeMap.put("BLOB", "java.lang.Byte[]");
		javaTypeMap.put("TEXT", "String");
		javaTypeMap.put("int", "java.lang.Integer");
		javaTypeMap.put("TINYINT", "java.lang.Integer");
		javaTypeMap.put("SMALLINT", "java.lang.Integerg");
		javaTypeMap.put("MEDIUMINT", "java.lang.Integer");
		javaTypeMap.put("BIT", "Boolean");
		javaTypeMap.put("BIGINT", "java.lang.Long");
		javaTypeMap.put("DECIMAL", "Double");
		
		javaTypeMap.put("DATETIME", "java.util.Date");
		javaTypeMap.put("DATE", "java.util.Date");
		
		javaTypeMap.put("IMAGE", "java.lang.Byte[]");
		javaTypeMap.put("FLOAT", "float");
		javaTypeMap.put("REAL", "float");
		javaTypeMap.put("TIMESTAMP", "java.sql.Timestamp");
		javaTypeMap.put("TIME", "java.sql.Time");
		javaTypeMap.put("varbinary", "String");
	}

	public static String getJavaType(String jdbcType) {
		String javaType = javaTypeMap.get(jdbcType);
		if (Util.isEmpty(javaType)) {
			javaType = javaTypeMap.get(jdbcType.toUpperCase());
			if (Util.isEmpty(javaType)) {
				System.err.println("没找到该类型" + jdbcType + "对应的javaType");
			}
		}
		return javaType;
	}

	public static StringBuffer getMethod(String name, String type) {
		StringBuffer tem = new StringBuffer();
		tem.append(FILE_HH);
		tem.append(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_19 + type + GENERATOR_ENTITY_PREFIX_20 + name.substring(0, 1).toUpperCase() + name.substring(1, name.length()) + "()" + GENERATOR_ENTITY_PREFIX_10 + FILE_HH);
		tem.append(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_17 + name + GENERATOR_ENTITY_PREFIX_18 + FILE_HH);
		tem.append(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_STR_PREFIX_9 + FILE_HH + FILE_HH);
		return tem;
	}

	public static StringBuffer setMethod(String name, String type) {
		StringBuffer tem = new StringBuffer();
		tem.append(FILE_HH);
		tem.append(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_19 + "void" + GENERATOR_ENTITY_PREFIX_21 + name.substring(0, 1).toUpperCase() + name.substring(1, name.length()) + "(" + type + " " + name + ")" + GENERATOR_ENTITY_PREFIX_10 + FILE_HH);
		tem.append(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_ENTITY_PREFIX_14  + GENERATOR_ENTITY_PREFIX_22 + name + GENERATOR_ENTITY_PREFIX_23 + name + GENERATOR_ENTITY_PREFIX_18 + FILE_HH);
		tem.append(GENERATOR_ENTITY_PREFIX_14 + GENERATOR_STR_PREFIX_9 + FILE_HH + FILE_HH);
		return tem;
	}
}
