package game_fox_adventure.nodes;

public class Node {
    public int key; //ключ узла, для поиска в бинарном дереве
    public String data; // данные в узле
    public Node leftChild; // левый поток
    public Node rightChild; // правый поток

    public void printNode(){
        System.out.println(data);
    }
}