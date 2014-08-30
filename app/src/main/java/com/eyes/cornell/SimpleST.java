package com.eyes.cornell;

/**
 * Created by redstripe509 on 8/11/14.
 */
public class SimpleST {

    public static class SplayBST<Key extends Comparable<Key>, Value>  {

        public Node root;   // root of the tree

        //Node data
        public class Node {
            public Key key;            // key
            public Value value;        // data
            private Node left;  //left subtree reference
            private Node right;   //right subtree reference

            public Node(Key key, Value value) {
                this.key   = key;
                this.value = value;
            }
        }

        // return value associated with the given key, return null if there is no value
        public Value get(Key key) {
            root = splay(root, key);
            int comp = key.compareTo(root.key);
            if (comp == 0) return root.value;
            else          return null;
        }

        public boolean contains(Key key) {
            return (get(key) != null);
        }

        //splay insertion
        public void put(Key key, Value value) {

            // splay key to root
            if (root == null) {
                root = new Node(key, value);
                return;
            }

            root = splay(root, key);

            //Compare new key to root
            int comp = key.compareTo(root.key);

            // Insert new node at root
            if (comp < 0) {
                Node n = new Node(key, value);
                n.left = root.left;
                n.right = root;
                root.left = null;
                root = n;
            }

            //Insert new node at root
            else if (comp > 0) {
                Node n = new Node(key, value);
                n.right = root.right;
                n.left = root;
                root.right = null;
                root = n;
            }

            // Replace value if duplicate key
            else if (comp == 0) {
                root.value = value;
            }

        }

        //splay deletion

        public void remove(Key key) {
            if (root == null) return; // empty tree

            root = splay(root, key);

            int comp = key.compareTo(root.key);

            if (comp == 0) {
                if (root.left == null) {
                    root = root.right;
                }
                else {
                    Node x = root.right;
                    root = root.left;
                    splay(root, key);
                    root.right = x;
                }
            }

            // else: it wasn't in the tree
        }


        //splay function

        private Node splay(Node h, Key key) {
            if (h == null) return null;

            int comp1 = key.compareTo(h.key);

            if (comp1 < 0) {

                if (h.left == null) {
                    return h;
                }
                int comp2 = key.compareTo(h.left.key);
                if (comp2 < 0) {
                    h.left.left = splay(h.left.left, key);
                    h = rotateRight(h);
                }
                else if (comp2 > 0) {
                    h.left.right = splay(h.left.right, key);
                    if (h.left.right != null)
                        h.left = rotateLeft(h.left);
                }

                if (h.left == null) return h;
                else                return rotateRight(h);
            }

            else if (comp1 > 0) {

                if (h.right == null) {
                    return h;
                }

                int comp2 = key.compareTo(h.right.key);
                if (comp2 < 0) {
                    h.right.left  = splay(h.right.left, key);
                    if (h.right.left != null)
                        h.right = rotateRight(h.right);
                }
                else if (comp2 > 0) {
                    h.right.right = splay(h.right.right, key);
                    h = rotateLeft(h);
                }

                if (h.right == null) return h;
                else                 return rotateLeft(h);
            }

            else return h;
        }


        //additional functions

        public int height() { return height(root); }
        private int height(Node x) {
            if (x == null) return -1;
            return 1 + Math.max(height(x.left), height(x.right));
        }


        public int size() {
            return size(root);
        }

        private int size(Node x) {
            if (x == null) return 0;
            else return (1 + size(x.left) + size(x.right));
        }

        // rotate right
        private Node rotateRight(Node h) {
            Node x = h.left;
            h.left = x.right;
            x.right = h;
            return x;
        }

        // rotate left
        private Node rotateLeft(Node h) {
            Node x = h.right;
            h.right = x.left;
            x.left = h;
            return x;
        }
        }
}
