package com.nitin.zRevisionsSep2020;

public interface ExceptionFunction<E,F> {
  F apply(E e) throws Throwable;
}
