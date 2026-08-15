class Solution {
    public boolean isValidSudoku(char[][] board) {

    int row=board.length;
    int col=board[0].length;
    List<HashSet<Character>> row_set=new ArrayList<>();
    List<HashSet<Character>> col_set=new ArrayList<>();
    List<HashSet<Character>> grid_set=new ArrayList<>();
    
    for(int i=0;i<row;i++){
      HashSet<Character> set1=new HashSet<>();
      HashSet<Character> set2=new HashSet<>();
      HashSet<Character> set3=new HashSet<>();
      row_set.add(set1);
      col_set.add(set2);
      grid_set.add(set3);
    }

    for(int i=0;i<row;i++){
       for(int j=0;j<col;j++){
        System.out.println(i+"  - "+j);

        if(board[i][j]!='.'){
       int box=(i/3)*3+(j/3);
       HashSet set=row_set.get(i);
       HashSet set2=col_set.get(j);
       HashSet set3=grid_set.get(box);

        if(set.contains(board[i][j])) return false;
        set.add(board[i][j]);
  
        if(set2.contains(board[i][j])) return false;
        set2.add(board[i][j]);

       if(set3.contains(board[i][j])) return false;
          set3.add(board[i][j]);

       }
       }
    }
    System.out.println(row_set);
    System.out.println(col_set);
    

    return true;   
    }

}
