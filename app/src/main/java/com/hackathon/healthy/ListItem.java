package com.hackathon.healthy;

import android.widget.TextView;

/**
 * Created by martinhocorreiamussamba on 23/11/18.
 */

public class ListItem {

   String head;
    String desc;

    public ListItem(String head, String desc) {
        this.head = head;
        this.desc = desc;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }
}
