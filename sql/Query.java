package sql;

public class Query {
    private String qs;

    public void Create(ReadCSV data, int i) {
        this.qs = "insert into Tiles values(" + data.file.get(i)[0]
                + ",'" + data.file.get(i)[1] + "','" //ID int
                + data.file.get(i)[2] + "','" //Country varchar
                + data.file.get(i)[3] + "','" //Fabric varchar
                + data.file.get(i)[4] + "','" //Collection varchar
                + data.file.get(i)[5] + "'," //Fab_Article `varchar
                + data.file.get(i)[6] + "," //Tile_Name varchar
                + data.file.get(i)[7] + "," //
                + data.file.get(i)[8] + ",'" //
                + data.file.get(i)[9] + "','"
                + data.file.get(i)[10] + "',"
                + data.file.get(i)[11] + ","
                + data.file.get(i)[12] + ",'"
                + data.file.get(i)[13] + "',"
                + data.file.get(i)[14] + ",'"
                + data.file.get(i)[15] + "','"
                + data.file.get(i)[16] + "','"
                + data.file.get(i)[17] + "','"
                + data.file.get(i)[18] + "','"
                + data.file.get(i)[19] + "','"
                + data.file.get(i)[20] + "','"
                + data.file.get(i)[21] + "','"
                + data.file.get(i)[22] + "','"
                + data.file.get(i)[23] + "')";
    }

    public String getStr() {
        return this.qs;
    }
}
