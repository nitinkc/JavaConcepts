package com.nitin.a4coreJavaAPI.object;

/**
 * Created by nitin.chaurasia on 3/3/2017.
 */
public class O3UsingClass4Name {
    public static void main(String[] args) {

        try {

            Class s = Class.forName("com.nitin.a4coreJavaAPI.object.Sample");
            Sample obj = (Sample) s.newInstance();
            System.out.println(obj.hashcode());

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
