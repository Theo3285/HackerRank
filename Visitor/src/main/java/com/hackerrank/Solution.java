package com.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static Tree solve() {

        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        sc.nextLine();
        String values = sc.nextLine();
        String colors = sc.nextLine();
        List<String> edges = new ArrayList<>();

        for (int i = 0; i < nodes-1; i++) {
            edges.add(sc.nextLine());
        }
        sc.close();

        return TreeBuilder.some(nodes)
                .with(values)
                .paintedIn(colors)
                .and(edges)
                .build();
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
