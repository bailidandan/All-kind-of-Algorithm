package test1;

public class RBTree<T extends Comparable<T>> {

    public static void main(String[] args) {

        ///*
        int[] testNum = new int[]{15, 1, 3, 6, 8, 20, 22, 43, 67};
        
        
//        RBTree<Integer> fuck = new RBTree<Integer>();
//        for (int i = 0; i < testNum.length; i++) {
//          fuck.insertNode(testNum[i]);
//        }
//        System.out.println(fuck.root.data);
        //*/

        RBTree<Character> fuck = new RBTree<Character>();
        fuck.insertNode('F');
        fuck.insertNode('G');
        fuck.insertNode('D');
        fuck.insertNode('B');
        fuck.insertNode('C');
        System.out.println(fuck.root.data);
       
    }

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private TreeNode<T> root;

    /**
     * ����һ���µĽڵ㣬������Ϻ���Ϻ��������
     *
     * @param data  ��Ҫ���������
     */
    public void insertNode(T data) {
        TreeNode<T> curr;
        TreeNode<T> parent = toTargetParent(data);//��ô��data�ĸ��ڵ�
        
        
        if (parent == null) {
            curr = root = new TreeNode<T>(data);
        } else {
            if (data.compareTo(parent.data) < 0) {
                curr = parent.left = new TreeNode<T>(data);
                curr.parent = parent;
            } else {
                curr = parent.right = new TreeNode<T>(data);
                curr.parent = parent;
            }
        }
        
        fixupTree(curr);//����һ������
    }

    
    /**
     * �޸�������Ĳ�ƽ��״̬
     *
     * @param node  �����ڵ�
     */
    private void fixupTree(TreeNode node) {
        TreeNode parent = null, grandParent = null;
        boolean parentColor = false, uncleColor = false;
        
        if (node != root) {
            parent = node.parent;
            grandParent = parent.parent;
            parentColor = parent.color;
            uncleColor = getUncleColor(node);
        }
        //���ڵ�Ϊ�ձ�ʾ��Ϊ���ڵ�
        if (parent == null && node.color == RED) {//����ող���Ľ�㲻Ϊ��
            node.color = BLACK;
        } else if (parentColor == RED && uncleColor == RED) {
            changeColor(grandParent);
            //�ٴ��жϸ��ڵ��Ƿ�����Ҫ��
            fixupTree(grandParent);//��������һֱ�������Ϊֹ
        } else if (parentColor == RED && uncleColor == BLACK) {//���������������ļ����ʱ��
            dispatchRotation(grandParent, parent, node);
        }
    }

    /**
     * �ж������������������LL��LR��RR��RL��ʹ����ȷ����ת
     *
     * @param grandParent   �游�ڵ�
     * @param parent    ���ڵ�
     * @param child     �����ڵ�
     */
    private void dispatchRotation(TreeNode grandParent, TreeNode parent, TreeNode child) {
        if (grandParent.left == parent) {
            if (parent.left == child) {
                rightRotation(grandParent);//��үү�����ǰְ֣��ְֵ����Ǻ���-��ֱ������
            } else {
                leftRotation(parent);//��үү�����ǰְ֣��ְֵ����Ǻ���-������Ȼ�����һ����үү����
                rightRotation(grandParent);
            }
        } else {
            if (parent.left == child) {
                rightRotation(parent);//��үү�����ǰְ֣��ְֵ����Ǻ���-������Ȼ�����һ����үү����
                leftRotation(grandParent);
            } else {
                leftRotation(grandParent);//��үү�����ǰְ֣��ְֵ����Ǻ���-��ֱ������
            }
        }
    }


    /**
     *  �ı��游�ڵ��Լ������ӽڵ����ɫ
     *
     * @param grandParent   ���������ڵ���游
     */
    private void changeColor(TreeNode grandParent) {
        grandParent.color = RED;
        if (grandParent.left != null) {
            grandParent.left.color = BLACK;
        }
        if (grandParent.right != null) {
            grandParent.right.color = BLACK;
        }
    }

    /**
     * ��������ڵ����ɫ
     *
     * @param node һ���ڵ�
     * @return ������ڵ����ɫ
     */
    private boolean getUncleColor(TreeNode node) {
        TreeNode parent = node.parent;
        //�����ǰ�����游�ǿյģ�˵�����丸�ڵ��Ǹ��ڵ�
        return getBrotherColor(parent.parent == null ? node : parent);
    }

