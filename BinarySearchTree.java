public class BinarySearchTree {
    // Complete this class
    BinaryTreeNode<Integer> root;

    public boolean sHelp(int e, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return false;
        }

        if (root.data == e) {
            return true;
        }
        if (e < root.data) {
            return sHelp(e, root.left);
        } else {
            return sHelp(e, root.right);
        }

    }

    public BinaryTreeNode<Integer> iHelp(int e, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new BinaryTreeNode<Integer>(e);
        }

        if (e < root.data) {
            root.left = iHelp(e, root.left);
            return root;
        } else {

            root.right = iHelp(e, root.right);
            return root;
        }

    }

    public void printTree(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        System.out.print(String.valueOf(root.data) + ':');
        if (root.left != null) {
            System.out.print("L:" + String.valueOf(root.left.data) + ",");

        }
        if (root.right != null) {
            System.out.print("R:" + String.valueOf(root.right.data));
        }
        System.out.println();

        printTree(root.left);
        printTree(root.right);

    }

    public BinaryTreeNode<Integer> deleteData(int e, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return root;
        }

        if (root.data == e) {

            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            } else {

                int a = Min(root.right);

                root.right = deleteData(a, root.right);
                root.data = a;
                return root;

            }

        }

        if (e < root.data) {
            root.left = deleteData(e, root.left);
            return root;
        } else {
            root.right = deleteData(e, root.right);
            return root;

        }

    }

    private Pair<Pair<Integer, Integer>, BinaryTreeNode<Integer>> findImbalanceNode(BinaryTreeNode<Integer> root,
            int e) {
        int l, r, bf;

        if (root == null) {
            Pair<Integer, Integer> pair = new Pair<Integer, Integer>();
            pair.first = 0;
            pair.second = 0;
            Pair<Pair<Integer, Integer>, BinaryTreeNode<Integer>> ans = new Pair<Pair<Integer, Integer>, BinaryTreeNode<Integer>>();
            ans.first = pair;
            return ans;
        }

        Pair<Pair<Integer, Integer>, BinaryTreeNode<Integer>> left = findImbalanceNode(root.left, e);
        if (left.second != null) {
            l = left.first.first;
            r = left.first.second;
            bf = l - r;
            root.left = balance(left.second, bf, e);

            return left;
        }

        Pair<Pair<Integer, Integer>, BinaryTreeNode<Integer>> right = findImbalanceNode(root.right, e);
        if (right.second != null) {
            l = right.first.first;
            r = right.first.second;
            bf = l - r;
            root.right = balance(right.second, bf, e);

            return right;
        }

        Pair<Integer, Integer> ans1 = new Pair<Integer, Integer>();
        Pair<Pair<Integer, Integer>, BinaryTreeNode<Integer>> ans = new Pair<Pair<Integer, Integer>, BinaryTreeNode<Integer>>();

        ans1.first = 1 + Math.max(left.first.first, left.first.second);
        ans1.second = 1 + Math.max(right.first.first, right.first.second);
        bf = ans1.first - ans1.second;
        if (Math.abs(bf) > 1) {
            ans.first = ans1;
            ans.second = root;

        } else {
            ans.first = ans1;

        }

        return ans;

    }

    public BinaryTreeNode<Integer> balance(BinaryTreeNode<Integer> node, int bf, int e) {

        if (bf < 0) {
            System.out.println("bf<0");
            if (node.right.data > e) {
                System.out.println("right-left");
                BinaryTreeNode<Integer> nodeX = rightRotation(node.right);
                node.right = nodeX;
                BinaryTreeNode<Integer> nodeY = leftRotation(node);
                return nodeY;
            } else {
                System.out.println("normal left");
                return leftRotation(node);

            }
        } else if (bf > 0) {
            System.out.println("bf>0");
            if (node.left.data < e) {
                System.out.println("left-right");
                BinaryTreeNode<Integer> nodeX = leftRotation(node.left);
                node.left = nodeX;
                BinaryTreeNode<Integer> nodeY = rightRotation(node);
                return nodeY;

            } else {
                System.out.println("normal right");
                return rightRotation(node);

            }
        }
        return null;

    }

    public static BinaryTreeNode<Integer> rightRotation(BinaryTreeNode<Integer> node) {
        BinaryTreeNode<Integer> newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        return newRoot;

    }

    public static BinaryTreeNode<Integer> leftRotation(BinaryTreeNode<Integer> node) {
        BinaryTreeNode<Integer> newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        return newRoot;
    }

    public boolean search(int e) {

        return sHelp(e, root);
    }

    public void insertData(int e) {
        this.root = iHelp(e, root);

        Pair<Pair<Integer, Integer>, BinaryTreeNode<Integer>> pair = findImbalanceNode(root, e);
        // System.out.println(pair.second.data);
        if (pair.second != null && pair.second.data == root.data) {
            System.out.println("inside if");
            int bf = pair.first.first - pair.first.second;
            root = balance(root, bf, e);

        }

    }

    public void deleteData(int e) {
        this.root = deleteData(e, root);
    }

    public void printTree() {
        printTree(root);
    }

    public static int Max(BinaryTreeNode<Integer> root) {
        if (root.left == null && root.right == null) {
            return root.data;
        }

        if (root.left == null) {
            if (root.data > Max(root.right)) {
                return root.data;
            } else
                return Max(root.right);
        } else if (root.right == null) {
            if (root.data > Max(root.left)) {
                return root.data;
            } else
                return Max(root.left);
        } else {

            return Math.max(root.data, Math.max(Max(root.left), Max(root.right)));

        }

    }

    public static int Min(BinaryTreeNode<Integer> root) {

        if (root.left == null && root.right == null) {
            return root.data;
        }

        if (root.left == null) {
            if (root.data < Min(root.right)) {
                return root.data;
            } else
                return Min(root.right);
        } else if (root.right == null) {
            if (root.data < Max(root.left)) {
                return root.data;
            } else
                return Min(root.left);
        } else {

            return Math.min(root.data, Math.min(Min(root.left), Min(root.right)));

        }
    }
}
