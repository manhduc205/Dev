/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bai_9;

/**
 *
 * @author ADMIN
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DanhMucSanPham implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<SanPham> items;

    public DanhMucSanPham() {
        items = new ArrayList<>();
    }

    public void add(SanPham sp) { items.add(sp); }
    public void remove(SanPham sp) { items.remove(sp); }
    public List<SanPham> getItems() { return items; }

    @Override
    public String toString() {
        return "Danh muc co " + items.size() + " san pham";
    }
}

