package com.example.iii.store;

import java.util.ArrayList;

/**
 * Created by iii on 2017/11/30.
 */

public class productlist {
    private ArrayList<products> list=new ArrayList<>();
    private int position=0;

    public productlist(){
        list.add(new products("錫蘭紅茶",25));
        list.add(new products("茉莉綠茶",25));
        list.add(new products("凍頂烏龍茶",25));
        list.add(new products("深焙普洱茶",25));
        list.add(new products("波霸奶茶",35));
        list.add(new products("布丁奶茶",45));
        list.add(new products("四季青茶",25));
        list.add(new products("文山青茶",25));
        list.add(new products("珍珠紅茶拿鐵",55));
        list.add(new products("可可鮮奶茶",55));
        list.add(new products("紅豆奶茶",50));
        list.add(new products("多多綠茶",35));
        list.add(new products("冬瓜檸檬",35));
        list.add(new products("甘蔗青茶",25));
    }
    public products[] getall(){
        return list.toArray(new products[list.size()]);
    }

}
