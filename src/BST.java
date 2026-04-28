import java.util.Iterator;
import java.util.Stack;
public class BST<K extends Comparable<K>,V> implements Iterable<BST.Entry<K,V>>{
    private Node root;
    private int size;
    private class Node{
        private K key;
        private V val;
        private Node left;
        private Node right;
        public Node(K key,V val){this.key=key;this.val=val;}
    }
    public static class Entry<K,V>{
        private K key;
        private V value;
        public Entry(K key,V value){this.key=key;this.value=value;}
        public K getKey(){return key;}
        public V getValue(){return value;}
    }
    public void put(K key,V val){
        if(root==null){root=new Node(key,val);size++;return;}
        Node current=root;
        while(true){
            int cmp=key.compareTo(current.key);
            if(cmp<0){
                if(current.left==null){current.left=new Node(key,val);size++;return;}
                current=current.left;
            }else if(cmp>0){
                if(current.right==null){current.right=new Node(key,val);size++;return;}
                current=current.right;
            }else{current.val=val;return;}
        }
    }
    public V get(K key){
        Node current=root;
        while(current!=null){
            int cmp=key.compareTo(current.key);
            if(cmp<0)current=current.left;
            else if(cmp>0)current=current.right;
            else return current.val;
        }
        return null;
    }
    public void delete(K key){
        Node parent=null;
        Node current=root;
        while(current!=null&&!current.key.equals(key)){
            parent=current;
            if(key.compareTo(current.key)<0)current=current.left;
            else current=current.right;
        }
        if(current==null)return;
        if(current.left!=null&&current.right!=null){
            Node successorParent=current;
            Node successor=current.right;
            while(successor.left!=null){
                successorParent=successor;
                successor=successor.left;
            }
            current.key=successor.key;
            current.val=successor.val;
            parent=successorParent;
            current=successor;
        }
        Node child;
        if(current.left!=null)child=current.left;
        else child=current.right;
        if(parent==null)root=child;
        else if(parent.left==current)parent.left=child;
        else parent.right=child;
        size--;
    }
    public int size(){return size;}
    @Override
    public Iterator<Entry<K,V>> iterator(){
        return new Iterator<Entry<K,V>>(){
            private Stack<Node> stack=new Stack<>();
            private Node current=root;
            @Override
            public boolean hasNext(){return current!=null||!stack.isEmpty();}
            @Override
            public Entry<K,V> next(){
                while(current!=null){
                    stack.push(current);
                    current=current.left;
                }
                Node node=stack.pop();
                current=node.right;
                return new Entry<>(node.key,node.val);
            }
        };
    }
}