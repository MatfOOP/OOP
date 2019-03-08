package rs.math.oop1.zd.p180500.katanci.z02.saVisestrukimUlazom;

public class ListWriter implements Runnable{
    
	private Data myData;
 
    public ListWriter(Data myData){
        this.myData = myData;
    }
 
    public void run(){
        for (int i = 0; i < 10; i++){
            myData.add(Thread.currentThread().getName() + " : " + i);
        }
    }
}