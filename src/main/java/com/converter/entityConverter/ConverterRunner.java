package com.converter.entityConverter;

public class ConverterRunner {

    private static final EntityConverterImpl entityConverter = new EntityConverterImpl();

    public static void main(String[] args) {

        DB2Entity db2Entity = new DB2Entity(true, 10.10);
        SpannerEntity spannerEntity = entityConverter.convert(db2Entity);

        System.out.println(spannerEntity);
    }
}
