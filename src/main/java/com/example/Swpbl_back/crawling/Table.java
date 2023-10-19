package com.example.Swpbl_back.crawling;

public class Table {
    public static void main(String[] args) {
        TrainCrawling tc = new TrainCrawling();
        for (int i = 0; i < tc.size; i++) {
            System.out.println(tc.DataTable[i][0] + tc.DataTable[i][1] + tc.DataTable[i][2] + tc.DataTable[i][3]);
        }
    }
}
