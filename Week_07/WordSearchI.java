package Week_07;

public class WordSearchI {
    public boolean ret = false;
    public boolean flag = false;

    public boolean exist(char[][] board, String word) {
        char[] wordCharArray = word.toCharArray();
        int start = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(i, j, board, wordCharArray, start);
            }
        }
        return ret;
    }

    public void helper(int i, int j, char[][] board, char[] wordCharArray, int start) {
        int hangSize = board.length;
        int lieSize = board[0].length;
        if (start == wordCharArray.length) {
            ret = true;
            flag = true;
            return;
        }
        if (i >= hangSize || i < 0 || j >= lieSize || j < 0) {
            return;
        }
        if (start > wordCharArray.length) {
            return;
        }
        if (wordCharArray[start] != board[i][j]) {
            return;
        }
        if (board[i][j] == '#') {
            return;
        }
        if (!flag) {
            char temp2 = board[i][j];
            board[i][j] = '#';
            helper(i, j + 1, board, wordCharArray, start + 1);
            helper(i, j - 1, board, wordCharArray, start + 1);
            helper(i + 1, j, board, wordCharArray, start + 1);
            helper(i - 1, j, board, wordCharArray, start + 1);
            board[i][j] = temp2;
        }
    }

    public static void main(String[] args) {
        WordSearchI wordSearchI = new WordSearchI();
        boolean ret = wordSearchI.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SEE");
//        boolean ret = wordSearchI.exist(new char[][]{
//                {'A'},
//        }, "A");
        System.out.println(ret);
    }
}
