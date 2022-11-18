package nitin.streams.Optionals;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OptionalOFNullable {
    public static void main(String[] args) {
        String string = "38400000-8cf0-11bd-b23e-10b96e4ef00d";
         string = null;
        UUID x = Optional.ofNullable(UUID.fromString(string)).orElse(UUID.randomUUID());

        Hhd hhd = new Hhd(x, UUID.randomUUID(), UUID.randomUUID(), "Nitin");
        List<Hhd> hhdList = new ArrayList<>();
        hhdList.add(hhd);

        System.out.println(hhdList);
    }

    @AllArgsConstructor
    @ToString
    static class Hhd {
        private UUID x;
        private UUID y;
        private UUID z;
        private String test;
    }
}