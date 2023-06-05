package com.hibersql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "tiles")
public class TilesEntity {
    public TilesEntity() {
    }

    public TilesEntity(Integer id, String country, String fabric, String collection, String fabArticle, String tileName, Double hight, Double widght, Double thickness, String measurement, String surface, Integer structure, Integer rettification, String material, Integer tonalVariety, String usageOf, String typeTile, String color1, String color2, String color3, String theme1, String theme2, String theme3, String theme4) {
        this.id = id;
        this.country = country;
        this.fabric = fabric;
        this.collection = collection;
        this.fabArticle = fabArticle;
        this.tileName = tileName;
        this.hight = hight;
        this.widght = widght;
        this.thickness = thickness;
        this.measurement = measurement;
        this.surface = surface;
        this.structure = structure;
        this.rettification = rettification;
        this.material = material;
        this.tonalVariety = tonalVariety;
        this.usageOf = usageOf;
        this.typeTile = typeTile;
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.theme1 = theme1;
        this.theme2 = theme2;
        this.theme3 = theme3;
        this.theme4 = theme4;
    }

    @Id
    @Column(name = "ID", nullable = true)
    private Integer id;
    @Basic
    @Column(name = "Country", nullable = true, length = 255)
    private String country;
    @Basic
    @Column(name = "Fabric", nullable = true, length = 255)
    private String fabric;
    @Basic
    @Column(name = "Collection", nullable = true, length = 255)
    private String collection;
    @Basic
    @Column(name = "Fab_Article", nullable = true, length = 255)
    private String fabArticle;
    @Basic
    @Column(name = "Tile_name", nullable = true, length = 255)
    private String tileName;
    @Basic
    @Column(name = "Hight", nullable = true, precision = 0)
    private Double hight;
    @Basic
    @Column(name = "Widght", nullable = true, precision = 0)
    private Double widght;
    @Basic
    @Column(name = "Thickness", nullable = true, precision = 0)
    private Double thickness;
    @Basic
    @Column(name = "Measurement", nullable = true, length = 255)
    private String measurement;
    @Basic
    @Column(name = "Surface", nullable = true, length = 255)
    private String surface;
    @Basic
    @Column(name = "Structure", nullable = true)
    private Integer structure;
    @Basic
    @Column(name = "Rettification", nullable = true)
    private Integer rettification;
    @Basic
    @Column(name = "Material", nullable = true, length = 255)
    private String material;
    @Basic
    @Column(name = "Tonal_Variety", nullable = true)
    private Integer tonalVariety;
    @Basic
    @Column(name = "Usage_of", nullable = true, length = 255)
    private String usageOf;
    @Basic
    @Column(name = "Type_Tile", nullable = true, length = 255)
    private String typeTile;
    @Basic
    @Column(name = "Color1", nullable = true, length = 255)
    private String color1;
    @Basic
    @Column(name = "Color2", nullable = true, length = 255)
    private String color2;
    @Basic
    @Column(name = "Color3", nullable = true, length = 255)
    private String color3;
    @Basic
    @Column(name = "Theme1", nullable = true, length = 255)
    private String theme1;
    @Basic
    @Column(name = "Theme2", nullable = true, length = 255)
    private String theme2;
    @Basic
    @Column(name = "Theme3", nullable = true, length = 255)
    private String theme3;
    @Basic
    @Column(name = "Theme4", nullable = true, length = 255)
    private String theme4;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TilesEntity that = (TilesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(country, that.country) && Objects.equals(fabric, that.fabric) && Objects.equals(collection, that.collection) && Objects.equals(fabArticle, that.fabArticle) && Objects.equals(tileName, that.tileName) && Objects.equals(hight, that.hight) && Objects.equals(widght, that.widght) && Objects.equals(thickness, that.thickness) && Objects.equals(measurement, that.measurement) && Objects.equals(surface, that.surface) && Objects.equals(structure, that.structure) && Objects.equals(rettification, that.rettification) && Objects.equals(material, that.material) && Objects.equals(tonalVariety, that.tonalVariety) && Objects.equals(usageOf, that.usageOf) && Objects.equals(typeTile, that.typeTile) && Objects.equals(color1, that.color1) && Objects.equals(color2, that.color2) && Objects.equals(color3, that.color3) && Objects.equals(theme1, that.theme1) && Objects.equals(theme2, that.theme2) && Objects.equals(theme3, that.theme3) && Objects.equals(theme4, that.theme4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, fabric, collection, fabArticle, tileName, hight, widght, thickness, measurement, surface, structure, rettification, material, tonalVariety, usageOf, typeTile, color1, color2, color3, theme1, theme2, theme3, theme4);
    }
}
