package com.datastructure.problems.Tree;

public class BinarySearchTree {

    public Node insertElement(Node rootNode, int key) {
        if (rootNode == null) {
            return new Node(key, null, null);
        }

        if (rootNode.getKey() < key) {
            rootNode.setRight(insertElement(rootNode.getRight(), key));
        } else {
            rootNode.setLeft(insertElement(rootNode.getLeft(), key));
        }
        return rootNode;
    }

    public boolean existElementInBST( Node rootNode, int searchElement) {
         if(rootNode.getKey() == searchElement)
             return true;

         if(rootNode.getKey() > searchElement ){
             return existElementInBST(rootNode.getLeft(),searchElement);
         } else {
             return existElementInBST(rootNode.getRight(),searchElement);
         }
    }

    public Node deleteElement(Node rootNode, int deleteElement) {
        if(rootNode == null) return rootNode;

        if(deleteElement < rootNode.getKey()) {
            rootNode.setLeft(deleteElement(rootNode.getLeft(),deleteElement));
        } else if(deleteElement > rootNode.getKey()) {
            rootNode.setRight(deleteElement(rootNode.getRight(),deleteElement));
        } else {
            // 1. no child
            if(rootNode.getLeft() == null && rootNode.getRight() == null) {
                rootNode = null;
            }
            //2. one child (left or right)
            else if(rootNode.getLeft() == null) {
                rootNode = rootNode.getRight();
            } else if(rootNode.getRight() == null) {
                rootNode = rootNode.getLeft();
            }
            //3. two children (find minimum from right or find maximum form left)
            else {
                //find minimum from right;
                Node minNode = findMin(rootNode.getRight());
                rootNode.setKey( minNode.getKey());
                rootNode.setRight(deleteElement(rootNode.getRight(), minNode.getKey()));
            }
        }
        return  rootNode;
    }

    Node findMin(Node root){
       if(root.getLeft() != null)
           return findMin(root.getLeft());
       else
           return root;
    }

    public void inorder(Node root) {
        if(root != null) {
            inorder(root.getLeft());
            System.out.print(root.getKey() + " ");
            inorder(root.getRight());
        }
    }

    public int height(Node root) {
        int count = 1;
        int leftHeight = calculate(root.getLeft(),++count);
        count = 1;
        int rightHeight = calculate(root.getRight(),++count);

        return Math.max(leftHeight,rightHeight);
    }

    private int calculate(Node root,int count) {
        if(root.getLeft() != null) {
            calculate(root.getLeft(),++count);
        }
        if(root.getRight() != null) {
            calculate(root.getRight(),++count);
        }
        return count;
    }


    public static void main(String[] args) {
//        var root = new Node(10);
//        root.setLeft(new Node(5));
//        root.setRight(new Node(15));
//        root.getRight().setLeft(new Node(12));
//        root.getRight().setRight(new Node(18));


        var bs = new BinarySearchTree();
        Node root = bs.insertElement(null,10);
        bs.insertElement(root,5);
        bs.insertElement(root,15);
        bs.insertElement(root,12);
        bs.insertElement(root, 18);
        bs.insertElement(root, 25);
        bs.inorder(root);
//        int x = 15;
//        root = bs.deleteElement(root, x);
//        System.out.println("");
//        bs.inorder(root);
//        int y = 18;
//        root = bs.deleteElement(root, y);
//        System.out.println("");
//        bs.inorder(root);
        System.out.println("");
        System.out.println(bs.height(root));
    }
 }

