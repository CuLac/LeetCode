package Daily.Easy;

/*

1232. Check If It Is a Straight Line
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
Check if these points make a straight line in the XY plane.

 */

public class Q1232_Check_If_It_Is_a_Straight_Line {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;

        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];

        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];

        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];

            if ((y - y1) * (x - x2) != (y - y2) * (x - x1)) {
                return false;
            }
        }

        return true;
    }
}
