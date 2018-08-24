package com.hackerrank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TreeFeature {

    @Mock
    private Console console;

    @Test
    public void print_tree_result() {
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

        verify(console).printLine("24");
        verify(console).printLine("40");
        verify(console).printLine("15");
    }

    private Tree solve() {
        int nodes = 5;
        String values = "4 7 2 5 12";
        String colors = "0 1 0 0 1";
        List<String> edges = Arrays.asList("1 2", "1 3", "3 4", "3 5");

        return TreeBuilder.some(nodes)
                .with(values)
                .paintedIn(colors)
                .and(edges)
                .build();
    }

}
