import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class LruCache {
  public static class LRU {
      
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }
    
    
    HashMap<Integer,Node> hm; 
    Node head;
    Node tail;
    int cap;
    
    LRU(int capacity) {
        hm = new HashMap<>();
        this.cap = capacity;
        
        head = new Node();
        tail = new Node();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public void AddNode(Node node)
    {
        Node nbr = head.next;
        
        node.next = nbr;
        node.prev =head;
        
        nbr.prev = node;
        head.next = node;
    }
    
    public void RemoveNode(Node node)
    {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        
        node.next = null;
        node.prev = null;
        
    }
    
    public void update(Node node)
    {
        RemoveNode(node);
        AddNode(node);
       
    }

    public int get(int key) {
        Node node = hm.get(key);
        
        if(node == null)
        {
            return -1;
        }
        else{
            int val = node.val;
            update(node);
            
            return val;
        }
    }

    public void put(int key, int value) {
        
        Node node = hm.get(key);
        
        if(node == null)
        {
            Node nn = new Node();
            nn.key = key;
            nn.val = value;
            
            if(hm.size() == cap)
            {
                Node lru = tail.prev;
                RemoveNode(lru);
                hm.remove(lru.key);
            }
            
            hm.put(key,nn);
            AddNode(nn);
        }
        else{
            node.val = value;
            update(node);
        }
        
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    LRU obj = new LRU(Integer.parseInt(str.split(" ")[1]));

    while (true) {
      str = br.readLine();
      String inp[] = str.split(" ");
      if (inp.length == 1) {
        break;
      } else if (inp.length == 2) {
        System.out.println(obj.get(Integer.parseInt(inp[1])));
      } else if (inp.length == 3) {
        obj.put(Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
      }
    }
  }
}
