package sql;

import java.util.ArrayList;

public interface TileCsv {
    String ID(ArrayList<String[]> data, int i);

    String Country(ArrayList<String[]> data, int i);

    String Fabric(ArrayList<String[]> data, int i);

    String Collection(ArrayList<String[]> data, int i);

    String Fab_Article(ArrayList<String[]> data, int i);

    String Tile_name(ArrayList<String[]> data, int i);

    String Hight(ArrayList<String[]> data, int i);

    String Widght(ArrayList<String[]> data, int i);

    String Thickness(ArrayList<String[]> data, int i);

    String Measurement(ArrayList<String[]> data, int i);

    String Surface(ArrayList<String[]> data, int i);

    String Structure(ArrayList<String[]> data, int i);

    String Rettification(ArrayList<String[]> data, int i);

    String Material(ArrayList<String[]> data, int i);

    String Tonal_Variety(ArrayList<String[]> data, int i);

    String Usage_of(ArrayList<String[]> data, int i);

    String Type_Tile(ArrayList<String[]> data, int i);

    String Color1(ArrayList<String[]> data, int i);

    String Color2(ArrayList<String[]> data, int i);

    String Color3(ArrayList<String[]> data, int i);

    String Theme1(ArrayList<String[]> data, int i);

    String Theme2(ArrayList<String[]> data, int i);

    String Theme3(ArrayList<String[]> data, int i);

    String Theme4(ArrayList<String[]> data, int i);

}