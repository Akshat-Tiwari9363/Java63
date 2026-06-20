public class bubble {

    void sort(int a[]){
        int i,j;
        boolean f;
        for(i=1;i<a.length;i++){
            f=true;
            for(j=0;j<a.length-1;j++){
                if(a[j]>a[j+1]){
                    int t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                    f=false;
                }
            }
            if(f){
                break;
            }
            System.out.print("Pass "+i+" : ");
            print(a);
        }
    }

    void print(int a[]){
        for(int i : a){
            System.out.print(i+"->");
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        int a[]={9,8,7,6,5,5,5,4,5,3,2,1};
        bubble b=new bubble();
        b.sort(a);
        b.print(a);
    }
}
