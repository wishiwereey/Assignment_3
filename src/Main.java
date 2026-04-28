public class Main{
    public static void main(String[] args){
        testHashTable();
        System.out.println("--------------------");
        testBST();
    }
    private static void testHashTable(){
        System.out.println("TEST MyHashTable");
        MyHashTable<MyTestingClass,Student> table=new MyHashTable<>(11);
        for(int i=0;i<10000;i++){
            MyTestingClass key=new MyTestingClass(i,"Name"+i);
            Student value=new Student("Student"+i,18+i%5);
            table.put(key,value);
        }
        System.out.println("Size: "+table.size());
        table.printBuckets();
        MyTestingClass key=new MyTestingClass(5,"Name5");
        Student value=new Student("Student5",18+5%5);
        System.out.println("Get key 5: "+table.get(key));
        System.out.println("Contains Student5: "+table.contains(value));
        System.out.println("GetKey Student5: "+table.getKey(value));
        System.out.println("Remove key 5: "+table.remove(key));
        System.out.println("Size after remove: "+table.size());
    }
    private static void testBST(){
        System.out.println("TEST BST");
        BST<Integer,String> tree=new BST<>();
        tree.put(5,"five");
        tree.put(2,"two");
        tree.put(8,"eight");
        tree.put(1,"one");
        tree.put(3,"three");
        tree.put(7,"seven");
        tree.put(9,"nine");
        System.out.println("Size: "+tree.size());
        System.out.println("Get 3: "+tree.get(3));
        tree.delete(2);
        System.out.println("After delete 2:");
        for(BST.Entry<Integer,String> elem:tree){
            System.out.println("key is "+elem.getKey()+" and value is "+elem.getValue());
        }
    }
}