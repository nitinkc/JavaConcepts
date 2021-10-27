package com.j15.foreignMemoryAccessAPI;


public class TestForeignMemory {
    public static void main(String[] args) {
        /*VarHandle intHandle = MemoryHandles.varHandle(int.class,
                ByteOrder.nativeOrder());

        try (MemorySegment segment = MemorySegment.allocateNative(100)) {
            MemoryAddress base = segment.baseAddress();
            for (int i = 0; i < 25; i++) {
                intHandle.set(base.addOffset(i * 4), i);
            }
        }*/
    }
}
