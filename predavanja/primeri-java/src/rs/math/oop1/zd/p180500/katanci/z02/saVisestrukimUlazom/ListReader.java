package rs.math.oop1.zd.p180500.katanci.z02.saVisestrukimUlazom;

public class ListReader implements Runnable{
   
	private Data myData;

    public ListReader(Data myData){
        this.myData = myData;
    }

    public void run(){
        for (int i = 0; i < 10; i++){
            myData.readData();
        }
    }
}