package nitin.streams.sortingNcomparators;

import com.entity.reports.EventComments;
import com.entity.reports.IntraStatsLine;
import com.entity.reports.SampleIntraStatLine;

import java.util.List;

public class AdvancedComparator {
    public static void main(String[] args) {

        IntraStatsLine intraStatsLine = SampleIntraStatLine.getIntraStatsLine();
        System.out.println("*************** BEFORE SORT ***************");
        intraStatsLine.getEventComments()
                .forEach(System.out::println);
        System.out.println("*************** AFTER SORT ***************");

        List<EventComments> eventCommentsList = intraStatsLine.getEventComments();

//        eventCommentsList.sort((object1, object2) -> {
//            return object2.getSomeStats().get(0).getTimeDtDisplay().compareTo(object1.getSomeStats().get(0).getTimeDtDisplay());
//        });

        eventCommentsList.sort((object1, object2) -> {
                    return object1.getSomeClass().getIndex().compareTo(object2.getSomeClass().getIndex());
                });

        eventCommentsList.sort((EventComments o1, EventComments o2) -> {
               if(o1.getSomeClass().getIndex() > o2.getSomeClass().getIndex())
                   return -1;
               else if(o1.getSomeClass().getIndex() < o2.getSomeClass().getIndex())
                   return 1;
               else {
                   return (o2.getSomeStats().get(0).getTimeDtDisplay().compareTo(o1.getSomeStats().get(0).getTimeDtDisplay()));
               }
            });


        intraStatsLine.setEventComments(eventCommentsList);
        intraStatsLine.getEventComments()
//                .forEach(x -> System.out.println(x.getSomeStats().get(0).toString()));
                .forEach(x -> System.out.println(x));



    }
}
