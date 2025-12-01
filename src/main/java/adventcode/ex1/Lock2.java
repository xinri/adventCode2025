package adventcode.ex1;

public class Lock2 {
    public Integer execute(int startingPoint, String instructions) {

        String[] split = instructions.split("\n");
        int i = startingPoint;
        int result = 0;

        for (String e : split) {
            String firstChar = e.trim().substring(0, 1);
            int remaining = Integer.parseInt(e.trim().substring(1));

/*            if (firstChar.equals("L")) {
                if (i == 0) result--;
                i = (i - remaining);
                result += Math.abs(Math.floorDiv(i, 100));
                i %= 100;
                if (i < 0) {
                    i = 100 + i;
                } else if (i==0) {
                    result++;
                }
            } else if (firstChar.equals("R")) {
                i = (i + remaining);
                if (i >= 100) {
                    result += Math.floorDiv(i, 100);
                }
                i %= 100;
            }*/

            if (firstChar.equals("L")) {
                RotateLeft rotateLeft = new RotateLeft(i, remaining);
                i = rotateLeft.rotate();
                result += rotateLeft.numberPassThrough0();
            } else if (firstChar.equals("R")) {
                RotateRight rotateRight = new RotateRight(i, remaining);
                i = rotateRight.rotate();
                result += rotateRight.numberPassThrough0();
            }
        }

        return result;
    }
}
