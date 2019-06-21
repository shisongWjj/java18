package com.ss.design.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * CourseCatalog
 *
 * @author shisong
 * @date 2019/1/16
 */
public class CourseCatalog extends CatalogComponent {

    private String name;
    private List<CatalogComponent> items = new ArrayList<>();
    private Integer level;

    public CourseCatalog(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        items.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
        items.remove(catalogComponent);
    }

    @Override
    public void print() {
        //这样输出 看不出层级
        /*System.out.println(this.name);
        for (CatalogComponent item : items) {
            System.out.print("  ");
            item.print();
        }*/

        System.out.println(this.name);
        for (CatalogComponent item : items) {
            for (int i = 0; i < this.level; i++) {
                System.out.print("  ");
            }
            item.print();
        }
    }
}
