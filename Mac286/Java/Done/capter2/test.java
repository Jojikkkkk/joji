
class test{
  public static void main(String[] args){
      int n = 100;
      int a[] = new int[n];

      for(int i = 0; i < 10; i++){
        a[i] = i+1;
        System.out.print(a[i] + " ");
      }
      System.out.println();
      System.out.println();
      int w =10;
      int insert = 6;
      int i;
      for(i = 0;i<w;i++){
        if(insert<a[i])
          break;
      }
      w++;
      int j=w;
      for(;i <= j ;j--){
        a[j+1] = a[j];
      }
        a[j+1] = insert;


        for(i = 0; i < w; i++){
          System.out.print(a[i]+ " ");
        }
        System.out.println();

      int delete = 2;

      for(i = 0; i< w;i++){
      if(delete==a[i])
        break;
      }

      for(;i<w;i++)
      {
        a[i] = a[i+1];
      }
      w--;

      for(i = 0; i < w; i++){
        System.out.print(a[i]+ " ");
      }

      System.out.println();
      System.out.println();

      System.out.println(search(a,11,6));
      System.out.println();
      System.out.println();
      System.out.println(binary(a,0,10,9));

}

public static int search(int[] a,int n, int x){

  int i = 0;
  while(i <=n && a[i] != x)
    i++;

  if(i < n)
    return i+1;
  else
    return 0;

}

public static int binary(int[] a,int f,int n,int x){

  while(f < n){
  int mid = (f+n)/2;
  if(a[mid] < x)
    f = mid + 1;
  else
    n = mid - 1;

  if(x == a[mid])
    return mid;
  else
  return 0;

  }

}


}
