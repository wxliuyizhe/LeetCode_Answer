public class Solution {
    // public static Integer lastPostion=null;
    public ArrayList<String[]> solveNQueens(int n) {
        if(n <= 0) return null;
        ArrayList<String[]> result = new ArrayList<String[]>();
        
        ArrayList<Integer> config = new ArrayList<Integer>();
        for(int i = 0; i< n; i++){
            
            config.clear();
            config.add(i);
            findConfig(config,n,result);

        }
        
        return result;
        
    }
    
    public void findConfig(ArrayList<Integer> config, int n, ArrayList<String[]> result){
        if(config.size() == n) {
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
    
    public boolean canBeInBoard(ArrayList<Integer> config,int idx){
        int len = config.size();
        for(int i = 0; i < len; i++){
            if(config.get(i) == idx) return false;// can not be at the same column
            if(Math.abs(i - len) == Math.abs(config.get(i) - idx)) return false;
            
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
