package generator;

import generator.data.ColumnInfoData;
import generator.data.TableInfoData;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface IGeneratorMapper {
    @Select("select table_schema as dataSourceName, table_name as name, table_comment as description from information_schema.tables where table_schema='happyjob' and table_type='base table'")
    List<TableInfoData> selTableNmList();

    @Select("select column_name as columnName,column_comment as description,data_type as typeName from information_schema.columns where table_schema='happyjob' and table_name=#{tableName}")
    List<ColumnInfoData> selTblColumnInfoList(String tableName);
}
