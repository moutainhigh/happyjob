package generator.data;

public class ColumnInfoData {
    // 字段类型名称
	private String typeName;

	// 字段名称
	private String columnName;

	// 是否允许为空
	private boolean canNullFlg;

	// 是否为主键
	private boolean isPkFlg;

	// 是否为自动增长
	private boolean isAutoAddFlg;

	// 字段长度
	private String length;

	// 字段描述
	private String description;

	public String getTypeName() {
		return typeName;
	}

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCanNullFlg() {
        return canNullFlg;
    }

    public void setCanNullFlg(boolean canNullFlg) {
        this.canNullFlg = canNullFlg;
    }

    public boolean isPkFlg() {
        return isPkFlg;
    }

    public void setPkFlg(boolean isPkFlg) {
        this.isPkFlg = isPkFlg;
    }

    public boolean isAutoAddFlg() {
        return isAutoAddFlg;
    }

    public void setAutoAddFlg(boolean isAutoAddFlg) {
        this.isAutoAddFlg = isAutoAddFlg;
    }

}
