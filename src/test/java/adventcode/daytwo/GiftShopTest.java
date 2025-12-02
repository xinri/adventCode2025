package adventcode.daytwo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GiftShopTest {

    @Test
    void should_return_1227775554_when_execute_nominal_case() {
        GiftShop giftShop = new GiftShop();
        long result = giftShop.addInvalidIds("""
                11-22,95-115,998-1012,1188511880-1188511890,222220-222224,
                1698522-1698528,446443-446449,38593856-38593862,565653-565659,
                824824821-824824827,2121212118-2121212124
                """);
        assertThat(result).isEqualTo(1227775554);
    }

    @Test
    void should_return_the_correct_sum_for_the_real_exercise() {
        GiftShop giftShop = new GiftShop();
        long result = giftShop.addInvalidIds("""
                12077-25471,4343258-4520548,53-81,43661-93348,6077-11830,2121124544-2121279534,631383-666113,5204516-5270916,
                411268-591930,783-1147,7575717634-7575795422,8613757494-8613800013,4-19,573518173-573624458,134794-312366,
                18345305-18402485,109442-132958,59361146-59451093,1171-2793,736409-927243,27424-41933,93-216,22119318-22282041,
                2854-4778,318142-398442,9477235089-9477417488,679497-734823,28-49,968753-1053291,267179606-267355722,326-780,
                1533294120-1533349219
                """);
        assertThat(result).isEqualTo(40214376723L);
    }


    @Test
    void should_return_4174379265_when_execute_nominal_case_for_multiple_invalid() {
        GiftShop giftShop = new GiftShop();
        long result = giftShop.addMultipleInvalidId("""
                11-22,95-115,998-1012,1188511880-1188511890,222220-222224,
                1698522-1698528,446443-446449,38593856-38593862,565653-565659,
                824824821-824824827,2121212118-2121212124
                """);
        assertThat(result).isEqualTo(4174379265L);
    }

    @Test
    void should_return_50793864718_when_execute_example_case_for_multiple_invalid() {
        GiftShop giftShop = new GiftShop();
        long result = giftShop.addMultipleInvalidId("""
                12077-25471,4343258-4520548,53-81,43661-93348,6077-11830,2121124544-2121279534,631383-666113,
                5204516-5270916,411268-591930,783-1147,7575717634-7575795422,8613757494-8613800013,4-19,573518173-573624458,
                134794-312366,18345305-18402485,109442-132958,59361146-59451093,1171-2793,736409-927243,27424-41933,93-216,
                22119318-22282041,2854-4778,318142-398442,9477235089-9477417488,679497-734823,28-49,968753-1053291,267179606-267355722,
                326-780,1533294120-1533349219
                """);
        assertThat(result).isEqualTo(50793864718L);
    }
}
