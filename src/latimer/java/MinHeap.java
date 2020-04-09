package latimer.java;

import java.util.ArrayList;
import java.util.List;

class MinHeap{

    List<Integer> heap;
    MinHeap(){
        heap=new ArrayList<>();
        heap.add(-1);
    }

    public void offer(int i){
        heap.add(i);
        int l=heap.size()-1;
        while(l/2!=0){
            int parent=heap.get(l/2);
            int cur=heap.get(l);
            if(parent>cur){
                heap.set(l/2,cur);
                heap.set(l,parent);
            }
            l/=2;
        }
    }
    public int poll(){
        int l=heap.size();
        int last=heap.get(l-1);
        int res=heap.get(1);
        heap.set(1,last);
        heap.remove(l-1);
        l=l-1;
        if(l!=1){
            int i=1;
            while(true){
                if((i*2>=l||heap.get(i)<=heap.get(i*2))&&(i*2+1>=l||heap.get(i)<=heap.get(i*2+1))){
                    break;
                }else if(i*2+1>l){
                    int parent=heap.get(i);
                    int left=heap.get(i*2);
                    heap.set(i,left);
                    heap.set(2*i,parent);
                    break;
                }else{
                    int parent=heap.get(i);
                    int left=heap.get(i*2);
                    int right=heap.get(i*2+1);
                    if(left<right){
                        heap.set(i*2,parent);
                        heap.set(i,left);
                        i=i*2;
                    }else{
                        heap.set(i*2+1,parent);
                        heap.set(i,right);
                        i=i*2+1;
                    }
                }
            }
        }
        return res;
    }
}

