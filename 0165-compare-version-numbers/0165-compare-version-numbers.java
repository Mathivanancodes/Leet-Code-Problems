class Solution {
    public int compareVersion(String version1, String version2) {
    int i = 0, j = 0;
    int val1 = 0, val2 = 0; 
        
        
    while(i<version1.length() || j<version2.length())
    {
       while(i<version1.length() && version1.charAt(i)!='.')
       {
         val1 = val1*10 + version1.charAt(i)-'0';   
         i++;  
       }
        
       while(j<version2.length() && version2.charAt(j)!='.')
       {
         val2 = val2*10 + version2.charAt(j)-'0';
         j++;  
       }
         
       if(val1>val2)
           return 1; 
       if(val1<val2)
            return -1; 
       val1 = 0; 
       val2 = 0; 
       i++;
       j++; 
    }
       
return 0;
                        
    }
}