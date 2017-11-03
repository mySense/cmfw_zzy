package com.baizhi.zzy.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
public class Menu {
    private String id;
    private String title;
    private String iconCls;
    private String selected;
    private String href;
    private List<Menu> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Menu() {
    }

    public Menu(String id, String title, String iconCls, String selected, String href, List<Menu> children) {
        this.id = id;
        this.title = title;
        this.iconCls = iconCls;
        this.selected = selected;
        this.href = href;
        this.children = children;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", selected='" + selected + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
