package com.utilities;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UuidUtils {

    public static String getUuidId(String id) {
        Objects.requireNonNull(id, "String id must not be null.");
        return UUID.nameUUIDFromBytes(id.getBytes(StandardCharsets.UTF_8)).toString();
    }

    public static Map<String, String> getIdToIdMap(List<String> idList) {
        return idList.stream()
                .collect(Collectors.toMap(Function.identity(), UuidUtils::getUuidId));
    }

    public static List<String> getPatientIds(Collection<String> idList) {
        return idList.stream()
                .map(UuidUtils::getUuidId)
                .collect(Collectors.toList());
    }
}
