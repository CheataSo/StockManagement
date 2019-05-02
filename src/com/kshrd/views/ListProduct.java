package com.kshrd.views;


import com.kshrd.models.DTO.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;

public class ListProduct {
        public static int CurrentPage = 0;
        public static int page = 1;
        public static int numberOfRow=1;
        public static int totalPage  ;
        public void display() {
            ArrayList<Product> list = SMSView.products;
            CellStyle Style = new CellStyle(CellStyle.HorizontalAlign.center);
            Table t = new Table(5, BorderStyle.UNICODE_DOUBLE_BOX,
                    ShownBorders.ALL);
            if (SMSView.products.size() == 0) {
                    System.out.println("No record yet!! please input some record!!");
            } else {
                    t.addCell("ID", Style);
                    t.addCell("Name", Style);
                    t.addCell("Unit Price", Style);
                    t.addCell("Quantity", Style);
                    t.addCell("Import Data");
                    for (int i=0;i<5;i++){
                    t.setColumnWidth(i,15,15);
                    }
                    for (int i = CurrentPage; i <CurrentPage + numberOfRow; i++) {


                                    t.addCell(list.get(i).getId() + "", Style);
                                    t.addCell(list.get(i).getName() + "",Style);
                                    t.addCell(list.get(i).getUnitPrice() + "$", Style);
                                    t.addCell(list.get(i).getQty() + "", Style);
                                    t.addCell(list.get(i).getImportDate() + "",Style);

                    }

                    if (list.size()%Pagination.row==0){
                            totalPage = (SMSView.products.size() / Pagination.row);
                    }
                    else {
                            totalPage = (SMSView.products.size() / Pagination.row)+1;
                    }
                    Table tp = new Table(2, BorderStyle.DESIGN_CURTAIN_HEAVY,
                            ShownBorders.SURROUND);
                    tp.setColumnWidth(0, 60, 60);
                    tp.addCell("Page : " + page + " of " + totalPage);
                    tp.addCell("Total Record : " + list.size());
                    System.out.println(t.render());
                    System.out.println(tp.render());
            }
    }
}



