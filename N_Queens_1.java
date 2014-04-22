public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        if(n <= 0) return null;
        ArrayList<String[]> result = new ArrayList<String[]>();

        //config is used to store reasonable configurations. The i th element in config stores the position of one           //queen at i th row, i.e. if config.get(1) is 2, then it means there is one queen at row 1, column 2

        ArrayList<Integer> config = new ArrayList<Integer>();

        for(int i = 0; i< n; i++){
            
            config.clear();
            config.add(i);
            findConfig(config,n,result);

        }
        
        return result;
        
    }
    
    public void findConfig(ArrayList<Integer> config, int n, ArrayList<String[]> result){
        if(config.size() == n) // if the config has n elements, it means this config is reasonable
            result.add(convert2StrArr(config));
            config.remove(n - 1);
            return;
        }
        for(int i = 0; i < n; i ++){
            if(canBeInBoard(config,i)){
                config.add(i);
                findConfig(config,n,result);
            }
        }
        config.remove(config.size() - 1);
    }
    
    public boolean canBeInBoard(ArrayList<Integer> config,int idx){// find reasonable position for next row
        int len = config.size();
        for(int i = 0; i < len; i++){
            if(config.get(i) == idx) return false;// can not be at the same column
            if(Math.abs(i - len) == Math.abs(config.get(i) - idx))
               return false;// can not be at the same diagonal.
        }
        return true;
    }
    
    public String[] convert2StrArr(ArrayList<Integer> config){
        String[] strArr = new String[config.size()];
        for(int i = 0; i < config.size(); i++){
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < config.size(); j++){
                if(j == config.get(i)) sb.append("Q");
                else sb.append(".");
            }
            
            strArr[i] = sb.toString();
        }
        return strArr;
    }
}