    /**
     * �����ֵܽڵ����ɫ
     *
     * @param child ����ڵ�
     * @return �����ֵܽڵ����ɫ
     */
    private boolean getBrotherColor(TreeNode child) {
        TreeNode parent = child.parent;
        if (parent.left == child && parent.right != null) {
            return parent.right.color;
        } else if (parent.right == child && parent.left != null) {
            return parent.left.color;
        } else {
            return BLACK;
        }
    }

    /**
     *  ������Ľڵ�����ӽڵ�����Ϊ�µĸ��ڵ㣬����ڵ㽵Ϊ�����ӽڵ�
     *  ע����ɫ�����ڵ���Ҫ�������Ҫ�������ڵ�����ӽڵ㣬��Ϊ���Ѿ��������˸��ڵ��ˡ�
     * @param curr  һ���ڵ�
     */
    private void leftRotation(TreeNode curr) {
        TreeNode tParent = curr.right;
        tParent.parent = curr.parent;
        tParent.color = BLACK;
        //�¸��ڵ�����ӽڵ�,���ڴ���ڵ���ұ�
        curr.right = tParent.left;
        if (tParent.left != null) {
            tParent.left.parent = curr;
        }
        //��Ϊ�ӽڵ�ǰ����������
        curr.color = RED;
        curr.parent = tParent;
        tParent.left = curr;
        setChild(curr, tParent);
    }

    /**
     *  ������Ľڵ�����ӽڵ�����Ϊ�µĸ��ڵ㣬����ڵ㽵Ϊ�����ӽڵ�
     *  ע����ɫ�����ڵ���Ҫ�������Ҫ�������ڵ�����ӽڵ㣬��Ϊ���Ѿ��������˸��ڵ��ˡ�
     * @param curr  һ���ڵ�
     */
    private void rightRotation(TreeNode curr) {
        //�µĸ��ڵ�
        TreeNode tParent = curr.left;//������������������
        tParent.parent = curr.parent;
        tParent.color = BLACK;
        
        
        //�¸��ڵ�����ӽڵ�,���ڴ���ڵ�����
        
        curr.left = tParent.right;//���������ĺ���ת���������ӣ����ϸ�ͬʱ���
        if (tParent.right != null) {
            tParent.right.parent = curr;
        }
        
        
        //����ڵ㽵Ϊ�ӽڵ�ǰ����������
        curr.color = RED;
        curr.parent = tParent;//���������ĸ�����֤��֮ǰû�����
        tParent.right = curr;
        setChild(curr, tParent);
    }

    /**
     * ʹ��ת��������Ч
     *
     * @param roNode    ����ת�Ľڵ�
     * @param newParent ����ת֮��ĸ��ڵ�
     */
    private void setChild(TreeNode roNode, TreeNode newParent) {//���򵹵Ľ�㣬����Ľ��
        TreeNode roNodeParent = newParent.parent;
        if (roNodeParent == null) {
            root = newParent;
        } else if (roNodeParent.left == roNode) {//��Ȼ�����²�������˸����������ϲ�������û�и�
            roNodeParent.left = newParent;
        } else {
            roNodeParent.right = newParent;
        }
    }

    /**
     *  ����data���λ�õĸ��ڵ㴦
     * @param data  ���ڶԱȵ�����
     * @return  data�ɴ�Ŵ��ĸ��ڵ�
     */
    private TreeNode<T> toTargetParent(T data) {//�������ֵĴ�С������룬����Ҫ���ҵ����ʴ�С��λ�� 
        TreeNode<T> curr = root;
        TreeNode<T> parent = root;
        
        //�����������;����
        while (curr != null) {//һֱ��������Ҷ�ӽ��ʱ��Ҳ����˵������ĸ����ĺ����������п�ȱλ�������������ݵ�
            parent = curr;
            if (data.compareTo(curr.data) < 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return parent;
    }

    /**
     * �ڲ��ڵ�
     */
    static class TreeNode<T extends Comparable<T>> {
        T data;
        boolean color;
        //αɾ��
        boolean isDeleted;
        TreeNode<T> left;
        TreeNode<T> right;
        TreeNode<T> parent;

        TreeNode(T data, boolean color) {
            this.data = data;
            this.color = color;
        }

        TreeNode(T data) {
            this.data = data;
            this.color = RED;
        }
    }
}