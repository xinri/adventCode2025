package adventcode.daytwo;

public class GiftShop {

    public long addInvalidIds(String giftDatas) {
        return new GiftData(giftDatas).sumInvalidIds();
    }

    public long addMultipleInvalidId(String giftDatas) {
        return new GiftData(giftDatas).sumMultipleInvalidIds();
    }

}
