import java.util.*;

public class IntervalScheduling {
    public static void main(String[] args) {
        job[] jobs = new job[8];
        jobs[0]=new job("A",0,6);
        jobs[1]=new job("B",1,4);
        jobs[2]=new job("C",3,5);
        jobs[3]=new job("D",3,8);
        jobs[4]=new job("E",4,7);
        jobs[5]=new job("F",5,9);
        jobs[6]=new job("G",6,10);
        jobs[7]=new job("H",8,11);
        List<job> res = new LinkedList<job>();
        Arrays.sort(jobs, new Comparator<job>() { //按结束时间排序
            @Override
            public int compare(job o1, job o2) {
                return o1.finish-o2.finish;
            }
        });
        for (int i = 0; i < jobs.length; i++) {
            if(res.size()==0){
                res.add(jobs[i]);
                i++;
            }
            if(jobs[i].start>=res.get(res.size()-1).finish){ //如果合适
                res.add(jobs[i]);
            }
        }
        System.out.println("选择的任务：");
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i).name+" ");
        }
    }
}

class job{
    String name;
    int start;
    int finish;
    public job(String name, int start, int finish) {
        this.name= name;
        this.start = start;
        this.finish = finish;
    }
}
