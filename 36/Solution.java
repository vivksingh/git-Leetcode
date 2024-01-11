import java.util.HashSet;

class Solution {
    public static boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> box = new HashSet<>();

            for(int j=0;j<9;j++){
                if(board[i][j]!='.' && !row.add(board[i][j])) return false;
                if(board[j][i]!='.' && !col.add(board[j][i])) return false;
                
                int rowindx=3*(i/3) + j/3;
                int colindx=3*(i%3) + j%3;
                if(board[rowindx][colindx] !='.' && !box.add(board[rowindx][colindx])) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
        { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
        { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
        { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
        { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
        { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
        { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
        { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
        { '.', '.', '.', '.', '8', '.', '.', '7', '9' }};
        System.out.println(isValidSudoku(board));
        board[0][2]='3' ;
        System.out.println(isValidSudoku(board));
    }
}