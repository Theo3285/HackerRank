package com.hackerrank;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TreeBuilderShould {

    @Test
    public void create_the_root_as_treenode() {
        int nodes = 1;
        String values = "4";
        String colors = "0";

        Tree root = TreeBuilder.some(nodes)
                .with(values)
                .paintedIn(colors)
                .build();

        assertTrue(root.isNode());
    }

    @Test
    public void create_a_complete_tree() {
        int nodes = 5;
        String values = "4 7 2 5 12";
        String colors = "0 1 0 0 1";
        List<String> edges = Arrays.asList("1 2", "1 3", "3 4", "3 5");

        Tree root = TreeBuilder.some(nodes)
                .with(values)
                .paintedIn(colors)
                .and(edges)
                .build();

        assertTrue(root.isNode());
        assertThat(root.size(), is(2));
        assertThat(root.getValue(), is(4));
        assertThat(root.getColor(), is(Color.RED));
        assertThat(root.getDepth(), is(0));

        List<Tree> rootChildren = root.all();
        Tree leaf2 = (Tree) rootChildren.get(0);
        assertFalse(leaf2.isNode());
        assertThat(leaf2.getValue(), is(7));
        assertThat(leaf2.getColor(), is(Color.GREEN));
        assertThat(leaf2.getDepth(), is(2));

        Tree node3 = (Tree) rootChildren.get(1);
        assertTrue(node3.isNode());
        assertThat(node3.size(), is(2));
        assertThat(node3.getValue(), is(2));
        assertThat(node3.getColor(), is(Color.RED));
        assertThat(node3.getDepth(), is(3));

        List<Tree> node3Children = node3.all();
        Tree leaf4 = (Tree) node3Children.get(0);
        assertFalse(leaf4.isNode());
        assertThat(leaf4.getValue(), is(5));
        assertThat(leaf4.getColor(), is(Color.RED));
        assertThat(leaf4.getDepth(), is(4));

        Tree leaf5 = (Tree) node3Children.get(1);
        assertFalse(leaf5.isNode());
        assertThat(leaf5.getValue(), is(12));
        assertThat(leaf5.getColor(), is(Color.GREEN));
        assertThat(leaf5.getDepth(), is(5));
    }
}