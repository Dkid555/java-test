package sql;

import java.util.ArrayList;

public class Query implements TileCsv {
    private String qs;
    @Override
    public String ID(ArrayList<String[]> data, int i){
        return data.get(i)[0];
    }
    @Override
    public String Country(ArrayList<String[]> data, int i){
        return "'" + data.get(i)[1] + "'";
    }

    @Override
    public String Fabric(ArrayList<String[]> data, int i) {
        return "'" + data.get(i)[2] + "'";
    }

    @Override
    public String Collection(ArrayList<String[]> data, int i) {
        return "'" + data.get(i)[3] + "'";
    }

    @Override
    public String Fab_Article(ArrayList<String[]> data, int i) {
        return "'" + data.get(i)[4] + "'";
    }

    @Override
    public String Tile_name(ArrayList<String[]> data, int i) {
        return "'" + data.get(i)[5] + "'";
    }

    @Override
    public String Hight(ArrayList<String[]> data, int i) {
        return data.get(i)[6];
    }

    @Override
    public String Widght(ArrayList<String[]> data, int i) {
        return data.get(i)[7];
    }

    @Override
    public String Thickness(ArrayList<String[]> data, int i) {
        return data.get(i)[8];
    }

    @Override
    public String Measurement(ArrayList<String[]> data, int i) {
        return "'" + data.get(i)[9] + "'";
    }

    @Override
    public String Surface(ArrayList<String[]> data, int i) {
        return "'" + data.get(i)[10] + "'";
    }

    @Override
    public String Structure(ArrayList<String[]> data, int i) {
        return data.get(i)[11] ;
    }

    @Override
    public String Rettification(ArrayList<String[]> data, int i) {
        return data.get(i)[12] ;
    }

    @Override
    public String Material(ArrayList<String[]> data, int i) {
        return "'" + data.get(i)[13] + "'";
    }

    @Override
    public String Tonal_Variety(ArrayList<String[]> data, int i) {
        return data.get(i)[14];
    }

    @Override
    public String Usage_of(ArrayList<String[]> data, int i) {
        return "'" + data.get(i)[15] + "'";
    }

    @Override
    public String Type_Tile(ArrayList<String[]> data, int i) {
        return "'" + data.get(i)[16] + "'";
    }

    @Override
    public String Color1(ArrayList<String[]> data, int i) {
        return "'" + data.get(i)[17] + "'";
    }

    @Override
    public String Color2(ArrayList<String[]> data, int i) {
        return "'" + data.get(i)[18] + "'";
    }

    @Override
    public String Color3(ArrayList<String[]> data, int i) {
        return "'" + data.get(i)[19] + "'";
    }

    @Override
    public String Theme1(ArrayList<String[]> data, int i) {
        return "'" + data.get(i)[20] + "'";
    }

    @Override
    public String Theme2(ArrayList<String[]> data, int i) {
        return "'" + data.get(i)[21] + "'";
    }

    @Override
    public String Theme3(ArrayList<String[]> data, int i) {
        return "'" + data.get(i)[22] + "'";
    }

    @Override
    public String Theme4(ArrayList<String[]> data, int i) {
        return "'" + data.get(i)[23] + "'";
    }

    //String Fabric;

    public void Create(ReadCSV data, int i) {
        this.qs = "insert into Tiles values("
                + ID(data.file, i) + ","
                + Country(data.file, i) + ","
                + Fabric(data.file, i) + ","
                + Collection(data.file, i) + ","
                + Fab_Article(data.file, i) + ","
                + Tile_name(data.file, i) + ","
                + Hight(data.file, i) + ","
                + Widght(data.file, i) + ","
                + Thickness(data.file, i) + ","
                + Measurement(data.file, i) + ","
                + Surface(data.file, i) + ","
                + Structure(data.file, i) + ","
                + Rettification(data.file, i) + ","
                + Material(data.file, i) + ","
                + Tonal_Variety(data.file, i) + ","
                + Usage_of(data.file, i) + ","
                + Type_Tile(data.file, i) + ","
                + Color1(data.file, i) + ","
                + Color2(data.file, i) + ","
                + Color3(data.file, i) + ","
                + Theme1(data.file, i) + ","
                + Theme2(data.file, i) + ","
                + Theme3(data.file, i) + ","
                + Theme4(data.file, i) + ")";
    }

    public String getStr() {
        return this.qs;
    }
}



