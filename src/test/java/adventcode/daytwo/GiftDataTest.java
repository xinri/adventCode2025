package adventcode.daytwo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GiftDataTest {

    @Test
    void should_return_separate_data_when_sending_gift_datas() {
        GiftData giftData = new GiftData("""
                11-22,95-115,998-1012,1188511880-1188511890,222220-222224,
                1698522-1698528,446443-446449,38593856-38593862,565653-565659,
                824824821-824824827,2121212118-2121212124
                """);
        List<RangeIds> listOfRangeId = giftData.getListOfRangeId();
        assertThat(listOfRangeId).containsExactly(
                new RangeIds("11-22"), new RangeIds("95-115"), new RangeIds("998-1012"),
                new RangeIds("1188511880-1188511890"), new RangeIds("222220-222224"),
                new RangeIds("1698522-1698528"), new RangeIds("446443-446449"),
                new RangeIds("38593856-38593862"), new RangeIds("565653-565659"),
                new RangeIds("824824821-824824827"), new RangeIds("2121212118-2121212124"));
    }

    @Test
    void should_return_sum_of_invalid_ids_when_execute_the_sum_function() {
        GiftData giftData = new GiftData("""
                11-22,95-115,998-1012,1188511880-1188511890,222220-222224,
                1698522-1698528,446443-446449,38593856-38593862,565653-565659,
                824824821-824824827,2121212118-2121212124
                """);
        assertThat(giftData.sumInvalidIds()).isEqualTo(1227775554);
    }
}
