package adventcode.dayone;

public class Lock {

    public Integer execute(int startingPoint, String instructions) {

        String[] split = instructions.split("\n");
        int i = startingPoint;
        int result = 0;

        for (String e : split) {
            String firstChar = e.trim().substring(0, 1);
            int remaining = Integer.parseInt(e.trim().substring(1));

            if (firstChar.equals("L")) {
                RotateLeft rotateLeft = new RotateLeft(i, remaining);
                i = rotateLeft.rotate();
                result += rotateLeft.isDialPointAt0() ? 1 : 0;
            } else if (firstChar.equals("R")) {
                RotateRight rotateRight = new RotateRight(i, remaining);
                i = rotateRight.rotate();
                result += rotateRight.isDialPointAt0() ? 1 : 0;
            }
        }

        return result;
    }
}
