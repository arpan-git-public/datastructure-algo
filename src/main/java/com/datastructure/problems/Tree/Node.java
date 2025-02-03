package com.datastructure.problems.Tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Node {
    @NonNull
    private int key;
    private Node left;
    private Node right;
}
