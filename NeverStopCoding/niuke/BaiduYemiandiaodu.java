package niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BaiduYemiandiaodu {
    public static void main(String args[]) {
        int cacheNum;
        int pageNum;
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
        	cacheNum = scan.nextInt();
            pageNum = scan.nextInt();
             
            ArrayList<Integer> pageList = new ArrayList<Integer>();
            for(int i=0; i<pageNum; i++){
                pageList.add(scan.nextInt());
            }
            //System.out.println(pageList);
             
            int cnt = 0;//缺页书
            Queue<Integer> cacheQueue = new LinkedList<Integer>();
            for(int i=0; i<pageNum; i++){
                int pageNo = pageList.get(i);
                if( cacheQueue.contains(pageNo) ){//若不缺页
                    continue;
                }else{//缺页
                    if(!(cacheQueue.size() < cacheNum)){//若当前队列已满，则移除第一个元素
                        cacheQueue.poll();//获取并移除队列头元素
                    }
                    cacheQueue.offer(pageNo);//在队列末尾追加元素
                    cnt++;
                }
                 
                //System.out.println(cacheQueue);
            }
            System.out.println(cnt);
        }
         
    }
     
     
}