package nitin.mappers.jackson.filter;

public class DoorFilter {
    @Override
    public boolean equals(Object obj) {
        System.out.println("Invoked DoorFilter");
        if (obj == null || !(obj instanceof Integer)) {
            return false;
        }
        //date should be in the past
        Integer doors = (Integer) obj;
        System.out.println(doors);
        return doors == 3;
    }
}
