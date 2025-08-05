class Solution {

    private class Cell implements Comparable<Cell> {
        int height;
        int row;
        int col;

        //constructor to initialize cell
        public Cell(int h, int r, int c) {
            this.height = h;
            this.row = r;
            this.col = c;
        }

        @Override
        public int compareTo(Cell other) {
            return Integer.compare(this.height, other.height);
        }
    }

    public int trapRainWater(int[][] heightMap) {

        int numOfRows = heightMap.length;
        int numOfCols = heightMap[0].length;

        boolean[][] visited = new boolean[numOfRows][numOfCols];
        PriorityQueue<Cell> boundary = new PriorityQueue<>();

        for (int i = 0; i < numOfRows; ++i) {

            boundary.add(new Cell(heightMap[i][0], i, 0));
            boundary.add(new Cell(heightMap[i][numOfCols - 1], i, numOfCols - 1));

            visited[i][0] = true;
            visited[i][numOfCols - 1] = true;
        }

        for (int j = 1; j < numOfCols - 1; ++j) {

            boundary.add(new Cell(heightMap[0][j], 0, j));
            boundary.add(new Cell(heightMap[numOfRows - 1][j], numOfRows - 1, j));

            visited[0][j] = true;
            visited[numOfRows - 1][j] = true;
        }

        int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        int trapWaterVol = 0;

        while (!boundary.isEmpty()) {
            Cell currBoundary = boundary.poll();
            int minBoundaryHeight = currBoundary.height;

            for (int[] dir : direction) {
                int neighborRow = currBoundary.row + dir[0];
                int neighborCol = currBoundary.col + dir[1];

                if (isValid(visited, neighborRow, neighborCol, numOfRows, numOfCols)) {

                    if (heightMap[neighborRow][neighborCol] < minBoundaryHeight)
                        trapWaterVol += minBoundaryHeight - heightMap[neighborRow][neighborCol];

                    boundary.add(new Cell(Math.max(minBoundaryHeight, heightMap[neighborRow][neighborCol]), neighborRow,
                            neighborCol));

                    visited[neighborRow][neighborCol] = true;
                }
            }
        }
        return trapWaterVol;
    }

    public boolean isValid(boolean[][] visited, int i, int j, int m, int n) {

        return (i < m && i >= 0) && (j < n && j >= 0) && !visited[i][j];
    }
}
