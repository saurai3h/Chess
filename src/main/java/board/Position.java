package board;

public class Position {
    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    private Integer row;
    private Integer column;

    public Position(int row, int column)    {
        setRow(row);
        setColumn(column);
    }
}
