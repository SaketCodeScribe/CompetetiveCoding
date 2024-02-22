package com.dsa_algorithms.BackTracking;

public class WordSearch {
    StringBuilder temp;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        WordSearch obj = new WordSearch();
        System.out.println(obj.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(obj.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCFB"));
        System.out.println(obj.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCEFSADEESE"));

    }

    public boolean exist(char[][] board, String word) {
        int i, j, m = board.length, n = board[0].length;

        temp = new StringBuilder();
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    temp.append(board[i][j]);
                    if (isExists(board, 1, i, j, m, n, word))
                        return true;
                    temp.deleteCharAt(temp.length() - 1);
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }

    private boolean isExists(char[][] board, int ind, int i, int j, int m, int n, String word) {
        board[i][j] = '*';
        if (temp.toString().compareTo(word) == 0)
            return true;
        if (ind >= word.length())
            return false;
        for (int[] dir : dirs) {
            if (i + dir[0] >= 0 && i + dir[0] < m && j + dir[1] >= 0 && j + dir[1] < n && board[i + dir[0]][j + dir[1]] != '*' && board[i + dir[0]][j + dir[1]] == word.charAt(ind)) {
                temp.append(word.charAt(ind));
                if (isExists(board, ind + 1, i + dir[0], j + dir[1], m, n, word))
                    return true;
                temp.deleteCharAt(temp.length() - 1);
                board[i + dir[0]][j+dir[1]] = word.charAt(ind);
            }
        }
        return false;
    }
}
