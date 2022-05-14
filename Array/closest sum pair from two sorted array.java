public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int X = sc.nextInt();
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        
        for(int i = 0 ; i < n ; i++){
            arr1[i] = sc.nextInt();
        }
        
        for(int i = 0 ; i < m ; i++){
            arr2[i] = sc.nextInt();
        }
        
     
        
        int l = 0;
        int r = m-1;
        
        int diff = Integer.MAX_VALUE;
        int final_l = 0;
        int final_r = 0;
        
        while(l < n && r >= 0){
            if(Math.abs(arr1[l] + arr2[r] - X) < diff){
                diff = Math.abs(arr1[l] + arr2[r]-X);
                final_l = l; 
                final_r = r; 
            }
            
            if((arr1[l] + arr2[r]) > X){
                r--;
            }
            else{
                l++;
            }
        }
        
       
        
        System.out.println(arr1[final_l] + " " + arr2[final_r]);
    }
