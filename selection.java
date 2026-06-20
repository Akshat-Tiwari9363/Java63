public class selection {
    void sort(int a[]){
        int i,j,min;
        for(i=0;i<a.length-1;i++){
            min=i;
            for(j=i+1;j<a.length;j++){
                if(a[min]>a[j]){
                    min=j;
                }
            }
            int t=a[min];
            a[min]=a[i];
            a[i]=t;
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
        selection s=new selection();
        s.sort(a);
        s.print(a);
    }    
}
